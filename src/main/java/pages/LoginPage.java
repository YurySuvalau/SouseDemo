package pages;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage implements Constants {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Login page in not loaded! Locator: '%s' was not found!", USERNAME_INPUT));
        }
        return this;
    }

    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return new ProductsPage(driver);
    }

    public LoginPage openPage() {
        driver.get(URL_SOUSE_DEMO);
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
