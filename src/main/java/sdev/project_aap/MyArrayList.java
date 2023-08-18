/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

import java.util.ArrayList;

/**
 *
 * @author JustJava
 */
public class MyArrayList<T> extends ArrayList<T> {

    /*
    Task 1 - Bubble sort ------------------------------------------------------------------------------------
     */
    public void bubbleSort() {
        /*
            first loop to iterate through each element of the list
            second loop to do the comparison
            as after a pass over the list (one iteration of the outside loop) we know that
            the bigger element is placed at the end of the list, in second pass we don`t need to compare it with the one before him
            as we know that it is the biggest , and so one after each pass
            the inner loop nedds to go up to one less element after each pass
            this bubble sort is sorting in ascending order , 
            if we want to sort in descending order then in if statement we have to change the comparison from > to <
            as our compareTo method in customer class, if the items value is equal , it sorts after the Customer id
            our customer id is always negative so it doesn`t do the swap , so the customer id stays in ascending order if the items value are equal
         */

        Comparable elementAtjIndex, elementAtjPlusIndex;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < ((size() - 1) - i); j++) {
                elementAtjIndex = (Comparable) get(j);
                elementAtjPlusIndex = (Comparable) get(j + 1);
                if (elementAtjIndex.compareTo(elementAtjPlusIndex) > 0) {
                    swapElements(j, j + 1);
                }
            }//innerloop   
        }//outerloop
    }//bubble sort

    /*
        as this is a helper method , we can make it private as is going to be used only inside this class
        currentIndex represents  index j
        nextIndex represents  index j+1
     */
    private void swapElements(int currentIndex, int nextIndex) {
        T temp = get(currentIndex);
        set(currentIndex, get(nextIndex));
        set(nextIndex, temp);
    }

    //bubble method 2
    /*
        to improve the speed of the algorithm if it is already sorted we can check if it is already sorted
        by createing a boolean variable isSorted assigned to true
        if after the first pass there is no swaps then the variable isSorted stays true 
        and we break from the loop after 1 pass/ best case scenario
        
     */
    public void improvedBubbleSort() {
        boolean isSorted = true;
        for (int i = 0; i < size(); i++) {
            // isSorted = false;
            for (int j = 0; j < ((size() - 1) - i); j++) {
                Comparable elementAtjIndex = (Comparable) get(j);
                Comparable elementAtjPlusIndex = (Comparable) get(j + 1);
                if (elementAtjIndex.compareTo(elementAtjPlusIndex) > 0) {
                    swapElements(j, j + 1);
                    isSorted = false;
                }
            }//innerloop   
            if (isSorted == true) {
                break;
            }
        }//outerloop
    }//bubble sort 2

    /*
    End Task 1 - Bubble sort ------------------------------------------------------------------------------------
     */
 /*
    Task 2 - Quick sort ------------------------------------------------------------------------------------
     */
 /*
        the recursive call on the left and right (of the pivot) partition , well execute until we get to the base case
        where the partition/list has only 1 element so startIndex >= endIndex
        we can not sort just one element as is already ordered...
        the partition method will return the index of the pivot for the next recursive call
        the recursive call on the left and right (of the pivot) partition , well execute until we get to the base case
        where the partition/list has only 1 element so startIndex >= endIndex
        we can not sort just one element as is already ordered...
        the partition method will return the index of the pivot for the next recursive call
     */
    public void quickSort(int startIndex, int endIndex) {
        int pivotIndex;
        if (startIndex < endIndex) {
            //set the pivot 
            pivotIndex = partition(startIndex, endIndex);

            //recursive call on the (list) left side of the pivot
            //from start index until the element before the pivot 
            quickSort(startIndex, pivotIndex - 1);

            //recursive call on the (list) right side of the pivot
            //from thefirst element after the pivot until the end index
            quickSort(pivotIndex + 1, endIndex);

        } else { // if startIndex >= endIndex
            return;
        }
    }//quick sort method

    /*   this method will partition/split our list in two 
            we start by declaring our required local variables
            leftPointerGoingUp is a index pointer for the left side of the list, and it is moving up the list 
            rightPinter is a index pointer for the rigth side of the list, and it is moving down the list
            the pivot, we will set it as the value/element at the first index
            1. create a loop that will move the left pointer and the right pointer to each other until they meet/cross
            this loop will execute until the pointers meet - outer loop
            2. create a loop to shift the left pointer up through the list until we find a value(element) that is bigger/more (or equal) then the pivot value(element)
            or until the pointers meet
            3. create a loop to shift the right pointer down through the list until we find a value that is smaller/less then (or equal) then the pivot
            or until the pointers meet
            if bigger/more and smaller/less elements/values are found then we swap them
            if the left and right pointers meet/cross each other then we replace the element of the pivot with the element of the rightPointerGoingDown
            
     */
    public int partition(int startIndex, int endIndex) {

        //select the first element as the pivot
        T pivot = get(startIndex);

        int leftPointerGoingUp = startIndex;

        int rightPointerGoingDown = endIndex;

        while (leftPointerGoingUp < rightPointerGoingDown) {

            //shift the left pointer up, to the right
            while (leftPointerGoingUp < endIndex && ((Comparable) get(leftPointerGoingUp)).compareTo((Comparable) pivot) <= 0) {
                leftPointerGoingUp++;
            }

            //shift the right pointer down, to the left
            while (rightPointerGoingDown > startIndex && ((Comparable) get(rightPointerGoingDown)).compareTo((Comparable) pivot) >= 0) {
                rightPointerGoingDown--;
            }
            //if the left pointers and right pointers did not cross each other  we swap the elements at the specifid indexes
            //we create a temporary object(of type generic) to store one of the elements we want to swap
            //we stored/save the element at at leftPointerGoingUp
            //this means we could set/put in the leftPointerGoingUp index , the element at rightPointerGoingDown 
            //then we will set the element at the right pointer with the value that is saved in the temporary object
            if (leftPointerGoingUp < rightPointerGoingDown) {
                T temp = get(leftPointerGoingUp);
                set(leftPointerGoingUp, get(rightPointerGoingDown));
                set(rightPointerGoingDown, temp);
            }
        }//outer while loop

        //at this point the left pointer and right pointer have crossed each other so we have to
        //swap the value/element of the pivot with the value/element of the rightPointerGoingDown
        //the pivot is actually holding a copy of the first element in this list, the lowest index
        //so it is acting as a temporary element for the swap operation
        //first we set the value/element in the first index - startIndex, 
        set(startIndex, get(rightPointerGoingDown));
        set(rightPointerGoingDown, pivot);

        return rightPointerGoingDown;
    }//partition method

    /*
    Task 2 - Quick sort End ------------------------------------------------------------------------------------
     */
 /*
    Task 4 - Binary search ------------------------------------------------------------------------------------
     */
    //this method calls two helper methods , one to find the first occurance and second to find the last occurance
    //if the findFirstOccurance
    public String binarySearch(String target) {
        //create a list to hold the customers with item equal with  the target
        MyArrayList<Customer> searchResults = new MyArrayList<>();
        int indexFirstOccurance;
        int indexLastOccurance;
        indexFirstOccurance = findFirstOccurance(target);
        indexLastOccurance = findLastOccurance(target);
        if (indexFirstOccurance == -1) {
            return "Not an existing " + target;
        } else {
            for (int i = indexFirstOccurance; i <= indexLastOccurance; i++) {
                searchResults.add((Customer) get(i));
            }
        }
        return searchResults.toString();
    }
    //binary search

    /*
        this variation of binary search works exactly like the typical binary search algorithm
        the diference is that when we find the target in the list we don`t exit the search
        instead we update the variable index and we continue , until we find the next match , 
        then we update again the index variable
        and we continue doing that until we get to the last element
        if the last element is equal with the target then we update the index variable
        if last element it is not equal with the target then the index is holding the last index of the element equal with the target
        if the target is not on the list then the index is not updated and we return -1
    
        so we have two methods:
        1.to find the first occurance of the target 
        if the middle element is not equal with the target then the algorithms perfoms as usual
            -if element at middle is more then the target then we go to the left
            -if element at middle is less then the target then we go to the right
        if the element at middle is equal with the target,we want to go to the left ,because we want to find the first occurance
        which means the equal sign goes in the statement that moves the algorithm to the left:  if (((Customer) get(middle)).getItem().compareTo( target) >= 0)
            -we update the end variable, we go the the left of the element , so the end becomes middle -1
            -we save the  middle(index)  in index 
            -and if there is more then one element we do the same thing , each time updating the index if the target is found
            -until we get to one element (if last elem equal with target , update index)
            -in the end the index variable is holding the index of the last element equal with the target
        2.to find the last occurance of the target 
        exactly the same as first method, the only difference is when the middle is equal with the target
        we want to move right of the middle element
        so the = sign is in the statement that moves us to the right : if (((Customer) get(middle)).getItem().compareTo( target) <= 0)
        
        As the compareTo method is overriden in the Customer class, 
        i wanted to use the in-build compareTo method to compare the (String) target with the (String) item
        so i casted the T element to a Customer and then i got the item , to compare it with the target
    
     */
    private int findFirstOccurance(String target) {
        int index = -1; //if we don`t find the element we return -1

        //initialize our start and end indexes
        int start = 0;
        int end = size() - 1;

        //loop runs until we get to a single element ,
        //if the element it is the target then we update the index
        while (start <= end) {
            int middle = (start + end) / 2;

            if (((Customer) get(middle)).getItem().compareTo(target) >= 0) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

            if (((Customer) get(middle)).getItem().compareTo(target) == 0) {
                index = middle;
            }
        }
        return index;
    }//first occurance

    public int findLastOccurance(String target) {
        int index = -1;
        int start = 0;
        int end = size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (((Customer) get(middle)).getItem().compareTo(target) <= 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }

            if (((Customer) get(middle)).getItem().compareTo(target) == 0) {
                index = middle;
            }
        }

        return index;
    }//last occurance

    /*
    Task 4 - Binary search End------------------------------------------------------------------------------------
     */
 
    
    
    //overrided the toString method to be easier, to print the list
    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < size(); i++) {
            list += get(i) + "\n";
        }
        return list;
    }//toString

}//class
