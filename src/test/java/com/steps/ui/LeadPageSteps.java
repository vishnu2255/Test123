package com.steps.ui;
import com.pages.leadPage.LeadPage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LeadPageSteps extends DriverFactory {

    private LeadPage leadPage;

    public LeadPageSteps(){
        leadPage = new LeadPage(driver);
    }

    @Given("^I click on Leads tab$")
    public void i_click_on_Leads_tab() throws Exception {
    leadPage.navigateToLead();
    }

    @Given("^I enter first name as \"([^\"]*)\" and last name as \"([^\"]*)\"$")
    public void i_enter_first_name_as_and_last_name_as(String arg1, String arg2) throws Exception {
    leadPage.enternames(arg1,arg2);
    }

    @Given("^I give company name as \"([^\"]*)\"$")
    public void i_give_company_name_as(String arg1) throws Exception {
    leadPage.entercomp(arg1);
    }

    @Given("^I select lead source as \"([^\"]*)\"$")
    public void i_select_lead_surce_as(String ava) throws Exception {
    leadPage.selectLead(ava);
    }

    @Given("^I input campaign field as \"([^\"]*)\"$")
    public void i_input_campign_field_as(String c) throws Exception {
    leadPage.entercamp(c);
    }

    @Given("^I save to create a new lead$")
    public void i_save_to_create_a_new_lead() throws Exception {
    leadPage.save();
    }

    @When("^I click on covert button to convert the created lead$")
    public void i_click_to_convert_the_created_lead() throws Exception {
    leadPage.convert1();
    }

    @When("^I click on convert button on the lead page$")
    public void i_click_on_convert_button_on_the_lead_page() throws Exception {
    leadPage.convert2();
    }

    @Then("^The new LEAD should be converted$")
    public void the_new_LEAD_should_be_converted() throws Exception {
        Assert.assertTrue("Lead not converted",leadPage.isLeadConverted());
    }

    @And("^I provide opportuntiy name \"([^\"]*)\" and subject \"([^\"]*)\" details$")
    public void iProvideOpporuntiyNameAndSubjectDetails(String op, String su) throws Throwable {
       leadPage.entOp(op,su);
    }

}
