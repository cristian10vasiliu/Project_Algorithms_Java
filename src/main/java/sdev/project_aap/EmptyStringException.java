/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

/**
 *
 * @author JustJava
 * exception class when the user enters empty strings
 */
public class EmptyStringException extends Exception{

        String exceptionMessage = "Empty string! Please type something !";
        
    public EmptyStringException() {
    }

    public EmptyStringException(String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }      
}
