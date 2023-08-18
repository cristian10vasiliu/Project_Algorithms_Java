/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JustJava
 * created three static methods , one to validate a String type input, one to validate int input
 * and one for a float input
 * then called the methods and assigned the returned value to the corresponding variable
 * called the addNewCustomer method to add it , with a consecutive customer id number
 */
public class AddNewCustomer {

    public static void main(String[] args) {
        // MyArrayList object to hold the customers list
        MyArrayList<Customer> customerList = new MyArrayList<Customer>();

        //instance of ReadData class
        ReadData list = new ReadData();
        customerList = list.customerList;

        //print the list
        //System.out.println("Customer list unsorted : " + "\n" + customerList.toString());
        //variables needed for customer constructor
        int custID;
        int sold;
        String region, country, item;
        float price;
        

        
        Scanner keyboard = new Scanner(System.in);

        //custId input
        System.out.print("Enter custumer id of the new entry. Please enter a positive number! ");
        custID = validateInt();
        System.out.println("custid " + custID);
       
        //region input
        System.out.print("Please enter the region of the new customer entry ");
        region = validateStringInput();
        System.out.println("region " + region);
        
        
        //country input
        System.out.print("Please enter the country of the new customer entry ");
        country = validateStringInput();
        System.out.println("country " + country);

        //item input
        System.out.print("Please enter the item of the new customer entry ");
        item = validateStringInput();
        System.out.println("item " + item);

        //item price input
        System.out.print("Please enter the price of the item ");
        price = promptPrice();
        System.out.println("price " + price);

        //nr of items input
        System.out.print("Please enter the nr of items sold of the new customer entry ");
        sold = validateInt();
        System.out.println("sold " + sold);

        
        //create a new customer
        Customer newCustomer = new Customer(custID, region, country, item, sold, price);

        //add the customer to the list
        addNewCustomer(customerList,newCustomer);

        System.out.println("Customer list unsorted : " + "\n" + customerList.toString());
         

    }//main method

    public static int validateInt() {
        int custId = 0;
        while (true) {
            try {
                Scanner keyboard = new Scanner(System.in);
                
                String input = keyboard.nextLine();
                if (input != null && input != "") {// if the input is not empty then parse
                    custId = Integer.parseInt(input);
                    if (custId < 0) {                   //if the input is negative number then throw a new exception
                        throw new NegativeNumberException();
                    }
                }
                break;
            } catch (NegativeNumberException nne) {
                System.out.println(nne.getExceptionMessage());

            } catch (NumberFormatException e) {
                System.out.println("Not a valid number! Try again");
            }
        }
        return custId;

    }//prompt cust id

    public static String validateStringInput() {
        String str = "";
        while (true) {
            try {
                Scanner keyboard = new Scanner(System.in);
                str = keyboard.nextLine();
                if (str.trim().isEmpty()) { //we first get rid of the white spaces and then if it is empty we throw a new exception 
                    throw new EmptyStringException("Field can not be empty!");
                }
                boolean containsDigits = false; // we loop through the chars and if any of them is a digit then the flag becomes true and we throw a new exception
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isDigit(str.charAt(i))) {
                        containsDigits = true;
                    }
                }
                if(containsDigits){
                    throw new DigitsException("Field can not contain digits");
                }
                break;

            } catch (EmptyStringException e) {
                System.out.println(e.getExceptionMessage());
            } catch (DigitsException d) {
                System.out.println(d.getMsg());
            }
        }
        return str;

    }
    
    public static float promptPrice(){
        float price = 0;
        while (true) {
            try {
                Scanner keyboard = new Scanner(System.in);
                
                String input = keyboard.nextLine();
                if (input != null && input != "") {
                    price = Float.parseFloat(input);
                    if (price < 0) {
                        throw new NegativeNumberException();
                    }
                    break;
                }
            } catch (NegativeNumberException nne) {
                System.out.println(nne.getExceptionMessage());

            } catch (NumberFormatException e) {
                System.out.println("Not a valid number! Try again");
            }
        }
        return price;
    }
    
    
    
                
      /*   ------------------------------------------------------------------------------------
    Task 5 - Add a customer entry at the end of the list with a new consecutive id number 
            to do that we have to update/over-write the custID , with the array size + 1
    
            Not sure if i understand correctly the task here...
            
     */
    
    public static void addNewCustomer( MyArrayList<Customer> customerList, Customer customer){
        customer.setCustID(customerList.size() + 1);
        customerList.add(customer);
    }
    
    

}//class
