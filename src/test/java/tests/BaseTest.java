package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import test_data.TestConstants;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements TestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    LoginPageFactory loginPageFactory;
    HamburgerMenuPage hamburgerMenuPage;
    CheckoutYourInfPage checkoutYourInfPage;

    @BeforeMethod
    public void InitTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        pageInit();
    }

    public void pageInit() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        hamburgerMenuPage = new HamburgerMenuPage(driver);
        checkoutYourInfPage = new CheckoutYourInfPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void driverQuit() {
        driver.quit();
    }
}
