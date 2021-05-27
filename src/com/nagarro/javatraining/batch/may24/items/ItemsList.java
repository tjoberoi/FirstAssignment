package com.nagarro.javatraining.batch.may24.items;
import java.util.*;
public class ItemsList {
	
 //List to store items 
   List<Item> itemsList;
 
 //Constructor to initialize list
   ItemsList()
   {
	   this.itemsList = new LinkedList<>();
   }
   
 //method to add items in list
   public void addInList(Item item)
   {
	   this.itemsList.add(item);
   }
   
 //method to display items in list
   public void printList()
   {
	   System.out.println("\n"+"Printing List of Items"+"\n");
	   System.out.println("Name          | Price          | SalesTaxPerItem          | EffectiveCost");
	   for(Item item : itemsList)
	   {
		   System.out.printf("%-15s %-16.2f %-26.2f %.2f\n",item.getItemName(), item.getItemPrice(), item.getSalesTaxPerItem(),item.getEffectiveCost());
	   }
   }
}
