package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilits.PropertyReader;

public class CartTests extends BaseTest {

    @Test
    public void testCartProductDeleteTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(System.getenv().getOrDefault("username", PropertyReader.getProperty("username")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .removeProduct();
        Assert.assertEquals(cartPage.getRemovedProduct(), "");
    }
}

