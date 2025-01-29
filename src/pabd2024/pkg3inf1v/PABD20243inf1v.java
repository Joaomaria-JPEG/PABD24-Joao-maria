/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pabd2024.pkg3inf1v;

import java.sql.*;

/**
 *
 * @author 20221074010038
 */
public class PABD20243inf1v {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Customer c = new Customer(2, "Pedro", "Rocha", "Pedro.rocha@gmail.com", 12, 1);
        CustomerDAO dao = new CustomerDAO();
        dao.insertCustomer(c);
//        dao.updateCustomer(0);
//        dao.deleteCustomer(0);
        dao.showCustomer();
    }

}
