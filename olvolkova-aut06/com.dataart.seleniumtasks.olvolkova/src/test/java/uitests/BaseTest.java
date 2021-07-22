package uitests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WebDriverManager;

public class BaseTest {

    @BeforeMethod
    public void before() {
        WebDriverManager.setDriver();
    }

    @AfterMethod
    public void after() {
        HomePage homePage = new HomePage();
        homePage.acceptAlertIfPresent();
        WebDriverManager.closeBrowser();
    }
}
