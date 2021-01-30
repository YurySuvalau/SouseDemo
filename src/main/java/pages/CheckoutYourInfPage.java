package pages;

import io.qameta.allure.Step;
import сonstants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutYourInfPage extends BasePage implements Constants {
    String CHECKOUT_ONE_STEP_CONTINUE_BUTTON = "//*[@class='btn_primary cart_button']";
    By CHECKOUT_INF_FIRSTNAME = By.xpath("//*[@id='first-name']");
    By CHECKOUT_INF_LASTNAME = By.xpath("//*[@id='last-name']");
    By CHECKOUT_INF_ZIPCODE = By.xpath("//*[@id='postal-code']");
    String ERROR = "//*[@data-test='error']";

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

    @Step("Open Personal info page")
    public CheckoutYourInfPage openPage() {
        driver.get(URL_SOUSE_DEMO + URL_CHECKOUT_PERSONAL_INFO);
        return this;
    }

    @Step("Fill Personal info")
    public CheckoutPage fillPersonalInfo(String firstname, String lastname, String zipcode) {
        driver.findElement(CHECKOUT_INF_FIRSTNAME).sendKeys(firstname);
        driver.findElement(CHECKOUT_INF_LASTNAME).sendKeys(lastname);
        driver.findElement(CHECKOUT_INF_ZIPCODE).sendKeys(zipcode);
        driver.findElement(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)).click();
        return new CheckoutPage(driver);
    }

    @Step("Check error message in login page")
    public String getErrorMessage() {
        return driver.findElement(By.xpath(ERROR)).getText();
    }

    public CheckoutPage confirmPersonalInfoBtn() {
        driver.findElement(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)).click();
        return new CheckoutPage(driver);
    }
}
