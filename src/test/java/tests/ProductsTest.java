package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductsTest extends BaseTest {

    @Test(description = "Add product to cart")
    public void addProductToCartTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD);
        productsPage.addProductToCart("Sauce Labs Fleece Jacket")
                .waitForPageOpened();
        cartPage.openPage()
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getQuantity(), "1");
        Assert.assertEquals(cartPage.getPrice(), "49.99");
    }

    @Test(description = "Check counter on cart icon")
    public void CounterOnCartIconTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket")
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getCartIconText(), "1");
    }

    @Test(description = "Check sorting from Z to A")
    public void sortByNameFromZtoATest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsListByName();
        productsPage.setSortMenuZtoA();
        ArrayList<String> sorted = productsPage.getElementsListByPrice();
        Assert.assertFalse(notSorted.equals(sorted));
    }

    @Test(description = "Check sorting from A to Z")
    public void sortByNameFromAtoZTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsListByName();
        productsPage.setSortMenuZtoA()
                .setSortMenuAtoZ();
        ArrayList<String> sorted = productsPage.getElementsListByName();
        Assert.assertTrue(notSorted.equals(sorted));
    }

    @Test(description = "Check sorting by price from High to Low")
    public void sortByPriceFromHiToLowTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsListByPrice();
        productsPage.setSortMenuByPriseHiToLow();
        ArrayList<String> sorted = productsPage.getElementsListByPrice();
        Assert.assertFalse(notSorted.equals(sorted));
    }

    @Test(description = "Check sorting by price from Low to Hi")
    public void sortByPriceFromLowToHiTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsListByPrice();
        productsPage.setSortMenuByPriceLowToHi();
        ArrayList<String> sorted = productsPage.getElementsListByPrice();
        Assert.assertFalse(notSorted.equals(sorted));
    }
}




