package ApachePOI.Resource;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : EditAccount.xlsx  in 2.sheet ini kullanabilirsiniz.
 */
public class _11_Soru {

    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI/Resource/Resource/EditAccount.xlsx";
        String sheetName = "editAccount";
        int istenenSutunSayisi = 3;

        List<List<String>> donenData = getData(path, sheetName, istenenSutunSayisi);

        System.out.println("donenData = " + donenData);

    }

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

}