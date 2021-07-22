package pages;

import com.google.common.base.Strings;
import entities.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class AddApplicationPage extends BasePage {

    @FindBy(name = "title")
    private WebElement appTitle;

    @FindBy(name = "description")
    private WebElement addDescription;

    @FindBy(css = "input[type=submit]")
    private WebElement createButton;

    @FindBy(name = "image")
    private WebElement imageAddButton;

    @FindBy(name = "icon")
    private WebElement iconAddButton;

    public boolean hasPageTitle() {
        return isElementPresent(By.className("title"));
    }

    public MyApplications createApp(Application application) {
        appTitle.sendKeys(application.getTitle());
        addDescription.sendKeys(application.getDescription());
        if(!Strings.isNullOrEmpty(application.getImageData())) {
            imageAddButton.sendKeys(application.getImageData());
            iconAddButton.sendKeys(application.getIconData());
        }
        createButton.click();
        return new MyApplications();
    }

    public MyApplications createAppButton() {
        createButton.click();
        return new MyApplications();
    }

    public HomePage updateApp(String descriprion) {
        addDescription.clear();
        addDescription.sendKeys(descriprion);
        createButton.click();
        return new HomePage();
    }
}
