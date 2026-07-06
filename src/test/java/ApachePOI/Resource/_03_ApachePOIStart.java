package ApahePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {

    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApahePOI/Resource/ApacheExcel2.xlsx";

        // Dosya yı aç yani bağlantı kur
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        // Dosyadaki WorkBook u oku ve Hafızaya yükle
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        // Çalışma sayfasını seç
        Sheet calismaSayfasi = calismaKitabi.getSheetAt(0); // getSheet("isim")

        // Satırı seç
        Row satir = calismaSayfasi.getRow(0);  // 0.Satır

        // hücreyi oku
        Cell hucre = satir.getCell(0);

        System.out.println("hucre = " + hucre);
    }

}