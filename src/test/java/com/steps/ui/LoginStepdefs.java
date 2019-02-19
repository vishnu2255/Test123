package com.steps.ui;

import com.pages.loginPage.LoginPage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepdefs extends DriverFactory {


    private LoginPage loginPage;

    public LoginStepdefs()
    {
    loginPage = new LoginPage(driver);
    }

    @Given("^I navigate to the url$")
    public void iNavigateToTheUrl() {
        driver.get("https://login.salesforce.com/");

    }

    @When("^I enter (valid|invalid) credentials$")
    public void iEnterValidCredentials(String type) {
        loginPage.login(type.toString());


    }

    @Then("^I see error message$")
    public void iSeeErrorMessage() {
        Assert.assertTrue("Error message not displayed", loginPage.errorMsgExists());
    }

}
