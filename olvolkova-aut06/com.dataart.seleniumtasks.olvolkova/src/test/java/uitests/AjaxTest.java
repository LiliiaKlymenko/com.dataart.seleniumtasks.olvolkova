package uitests;

import entities.User;
import org.testng.annotations.Test;
import pages.AjaxTestPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;

import static org.testng.Assert.assertEquals;

public class AjaxTest extends BaseTest{

    @Test
    public void ajaxCalcTest() {
        int x = 5;
        int y = 7;
        
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        AjaxTestPage ajaxTestPage = homePage.openAjaxTestPage().enterValues(x, y);
        
        String actualResult = ajaxTestPage.getResult();
        String expectedResult = String.format("Result is: %.1f", Float.valueOf(x + y));
        
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void ajaxCalcTestWithString() {
        int x = 5;
        String y = "Not a Number";
        
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        AjaxTestPage ajaxTestPage = homePage.openAjaxTestPage().enterValues(x, y);
        
        String actualResult = ajaxTestPage.getResult();
        String expectedResult = "Result is: Incorrect data";
        
        assertEquals(actualResult, expectedResult);
    }
}
