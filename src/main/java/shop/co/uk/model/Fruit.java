package shop.co.uk.model;

public class Fruit extends Item {

	private Fruit(float id, FruitType type) {
		super(id, type);
	}
	
	private Fruit(float id, String title, String size, double unitPrice, String description, int quantity) {
		super(id, title, size, unitPrice, description, quantity);
	}
	
	public static Fruit createFruit(float id, FruitType type) {
		Fruit fruit = new Fruit(id, type);
		return fruit;
	}
	
	public static Fruit createFruit(float id, String title, String size, double unitPrice, String description, int quantity) {
		Fruit fruit = new Fruit(id, title, size, unitPrice, description, quantity);
		return fruit;
	}
}
