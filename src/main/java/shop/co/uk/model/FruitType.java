package shop.co.uk.model;

public enum FruitType {
	APPRICOT_RIPE_READY_X5("Apricot Ripe & Ready x5", "98.76kb", 2.30, "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."), 
	AVOCADO_RIPE_READY_XL("Avocado Ripe & Ready xL", "90.6kb", 2.20, "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."), 
	AVOCADO_RIPE_READY_X2("Avocado Ripe & Ready x2", "90.6kb", 1.80, "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."),
	AVOCADO_RIPE_READY_X4("Avocado Ripe & Ready x4", "87kb", 2.0, "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...");
//	AVOCADO_RIPE_READY_X4, PEARS_RIPE_READY_X4, GOLDEN_KIWI_X4, 
//	KIWI_RIPE_READY_X4;
	private String title;
	private String size;
	private double unitPrice;
	private String description;
	FruitType(String t, String s, double uPrice, String desc) {
		title = t;
		size = s;
		unitPrice = uPrice;
		description = desc;
	}
	
	String getTitle() {
		return title;
	}
	
	String getSize() {
		return size;
	}
	
	double getUnitPrice() {
		return unitPrice;
	}
	
	String getDescription() {
		return description;
	}
	
}
