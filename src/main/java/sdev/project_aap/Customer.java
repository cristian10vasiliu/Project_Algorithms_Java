/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

/**
 *
 * @author JustJava
 */
public class Customer implements Comparable<Object> {

	private int custID;
	private String region;
	private String country;
	private String item;
	private int sold;
	private float price;


	// constructor
	public Customer(int custID, String region, String country, String item, int sold, float price) {
		super();
		this.custID = custID;
		this.region = region;
		this.country = country;
		this.item = item;
		this.sold = sold;
		this.price = price;
	}

	// setters and getters
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	// so the film objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the title of the film
	//@Override
        
	public int compareTo(Object obj) {
            //casting the object to a customer type
            Customer cst = (Customer)obj;
            
            if( this.item.compareTo(cst.getItem()) > 0){   
               return 1;
               
            } else if (this.item.compareTo(cst.getItem()) < 0){
               return -1;
               
            } else {
              
            //if the value of the item column is equal the sort after Customer Id
            //will return a negative value as the customer is in ascending order
            //return (cst.getCustID()) - custID; //to sort the list in descending order for the same value items
            return (custID - (cst.getCustID()));      
            }      
	}//compare method


	@Override
	public String toString() {
		return "Customer [custID= " + custID + ", region= " + region + ", country= " + country + ", item = "
				+ item  +  ", sold = " + sold  + ", price = "
				+ price  + "]";
	}

}

