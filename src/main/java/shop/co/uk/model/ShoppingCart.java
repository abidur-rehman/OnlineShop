package shop.co.uk.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> results;
    private double total;
    
    private ShoppingCart() {
    	this.results = new ArrayList<>();
    	this.total = 0;
    }
     
    private ShoppingCart(List<Item> results){
    	this.results = new ArrayList<>();
    	this.results.addAll(results);
        this.total = 0;
    }

	public double getTotal(){
        for(Item item : this.results){
        	double unitPrice = item.getUnitPrice();
        	double itemTotalPrice = item.getQuantity() * unitPrice;
            this.total += itemTotalPrice;
        }
        return this.total;
    }
    
    public List<Item> getResults() {
		return results;
	}

	public static ShoppingCart createShoppingCart(List<Item> items) {
		ShoppingCart cart = new ShoppingCart(items);
		return cart;
	}

}
