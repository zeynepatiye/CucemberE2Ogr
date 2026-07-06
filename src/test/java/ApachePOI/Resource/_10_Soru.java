package ApachePOI.Resource;


// YeniExcel2.xlsx adında bir yeni excele merhaba Dünya 0 şeklinde yazı yazınız.
// Daha sonra program her yeniden çalıştırıldığında altına Merhaba Dünya 1.2.3
// şeklinde eklesin. Yani dosya yok ise oluşturup yazsın, daha sonra hep altına eklesin.

// File dosya=new File(path)
// if ( dosya.exists() )    dosya var ise

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Merhaba Dünya 0
// Merhaba Dünya 1
// Merhaba Dünya 2
// ...
public class _10_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/_08_NewExcelWrite.xlsx";

        File dosya=new File(path);

        if (dosya.exists())   // excel var ise : 2. ve sonraki tüm çalışmalarda burası çalışacak
        {
            FileInputStream inputStream = new FileInputStream(path);//okuma modunda aç
            Workbook workbook = WorkbookFactory.create(inputStream);//excel e tıklattım gibi oldu
            Sheet sheet = workbook.getSheetAt(0);//ilk sayfa ya

            // hafızada idi, değişiklikleri mi yaptım
            int varOlanSatirSayisi=sheet.getPhysicalNumberOfRows(); // var olan satır sayısı
            Row yeniSatir=sheet.createRow(varOlanSatirSayisi);  // yeni satırı en son yerde açıyorum
            Cell yeniHucre=yeniSatir.createCell(0);
            yeniHucre.setCellValue("Merhaba Dünya "+ varOlanSatirSayisi);

            inputStream.close(); // okuma modunu kapat

            //Kaydet
            FileOutputStream outputStream=new FileOutputStream(path); // yazma modunda dosyayı ac
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Var olan Excel e ekleme yapıldı");
        }
        else   // excel yok ise : sadece 1 kez dosya oluşturmak ve ilk satırı yazmak için çalışacak
        {
            XSSFWorkbook workbook=new XSSFWorkbook();
            XSSFSheet sheet=workbook.createSheet("Sayfa1");

            Row yeniSatir=sheet.createRow(0);
            Cell yeniHucre=yeniSatir.createCell(0);
            yeniHucre.setCellValue("Merhaba Dünya 0");

            //Kaydet
            FileOutputStream outputStream=new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close(); // hafızadaki workbook bölgesini boşaltıyor.
            outputStream.close();

            System.out.println("Yeni Excel oluşturuldu ve kaydedildi.");
        }




    }
}