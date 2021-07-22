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
        
        HomePage homePage = new LoginPage().openAndLoginWithNoAuth(validUser);
        ApplicationPage applicationPage = homePage.getApplicationPage(3);
        
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
        
        MyApplications myApplications = new MyApplications();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openAddAppPage().createApp(application);
        myApplications.openApplicationPage(application.getTitle()).downloadJson();
        
        // TODO 'Add verification to the test'
    }

    @Test
    public void editApp(){
        String expectedDescription = "New description";
        User validUser = TestData.getValidUser();
        Application application = TestData.getDataForNewApp();
        
        LoginPage loginPage = new LoginPage();
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
        
        // TODO 'Add verification to the test'
    }

    @Test
    public void makeAppPopular() {
        User validUser = TestData.getValidUser();
        Application application = TestData.getDataForNewApp();
        LoginPage loginPage = new LoginPage();
        ApplicationPage applicationPage = new ApplicationPage();
        HomePage homePage = loginPage.openAndLoginWithNoAuth(validUser);
        homePage.openMyAppPage().openAddAppPage().createApp(application);
                // download #1
        homePage.openMyAppPage().openApplicationPage(application.getTitle()).downloadJson();
        homePage.backToPreviousPage();
                // download #2
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
                // download #3
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
                // download #4
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
                // download #5
        applicationPage.downloadJson();
        homePage.backToPreviousPage();
        homePage.refreshPage();
        applicationPage.findApp(application.getTitle());
        
        // TODO 'Add verification to the test'
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
