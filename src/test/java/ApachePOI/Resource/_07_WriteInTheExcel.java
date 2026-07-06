package ApachePOI.Resource;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/Resource/Resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // hafızada idi, değişiklikleri mi yaptım
        int varOlanSatirSayisi=sheet.getPhysicalNumberOfRows(); // var olan satır sayısı
        Row yeniSatir=sheet.createRow(varOlanSatirSayisi);  // yeni satırı en son yerde açıyorum
        Cell yeniHucre=yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba Dünya");

        inputStream.close(); // okuma modunu kapat

        //Kaydet
        FileOutputStream outputStream=new FileOutputStream(path); // yazma modunda dosyayı ac
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");
    }
}