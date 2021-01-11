package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void testCartProductDelete() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage() //open cart page
                .waitForPageOpened()
                .removeProduct();//delete product from cart
        Assert.assertEquals(cartPage.getRemovedProduct(), "");//product removal check
    }
}

