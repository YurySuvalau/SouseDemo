package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void testCartProductDelete() {
        loginPage.openPage();//open page
        loginPage.login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage(); //open cart page
        cartPage.removeProduct();//delete product from cart
        Assert.assertEquals(cartPage.getRemovedProduct(), "");//product removal check
    }
}

