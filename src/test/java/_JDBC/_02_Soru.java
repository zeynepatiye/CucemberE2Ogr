package _JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _02_Soru {
    // city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız
    @Test
    public void Test1() throws SQLException {
        String serverDBURL="jdbc:mysql://acela.proxy.rlwy.net:15150/sakila";
        String username="sdet";
        String password="SDET123!";

        Connection connection= DriverManager.getConnection(serverDBURL, username, password);
        Statement sorguEkrani=connection.createStatement();
        ResultSet sonuclar= sorguEkrani.executeQuery("select * from city");

        while(sonuclar.next())
            System.out.println(sonuclar.getString("city"));  // satırdak, şehir ismi

        connection.close();
    }
}