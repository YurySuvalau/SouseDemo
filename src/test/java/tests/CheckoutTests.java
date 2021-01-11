package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.Constants.*;

public class CheckoutTests extends BaseTest {

    @Test
    public void firstNameFieldIsEmpty() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage()//open cart page
                .waitForPageOpened()
                .checkoutBtnClick() //click on checkout button
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo("", LASTNAME, ZIPCODE) //add your inf
                .waitForPageOpened();
        Assert.assertEquals(checkoutYourInfPage.getErrorMessage(), "Error: First Name is required");//chek result
    }

    @Test
    public void setPersonalData() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage() //open cart page
                .waitForPageOpened()
                .checkoutBtnClick()//click on checkout button
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE)//add your inf
                .waitForPageOpened();
        Assert.assertEquals(checkoutPage.getCheckoutOverviewLabel(), "Checkout: Overview");
    }

    @Test
    public void lastNameFieldIsEmpty() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage() //open cart page
                .waitForPageOpened()
                .checkoutBtnClick()//click on checkout button
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, "", ZIPCODE)
                .waitForPageOpened();
        Assert.assertEquals(checkoutYourInfPage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void buyingProductTest() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage() //open cart page
                .waitForPageOpened()
                .checkoutBtnClick()//click on checkout button
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE) //enter personal info
                .waitForPageOpened();
        Assert.assertEquals(driver.findElement(CHECKOUT_OVERVIEW_ITEM_NAME).getText(), "Sauce Labs Fleece Jacket");// check the conformity of the product with the ordered
        checkoutPage.finishBtnClick() //Click "Finish" button
                .waitForPageOpened();
        Assert.assertTrue(checkoutPage.isDisplayedConfirmOrderMessage());//Check the order is confirmed
    }

    @Test
    public void getEmptyOrder() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        cartPage.openPage() //open cart page
                .waitForPageOpened()
                .checkoutBtnClick() //click on checkout button
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE) //enter personal info
                .waitForPageOpened();
        checkoutPage.finishBtnClick() //Click "Finish" button
                .waitForPageOpened();
        Assert.assertFalse(checkoutPage.isDisplayedConfirmOrderMessage());//Check the order is confirmed
    }

    @Test
    public void getTotalCostProduct() {
        loginPage.openPage()//open page
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        cartPage.openPage() //open cart page
                .waitForPageOpened()
                .checkoutBtnClick() //click on checkout button
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE) //enter personal info
                .waitForPageOpened();
        Assert.assertTrue(checkoutPage.getItemTotalCost());//check summary total cost of product
    }
}
