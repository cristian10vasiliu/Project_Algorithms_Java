/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdev.project_aap;

/**
 *
 * @author JustJava
 * exception class when the user input contains digits
 */
public class DigitsException extends Exception{

     String msg = "Field can not contain numbers";   
    
    public DigitsException() {
    }

    public DigitsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
     
}
