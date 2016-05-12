package shop.co.uk.service;

import shop.co.uk.model.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart getShoppingCart();

	ShoppingCart getItemFromShoppingCart(long id);

	ShoppingCart addItemToShoppingCart(long id);

	ShoppingCart removeItemFromShoppingCart(long id);

	boolean isShoppingCartEmpty(ShoppingCart shoppingCart);

}
