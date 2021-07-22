package pages;

import entities.Application;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;
import utils.WebDriverManager;

import java.util.List;

public class MyApplications extends BasePage {

    @FindBy(css = "a[href='/new']")
    private WebElement addAppButton;

    @FindBy(css = "div.app a")
    private List<WebElement> myAppList;

    public NewApplicationAdd openAddAppPage() {
        addAppButton.click();
        return new NewApplicationAdd();
    }

    public ApplicationPage openApplicationPage(String title) {
        myAppList.stream().filter(application -> application.getAttribute("href").contains(title)).findFirst().get().click();
        return new ApplicationPage();
    }

    public boolean isAppPresent(String title) {
       return myAppList.stream().filter(application -> application.getAttribute("href").contains(title)).count() != 0;
    }

}
