package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void demoTest() {
        loginPageFactory.openPage()
                .waitForPageOpened()
                .login(LOGIN_PAGE_USERNAME, LOGIN_PAGE_PASSWORD)
                .waitForPageOpened();
        Assert.assertTrue(productsPage.isPageOpened());
    }
}