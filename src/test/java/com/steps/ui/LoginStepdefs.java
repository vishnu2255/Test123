package com.steps.ui;

import com.pages.loginPage.LoginPage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepdefs extends DriverFactory {


    private LoginPage loginPage;
    public LoginStepdefs()
    {
    loginPage = new LoginPage(driver);
    }

    @When("^I enter (valid|invalid) credentials and click login button$")
    public void iEnterValidCredentials(String type) {
        loginPage.login(type.toString());


    }

    @Then("^I see error message displayed$")
    public void iSeeErrorMessage() {
        Assert.assertTrue("Error message not displayed", loginPage.errorMsgExists());
    }

    @And("^I verify I am on login page$")
    public void iVerifyIAmOnLoginPage() {

        Assert.assertTrue("User is not on login page",loginPage.verifyLoginPage());
    }

}
