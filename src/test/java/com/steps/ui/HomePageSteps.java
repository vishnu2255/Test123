package com.steps.ui;

import com.pages.homePage.HomePage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageSteps extends DriverFactory {

    private HomePage homepage;
    Logger logger = LoggerFactory.getLogger(HomePageSteps.class);

    public HomePageSteps()
    {
        homepage = new HomePage(driver);
    }


    @Given("^I navigate to the Firmex home page$")
    public void iNavigateToTheFirmexHomePage() {
        driver.get("https://www.firmex.com/");
    }

    @And("^I verify home page title$")
    public void iVerifyHomePageTitle() {
        Assert.assertTrue("User is not on home page",homepage.verifyTitle());
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        homepage.navigateToLoginPage();
    }

}
