package _JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {
    public static Connection connection;
    public static Statement sorguEkrani;

    public static void DBConnectionOpen(){
        String serverDBURL="jdbc:mysql://acela.proxy.rlwy.net:15150/sakila";
        String username="sdet";
        String password="SDET123!";

        try {
            connection = DriverManager.getConnection(serverDBURL, username, password);
            sorguEkrani = connection.createStatement();
        }
        catch (Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose(){
        try {
            connection.close();
        }
        catch (Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

}