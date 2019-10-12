package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    static Connection con = null;

    static {
        try {
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/FeedBack";
            String user = "root";
            String pass = "root";
            con = DriverManager.getConnection(url, user, pass);
        } 
        
        catch (Exception e) {
            System.out.println("mc\n" + e);
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
