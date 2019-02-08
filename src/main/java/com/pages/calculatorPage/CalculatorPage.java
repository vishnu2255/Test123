package com.pages.calculatorPage;

import com.pages.basePage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorPage extends BasePage<CalculatorPage> {

    Logger logger = LoggerFactory.getLogger(CalculatorPage.class);

    @FindBy(xpath = "//*[@id=\"par_valeur\"]")
    WebElement paymentInput_pp;

    @FindBy(id="par_pret")
    WebElement paymentInput_ma;

    @FindBy(id="PrixPropriete")
    WebElement purchasePriceInput;

    @FindBy(id = "MiseDeFond")
    WebElement downPaymentInput;

    @FindBy(id="Amortissement")
    WebElement amortizationSelect;

    @FindBy(id="TauxInteret")
    WebElement interestInput;

    @FindBy(id="FrequenceVersement")
    WebElement frequencySelect;

    @FindBy(id="btn_calculer")
    WebElement calculateBtn;

    @FindBy(id="paiement-resultats")
    WebElement result;

    private WebDriver driver;

    public CalculatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void enterPaymentType(String type)
    {
        if(type.equalsIgnoreCase("purchase price"))
        {
            paymentInput_pp.click();
        }
        else if(type.equalsIgnoreCase("mortgage amount"))
        {
            paymentInput_ma.click();
        }
        else
            throw new Error("Invalid input");
    }

    public void enterInputAmount(String amnt)
    {
        waitUtils.getElementAfterShortWait(purchasePriceInput).clear();
        purchasePriceInput.sendKeys(amnt);
    }

    public void selectAmortization(String years)
    {
        try {
            Select sel = new Select(amortizationSelect);
            sel.selectByValue((years));
        }catch(NoSuchElementException w)
        {
            logger.info("Enter valid no:of years");
        }

    }

    public void enterIntRate(String intr)
    {
        interestInput.clear();
        interestInput.sendKeys(intr);
    }

    public void selectPayFreq(String freq){

        try{
            Select sel = new Select(interestInput);
            sel.selectByVisibleText(freq);
        }catch (NoSuchElementException e)
        {
            logger.info("enter valid record");
        }
    }

    public void enterDownPayment(String rec)
    {
        downPaymentInput.clear();
        downPaymentInput.sendKeys(rec);
    }

    public void calculate()
    {
        calculateBtn.click();
    }

    public Boolean validateResults()
    {
       return waitUtils.getElementAfterShortWait(result).isDisplayed();
    }


    @Override
    protected void load() {

        driver.get("https://ia.ca/mortgage-payment-calculator");
        logger.info("Calculator page loaded");
    }

    @Override
    protected void isLoaded() throws Error {
        try{

            if(driver.getCurrentUrl().contains("https://ia.ca/mortgage-payment-calculator"))
            {
                logger.info("calculator page loaded");
            }

        }catch (Exception e)
        {
            logger.info("calculator page not loaded");
        }
    }
}

