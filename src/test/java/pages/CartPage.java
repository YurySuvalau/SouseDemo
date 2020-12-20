package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public static final String CONTINUE_SHOPPING_BUTTON = "//*[@class = 'ArtStyle TL-220G']";
    public static final String GET_QUANTITY_IN_CART = "//*[@class='cart_quantity']";
    public static final String GET_PRICE_IN_CART = "//*[@class='inventory_item_price']";
    public static final String REMOVE_BUTTON = "//*[@class='btn_secondary cart_button']";
    public static final String REMOVE_RESULT = "//*[@class='removed_cart_item']";
    public static final String CHECKOUT_BUTTON = "//*[@class='btn_action checkout_button']";

    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");

    }

    public String getQuantity() {

        WebElement quantity = driver.findElement(By.xpath(GET_QUANTITY_IN_CART));

        return quantity.getText();
    }

    public String getPrice() {
        WebElement price = driver.findElement(By.xpath(GET_PRICE_IN_CART));
        return price.getText();
    }

    public void removeProduct() {
        driver.findElement(By.xpath(REMOVE_BUTTON)).click();

    }

    public String removeCheck() {
        WebElement checkRemove = driver.findElement(By.xpath(REMOVE_RESULT));
        return checkRemove.getText();
    }

    public void checkoutButClick() {
        driver.findElement(By.xpath(CHECKOUT_BUTTON)).click();
    }
    public void clickContinueShoppingButton(){
        driver.findElement(By.xpath(CONTINUE_SHOPPING_BUTTON)).click();
    }
}
