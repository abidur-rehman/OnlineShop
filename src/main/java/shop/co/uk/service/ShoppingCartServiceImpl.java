package shop.co.uk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.co.uk.model.Item;
import shop.co.uk.model.ShoppingCart;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ItemService itemService; 

	@Override
	public ShoppingCart getShoppingCart() {
		List<Item> items = itemService.findAllItems();
		ShoppingCart shoppingCart = ShoppingCart.createShoppingCart(items);
		return shoppingCart;
	}

	@Override
	public boolean isShoppingCartEmpty(ShoppingCart shoppingCart) {
		if (shoppingCart.getResults().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public ShoppingCart getItemFromShoppingCart(long id) {
		Item item = itemService.findById(id);
		List<Item> items = new ArrayList<>();
		items.add(item);
		ShoppingCart shoppingCart = ShoppingCart.createShoppingCart(items);
		return shoppingCart;
	}

	@Override
	public ShoppingCart addItemToShoppingCart(long id) {
		Item item = itemService.findById(id);
		if (item != null) {
			itemService.addItem(item);
		}
		List<Item> items = itemService.findAllItems();
		ShoppingCart shoppingCart = ShoppingCart.createShoppingCart(items);
		return shoppingCart;
	}

	@Override
	public ShoppingCart removeItemFromShoppingCart(long id) {
		Item item = itemService.findById(id);
		if (item != null) {
			itemService.removeItem(item);
		} 
		List<Item> items = itemService.findAllItems();
		ShoppingCart shoppingCart = ShoppingCart.createShoppingCart(items);
		return shoppingCart;
	}
}
