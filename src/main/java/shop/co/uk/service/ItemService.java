package shop.co.uk.service;

import java.util.List;

import shop.co.uk.model.Item;

public interface ItemService {

	List<Item> findAllItems();

	Item findById(long id);

	void removeItem(Item item);

	void addItem(Item item);

}
