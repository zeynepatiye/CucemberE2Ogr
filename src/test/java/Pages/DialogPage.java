package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DialogPage extends ParentPage{

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement password;

    @FindBy(xpath = "//*[@value='Login']")
    public WebElement btnLogin;

    @FindBy(xpath="//input[@type='radio' and @value='1']")
    public WebElement subYes;

    @FindBy(xpath="//*[@value='Continue']")
    public WebElement cntBtn;

    @FindBy(css="[class='alert alert-success alert-dismissible']")
    public WebElement msgLabel;

    @FindBy(id="input-enquiry")
    public WebElement enquiryArea;

    @FindBy(css="[type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath="//input[@type='radio' and @value='0']")
    public WebElement subNo;

    @FindBy(id="input-firstname")
    public WebElement inputFirstname;

    @FindBy(id="input-lastname")
    public WebElement inputLastname;

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(css = "[class='btn btn-default btn-lg']")
    public WebElement srcBtn;

    @FindBy(css = "[class='caption'] a")
    public List<WebElement> srcNameList;


    public WebElement getWebElement(String strElement)
    {
        switch (strElement)
        {
            case "inputFirstname" : return this.inputFirstname;
            case "inputLastname" : return this.inputLastname;
            case "cntBtn" : return this.cntBtn;
            case "enquiryArea" : return this.enquiryArea;
            case "submitBtn" : return this.submitBtn;
            case "subYes" : return this.subYes;
            case "subNo" : return this.subNo;
            case "searchBox" : return this.searchBox;
            case "srcBtn" : return this.srcBtn;
            default: return null;
        }
    }


    public void verifyTitleContainsText(String text){
        wait.until(ExpectedConditions.titleContains(text));
        Assert.assertTrue(GWD.getDriver().getTitle().toLowerCase().contains(text.toLowerCase()), "Login olunamadı");
    }

    public void SuccessMessageValidation()
    {
        wait.until(ExpectedConditions.visibilityOf(msgLabel));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }

    public void verifyURLContainsText(String text){
        wait.until(ExpectedConditions.urlContains(text));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().toLowerCase().contains(text.toLowerCase()), "Hata oluştu");
    }

}