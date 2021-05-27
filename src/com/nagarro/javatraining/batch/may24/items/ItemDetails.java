package com.nagarro.javatraining.batch.may24.items;
import java.util.*;

//class for managing details of items
public class ItemDetails 
{
    
	static Scanner sc;
	static int firstTime = 1;
	static String choice;
	static Item item;
    static Exception e = new Exception();
    
    //method for setting values of an item 
    public static void setItemValues(String name, String type, double price, int quantity , Item item)
    {
    	  item.setItemName(name);
		  item.setItemPrice(price);
		  item.setItemType(type);
		  item.setItemQuantity(quantity);
    }
    
    //main method 
	public static void main(String gg[])
	{  
		 String name = null , type = null;
		 double price = 0.0;
		 int quantity = 0;
		 int errorCounter  = 0;
		 int detailsCounter = 0;
		 ItemsList list = new ItemsList();
		 
	     while(true)
	     {
	       name = type = null; 
	       price = 0.0;	
	       quantity = 0;  
	       errorCounter = 0;
	       detailsCounter = 0;
	       
	       System.out.println("Enter details of item on single line: (Format:  -detailName value )");
		   if(firstTime == 1 ) 
		   {
		   System.out.println("eg. -name Ben -type Raw -price 99.72 -quantity 100 ");
		   firstTime=0;
		   }
		  
		  sc = new Scanner(System.in);
		  
		  String input = sc.nextLine();
		  String[] details = input.split("\\s");
		  if(details.length%2 != 0) System.out.println("Some values are missing");
		  else
		  {		 
		  for(int i=0; i<details.length; i++)
		  {
			  if(details[i].toLowerCase().equalsIgnoreCase("-name"))
			  {
				  detailsCounter++;
				  if(details.length >= 2 * detailsCounter)
				  {
					  if(details[i+1].charAt(0)!= '-') name = details[i+1];
					  else errorCounter++;
				  }
			  }
			  else
			  {
				  if(details[i].toLowerCase().equalsIgnoreCase("-type"))
				  {
					  detailsCounter++;
					  if(details.length >= 2 * detailsCounter) {
						  if(details[i+1].charAt(0)!= '-') {
							 if(details[i+1].equalsIgnoreCase("Raw") || details[i+1].equalsIgnoreCase("Manufactured") || details[i+1].equalsIgnoreCase("Imported")) type = details[i+1];
							 else System.out.println("Type value can only be one of Raw, Manufactured or Imported");
						  }
						  else errorCounter++;
					  }
				  }
				  else
				  {
					  if(details[i].toLowerCase().equalsIgnoreCase("-price"))
					  {
						  try
						  {		     
							  detailsCounter++;
							  if(details.length >= 2 * detailsCounter && Double.valueOf(details[i+1]) >= 0.0) price = Double.valueOf(details[i+1]);
							  else throw e;
						  }
						  catch(Exception e)
						  {
							  errorCounter++;
							  System.out.println("Invalid price value");
							  System.out.println("Item not added in list");
						  }
					  }
					  else 
					  {
						  if(details[i].toLowerCase().equalsIgnoreCase("-quantity"))
						  {
							  try
							  {
								  detailsCounter++;
								  if(details.length >= 2 * detailsCounter && Integer.valueOf(details[i+1]) >= 0)  
							       quantity = Integer.valueOf(details[i+1]);
							  }
							  catch(Exception e)
							  {
								  errorCounter++;
								  System.out.println("Invalid quantity value");
								  System.out.println("Item not added in list");
							  }
						  }
					  }
				  }
			  } 
		   }
	      }
		  if(type == null) System.out.println("Type is mandatory");
		  else
		  {
		  if(errorCounter == 0) {
		      if(type.equalsIgnoreCase("Raw"))
		      {
		    	  item = new RawItem();
		      }
		      else
		      {
		    	  if(type.equalsIgnoreCase("Manufactured"))
		    	  {
		    		  item = new ManufacturedItem();
		    	  }
		    	  else item = new ImportedItem();
		      }
		      setItemValues(name, type, price, quantity, item);
		      list.addInList(item);
		      item.calculateEffectiveCost();
		      System.out.println("Item added in list");
		  }
		  }
		  System.out.println("Do you want to enter more items (y/n)");
		  choice = sc.next();
		  if(choice.equalsIgnoreCase("n") || !(choice.equalsIgnoreCase("y")))
		  {
			  break;
		  }
	    }
	    // Displaying items in the list
	    list.printList();
	}
}
