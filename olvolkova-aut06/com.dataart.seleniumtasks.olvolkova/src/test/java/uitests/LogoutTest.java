package uitests;

import entities.User;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest{

    @Test
    public void logoutTest() {
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openNewTab();
        homePage.switchToTab(1);
        loginPage.openPage();
        homePage.logout();
        homePage.switchToTab(0);
        homePage.openMyAppPage();
        assertTrue(loginPage.hasLoginButton());
    }
}
