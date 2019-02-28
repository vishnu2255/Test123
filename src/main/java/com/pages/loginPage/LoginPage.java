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

    @FindBy(xpath = "//*[@id=\"login_user\"]")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"login_pw\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login_btn\"]")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div[5]/div[1]/p")
    WebElement errorMsg;


    public void login(String val)
    {
        String uname = "";
        String pass = "";

        switch(val){
        case ("valid"):

            break;
        case ("invalid"):
            uname = "test@gmail.com";
            pass = "test@123";
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
            return waitUtils.getElementAfterMediumWait(errorMsg).isDisplayed();

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean verifyLoginPage(){
        return driver.getCurrentUrl().contains("login.firmex.com");
    }

    @Override
    protected void load() {
    driver.get("https://login.firmex.com");
    }

    @Override
    protected void isLoaded() throws Error {
    if(driver.getCurrentUrl().contains("login"))
    {
        System.out.println("login page loaded");
    }
    else
    {
        System.out.println("not loded");
    }
    }
}
