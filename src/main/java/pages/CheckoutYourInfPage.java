package pages;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutYourInfPage extends BasePage implements Constants {

    public CheckoutYourInfPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutYourInfPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Checkout Page with personal information it's not loaded! Locator: '%s' was not found!", CHECKOUT_ONE_STEP_CONTINUE_BUTTON));
        }
        return this;
    }

    public CheckoutYourInfPage openPage() {
        driver.get(URL_SOUSE_DEMO + URL_CHECKOUT_PERSONAL_INFO);
        return this;
    }

    public CheckoutPage fillPersonalInfo(String firstname, String lastname, String zipcode) {
        driver.findElement(CHECKOUT_INF_FIRSTNAME).sendKeys(firstname);
        driver.findElement(CHECKOUT_INF_LASTNAME).sendKeys(lastname);
        driver.findElement(CHECKOUT_INF_ZIPCODE).sendKeys(zipcode);
        driver.findElement(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)).click();
        return new CheckoutPage(driver);
    }

    public String getErrorMessage() {
        WebElement getMessage = driver.findElement(By.xpath(ERROR));
        return getMessage.getText();
    }

    public CheckoutPage confirmPersonalInfoBtn() {
        driver.findElement(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)).click();
        return new CheckoutPage(driver);
    }
}
