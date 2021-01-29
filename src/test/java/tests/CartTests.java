package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void testCartProductDeleteTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(System.getenv("username"), System.getenv("password"))
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .removeProduct();
        Assert.assertEquals(cartPage.getRemovedProduct(), "");
    }
}

