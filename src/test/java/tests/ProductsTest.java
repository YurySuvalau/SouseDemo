package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Constants.Constants.*;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductToCart() {
        loginPage.openPage()//open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket")//add product to cart
                .waitForPageOpened();
        cartPage.openPage()//open cart page
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getQuantity(), "1");//assert quantity
        Assert.assertEquals(cartPage.getPrice(), "49.99"); // assert price
    }

    @Test
    public void CounterOnCartIcon() {
        loginPage.openPage() //open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket") //add product to cart
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getCartIconText(), "1");
    }

    @Test
    public void sortByNameFromZtoA() {
        loginPage.openPage() //open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsList(INVENTORY_ITEM_NAME);//get not sorted item list
        productsPage.setSortMenu(SORT_NAME_BY_Z_TO_A);//sort list by name Z to A
        ArrayList<String> sorted = productsPage.getElementsList(INVENTORY_ITEM_NAME);// get sorted item list
        Assert.assertFalse(notSorted.equals(sorted)); //Compare lists
    }

    @Test
    public void sortByNameFromAtoZ() {
        loginPage.openPage() //open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsList(INVENTORY_ITEM_NAME);//get not sorted item list
        productsPage.setSortMenu(SORT_BY_PRICE_LOW_TO_HIGH)//sort list by price low to high
                .setSortMenu(SORT_NAME_BY_A_TO_Z);//sort list by name Z to A
        ArrayList<String> sorted = productsPage.getElementsList(INVENTORY_ITEM_NAME);// get sorted item list
        Assert.assertTrue(notSorted.equals(sorted)); //Compare lists
    }

    @Test
    public void sortByPriceFromHiToLow() {
        loginPage.openPage() //open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsList(INVENTORY_PRICE);//get not sorted item list
        productsPage.setSortMenu(SORT_BY_PRICE_HIGH_TO_LOW);//sort list by price high to low
        ArrayList<String> sorted = productsPage.getElementsList(INVENTORY_PRICE);// get sorted item list
        Assert.assertFalse(notSorted.equals(sorted)); //Compare lists
    }

    @Test
    public void sortByPriceFromLowToHi() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        ArrayList<String> notSorted = productsPage.getElementsList(INVENTORY_PRICE);//get not sorted item list
        productsPage.setSortMenu(SORT_BY_PRICE_LOW_TO_HIGH);//sort list by price low to high
        ArrayList<String> sorted = productsPage.getElementsList(INVENTORY_PRICE);// get sorted item list
        Assert.assertFalse(notSorted.equals(sorted)); //Compare lists
    }
}




