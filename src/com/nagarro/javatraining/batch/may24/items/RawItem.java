package com.nagarro.javatraining.batch.may24.items;

public class RawItem extends Item
{
	
	// Implementation of calculateEffectiveCost for Raw Items
	public void calculateEffectiveCost()
	{
		 double tax, price, result;
		 int quantity;
		 
		 price = this.getItemPrice();
		 quantity = this.getItemQuantity();
		 
		 tax = price * 0.125;
		 result = (price + tax) * quantity;
		 this.setSalesTaxPerItem(tax);
		 this.setEffectiveCost(result);
	}
}
