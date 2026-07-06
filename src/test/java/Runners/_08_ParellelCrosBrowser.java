package Runners;


import Utilities.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features =  { "src/test/java/FeatureFiles/_01_Login.feature"},
        glue = {"StepDefinitions"}
)

public class _08_ParellelCrosBrowser extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("BrowserTipi")
    public void beforeClass(String BrowserName)
    {
        GWD.setThreadBrowserName(BrowserName);
    }

}