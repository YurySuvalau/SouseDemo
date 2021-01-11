package Constants;

import org.openqa.selenium.By;

public interface Constants {
    //Url
    String URL_SOUSE_DEMO = "https://www.saucedemo.com";
    String URL_CART_PAGE = "/cart.html";
    String URL_PRODUCTS = "/inventory.html";
    String URL_CHECKOUT = "/checkout-step-two.html";
    String URL_LOGIN = "/index.html";
    String URL_CHECKOUT_PERSONAL_INFO = "/checkout-step-one.html";
    String URL_CHECKOUT_FINISH_PAGE = "/checkout-complete.html";
    //Login input
    By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    //Product page
    String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    By CART_ICON = By.xpath("//*[@class='fa-layers-counter shopping_cart_badge']");
    By PRODUCT_LABEL = By.xpath("//*[contains(text(),'Product')]");
    By INVENTORY_ITEM_NAME = By.xpath("//*[@class='inventory_item_name']");
    By INVENTORY_PRICE = By.xpath("//*[@class='inventory_item_price']");
    //Product page/hamburger menu
    By HAMBURGER_MENU = By.xpath("//*[@class='bm-burger-button']");
    By HAMBURGER_MENU_REST_APP_STATE = By.xpath("//a[@id='reset_sidebar_link']");
    By HAMBURGER_MENU_LOGOUT = By.xpath("//*[@id='logout_sidebar_link']");
    By HAMBURGER_MENU_CLOSE = By.xpath("//*[@class='bm-cross-button']//button");
    By HAMBURGER_MENU_LOGOUT_BTN = By.xpath("//*[@class='bm-item-list']//*[text() = 'Logout']");
    //Product page/sort menu
    By SORT_MENU = By.xpath("//*[@class ='product_sort_container']");
    String SORT_NAME_BY_Z_TO_A = "Name (Z to A)";
    String SORT_NAME_BY_A_TO_Z = "Name (A to Z)";
    String SORT_BY_PRICE_LOW_TO_HIGH = "Price (low to high)";
    String SORT_BY_PRICE_HIGH_TO_LOW = "Price (high to low)";
    //Cart page
    String CONTINUE_SHOPPING_BUTTON = "//*[@class = 'ArtStyle TL-220G']";
    String GET_QUANTITY_IN_CART = "//*[@class='cart_quantity']";
    String GET_PRICE_IN_CART = "//*[@class='inventory_item_price']";
    String REMOVE_BUTTON = "//*[@class='btn_secondary cart_button']";
    String REMOVE_RESULT = "//*[@class='removed_cart_item']";
    By CHECKOUT_BUTTON = By.xpath("//*[@class='btn_action checkout_button']");
    String PRODUCT_NAME_ANCESTOR = "//*[text() = '%s']/ancestor::*[@class='cart_item']";
    String PRODUCT_QUANTITY = PRODUCT_NAME_ANCESTOR + "//*[@class='cart_quantity']";
    String PRODUCT_PRICE = PRODUCT_NAME_ANCESTOR + "//*[@class='inventory_item_price']";
    //Checkout
    String CHECKOUT_ONE_STEP_CONTINUE_BUTTON = "//*[@class='btn_primary cart_button']";
    By CHECKOUT_INF_FIRSTNAME = By.xpath("//*[@id='first-name']");
    By CHECKOUT_INF_LASTNAME = By.xpath("//*[@id='last-name']");
    By CHECKOUT_INF_ZIPCODE = By.xpath("//*[@id='postal-code']");
    String CHECKOUT_INF_STEP_TWO_OVERVIEW = "//*[@class='subheader']";
    By CHECKOUT_OVERVIEW_ITEM_NAME = By.xpath("//*[@class='inventory_item_name']");
    String ERROR = "//*[@data-test='error']";
    //Checkout/Overview
    String OVERVIEW_ITEM_TOTAL = ("//*[@class='summary_subtotal_label']");
    String OVERVIEW_TAX = "//*[@class='summary_tax_label']";
    String OVERVIEW_SUMMARY = "//*[@class='summary_total_label']";
    By CHECKOUT_FINISH_LABEL = By.xpath("//*[@class='subheader']");
    By CHECKOUT_FINISH_BUTTON = By.xpath("//*[@class='btn_action cart_button']");
    By CHECKOUT_FINISH_MESSAGE = By.xpath("//*[@id='checkout_complete_container']//*[text()='THANK YOU FOR YOUR ORDER']");
}

