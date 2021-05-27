package com.nagarro.javatraining.batch.may24.items;

public class ManufacturedItem extends Item{
	public void calculateEffectiveCost()
	{
	 double tax, price, interMediatePrice, result;
	 int quantity;
	 
	 price = this.getItemPrice(); 
	 quantity = this.getItemQuantity();
	 
	 interMediatePrice = price * 0.125;
	 tax = interMediatePrice + 0.02 * (price + interMediatePrice);
	 result = (price + tax) * quantity;
	 
	 this.setSalesTaxPerItem(tax);
	 this.setEffectiveCost(result);
	}	
}
