package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Test button Remove in shipping cart")
    public void testCartProductDeleteTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .removeProduct();
        Assert.assertEquals(cartPage.getRemovedProduct(), "");
    }
}

