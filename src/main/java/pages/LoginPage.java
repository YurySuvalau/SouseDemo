package pages;

import io.qameta.allure.Step;
import сonstants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage implements Constants {
    By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");

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
    @Step("Enter login data")
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return new ProductsPage(driver);
    }

    @Step("Open login page")
    public LoginPage openPage() {
        driver.get(URL_SOUSE_DEMO);
        return this;
    }

    @Step("Get current page url address")
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
