package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_GetMetaData extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        //MetaFizik -> Fizik ötesi, fiziğin dışındakiler
        //MetaData -> Data nın dışındaki gelen veriler
        DBConnectionOpen();
        ResultSet rs= sorguEkrani.executeQuery("Select * from language");
        ResultSetMetaData rsmd=rs.getMetaData();
        int kolonSayisi= rsmd.getColumnCount();

        while(rs.next()) {
            for (int i = 1; i <= kolonSayisi; i++)
                System.out.print(rs.getString(i) + "\t");

            System.out.println();
        }

        DBConnectionClose();
    }


}