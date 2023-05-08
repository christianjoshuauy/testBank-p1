/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author Christian
 */
public class Account {
    private String username;
    private double balance;
    private int userType;
    private int status;
    
    public Account() {
    }

    public Account(String username, double balance) {
        this.username = username;
        this.balance = balance;
        userType = 0;
        status = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
