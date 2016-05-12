package shop.co.uk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import shop.co.uk.model.Fruit;
import shop.co.uk.model.FruitType;
import shop.co.uk.model.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Item> items;
	
	static{
		items = populateDummyItems();
	}
	
	@Override
	public List<Item> findAllItems() {
		return items;
	}
	
	@Override
	public Item findById(long id) {
		for(Item item : items){
			if(item.getId() == id){
				return item;
			}
		}
		return null;
	}

	private static List<Item> populateDummyItems() {
		List<Item> items = new ArrayList<>();
		items.add(Fruit.createFruit(counter.incrementAndGet(), FruitType.APPRICOT_RIPE_READY_X5));
		items.add(Fruit.createFruit(counter.incrementAndGet(), FruitType.AVOCADO_RIPE_READY_XL));
		items.add(Fruit.createFruit(counter.incrementAndGet(), FruitType.AVOCADO_RIPE_READY_X2));
		items.add(Fruit.createFruit(counter.incrementAndGet(), FruitType.AVOCADO_RIPE_READY_X4));
		return items;
	}

	@Override
	public void removeItem(Item item) {
		if (item.getQuantity() > 0 ) {
			Item.decrementQuantity(item);
		} else {
			throw new IllegalArgumentException("You do not have " + item.getTitle() + " in your shopping cart");
		}
	}

	@Override
	public void addItem(Item item) {
		Item.incrementQuantity(item);		
	}
}
