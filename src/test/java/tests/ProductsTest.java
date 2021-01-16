package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductsTest extends BaseTest {

    @Test
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

    @Test
    public void CounterOnCartIconTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket")
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getCartIconText(), "1");
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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




