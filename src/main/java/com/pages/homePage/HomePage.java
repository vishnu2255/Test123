package com.pages.homePage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//LoadableComponent<HomePage>
public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//*[@id=\"site-navigation\"]/a[1]")
    WebElement loginBtn;



   private WebDriver driver;

   public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }


    public Boolean verifyTitle(){

        System.out.println(driver.getTitle());
        return driver.getTitle().contains("The World's Most Trusted Virtual Data Room | Firmex");
    }

    public void navigateToLoginPage(){
       waitUtils.getElementAfterShortWait(loginBtn).click();
    }


    @Override
    protected void load() {

        driver.get("https://www.firmex.com/");
    }

    @Override
    protected void isLoaded() throws Error {
        try{

            if(driver.getCurrentUrl().contains("https://www.firmex.com/"))
            {
                System.out.println("home page loaded");
            }

        }catch (Exception e)
        {
                System.out.println("home page not loaded");
        }

   }

}
