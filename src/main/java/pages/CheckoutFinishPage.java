package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import сonstants.Constants;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutFinishPage extends BasePage implements Constants {
    By CHECKOUT_FINISH_LABEL = By.xpath("//*[@class='subheader']");

    public CheckoutFinishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutFinishPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_FINISH_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Checkout complete Page it's not loaded! Locator: '%s' was not found!", CHECKOUT_FINISH_LABEL));
        }
        return this;
    }

    @Step("Open checkout finish page")
    public CheckoutFinishPage openPage() {
        openPage(URL_SOUSE_DEMO + URL_CHECKOUT_FINISH_PAGE);
        return this;
    }
}

