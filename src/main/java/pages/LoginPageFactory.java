package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {
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

    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public LoginPageFactory loginWithIncorrectData(String username, String password) {
        login(username, password);
        return this;
    }

    public LoginPageFactory openPage() {
        driver.get(URL_SOUSE_DEMO);
        return this;
    }
}