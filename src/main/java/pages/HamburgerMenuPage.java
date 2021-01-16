package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HamburgerMenuPage extends BasePage {
    By HAMBURGER_MENU = By.xpath("//*[@class='bm-burger-button']");
    By HAMBURGER_MENU_REST_APP_STATE = By.xpath("//a[@id='reset_sidebar_link']");
    By HAMBURGER_MENU_LOGOUT = By.xpath("//*[@id='logout_sidebar_link']");
    By HAMBURGER_MENU_CLOSE = By.xpath("//*[@class='bm-cross-button']//button");

    public HamburgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HamburgerMenuPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HAMBURGER_MENU_CLOSE));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Hamburger menu page it's not loaded! Locator: '%s' was not found!", HAMBURGER_MENU_CLOSE));
        }
        return this;
    }

    public HamburgerMenuPage openPage() {
        driver.findElement(HAMBURGER_MENU).click();
        return this;
    }

    public HamburgerMenuPage resetAppStateClick() {
        driver.findElement(HAMBURGER_MENU_REST_APP_STATE).click();
        return this;
    }

    public ProductsPage closeMenuSpanClick() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(HAMBURGER_MENU_CLOSE));
        return new ProductsPage(driver);
    }

    public LoginPage logoutBtnClick() {
        driver.findElement(HAMBURGER_MENU_LOGOUT).click();
        return new LoginPage(driver);
    }
}
