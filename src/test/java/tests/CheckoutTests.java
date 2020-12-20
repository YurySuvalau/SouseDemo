package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutOneStepTest() {
        loginPage.openPage();//open page
        loginPage.login(loginPage.USERNAME, loginPage.PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage();//open cart page
        cartPage.checkoutButClick();//click on checkout button
        checkoutPage.checkoutOneStepClickContinueBut();//click continue button
        Assert.assertEquals(checkoutPage.actualResultCheckout(), "Error: First Name is required");//chek result
    }

    @Test
    public void checkoutAddYourAllInfChek() {
        loginPage.openPage();//open page
        loginPage.login(loginPage.USERNAME, loginPage.PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage();//open cart page
        cartPage.checkoutButClick();//click on checkout button
        checkoutPage.checkoutYourInf(checkoutPage.FIRSTNAME,checkoutPage.LASTNAME,checkoutPage.ZIPCODE);//add your inf
        Assert.assertEquals(checkoutPage.checkoutYourInfActualRes(), "Checkout: Overview");
    }

    @Test
    public void yourInfFieldLastNameIsEmpty() {
        loginPage.openPage();//open page
        loginPage.login(loginPage.USERNAME, loginPage.PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage();//open cart page
        cartPage.checkoutButClick();//click on checkout button
        checkoutPage.checkoutYourInf(checkoutPage.FIRSTNAME, "",checkoutPage.ZIPCODE);
        Assert.assertEquals(checkoutPage.actualResultCheckout(), "Error: Last Name is required");
    }
}
