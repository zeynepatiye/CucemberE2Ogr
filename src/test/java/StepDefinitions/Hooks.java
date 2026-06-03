package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;

public class Hooks {
    @After//after senaryo
    public void after(){
        GWD.quitDriver();
    }
}
