/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

import java.io.File;
import java.util.Random;

/**
 *
 * @author JustJava
 */
public class MyArrayListApp {

    public static void main(String[] args) {

        // MyArrayList object to hold the customers list
        MyArrayList<Customer> customerList = new MyArrayList<Customer>();

        //instance of ReadData class
        ReadData list = new ReadData();
        customerList = list.customerList;

        //print the list
        //System.out.println("Customer list unsorted : " + "\n" + customerList.toString());
        
       
        
        // Task 1 - Bubble sort ------------------------------------------------------------------------------------
        //sort the list with bubble sort
        //customerList.bubbleSort();
        customerList.improvedBubbleSort(); 

        //print the sorted list
        //System.out.println("Customer list sorted with bubble sort : " + "\n" + customerList.toString());
        System.out.println("Print just the customer id and the items to be easier to read ");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i).getCustID() + " " + customerList.get(i).getItem());
        }
        // Task 1 - Bubble sort ------------------------------------------------------------------------------------
        
         
         
         
         
        /*   <-- //Please Uncomment to run
        
        // Task 2 - Quick sort ------------------------------------------------------------------------------------
        customerList.quickSort(0, customerList.size() - 1);
        //System.out.println("Customer list sorted with bubble sort : " + "\n" + customerList.toString());
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i).getCustID() + " " + customerList.get(i).getItem());
        }
        // Task 2 - Quick sort ------------------------------------------------------------------------------------
         
         */  //Please Uncomment to run
         
         
         
        /* Task 3 - Bubble sort - complexity of your sorting algorithm------------------------------------------------------------------------------------
                    to get 10, 100, 1000, 5000, size lists of customers created
                    * a method:getSmallerLists, to create and randomly populate a list of given size, in this class
  
                    *.... i ran it  the algorithms a few times then decided to improve the analysis of time complexity
                    *
                    * a loop will execute n times : randomly populate the lists 
                    * read the duration of bubble sort for each list 
                    * add the duration to a variable sum 
                    * after the loop is finished get the average for each list
                    *
         */
        /* <-- //Please Uncomment to run
        
        //create 4 list, to hold 10, 100, 1000, 5000 customers
         MyArrayList<Customer> customerList1 = new MyArrayList<>();
         MyArrayList<Customer> customerList2 = new MyArrayList<>();
         MyArrayList<Customer> customerList3 = new MyArrayList<>();
         MyArrayList<Customer> customerList4 = new MyArrayList<>();
        
        
        int numberOfiterations = 5;
        long startTime;
        long endTime;
        long duration;
        long sum10 = 0;//sum of duration for 10 entries list
        long sum100 = 0;//sum of duration for 100 entries list
        long sum1000 = 0;//sum of duration for 1000 entries list
        long sum5000 = 0;//sum of duration for 5000 entries list
        long sum10000 = 0;//sum of duration for 10000 entries list
        
        for (int i = 0; i < numberOfiterations; i++) {
            //populate the lists and sort each list
            customerList1 = getSmallerLists(customerList, 10);
            customerList2 = getSmallerLists(customerList, 100);
            customerList3 = getSmallerLists(customerList, 1000);
            customerList4 = getSmallerLists(customerList, 5000);

            System.out.println("-----------------------------------------------");
            startTime = System.currentTimeMillis();
            customerList1.bubbleSort();
            //customerList1.improvedBubbleSort();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            sum10 += duration;
            System.out.println("BubbleSort of " + customerList1.size() + " elements took " + duration + " milliseconds");

            System.out.println("-----------------------------------------------");
            startTime = System.currentTimeMillis();
            customerList2.bubbleSort();
            //customerList2.improvedBubbleSort();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            sum100 += duration;
            System.out.println("BubbleSort of " + customerList2.size() + " elements took " + duration + " milliseconds");

            System.out.println("-----------------------------------------------");
            startTime = System.currentTimeMillis();
            customerList3.bubbleSort();
            //customerList3.improvedBubbleSort();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            sum1000 += duration;
            System.out.println("BubbleSort of " + customerList3.size() + " elements took " + duration + " milliseconds");

            System.out.println("-----------------------------------------------");
            startTime = System.currentTimeMillis();
            customerList4.bubbleSort();
            //customerList4.improvedBubbleSort();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            sum5000 += duration;
            System.out.println("BubbleSort of " + customerList4.size() + " elements took " + duration + " milliseconds");

            System.out.println("-----------------------------------------------");
            startTime = System.currentTimeMillis();
            customerList.bubbleSort();
            //customerList.improvedBubbleSort();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            sum10000 += duration;
            System.out.println("BubbleSort of " + customerList.size() + " elements took " + duration + " milliseconds");

        }//for loop
        System.out.println("-------------------------------------------");
        System.out.println("Bubble sort average time to sort a list of 10 entries is: " + (sum10 / numberOfiterations));
        System.out.println("Bubble sort average time to sort a list of 100 entries is: " + (sum100 / numberOfiterations));
        System.out.println("Bubble sort average time to sort a list of 1000 entries is: " + (sum1000 / numberOfiterations));
        System.out.println("Bubble sort average time to sort a list of 5000 entries is: " + (sum5000 / numberOfiterations));
        System.out.println("Bubble sort average time to sort a list of 10000 entries is: " + (sum10000 / numberOfiterations));
        
        // Task 3 - Bubble sort - complexity of your sorting algorithm ------------------------------------------------------------------------------------
        
        */      //Please Uncomment to run
         
         
        /* <-- //Please Uncomment to run
         
        //Task 4 - Binary search ------------------------------------------------------------------------------------
        //sort the list as binary search works with sorted lists
        customerList.quickSort(0, customerList.size() - 1);
        // for (int i = 0; i < customerList.size(); i++) {
        //    System.out.println("Index: " + i + " ./" +customerList.get(i).getCustID() + " " + customerList.get(i).getItem());
        // }
        String target = "Office Supplies";
        // System.out.println("First Occurance " + customerList.findFirstOccurance(target));
        // System.out.println("Last Occurance " + customerList.findLastOccurance(target));
        System.out.println("List of the customers with item: " + target);
        System.out.println(customerList.binarySearch(target));
        //Task 4 - Binary search ------------------------------------------------------------------------------------
        
        */ //Please Uncomment to run

    }//main method

    /*  For task 3 - complexity of your sorting algorithm
        method to get 10, 100, 1000, 5000 costomers list
        static method with two parameters - the whole list of customers , and a size which will determine the size of the smaller list
        randomly getting customers from the 10000 entries list, and add them to smaller list
     */
    public static MyArrayList<Customer> getSmallerLists(MyArrayList<Customer> customerList, int size) {
        MyArrayList<Customer> sizedCustomerList = new MyArrayList<Customer>();
        Random rand = new Random();
        int index;
        for (int i = 0; i < size; i++) {
            index = rand.nextInt(10000);
            sizedCustomerList.add(customerList.get(index));
        }
        return sizedCustomerList;
    }//get smaller lists method  

}//class
