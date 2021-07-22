package uitests;

import entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JsPage;
import pages.LoginPage;
import utils.TestData;


public class JsTest extends BaseTest {

    @Test
    public void jsTest() {
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        JsPage jsPage = homePage.openJsTestPage();
        jsPage.enterCoordinates(Math.round(jsPage.getLeftCoordinates()), Math.round(jsPage.getTopCoordinates()));
        String expectedResult = "Whoo Hoooo! Correct!";
        String actualResult = jsPage.alertText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
