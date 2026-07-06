package ApachePOI.Resource;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  varolan boş bir excel dosyasına
 *  1 den 10 kadar çarpımlar için yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */
//        1 x 1 = 1
//        1 x 2 = 2
//        1 x 3 = 3
//        1 x 4 = 4
//        1 x 5 = 5
//        1 x 6 = 6
//        1 x 7 = 7
//        1 x 8 = 8
//        1 x 9 = 9
//        1 x 10 = 10
public class _09_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/Resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int yeniSatirNo=0;
        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <=10 ; j++) {
                Row yeniSatir=sheet.createRow(yeniSatirNo++);
                //System.out.println(i+"x"+j+"="+ (i*j) );
                Cell cell1=yeniSatir.createCell(0); cell1.setCellValue(i);
                Cell cell2=yeniSatir.createCell(1); cell2.setCellValue("x");
                Cell cell3=yeniSatir.createCell(2); cell3.setCellValue(j);
                Cell cell4=yeniSatir.createCell(3); cell4.setCellValue("=");
                Cell cell5=yeniSatir.createCell(4); cell5.setCellValue(i*j);
            }

            Row yeniSatir=sheet.createRow(yeniSatirNo++);
        }

        inputStream.close();

        //Kaydet
        FileOutputStream outputStream=new FileOutputStream(path); // yazma modunda dosyayı ac
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");
    }
}