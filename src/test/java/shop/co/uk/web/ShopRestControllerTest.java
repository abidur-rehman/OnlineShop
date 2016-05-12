package shop.co.uk.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import shop.co.uk.builder.ItemBuilder;
import shop.co.uk.model.Item;
import shop.co.uk.model.ShoppingCart;
import shop.co.uk.service.ShoppingCartService;
import shop.co.uk.web.ShopRestController;

/**
 * These are controller tests
 * @author abidrehman
 *
 */
public class ShopRestControllerTest {
	private static String MEDIA_TYPE_JSON = "application/json";
	
	@InjectMocks
	private ShopRestController shopRestController;
	
	private MockMvc mockMvc;
	
	@Mock
	private ShoppingCartService shoppingCartService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(shopRestController)
				.build();
	}
	
	/**
	 * Retrieves shopping cart in a json format with all items
	 * @throws Exception
	 */
	@Test
	public void getShoppingCartTest() throws Exception {
		List<Item> items = new ArrayList<Item>();
		Item item1 = new ItemBuilder()
				.id(1.0f)
				.title("Apricot Ripe & Ready x5")
				.size("98.76kb")
				.unitPrice(2.3)
				.description("Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...")
				.quantity(1)
				.build();
		items.add(item1);
		
		Item item2 = new ItemBuilder()
				.id(2.0f)
				.title("Avocado Ripe & Ready xL")
				.size("90.6kb")
				.unitPrice(2.20)
				.description("Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...")
				.quantity(1)
				.build();
		items.add(item2);
		
		Item item3 = new ItemBuilder()
				.id(3.0f)
				.title("Avocado Ripe & Ready x2")
				.size("90.6kb")
				.unitPrice(1.80)
				.description("Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...")
				.quantity(1)
				.build();
		items.add(item3);
		
		ShoppingCart shoppingCart = ShoppingCart.createShoppingCart(items);

		when(shoppingCartService.getShoppingCart()).thenReturn(shoppingCart);
		mockMvc.perform(get("/rest/shoppingCart"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MEDIA_TYPE_JSON))
			.andExpect(jsonPath("$results", hasSize(3)))
			.andExpect(jsonPath("$results[0].id", is(1.0)))
			.andExpect(jsonPath("$results[0].title", is("Apricot Ripe & Ready x5")))
			.andExpect(jsonPath("$results[0].unitPrice", is(2.3)))
			.andExpect(jsonPath("$results[0].size", is("98.76kb")))
			.andExpect(jsonPath("$results[1].id", is(2.0)))
			.andExpect(jsonPath("$results[1].title", is("Avocado Ripe & Ready xL")))
			.andExpect(jsonPath("$results[1].unitPrice", is(2.2)))
			.andExpect(jsonPath("$results[1].size", is("90.6kb")))
			.andExpect(jsonPath("$results[2].id", is(3.0)))
			.andExpect(jsonPath("$results[2].title", is("Avocado Ripe & Ready x2")))
			.andExpect(jsonPath("$results[2].unitPrice", is(1.80)))
			.andExpect(jsonPath("$results[2].size", is("90.6kb")))
			.andExpect(jsonPath("$total", is(6.3)));
 
		verify(shoppingCartService, times(1)).getShoppingCart();
	}
	
	/**
	 * Simulates the empty shopping cart with a json message
	 * @throws Exception
	 */
	@Test
	public void getEmptyShoppingCart() throws Exception {
		ShoppingCart shoppingCart = ShoppingCart.createShoppingCart(Collections.<Item> emptyList());

		when(shoppingCartService.getShoppingCart()).thenReturn(shoppingCart);
		mockMvc.perform(get("/rest/shoppingCart"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MEDIA_TYPE_JSON))
			.andExpect(jsonPath("$results", hasSize(0)))
			.andExpect(jsonPath("$total", is(0.0)));
	}
}
