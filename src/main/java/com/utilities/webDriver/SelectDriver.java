package com.utilities.webDriver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

@Slf4j
public class SelectDriver {

    static  String browser;

    static{
        browser = getBrowser();

    }

    public static String getBrowser()
    {
        String browser = null;

        if(browser == null)
        {
            browser = "firefox";
        }
        return browser;
    }

    public static WebDriver getDriver()
    {
        WebDriver driver = null;

        switch (browser.toLowerCase())
        {
            case "chrome":
               return null;
            case "safari":
               return null;
           default:
             return getFirefoxDriver();
        }
    }

    public static WebDriver getFirefoxDriver()
    {
        File resourcesDirectory = new File("src/test/resources");
        resourcesDirectory.getAbsolutePath();
        String path = resourcesDirectory.getAbsolutePath() + "\\drivers\\geckodriver.exe";

        System.setProperty("webdriver.gecko.driver",path);
        WebDriver driver = new FirefoxDriver();

        return driver;
    }

}
