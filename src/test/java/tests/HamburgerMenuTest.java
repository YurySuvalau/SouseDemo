package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.Constants.*;

public class HamburgerMenuTest extends BaseTest {

    @Test
    public void restAppStatesAddToCarBtnStatus() {
        loginPage.openPage() //open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        hamburgerMenuPage.openPage()//Click on hamburger menu page icon
                .waitForPageOpened()
                .resetAppStateClick() //Click on "Rest app state" button
                .closeMenuSpanClick() //Click on close menu span
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getTextOnAddToCartBtn("Sauce Labs Fleece Jacket"), "ADD TO CART");//Check button "add to cart" text
    }

    @Test
    public void restAppStateCartIconStatus() {
        loginPage.openPage()//open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        hamburgerMenuPage.openPage() //Click on hamburger menu page icon
                .waitForPageOpened()
                .resetAppStateClick()//Click on "Rest app state" button
                .closeMenuSpanClick() //Click close menu span
                .waitForPageOpened();
        Assert.assertFalse(productsPage.isDisplayedCartIconCount());//Check button "add to cart" text
    }

    @Test
    public void hamburgerMenuLogoutBtn() {
        loginPage.openPage()//open site
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD) //login
                .waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");//add product to cart
        hamburgerMenuPage.openPage() //Click on hamburger menu page icon
                .waitForPageOpened()
                .logoutBtnClick() //Click on "Rest app state" button
                .waitForPageOpened();
        Assert.assertEquals(loginPage.getUrl(), URL_SOUSE_DEMO + URL_LOGIN);//Check button "add to cart" text
    }
}


