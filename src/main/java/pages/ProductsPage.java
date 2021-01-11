package pages;

import Constants.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage implements Constants {

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

    public String getCartIconText() {
        WebElement iconText = driver.findElement(CART_ICON);
        return iconText.getText();
    }

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

    public ProductsPage setSortMenu(String select) {
        Select sortMenu = new Select(driver.findElement(SORT_MENU));
        sortMenu.selectByVisibleText(select);
        return this;
    }

    public ArrayList<String> getElementsList(By attribute) {
        List<WebElement> elements = driver.findElements(attribute);
        ArrayList<String> listOfItem = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            listOfItem.add(elements.get(i).getText());
        }
        return listOfItem;
    }

}



