package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void addProductToCartTest() {
        loginPage.openPage();//open page
        loginPage.login(loginPage.USERNAME, loginPage.PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage(); //open cart page
        Assert.assertEquals(cartPage.getQuantity(), "1");//assert quantity
        Assert.assertEquals(cartPage.getPrice(), "49.99"); // assert price
    }
    @Test
    public void testCounterOnCartIcon () {

        loginPage.openPage();//open page
        loginPage.login(loginPage.USERNAME, loginPage.PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        Assert.assertEquals(productsPage.cartIconText(), "1");
    }

}

