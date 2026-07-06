package ApachePOI.Resource;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApahePOI/Resource/ApacheExcel2.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // satır miktarı

            for (int j = 0; j <  sheet.getRow(i).getPhysicalNumberOfCells() ; j++)  // satırdaki hucre sayısı
                System.out.print( sheet.getRow(i).getCell(j)+"\t" ); // zoo[i][j]

            System.out.println();

        }

    }
}