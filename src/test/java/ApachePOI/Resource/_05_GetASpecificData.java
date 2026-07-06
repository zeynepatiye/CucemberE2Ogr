package ApachePOI.Resource;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
 * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
 * src/test/java/ApachePOI/Resource/LoginData.xlsx
 */
public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {
        String aranan="ADDress";

        String path = "src/test/java/ApachePOI/Resource/Resource/LoginData.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(aranan))
                for (int j = 1; j <  sheet.getRow(i).getPhysicalNumberOfCells() ; j++)
                    System.out.print( sheet.getRow(i).getCell(j)+"\t" );

        //sout  Reading
    }
}
// TODO: Aynı soruyu main de aranan kelimenin gönderildiği ve metodda bulunan
//  sonucun yine main de yazdırılgığı  şekliyle çözünüz