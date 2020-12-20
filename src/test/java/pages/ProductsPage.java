package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text() = '%s']/ancestor::*[@class='inventory_item']//button";
    public static final String CART_ICON = "//*[@class='fa-layers-counter shopping_cart_badge']";


    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();

    }
    public String cartIconText() {
        WebElement iconText = driver.findElement(By.xpath(CART_ICON));
        return iconText.getText();
    }
}
