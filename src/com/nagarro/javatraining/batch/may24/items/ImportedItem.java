package com.nagarro.javatraining.batch.may24.items;

//class for Imported item type
public class ImportedItem extends Item{
	//Implementation of calculateEffectiveCost according to tax rules for Imported item
	public void calculateEffectiveCost()
	{
	 double price, importDuty, surcharge = 0.0, result;
	 int quantity;
	 
	 price = this.getItemPrice();
	 quantity = this.getItemQuantity();
	 importDuty = price * 0.1;
	 result = importDuty + price;
	 
	 if(result <= 100) surcharge = 5.0;
	 else
	 {
		 if(result > 100 && result <= 200) surcharge = 10.0;
		 else
		 {
			 surcharge = (0.5 * result);	 
		 }
	 }
	 result = result + surcharge;
	 this.setSalesTaxPerItem(result);
	 result = result * quantity;
	 this.setEffectiveCost(result);
	}	
}
