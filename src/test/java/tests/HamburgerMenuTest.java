package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static сonstants.Constants.*;

public class HamburgerMenuTest extends BaseTest {

    @Test(description = "Check button Add To Cart after click on Rest App States  button")
    public void restAppStatesAddToCarBtnStatusTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        hamburgerMenuPage.openPage()
                .waitForPageOpened()
                .resetAppStateClick()
                .closeMenuSpanClick()
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getTextOnAddToCartBtn("Sauce Labs Fleece Jacket"), "ADD TO CART");
    }

    @Test(description = "Check icon on Cart after click on Rest App States  button")
    public void restAppStateCartIconStatusTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        hamburgerMenuPage.openPage()
                .waitForPageOpened()
                .resetAppStateClick()
                .closeMenuSpanClick()
                .waitForPageOpened();
        Assert.assertFalse(productsPage.isDisplayedCartIconCount());
    }

    @Test(description = "Click Logout button")
    public void hamburgerMenuLogoutBtnTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        hamburgerMenuPage.openPage()
                .waitForPageOpened()
                .logoutBtnClick()
                .waitForPageOpened();
        Assert.assertEquals(loginPage.getUrl(), URL_SOUSE_DEMO + URL_LOGIN);
    }
}


