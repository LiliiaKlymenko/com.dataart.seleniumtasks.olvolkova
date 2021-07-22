package pages;

import entities.Application;
import json.ApplicationJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;
import utils.JsonUtils;
import utils.WebDriverManager;

import java.util.List;

public class ApplicationPage extends BasePage {
    @FindBy(className = "name")
    private WebElement title;

    @FindBy(css = "div.description:nth-child(3)")
    private WebElement description;

    @FindBy(css = "div.description:nth-child(4)")
    private WebElement category;

    @FindBy(css = "div.description:nth-child(5)")
    private WebElement author;

    @FindBy(className = "downloads")
    private WebElement downloads;

    @FindBy(css = "div.download-button a")
    private WebElement downloadButton;

    @FindBy(css = "div.edit-app-button a:nth-child(1)")
    private WebElement deleteAppButton;

    @FindBy(css = "div.edit-app-button a:nth-child(2)")
    private WebElement editAppButton;

    @FindBy(css = "div.popular-app a")
    private List<WebElement> myApp;

    public Application getApplicationEntity() {
        return new Application().withDescription(description.getText().replace("Description: ", ""))
                .withAuthor(author.getText().replace("Author: ", ""))
                .withCategory(category.getText().replace("Category: ", ""))
                .withTitle(title.getText())
                .withNumberOfDownloads(Integer.parseInt(downloads.getText().replace("# of downloads: ", "")));
    }

    public ApplicationJson downloadJson() {
        downloadButton.click();
        String json = WebDriverManager.getDriver().findElement(By.cssSelector("body")).getText();
        return JsonUtils.jsonToJavaObject(json, ApplicationJson.class);
    }

    public NewApplicationAdd editApp() {
        editAppButton.click();
        return new NewApplicationAdd();
    }

    public HomePage deleteApp() {
        deleteAppButton.click();
        return new HomePage();
    }

    public ApplicationPage findApp(String title) {
        myApp.stream().filter(application -> application.getAttribute("href").contains(title)).findFirst().get().click();
        return new ApplicationPage();
    }

}
