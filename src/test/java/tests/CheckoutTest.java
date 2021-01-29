package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "When filling in personal information, leave the first name field blank")
    public void firstNameFieldIsEmptyTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .checkoutBtnClick()
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo("", LASTNAME, ZIPCODE)
                .waitForPageOpened();
        Assert.assertEquals(checkoutYourInfPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test(description = "Fill all fields in personal info page")
    public void setPersonalDataTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .checkoutBtnClick()
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE)
                .waitForPageOpened();
        Assert.assertEquals(checkoutPage.getCheckoutOverviewLabel(), "Checkout: Overview");
    }

    @Test(description = "When filling in personal information, leave the last name field blank")
    public void lastNameFieldIsEmptyTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .checkoutBtnClick()
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, "", ZIPCODE)
                .waitForPageOpened();
        Assert.assertEquals(checkoutYourInfPage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test(description = "Buying product")
    public void buyingProductTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .checkoutBtnClick()
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE)
                .waitForPageOpened();
        Assert.assertEquals(checkoutPage.getCheckoutItemName(), "Sauce Labs Fleece Jacket");
        checkoutPage.finishBtnClick()
                .waitForPageOpened();
        Assert.assertTrue(checkoutPage.isConfirmOrderMessageDisplayed());
    }

    @Test(description = "Make an empty order")
    public void getEmptyOrderTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        cartPage.openPage()
                .waitForPageOpened()
                .checkoutBtnClick()
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE)
                .waitForPageOpened();
        checkoutPage.finishBtnClick()
                .waitForPageOpened();
        Assert.assertFalse(checkoutPage.isConfirmOrderMessageDisplayed());
    }

    @Test(description = "Check total cost of product")
    public void getTotalCostProductTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened()
                .checkoutBtnClick()
                .waitForPageOpened();
        checkoutYourInfPage.fillPersonalInfo(FIRSTNAME, LASTNAME, ZIPCODE)
                .waitForPageOpened();
        Assert.assertTrue(checkoutPage.getItemTotalCost());
    }
}
