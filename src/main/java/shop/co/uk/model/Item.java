package shop.co.uk.model;

public abstract class Item {
	private float id;
	private String title;
	private String size;
	private double unitPrice;
	private String description;
	private int quantity;
	
	public Item(float id, String title, String size, double unitPrice, String description, int quantity) {
		this.id = id;
		this.title = title;
		this.size = size;
		this.unitPrice = unitPrice;
		this.description = description;
		this.quantity = quantity;
	}
	
	public Item(float id, FruitType type) {
		this.id = id;
		this.title = type.getTitle();
		this.size = type.getSize();
		this.unitPrice = type.getUnitPrice();
		this.description = type.getDescription();
		this.quantity += 1;
	}
	
	public float getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getSize() {
		return size;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public String getDescription() {
		return description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public static void incrementQuantity(Item item) {
		item.quantity += 1;
	}
	public static void decrementQuantity(Item item) {
		item.quantity -= 1;		
	}
	
}
