package tests;

import Utils.CapabilitiesGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
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
    public void createDriver(ITestContext context) {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (SessionNotCreatedException ex) {
            Assert.fail("Браузер не был открыт. Проверьте, что используется корректная версия драйвера");
        }

        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
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
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
