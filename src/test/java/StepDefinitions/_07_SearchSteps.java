package StepDefinitions;

import Pages.DialogPage;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;

public class _07_SearchSteps {
    DialogPage dp=new DialogPage();

    @Then("Send The query to The database {string} and control match")
    public void sendTheQueryToTheDatabaseAndControlMatch(String sorgu) {
        ArrayList<ArrayList<String>> dbUrunler= DBUtility.getListData(sorgu);
//        System.out.println(sorgu);
//        System.out.println(dbUrunler);

        Assert.assertTrue( dbUrunler.size() == dp.srcNameList.size(), "Ürünlerin sayısı aynı değil");

        for (int i = 0; i < dbUrunler.size(); i++)
            Assert.assertTrue(
                    dbUrunler.get(i).get(0).equals(dp.srcNameList.get(i).getText() )
                    , "Eşleştirme yapılamadı, ürün sıraları aynı değil"
            );

    }
}