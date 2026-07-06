package ApachePOI.Resource;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // hafızada bir workbook oluşturucam
        // onun içide yine hafızada bir sheet oluşturucam
        // yazma işlemlerini yapıp
        // kaydedicem

        XSSFWorkbook workbook=new XSSFWorkbook(); // hafızada worbook oluşturuldu
        XSSFSheet sheet=workbook.createSheet("Sayfa1"); // hafızada sheet oluşturuldu

        // kalan kısım aynı : Değişiklikleri yap
        Row yeniSatir=sheet.createRow(0);
        Cell yeniHucre=yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba yeni Excel Satırı");

        //Kaydet
        String path = "src/test/java/ApachePOI/Resource/Resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();//hafızadaki workbook bölgesini boşaltıyor .hafızayı temizliyor
        outputStream.close();

        System.out.println("Yeni Excel oluşturuldu ve kaydedildi.");
    }
}