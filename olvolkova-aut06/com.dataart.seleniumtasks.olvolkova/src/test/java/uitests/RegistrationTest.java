package uitests;

import entities.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import testdata.TestEnums;
import utils.TestData;
import java.util.List;

import static org.testng.Assert.*;

public class RegistrationTest extends BaseTest{

    @Test
    public void registrationTest() {
        User newUser = TestData.getUserForRegistration();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = loginPage.openPage().openRegisterPage();
        HomePage homePage = registerPage.registerFormWithCredentials(newUser);
        assertEquals(homePage.getPageTitle(), "Selenium test application",
                "Sign-in with valid login and password");
        assertEquals(homePage.getWelcomeMessage(), "Welcome " + newUser.getFirstName() + " " + newUser.getLastName(),
                "Register with new user");
    }

    @Test
    public void registrationAsDeveloperTest() {
        User newUser = TestData.getUserForRegistration();
        LoginPage loginPage = new LoginPage();
        NewApplicationAdd newApplicationAdd = new NewApplicationAdd();
        RegisterPage registerPage = loginPage.openPage().openRegisterPage();
        HomePage homePage = registerPage.registerFormWithCredentials(newUser);
        homePage.openMyAppPage().openAddAppPage().hasPageTitle();
        assertTrue(newApplicationAdd.hasPageTitle());
    }

    @Test
    public void registrationAsUserTest() {
        User newUser = TestData.getUserForRegistration().withUserRole(TestEnums.UserRole.USER);
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = loginPage.openPage().openRegisterPage();
        HomePage homePage = registerPage.registerFormWithCredentials(newUser);
        assertTrue(homePage.hasAppsContent());
        assertFalse(homePage.hasMyAppButton());

    }

    @Test
    public void logInAfterRegistrationTest() {
        User newUser = TestData.getUserForRegistration();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = loginPage.openPage().openRegisterPage();
        HomePage homePage = registerPage.registerFormWithCredentials(newUser);
        homePage.logout();
        loginPage.openAndLoginWithNoAuth(newUser);
    }

    @Test(dataProvider = "usersList")
    public void registrationTestWithCSV(User user) {
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = loginPage.openPage().openRegisterPage();
        HomePage homePage = registerPage.registerFormWithCredentials(user);
        assertEquals(homePage.getPageTitle(), "Selenium test application",
                "Sign-in with valid login and password");
        assertEquals(homePage.getWelcomeMessage(), "Welcome " + user.getFirstName() + " " + user.getLastName(),
                "Register with new user");
    }

    @DataProvider(name = "usersList")
    public Object[][] getUsersTest() {
        List<User> userList = TestData.getUserListFromCSV();
        return new Object[][]{
                {userList.get(0)}, {userList.get(1)}, {userList.get(2)}, {userList.get(3)}, {userList.get(4)}
        };
    }
}
