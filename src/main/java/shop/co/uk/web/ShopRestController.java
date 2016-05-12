package shop.co.uk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.co.uk.model.ShoppingCart;
import shop.co.uk.service.ShoppingCartService;

@RestController
@RequestMapping(produces="application/json", value="/rest")
public class ShopRestController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> exceptionHandling(Exception e) {
		ErrorResponse error = ErrorResponse.createError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public ResponseEntity<ShoppingCart> getShoppingCart() {
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();
		if(shoppingCartService.isShoppingCartEmpty(shoppingCart)){
			return new ResponseEntity<ShoppingCart>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
	}

	@RequestMapping(value = "/shoppingCart/item/{id}", method = RequestMethod.GET)
	public ResponseEntity<ShoppingCart> getItemFromShoppingCart(@PathVariable("id") long id) {
		ShoppingCart shoppingCart = shoppingCartService.getItemFromShoppingCart(id);
		if(shoppingCartService.isShoppingCartEmpty(shoppingCart)){
			return new ResponseEntity<ShoppingCart>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shoppingCart/item/{id}", method = RequestMethod.POST)
	public ResponseEntity<ShoppingCart> addItemInShoppingCart(@PathVariable("id") long id) {
		ShoppingCart shoppingCart = shoppingCartService.addItemToShoppingCart(id);
		if(shoppingCartService.isShoppingCartEmpty(shoppingCart)){
			return new ResponseEntity<ShoppingCart>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shoppingCart/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ShoppingCart> removeItemFromShoppingCart(@PathVariable("id") long id) {
		ShoppingCart shoppingCart = shoppingCartService.removeItemFromShoppingCart(id);
		if(shoppingCartService.isShoppingCartEmpty(shoppingCart)){
			return new ResponseEntity<ShoppingCart>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
	}
}
