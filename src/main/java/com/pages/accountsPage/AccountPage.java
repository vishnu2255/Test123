package com.pages.accountsPage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePage<AccountPage> {


    @FindBy(xpath = "//*[@id=\"home_Tab\"]")
    WebElement homeTab;

    @FindBy(xpath = "//*[@id=\"Account_Tab\"]")
    WebElement accountTab;

    @FindBy(xpath = "//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")
    WebElement newBtn;

    @FindBy(xpath = "//*[@id=\"acc2\"]")
    WebElement accountName;

    @FindBy(xpath = "//*[@id=\"00N1U00000JIvt4\"]")
    WebElement accountType;

    @FindBy(xpath = "//*[@id=\"00N1U00000KSZCh\"]")
    WebElement sla;

    @FindBy(xpath = "//*[@id=\"00N1U00000KSZCf\"]")
    WebElement custPrio;

    @FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"00N1U00000KSZCg\"]")
    WebElement numOfLocs;

    @FindBy(xpath = "//*[@id=\"acc2_ileinner\"]")
    WebElement accountCreated;

    private WebDriver driver;

    public AccountPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public Boolean onHOmePage(){
        try {
            return homeTab.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void navigateAccountsTab(){
        homeTab.click();
        accountTab.click();
        newBtn.click();
    }

    public void enterAccount(String name)
    {
        accountName.sendKeys(name);

    }

    public void selectAcntTYpe(String val){
        Select sel = new Select(accountType);
        sel.selectByValue(val);

    }

    public void selectSLAType(String val){
        Select sel = new Select(sla);
        sel.selectByValue(val);

    }

    public void selectPrioType(String val){
        Select sel = new Select(custPrio);
        sel.selectByValue(val);

    }

    public void setLocs(int num){
        numOfLocs.sendKeys(String.valueOf(num));
    }

    public void saveAccount(){
        saveBtn.click();
    }

    public Boolean accntCreated(){
       return accountCreated.isDisplayed();
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

}
