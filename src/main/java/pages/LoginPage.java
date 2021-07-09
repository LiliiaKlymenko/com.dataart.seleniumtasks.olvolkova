package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.InitPageElements;
import utils.PropertyManager;
import utils.WebDriverManager;

public class LoginPage extends InitPageElements {
    @FindBy(id = "j_username")
    private WebElement loginField;

    @FindBy(id = "j_password")
    private WebElement passwordField;

    @FindBy(css = "input[type=submit]")
    private WebElement loginButton;

    @FindBy(className = "flash")
    private WebElement error;

    public String getError() {
        return error.getText();
    }

    public HomePage submitFormWithCredentials(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }

    public LoginPage openPage() {
        WebDriverManager.driver.get(PropertyManager.getInstance().loadData("noAuthUrl"));
        return new LoginPage();
    }

}
