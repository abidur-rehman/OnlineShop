package shop.co.uk.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import shop.co.uk.model.Item;
import shop.co.uk.model.ShoppingCart;
import shop.co.uk.configuration.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {TestApplicationConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class ShoppingCartServiceTests {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Test
	public void getShoppingCartTest() {
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();
		assertNotNull(shoppingCart.getResults());
		assertEquals(shoppingCart.getResults().size(), 4);
		assertEquals(shoppingCart.getResults().get(0).getTitle(), "Apricot Ripe & Ready x5");
		assertEquals(shoppingCart.getResults().get(1).getTitle(), "Avocado Ripe & Ready xL");
		assertEquals(shoppingCart.getResults().get(2).getTitle(), "Avocado Ripe & Ready x2");
		assertEquals(shoppingCart.getResults().get(3).getTitle(), "Avocado Ripe & Ready x4");
		assertEquals(shoppingCart.getTotal(), 8.3, 0);
	}
	
	@Test
	public void removeItemNotFoundTest() {
		ShoppingCart shoppingCart = shoppingCartService.removeItemFromShoppingCart(1);
		assertNotNull(shoppingCart.getResults());
		assertEquals(shoppingCart.getResults().size(), 4);
		Item item = shoppingCart.getResults().get(0);
		try {
			shoppingCartService.removeItemFromShoppingCart(1);
			fail(); // FAIL when no exception is thrown
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "You do not have " + item.getTitle() + " in your shopping cart");
		}
	}
	
	@Test
	public void addItemToShoppingCartTest() {
		ShoppingCart shoppingCart = shoppingCartService.addItemToShoppingCart(1);
		assertNotNull(shoppingCart.getResults());
		assertEquals(shoppingCart.getResults().size(), 4);
		assertEquals(shoppingCart.getResults().get(0).getTitle(), "Apricot Ripe & Ready x5");
		assertEquals(shoppingCart.getResults().get(0).getSize(), "98.76kb");
		assertEquals(shoppingCart.getResults().get(0).getUnitPrice(), 2.3, 0);
		assertEquals(shoppingCart.getResults().get(0).getQuantity(), 1);
		assertEquals(shoppingCart.getResults().get(1).getTitle(), "Avocado Ripe & Ready xL");
		assertEquals(shoppingCart.getResults().get(2).getTitle(), "Avocado Ripe & Ready x2");
		assertEquals(shoppingCart.getResults().get(3).getTitle(), "Avocado Ripe & Ready x4");
		assertEquals(shoppingCart.getTotal(), 8.3, 0);
	}
	
	@Test
	public void getItemFromShoppingCartTest() {
		ShoppingCart shoppingCart = shoppingCartService.getItemFromShoppingCart(1);
		assertNotNull(shoppingCart.getResults());
		assertEquals(shoppingCart.getResults().size(), 1);
		assertEquals(shoppingCart.getResults().get(0).getTitle(), "Apricot Ripe & Ready x5");
		assertEquals(shoppingCart.getResults().get(0).getQuantity(), 1);
		assertEquals(shoppingCart.getResults().get(0).getSize(), "98.76kb");
		assertEquals(shoppingCart.getResults().get(0).getUnitPrice(), 2.3, 0);
		assertEquals(shoppingCart.getTotal(), 2.3, 0);
	}
	
	@Test
	public void removeItemFromShoppingCartTest() {
		ShoppingCart shoppingCart = shoppingCartService.removeItemFromShoppingCart(1);
		assertNotNull(shoppingCart.getResults());
		assertEquals(shoppingCart.getResults().size(), 4);
		assertEquals(shoppingCart.getResults().get(0).getTitle(), "Apricot Ripe & Ready x5");
		assertEquals(shoppingCart.getResults().get(0).getSize(), "98.76kb");
		assertEquals(shoppingCart.getResults().get(0).getUnitPrice(), 2.3, 0);
		assertEquals(shoppingCart.getResults().get(0).getQuantity(), 0);
		assertEquals(shoppingCart.getTotal(), 6.0, 0);
	}
}
