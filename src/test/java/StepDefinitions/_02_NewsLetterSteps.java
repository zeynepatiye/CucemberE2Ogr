package StepDefinitions;

import Pages.DialogPage;
import Pages.NavigatePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _02_NewsLetterSteps {
    NavigatePage np=new NavigatePage();
    DialogPage dp=new DialogPage();

    @And("Navigate to NewsLetter")
    public void navigateToNewsLetter() {
        np.myClick(np.Newsletter);
    }

    @When("Click to Yes")
    public void clickToYes() {
        dp.myClick(dp.subYes);
        dp.myClick(dp.cntBtn);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dp.SuccessMessageValidation();
    }

    @When("Click to No")
    public void clickToNo() {
        dp.myClick(dp.subNo);
        dp.myClick(dp.cntBtn);
    }

    @When("checked to unchecked option")
    public void checkedToUncheckedOption() {
        if (dp.subYes.isSelected())
            dp.myClick(dp.subNo);
        else
            dp.myClick(dp.subYes);
        dp.myClick(dp.cntBtn);
    }
}