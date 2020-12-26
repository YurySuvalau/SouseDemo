package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutOneStepTest() {
        loginPage.openPage();//open page
        loginPage.login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage(); //open cart page
        cartPage.checkoutButtonClick();//click on checkout button
        checkoutPage.checkoutOneStepClickContinueBut();//click continue button
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required");//chek result
    }

    @Test
    public void checkoutAddYourAllInfChek() {
        loginPage.openPage();//open page
        loginPage.login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage(); //open cart page
        cartPage.checkoutButtonClick();//click on checkout button
        checkoutPage.fillPersonalInfo(CheckoutTests.FIRSTNAME, CheckoutTests.LASTNAME, CheckoutTests.ZIPCODE);//add your inf
        Assert.assertEquals(checkoutPage.getCheckoutOverviewLabel(), "Checkout: Overview");
    }

    @Test
    public void yourInfFieldLastNameIsEmpty() {
        loginPage.openPage();//open page
        loginPage.login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD); //login
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage(); //open cart page
        cartPage.checkoutButtonClick();//click on checkout button
        checkoutPage.fillPersonalInfo(CheckoutTests.FIRSTNAME, "", CheckoutTests.ZIPCODE);
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required");
    }
}
