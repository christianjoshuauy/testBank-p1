/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class Connect {
    Connection conn = null;
    
    public Connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbank","root","");
//            JOptionPane.showMessageDialog(null, "Connected");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addAccount(Account account) {
        Statement stmt;
        String sql;
        try {
            stmt = conn.createStatement();
            sql = "INSERT INTO account (username, balance) VALUES('" + account.getUsername() + "', " + account.getBalance() + ")";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void closeAccount(String username) {
        Statement stmt;
        String sql;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            sql = "SELECT * FROM account WHERE username='" + username + "'";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                ConfirmAccountClosure cac = new ConfirmAccountClosure(username);
                cac.show();
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void confirmCloseAccount(String username) {
        Statement stmt;
        String sql;
        try {
            stmt = conn.createStatement();
            sql = "UPDATE account SET status=-1 WHERE username='" + username + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
