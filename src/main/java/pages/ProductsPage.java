package pages;

import io.qameta.allure.Step;
import сonstants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage implements Constants {
    String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    By CART_ICON = By.xpath("//*[@class='fa-layers-counter shopping_cart_badge']");
    By PRODUCT_LABEL = By.xpath("//*[contains(text(),'Product')]");
    By INVENTORY_ITEM_NAME = By.xpath("//*[@class='inventory_item_name']");
    By INVENTORY_PRICE = By.xpath("//*[@class='inventory_item_price']");
    By SORT_MENU = By.xpath("//*[@class ='product_sort_container']");
    String SORT_NAME_BY_Z_TO_A = "Name (Z to A)";
    String SORT_NAME_BY_A_TO_Z = "Name (A to Z)";
    String SORT_BY_PRICE_LOW_TO_HIGH = "Price (low to high)";
    String SORT_BY_PRICE_HIGH_TO_LOW = "Price (high to low)";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Products page in not loaded! Locator: '%s' was not found!", PRODUCT_LABEL));
        }
        return this;
    }

    @Step("Check cart icon count")
    public String getCartIconText() {
        return driver.findElement(CART_ICON).getText();
    }

    @Step("Check cart icon count is displayed")
    public boolean isDisplayedCartIconCount() {
        try {
            driver.findElement(CART_ICON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPageOpened() {
        return driver.findElement(PRODUCT_LABEL).isDisplayed();
    }

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    public String getTextOnAddToCartBtn(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).getText();
    }

    public ProductsPage openPage() {
        openPage(URL_SOUSE_DEMO + URL_PRODUCTS);
        return this;
    }

    public ProductsPage setSortMenuZtoA() {
        Select sortMenu = new Select(driver.findElement(SORT_MENU));
        sortMenu.selectByVisibleText(SORT_NAME_BY_Z_TO_A);
        return this;
    }

    public ProductsPage setSortMenuAtoZ() {
        Select sortMenu = new Select(driver.findElement(SORT_MENU));
        sortMenu.selectByVisibleText(SORT_NAME_BY_A_TO_Z);
        return this;
    }

    public ProductsPage setSortMenuByPriseHiToLow() {
        Select sortMenu = new Select(driver.findElement(SORT_MENU));
        sortMenu.selectByVisibleText(SORT_BY_PRICE_HIGH_TO_LOW);
        return this;
    }

    public ProductsPage setSortMenuByPriceLowToHi() {
        Select sortMenu = new Select(driver.findElement(SORT_MENU));
        sortMenu.selectByVisibleText(SORT_BY_PRICE_LOW_TO_HIGH);
        return this;
    }

    public ArrayList<String> getElementsListByName() {
        List<WebElement> elements = driver.findElements(INVENTORY_ITEM_NAME);
        ArrayList<String> listOfItem = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            listOfItem.add(elements.get(i).getText());
        }
        return listOfItem;
    }

    public ArrayList<String> getElementsListByPrice() {
        List<WebElement> elements = driver.findElements(INVENTORY_PRICE);
        ArrayList<String> listOfItem = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            listOfItem.add(elements.get(i).getText());
        }
        return listOfItem;
    }
}



