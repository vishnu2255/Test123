package com.steps.ui;

import com.pages.homePage.HomePage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageSteps extends DriverFactory {

    private HomePage homepage;
    Logger logger = LoggerFactory.getLogger(HomePageSteps.class);

    public HomePageSteps()
    {
        homepage = new HomePage(driver);
    }

    @Given("^I am on home page$")
        public void homePage()
        {
          //  homepage.get();
            driver.get("https://ia.ca/");
        }

}
