package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {
    String PRODUCT_NAME_ANCESTOR = "//*[text() = '%s']/ancestor::*[@class='cart_item']";
    String PRODUCT_QUANTITY = PRODUCT_NAME_ANCESTOR + "//*[@class='cart_quantity']";
    String PRODUCT_PRICE = PRODUCT_NAME_ANCESTOR + "//*[@class='inventory_item_price']";
    //Study class
    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;
    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageFactory waitForPageOpened() {
        return this;
    }

    @Step("Fill login info")
    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    @Step("Fill incorrect login data")
    public LoginPageFactory loginWithIncorrectData(String username, String password) {
        login(username, password);
        return this;
    }

    @Step("Open Login page")
    public LoginPageFactory openPage() {
        driver.get(URL_SOUSE_DEMO);
        return this;
    }
}