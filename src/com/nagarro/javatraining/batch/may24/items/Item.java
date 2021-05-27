package com.nagarro.javatraining.batch.may24.items;

 // Abstract Item class 
 public abstract class Item 
 {	
	// Properties  for details of an item
	private String itemName;
	private String itemType;
	private double itemPrice;
	private int    itemQuantity;
	private double salesTaxPerItem;
	
	private double effectiveCost;
	
	// Abstract method for calculation of final cost
    public abstract void calculateEffectiveCost();	
	
    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getEffectiveCost() {
		return effectiveCost;
	}

	public void setEffectiveCost(double effectiveCost) {
		this.effectiveCost = effectiveCost;
	}
	
	public double getSalesTaxPerItem() {
		return salesTaxPerItem;
	}

	public void setSalesTaxPerItem(double salesTaxPerItem) {
		this.salesTaxPerItem = salesTaxPerItem;
	}
 }
