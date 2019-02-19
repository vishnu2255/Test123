package com.steps.ui;

import com.pages.accountsPage.AccountPage;
import com.pages.loginPage.LoginPage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountPageSteps extends DriverFactory {

    private AccountPage accountPage;
    private LoginPage loginPage;

    public AccountPageSteps(){
        accountPage = new AccountPage(driver);
        loginPage   = new LoginPage(driver);
    }

    @Then("^I see home page$")
    public Boolean iSeeHomePage() throws InterruptedException {

        Thread.sleep(20000);
        return driver.getCurrentUrl().contains("Homepage");
    }

    @And("^I enter num of locations as (\\d+)$")
    public void iEnterNumOfLocationsAs(int num) {
        accountPage.setLocs(num);
    }


    @And("^I click on Accounts tab$")
    public void iClickOnAccountsTab() {
     accountPage.navigateAccountsTab();

    }

    @Given("^I am on homepage$")
    public void iAmOnHomepage() throws InterruptedException {

        driver.get("https://na85.salesforce.com/home/home.jsp");
        loginPage.login("valid");
        Thread.sleep(30000);
    }

    @Given("^I click on create new account button$")
    public void iClickOnCreateNewAccountButton() {

    }

    @Given("^I enter account name as \"([^\"]*)\"$")
    public void iEnterAccountNameAs(String name) throws Throwable {
        accountPage.enterAccount(name);

    }

    @And("^I select business type as \"([^\"]*)\"$")
    public void iSelectBusinessTypeAs(String type) throws Throwable {
        accountPage.selectAcntTYpe(type);
    }

    @And("^I select customer priority as \"([^\"]*)\"$")
    public void iSelectCustomerPriorityAs(String type) throws Throwable {
        accountPage.selectPrioType(type);
    }

    @And("^I select SLA as \"([^\"]*)\"$")
    public void iSelectSLAAs(String type) throws Throwable {
        accountPage.selectSLAType(type);
    }

    @When("^I click on save button$")
    public void iClickOnSaveButton() {
        accountPage.saveAccount();
    }

    @Then("^New account is created$")
    public void newAccountIsCreated() {

    }
}
