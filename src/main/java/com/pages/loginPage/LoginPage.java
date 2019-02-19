package com.pages.loginPage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage<LoginPage> {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"Login\"]")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"error\"]")
    WebElement errorMsg;

    public void login(String val)
    {
        String uname = "";
        String pass = "";

        switch(val){
        case ("valid"):
            uname = "raghavreddy@canadadrive.com";
            pass ="Qatesting@1";
            break;
        case ("invalid"):
            uname = "test";
            pass = "test";
            break;

        default:
            System.out.println("not a valid input ");
                   }
        try {
            username.clear();
            username.sendKeys(uname);
            password.clear();
            password.sendKeys(pass);
            login.click();
        }catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Boolean errorMsgExists(){

        try{
            return errorMsg.isDisplayed();

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
