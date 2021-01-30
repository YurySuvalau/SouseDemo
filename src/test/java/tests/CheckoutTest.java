package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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
