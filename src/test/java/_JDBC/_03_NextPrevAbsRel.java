package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        DBConnectionOpen();
        ResultSet rs= sorguEkrani.executeQuery("select * from language");

        rs.next(); // 1 adım ileri, sonraki yani burada ilk adım, ilk satır
        System.out.println("1.satır = " + rs.getString("name")); // English

        rs.next(); // 1 adım ileri, sonraki satir
        System.out.println("2.satır = " + rs.getString("name")); // italian

        rs.previous(); // 1 adım geri
        System.out.println("1.satır = " + rs.getString("name"));  // English

        rs.first(); // 1.adıma git
        System.out.println("ilk adım = " + rs.getString("name"));  // English

        rs.last(); // son adıma git
        System.out.println("Son adım = " + rs.getString("name"));  // German
        int sonSatirMik=rs.getRow(); // kaçıncı satırda olduğu bilgisi
        System.out.println("sonSatirMik = " + sonSatirMik);

        rs.absolute(3); // 3 nolu satıra direk git, hezaman baştan sayar
        System.out.println("3.Satır = " + rs.getString("name")); //Japanese

        rs.relative(3); // 3 adım daha git olduğun yerden
        System.out.println("6.Satır = " + rs.getString("name"));  // German

        DBConnectionClose();
    }

// rs.next() : sonraki satır
// rs.previous : önceki satır
// rs.absolute(10) : baştan itibaren 10.satıra ileri gider.
// rs.relative(10) : bulunduğu yerden 10.satıra ileri gider.
// rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
// rs.relative(-5) :  - (eksi) bulunduğu yerden 5 satır geri
// ilk satırdan relative ile 5 geri gitmek istersek sınırı taştığı için hata verecektir
// rs.first() :  ilk satıra git
// rs.last() :  Son satıra git
// rs.getRow(); bulunduğu satırın kaçıncı satır bilgisini veririr

}