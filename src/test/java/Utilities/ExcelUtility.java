package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

    //Excelden istediğim kadar sütunu oku bana List olarak ver
    public static List<List<String>> getData(String path, String sheetName, int istenenSutunSayisi) {
        List<List<String>> tablo = new ArrayList<>();
        Sheet sheet =null;
        FileInputStream inputStream=null;

        try {
            inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> satir=new ArrayList<>();

            for (int j = 0; j <  istenenSutunSayisi ; j++)
                satir.add( sheet.getRow(i).getCell(j).toString()  );

            tablo.add(satir);
        }

        //2 boyutlu bir List olarak geri gönderiniz

        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tablo;
    }


    //Verdiğim bilgileri Excele yaz (dosya önce yok, sonra o dosyaya devam et)
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