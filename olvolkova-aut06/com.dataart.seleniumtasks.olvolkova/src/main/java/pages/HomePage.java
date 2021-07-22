package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "welcome")
    private WebElement welcomeMessage;

    @FindBy(css = "a[href='/auth/logout']")
    private WebElement logoutButton;

    @FindBy(css = "a[href='/my']")
    private WebElement myAppButton;

    @FindBy(css = "a[href='/']")
    private WebElement homeButton;

    @FindBy(css = "div.apps a")
    private List<WebElement> appsList;

    @FindBy(css = "a[href='/calc/']")
    private WebElement ajaxTestPageButton;

    @FindBy(css = "a[href='/js/']")
    private WebElement jsTestPageButton;

    public ApplicationPage getApplicationPage(int index) {
        appsList.get(index).click();
        return new ApplicationPage();
    }

    public JsPage openJsTestPage() {
        jsTestPageButton.click();
        return new JsPage();
    }


    public String getPageTitle() {
        return title.getText();
    }

    public boolean hasPageTitle() {
        return isElementPresent(By.className("title"));
    }

    public boolean hasAppsContent() {
        return isElementPresent(By.className("content"));
    }

    public boolean hasMyAppButton() {
        return isElementPresent(By.cssSelector("a[href='/my']"));
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage();
    }

    public AjaxTestPage openAjaxTestPage() {
        ajaxTestPageButton.click();
        return new AjaxTestPage();
    }

    public MyApplications openMyAppPage() {
        myAppButton.click();
        return new MyApplications();
    }

    public HomePage openHomePage() {
        homeButton.click();
        return new HomePage();
    }


}
