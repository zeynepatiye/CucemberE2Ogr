package _JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class _05_DBUtilitySoru extends JDBCParent{

    // Gönderilen sorgu sonucundaki tüm datayı bir List olarak döndüren metodu yazınız.
    public static void main(String[] args) {

        String sorguSql="select film_id,title,release_year from film";
        ArrayList<ArrayList<String>> donenData= getListData(sorguSql);

        System.out.println("donenData = " + donenData);
    }

    public static ArrayList<ArrayList<String>> getListData(String sorgu){
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();
        DBConnectionOpen();

        try {
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData();
            int kolonSayisi = rsmd.getColumnCount();

            while (rs.next()) {
                ArrayList<String> satir=new ArrayList<>();
                for (int i = 1; i <= kolonSayisi; i++)
                    satir.add(rs.getString(i));

                tablo.add(satir);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        DBConnectionClose();
        return tablo;
    }



}