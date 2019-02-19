package com.pages.leadPage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LeadPage extends BasePage<LeadPage> {

    private WebDriver driver;

    public LeadPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"Lead_Tab\"]/a")
    WebElement leadTab;

    @FindBy(xpath = "//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
    WebElement newBtn;

    @FindBy(xpath = "//*[@id=\"name_firstlea2\"]")
    WebElement fName;

    @FindBy(xpath = "//*[@id=\"name_lastlea2\"]")
    WebElement lName;

    @FindBy(xpath = "//*[@id=\"lea3\"]")
    WebElement companyName;

    @FindBy(xpath = "//*[@id=\"lea20\"]")
    WebElement campaign;

    @FindBy(xpath = "//*[@id=\"lea13\"]")
    WebElement leadStatus;

    @FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"topButtonRow\"]/input[5]")
    WebElement covert1;

    @FindBy(xpath = "//*[@id=\"noopptt\"")
    WebElement oppName;

    @FindBy(xpath = "//*[@id=\"tsk5_fu\"]")
    WebElement subName;

    @FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
    WebElement covert2;


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }


    public void navigateToLead(){
        leadTab.click();


    }

    public void enternames(String f,String l)
    {
        fName.sendKeys(f);
        lName.sendKeys(l);

    }

    public void  entercomp(String c){
        companyName.sendKeys(c);
    }

    public void  entercamp(String c){
        campaign.sendKeys(c);
    }

    public void selectLead(String val){
        Select sel = new Select(leadStatus);
        sel.selectByValue(val);
    }

    public void save(){
        saveBtn.click();
    }

    public void convert1(){
        covert1.click();
    }

    public void convert2(){
        covert2.click();
    }

    public void entOp(String val , String val2){
        oppName.sendKeys(val);
        subName.sendKeys(val2);
    }

    public boolean isLeadConverted(){
        return false;
    }


















}
