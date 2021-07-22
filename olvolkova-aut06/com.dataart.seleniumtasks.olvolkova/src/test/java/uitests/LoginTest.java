package uitests;

import entities.User;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginAsValidUser() {
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        assertEquals(homePage.getPageTitle(), "Selenium test application",
                "Sign-in with valid login and password without Auth");
    }

    @Test
    public void loginAsInValidUser() {
        User invalidUser = TestData.getInvalidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.openAndLoginWithNoAuth(invalidUser);
        assertEquals(loginPage.getError(), "You have entered an invalid username or password!",
                "Sign-in with invalid login and password without Auth");
    }

    @Test
    public void loginBasicAuthValidUser() {
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithBasicAuth(validUser);
        assertEquals(homePage.getPageTitle(), "Selenium test application",
                "Sign-in with valid login and password using Basic Auth");
    }

    @Test
    public void loginBasicAuthInvalidUser() {
        User invalidUser = TestData.getInvalidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithBasicAuth(invalidUser);
        assertFalse(homePage.hasPageTitle(), 
                    "Sign-in with invalid login and password using Basic Auth");
    }
}
