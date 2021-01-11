package pages;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage implements Constants {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_INF_STEP_TWO_OVERVIEW)));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Checkout Page page it's not loaded! Locator: '%s' was not found!", CHECKOUT_INF_STEP_TWO_OVERVIEW));
        }
        return this;
    }

    public float getNumbers(String attribute) {
        return Float.parseFloat((attribute).replaceAll("[^0-9.]", ""));
    }

    public CheckoutPage openPage() {
        driver.get(URL_SOUSE_DEMO + URL_CHECKOUT);
        return this;
    }

    public String getCheckoutOverviewLabel() {
        WebElement actualResult = driver.findElement(By.xpath(CHECKOUT_INF_STEP_TWO_OVERVIEW));
        return actualResult.getText();
    }

    public boolean isDisplayedConfirmOrderMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_FINISH_MESSAGE));
        return driver.findElement(Constants.CHECKOUT_FINISH_MESSAGE).isDisplayed();
    }

    public boolean getItemTotalCost() {
        String totalCost = driver.findElement(By.xpath(OVERVIEW_ITEM_TOTAL)).getText();
        String tax = driver.findElement(By.xpath(OVERVIEW_TAX)).getText();
        String total = driver.findElement(By.xpath(OVERVIEW_SUMMARY)).getText();
        float totalCost1 = getNumbers(totalCost);
        float tax1 = getNumbers(tax);
        float totalSummary = getNumbers(total);
        float sum = totalCost1 + tax1;
        if (sum == totalSummary) {
            return true;
        } else {
            return false;
        }
    }

    public CheckoutFinishPage finishBtnClick() {
        driver.findElement(CHECKOUT_FINISH_BUTTON).click();
        return new CheckoutFinishPage(driver);
    }
}


