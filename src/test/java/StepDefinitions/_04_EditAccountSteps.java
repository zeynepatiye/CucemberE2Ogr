package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import Utilities.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _04_EditAccountSteps {
    NavigatePage np=new NavigatePage();
    DialogPage dp=new DialogPage();

    @And("Navigate to Edit Account")
    public void navigateToEditAccount() {
        np.myClick(np.EditAccount);
    }

    @When("Edit account name as {string} surname as {string}")
    public void editAccountNameAsSurnameAs(String name, String surname) {
        dp.mySendKeys(dp.inputFirstname, name);
        dp.mySendKeys(dp.inputLastname, surname);
        dp.myClick(dp.cntBtn);
    }

    @When("User update EditAccount from Excel")
    public void userUpdateEditAccountFromExcel() {
        List<List<String>> tablo=ExcelUtility.getData(
                "src/test/java/ApahePOI/Resource/EditAccount.xlsx",
                "editAccount",
                2
        );

        for(List<String> satir : tablo)
        {
            np.myClick(np.EditAccount);
            dp.mySendKeys(dp.inputFirstname, satir.get(0));
            dp.mySendKeys(dp.inputLastname, satir.get(1));
            dp.myClick(dp.cntBtn);
            dp.SuccessMessageValidation();
        }

    }
}