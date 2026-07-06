package _JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void Test1() throws SQLException {
        String serverDBURL="jdbc:mysql://acela.proxy.rlwy.net:15150/sakila";
        String username="sdet";
        String password="SDET123!";

        //1- bağlantı bilgilerini girdik DB server bağlandık
        Connection connection= DriverManager.getConnection(serverDBURL, username, password);

        //2- Sorgu ekranını açtık
        Statement sorguEkrani=connection.createStatement();

        //3- Sorgu ekranına sorguyu yazdım ve çalıştırdım
        ResultSet sonucTablosuGostergesi=sorguEkrani.executeQuery("select * from customer");

        //4- Sonuçlar elimizde satır satır ilerleyerek bakalım
        sonucTablosuGostergesi.next(); // bu next komutuyla ilk satırı şu an aldık
        String ad=sonucTablosuGostergesi.getString("first_name");
        System.out.print("ad = " + ad);

        String soyad=sonucTablosuGostergesi.getString("last_name");
        System.out.println(" soyad = " + soyad);

        connection.close();
    }


}