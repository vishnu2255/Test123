package com.pages.homePage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//LoadableComponent<HomePage>
public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//*[@id=\"nav-secondaire\"]/div[1]/ul/li[4]/a/span")
    WebElement loansBtn;



    //*[@id="nav-secondaire"]/div[1]/ul/li[4]/ul/li[2]/section[1]/ul/li[2]/a
    //*[@id="nav-secondaire"]/div[1]/ul/li[4]/a/span
   private WebDriver driver;

   public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void navigateToCalPage()
    {
        try {

            loansBtn.click();
            driver.findElement(By.linkText("Mortgage payment calculator")).click();
        }catch (NoSuchElementException e)
        {
            System.out.println(e);
        }
    }

    @Override
    protected void load() {

        driver.get("https://ia.ca/");
    }

    @Override
    protected void isLoaded() throws Error {
        try{

            if(driver.getCurrentUrl().contains("https://ia.ca/"))
            {
                System.out.println("home page loaded");
            }

        }catch (Exception e)
        {
            System.out.println("home page not loaded");
        }
    }

}
