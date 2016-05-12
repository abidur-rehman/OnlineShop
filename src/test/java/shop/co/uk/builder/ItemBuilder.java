package shop.co.uk.builder;

import shop.co.uk.model.Fruit;
import shop.co.uk.model.Item;

public class ItemBuilder {
	private float id;
	private String title;
	private String size;
	private double unitPrice;
	private String description;
	private int quantity;
	
	public ItemBuilder id(float id) {
		this.id = id;
		return this;
	}
	public ItemBuilder title(String title) {
		this.title = title;
		return this;
	}
	public ItemBuilder size(String size) {
		this.size = size;
		return this;
	}
	public ItemBuilder unitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}
	public ItemBuilder description(String description) {
		this.description = description;
		return this;
	}
	public ItemBuilder quantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public Item build() {
		return Fruit.createFruit(id, title, size, unitPrice, description, quantity);
	}
}
