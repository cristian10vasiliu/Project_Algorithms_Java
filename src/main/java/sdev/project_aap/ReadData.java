/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JustJava
 * class to read the data and add it to an arrayList
 */
public class ReadData {
    MyArrayList<Customer> customerList;
    //file path
    File directory = new File("src\\main\\java"); 
    String region = directory.getAbsolutePath() + "\\sdev\\Project_AAP\\customers.csv";
        
    
    //constructor, when we call it , we`re going to read the list
    public ReadData(){
        this.customerList = readData(region);
    }
    
    public  MyArrayList<Customer> readData(String filePath){
        
        //create arrayList to hold the customerList objects
            MyArrayList<Customer> customerList = new MyArrayList<>();
        try{
            //create a scanner object to read from the file
            Scanner sc = new Scanner(new File(filePath));
            // this will just print the header in CSV file
            sc.nextLine();
            
            int i = 0; String st = "";

            while (sc.hasNextLine()){  //returns a boolean value
                st = sc.nextLine();
                String[] data = st.split(",");
                //we add 
                customerList.add(new Customer(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]), Float.parseFloat(data[5])) );
            }//while loop
            sc.close();  //closes the scanner
                    
        } catch (FileNotFoundException exception){
            System.out.println("Customer file is not found!");
        }
      return customerList;
    }//read data 
    
}
