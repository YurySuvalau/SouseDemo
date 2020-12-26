package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL_CHECKOUT = "https://www.saucedemo.com/checkout-step-one.html";
    public static final String CHECKOUT_ONE_STEP_CONTINUE_BUTTON = "//*[@class='btn_primary cart_button']";
    public static final By CHECKOUT_INF_FIRSTNAME = By.xpath("//*[@id='first-name']");
    public static final By CHECKOUT_INF_LASTNAME = By.xpath("//*[@id='last-name']");
    public static final By CHECKOUT_INF_ZIPCODE = By.xpath("//*[@id='postal-code']");
    public static final String CHECKOUT_INF_STEP_TWO_OVERVIEW = "//*[@class='subheader']";
    public static final By ERROR = By.xpath("//*[@data-test='error']");

    public void openPage() {
        driver.get(URL_CHECKOUT);
    }

    public void checkoutOneStepClickContinueBut() {
        driver.findElement(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)).click();
    }

    public String getErrorMessage () {
        WebElement actualResult = driver.findElement(ERROR);
        return actualResult.getText();
    }

    public void fillPersonalInfo(String firstname, String lastname, String zipcode) {
        driver.findElement(CHECKOUT_INF_FIRSTNAME).sendKeys(firstname);
        driver.findElement(CHECKOUT_INF_LASTNAME).sendKeys(lastname);
        driver.findElement(CHECKOUT_INF_ZIPCODE).sendKeys(zipcode);
        driver.findElement(By.xpath(CHECKOUT_ONE_STEP_CONTINUE_BUTTON)).click();
    }

    public String  getCheckoutOverviewLabel() {
        WebElement actualResult = driver.findElement(By.xpath(CHECKOUT_INF_STEP_TWO_OVERVIEW));
        return actualResult.getText();
    }
}

