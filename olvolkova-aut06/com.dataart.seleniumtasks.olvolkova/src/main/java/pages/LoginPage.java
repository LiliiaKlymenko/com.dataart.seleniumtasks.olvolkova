package pages;

import entities.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;
import utils.PropertyManager;
import utils.WebDriverManager;

public class LoginPage extends BasePage {
    
    @FindBy(id = "j_username")
    private WebElement loginField;

    @FindBy(id = "j_password")
    private WebElement passwordField;

    @FindBy(css = "input[type=submit]")
    private WebElement loginButton;

    @FindBy(className = "flash")
    private WebElement error;

    @FindBy(css = "a")
    private  WebElement registerButton;

    public String getError() {
        return error.getText();
    }

    public boolean hasLoginButton() {
        return isElementPresent(By.cssSelector("input[type=submit]"));
    }

    public HomePage submitFormWithCredentials(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }

    public RegisterPage openRegisterPage() {
        registerButton.click();
        return new RegisterPage();
    }

    public LoginPage openPage() {
        PropertyManager propertyManager = PropertyManager.getInstance();
        WebDriverManager.getDriver().get(propertyManager.loadData("protocol") + propertyManager.loadData("noAuthUrl"));
        return new LoginPage();
    }

    public HomePage openAndLoginWithBasicAuth(User user) {
        PropertyManager propertyManager = PropertyManager.getInstance();
        String protocol = propertyManager.loadData("protocol");
        String basicAuth = user.getLogin() + ":" + user.getPassword() + "@";
        String uri = propertyManager.loadData("basicAuthUrl");
        WebDriverManager.getDriver().get(protocol + basicAuth + uri);
        return new HomePage();
    }

    public HomePage openAndLoginWithNoAuth(User user) {
        openPage();
        submitFormWithCredentials(user.getLogin(), user.getPassword());
        return new HomePage();
    }

}
