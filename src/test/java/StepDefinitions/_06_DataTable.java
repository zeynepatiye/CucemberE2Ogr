package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _06_DataTable {
    NavigatePage np=new NavigatePage();
    DialogPage dp=new DialogPage();

    @And("Click on Element Navigate")
    public void clickOnElementNavigate(DataTable linkler) {
        List<String> listLinkler=linkler.asList();

        for (int i = 0; i < listLinkler.size(); i++) {
            np.myClick( np.getWebElement(listLinkler.get(i)));
        }

    }

    @And("User sending info in Dialog")
    public void userSendingInfoInDialog(DataTable kutuVeYazi) {
        List< List<String>> listKutuVeYazi= kutuVeYazi.asLists();

        for (int i = 0; i < listKutuVeYazi.size(); i++) {
            WebElement textBox= dp.getWebElement(listKutuVeYazi.get(i).get(0));
            dp.mySendKeys(textBox, listKutuVeYazi.get(i).get(1));

            //System.out.println(listKutuVeYazi.get(i).get(0)+" "+listKutuVeYazi.get(i).get(1));
        }

    }

    @And("Click on Element Dialog")
    public void clickOnElementDialog(DataTable butonlar) {
        List<String> listbutonlar=butonlar.asList();

        for (int i = 0; i < listbutonlar.size(); i++) {
            dp.myClick( dp.getWebElement(listbutonlar.get(i)));
        }
    }
}