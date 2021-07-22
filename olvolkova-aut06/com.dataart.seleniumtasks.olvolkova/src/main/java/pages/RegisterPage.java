package pages;

import entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BasePage;

public class RegisterPage extends BasePage {
    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "fname")
    private WebElement firstNameField;

    @FindBy(name = "lname")
    private WebElement lastNameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "passwordConfirm")
    private WebElement passwordConfirmField;

    @FindBy(css = "input[type=submit]")
    private WebElement registerButton;

    @FindBy(name = "role")
    private WebElement roleDropdown;

    public HomePage registerFormWithCredentials(User newUser) {
        nameField.sendKeys(newUser.getLogin());
        firstNameField.sendKeys(newUser.getFirstName());
        lastNameField.sendKeys(newUser.getLastName());
        passwordField.sendKeys(newUser.getPassword());
        passwordConfirmField.sendKeys(newUser.getPasswordConfirm());
        new Select(roleDropdown).selectByValue(newUser.getUserRole().name());
        registerButton.click();
        return new HomePage();
    }
}
