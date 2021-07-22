package uitests;

import entities.Application;
import entities.User;
import json.ApplicationJson;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.*;
import utils.TestData;

public class ApplicationTest extends BaseTest{

    @Test
    public void compareAppJson(){
        User validUser = TestData.getValidUser();
        LoginPage loginPage = new LoginPage();
        ApplicationPage applicationPage = new ApplicationPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.getApplicationPage(3);
        ApplicationJson json = applicationPage.downloadJson();
        applicationPage.backToPreviousPage();
        applicationPage.refreshPage();
        Application application = applicationPage.getApplicationEntity();
        assertEquals(application.getAuthor(), json.getAuthor().getName());
        assertEquals(application.getCategory(), json.getCategory().getTitle());
        assertEquals(application.getDescription(), json.getDescription());
        assertEquals(application.getTitle(), json.getTitle());
        assertEquals(application.getNumberOfDownloads(), json.getNumberOfDownloads());
    }

    @Test
    public void createApp(){
        User validUser = TestData.getValidUser();
        Application application = TestData.getDataForNewApp();
        LoginPage loginPage = new LoginPage();
        MyApplications myApplications = new MyApplications();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openAddAppPage().createApp(application);
        myApplications.openApplicationPage(application.getTitle()).downloadJson();
    }

    @Test
    public void editApp(){
        User validUser = TestData.getValidUser();
        Application application = TestData.getDataForNewApp();
        LoginPage loginPage = new LoginPage();
        String expectedDescription = "New description";
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openApplicationPage(application.getTitle()).editApp().updateApp(expectedDescription);
        String actualDescription = homePage.openMyAppPage().openApplicationPage(application.getTitle())
                .getApplicationEntity().getDescription();
        assertEquals(actualDescription, expectedDescription);
    }

    @Test
    public void createAppWithImage() {
        User validUser = TestData.getValidUser();
        Application application = TestData.newAppWithImage();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openAddAppPage().createApp(application);
    }

    @Test
    public void makeAppPopular() {
        User validUser = TestData.getValidUser();
        Application application = TestData.getDataForNewApp();
        LoginPage loginPage = new LoginPage();
        ApplicationPage applicationPage = new ApplicationPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openAddAppPage().createApp(application);
        homePage.openMyAppPage().openApplicationPage(application.getTitle()).downloadJson();
        homePage.backToPreviousPage();
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
        homePage.refreshPage();
        applicationPage.findApp(application.getTitle());
    }

    @Test
    public void deleteApp() {
        User validUser = TestData.getValidUser();
        Application application = TestData.newAppWithImage();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openAddAppPage().createApp(application);
        homePage.openMyAppPage().openApplicationPage(application.getTitle()).deleteApp().acceptAlert();
        homePage.openMyAppPage();
        assertFalse(new HomePage().openMyAppPage().isAppPresent(application.getTitle()));
    }
}
