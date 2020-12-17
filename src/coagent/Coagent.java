/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coagent;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lenovo
 */
public class Coagent {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //getConnection();
        javax.swing.JFrame gui = new Login();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setResizable(true);
        
        /*
        javax.swing.JFrame gui = new gui();
        gui.setVisible(true);
        gui.setResizable(true);
        */
        
    }
        public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/coagent?serverTimezone=UTC";
            String username = "root";
            String password = keys.dbPassword;
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Connected!");
            return conn;
        } catch(Exception e){System.out.println(e);}
        return null;
    }
}

