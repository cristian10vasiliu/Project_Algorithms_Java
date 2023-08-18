/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

/**
 *exception class when the user enters negative numbers
 * @author JustJava
 */
public class NegativeNumberException extends Exception {
    String exceptionMessage = "Negative numbers not allowed!";
    
    //constructor

    public NegativeNumberException() {
    }

    public NegativeNumberException(String message) {
        super(message);
        this.exceptionMessage = message;
    }


    public String getExceptionMessage() {
        return exceptionMessage;
    }
    
    
}
