import entities.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;
import utils.WebDriverManager;

import static org.testng.Assert.assertEquals;

/**
 *  Login tests
 */
public class LoginTest {

    @BeforeMethod
    public void before() {
        WebDriverManager.openBrowser();
    }

    @Test
    public void loginWithValidKeys() {
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openPage().submitFormWithCredentials(validUser.getLogin(), validUser.getPassword());
        assertEquals(homePage.getPageTitle(), "Selenium test application",
                "Sign-in with valid login and password");
    }

    //    Sign-in with invalid login and password
    @Test
    public void loginWithInValidKeys() {
        User validUser = TestData.getInvalidUser();
        LoginPage loginPage = new LoginPage();
        loginPage.openPage().submitFormWithCredentials(validUser.getLogin(), validUser.getPassword());
        assertEquals(loginPage.getError(), "You have entered an invalid username or password!",
                "Sign-in with invalid login and password");
    }
}
