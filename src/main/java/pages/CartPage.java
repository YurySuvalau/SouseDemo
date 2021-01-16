package pages;

import сonstants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage implements Constants {
    String GET_QUANTITY_IN_CART = "//*[@class='cart_quantity']";
    String GET_PRICE_IN_CART = "//*[@class='inventory_item_price']";
    String REMOVE_BUTTON = "//*[@class='btn_secondary cart_button']";
    String REMOVE_RESULT = "//*[@class='removed_cart_item']";
    By CHECKOUT_BUTTON = By.xpath("//*[@class='btn_action checkout_button']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Cart Page page it's not loaded! Locator: '%s' was not found!", CHECKOUT_BUTTON));
        }
        return this;
    }

    public CartPage openPage() {
        openPage(URL_SOUSE_DEMO + URL_CART_PAGE);
        return this;
    }

    public String getQuantity() {
        WebElement quantity = driver.findElement(By.xpath(GET_QUANTITY_IN_CART));
        return quantity.getText();
    }

    public String getPrice() {
        WebElement price = driver.findElement(By.xpath(GET_PRICE_IN_CART));
        return price.getText();
    }

    public CartPage removeProduct() {
        driver.findElement(By.xpath(REMOVE_BUTTON)).click();
        return this;
    }

    public String getRemovedProduct() {
        WebElement removedProduct = driver.findElement(By.xpath(REMOVE_RESULT));
        return removedProduct.getText();
    }

    public CheckoutYourInfPage checkoutBtnClick() {
        driver.findElement((CHECKOUT_BUTTON)).click();
        return new CheckoutYourInfPage(driver);
    }
}

