package ApachePOI.Resource;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
   Main den bir metod çağırmak suretiyle, henüz oluşturulmamış
   path i verilen excel için, program her çalıştıkça içine "test passed"
   yazısını ekleyen metodu yazınız.
   Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
   dosya varsa en son satırın altına yaz.

   File dosya= new File(path); //dosya kontrolü

if (!file.exists()) //dosya yok ise
{
  oluşturup
  merhaba düznya yazsın
}
else
{
   var olan dosyaya eklesin
  }

 */
public class _12_Soru {
    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/Resource/TestSonuclari.xlsx";
        String senaryoAdi="Edit Account";
        String testSonuc="Test Passed";

        writeToExcel(path, senaryoAdi, testSonuc); //excel create
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
    }

    public static void writeToExcel(String path, String senaryoAdi, String testSonuc)
    {
        File dosya=new File(path);

        try {
            if (dosya.exists())   // excel var ise : 2. ve sonraki tüm çalışmalarda burası çalışacak
            {
                //okuma modunda aç
                FileInputStream inputStream = new FileInputStream(path);
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                //değişiklikleri yap
                Row yeniSatir = sheet.createRow(sheet.getPhysicalNumberOfRows());
                Cell cell = yeniSatir.createCell(0); cell.setCellValue(senaryoAdi+" "+sheet.getPhysicalNumberOfRows());
                Cell cell2 = yeniSatir.createCell(1);  cell2.setCellValue(testSonuc);

                //okuma modunu kapat
                inputStream.close();

                //kaydet
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                System.out.println("Var olan Excel e ekleme yapıldı");
            } else   // excel yok ise : sadece 1 kez dosya oluşturmak ve ilk satırı yazmak için çalışacak
            {
                //hafızada oluştur
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Sayfa1");

                //depişiklikleri yap
                Row yeniSatir = sheet.createRow(0);
                Cell cell = yeniSatir.createCell(0); cell.setCellValue(senaryoAdi);
                Cell cell2 = yeniSatir.createCell(1); cell2.setCellValue(testSonuc);

                //kaydet
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                System.out.println("Yeni Excel oluşturuldu ve kaydedildi.");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Hata oluştu "+ex.getMessage());
        }


    }



}