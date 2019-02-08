package com.steps.ui;

import com.pages.calculatorPage.CalculatorPage;
import com.pages.homePage.HomePage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStepdefs extends DriverFactory {

    Logger logger = LoggerFactory.getLogger(MyStepdefs.class);
    private CalculatorPage calculatorPage;
    private HomePage homePage;

   public MyStepdefs(){
        homePage = new HomePage(driver);
        calculatorPage = new CalculatorPage(driver);

    }


    @And("^I navigate to Calculator page$")
    public void iNavigateToCalculatorPage() {

        homePage.navigateToCalPage();
    }

    @Given("^I am on Calculator page$")
    public void iAmOnCalculatorPage() {
        calculatorPage.get();

    }

    @When("^I give payment type as (.*)$")
    public void iGiveValidPaymentType(String type) {
        calculatorPage.enterPaymentType(type);

    }


    @And("^I input downpayment amount as (\\d+)$")
    public void iInputDownpaymentAmountAs(int dwnpay) {
        calculatorPage.enterDownPayment(String.valueOf(dwnpay));
    }

    @And("^I give price amount as (\\d+)$")
    public void iGivePriceAmountAs(int amnt) {
        calculatorPage.enterInputAmount(String.valueOf(amnt));
    }

    @And("^I select (\\d+) years amortization period$")
    public void iSelectYearsAmortizationPeriod(int years) {
        calculatorPage.selectAmortization(String.valueOf(years));
    }

    @And("^I input interest rate as (\\d+)$")
    public void iInputInterestRateAs(int intr) {
        calculatorPage.enterIntRate(String.valueOf(intr));
    }

    @And("^I select (.*) payment frequency$")
    public void iSelectMonthlyPaymentFrequency(String freq) {
        calculatorPage.selectPayFreq(freq);
    }

    @And("^I click on calculate button$")
    public void iClickOnCalculateButton() {
        calculatorPage.calculate();
    }

    @Then("^I (should|should not) see the result$")
    public void iShouldSeeTheResult(String rec) {

        if(rec.equalsIgnoreCase("should"))
        {
            Assert.assertTrue("Result not displayed, Inputs are not as expected",calculatorPage.validateResults());
        }
        else
        {
            Assert.assertTrue("Result is displayed, Inputs are not as expected",!calculatorPage.validateResults());
        }

    }
}
