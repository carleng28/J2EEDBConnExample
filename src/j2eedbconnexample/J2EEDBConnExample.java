/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2eedbconnexample;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class J2EEDBConnExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        //First we load the driver
        String dbURL = "jdbc:mysql://localhost:3306/mytest?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        //Second, we stablish the connection
        Connection conn = DriverManager.getConnection(dbURL, user, password);
        Statement statement =  conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM phonebook");
        
        System.out.println("TelNo           Fname       Lname");
        
        while (rs.next()){
        
            
            System.out.print(rs.getString("TelNo") +"\t");
            System.out.print(rs.getString("Fname") +"\t");
            System.out.println(rs.getString("Lname"));
            
        }
    }
    
}
