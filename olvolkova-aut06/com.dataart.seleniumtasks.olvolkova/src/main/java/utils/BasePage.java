package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BasePage extends PageFactory {
    public BasePage() {
        initElements(WebDriverManager.getDriver(), this);
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            WebDriverManager.getDriver().findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void openNewTab() {
        JavascriptExecutor jse = (JavascriptExecutor) WebDriverManager.getDriver();
        jse.executeScript("window.open()");
    }

    public void switchToTab(int index) {
        ArrayList<String> tabs = new ArrayList<String>(WebDriverManager.getDriver().getWindowHandles());
        WebDriverManager.getDriver().switchTo().window(tabs.get(index));
    }

    public void backToPreviousPage() {
        WebDriverManager.getDriver().navigate().back();
    }

    public void refreshPage() {
        WebDriverManager.getDriver().navigate().refresh();
    }

    public void acceptAlert() {
        Alert alert = WebDriverManager.getDriver().switchTo().alert();
        alert.accept();
    }

    public void acceptAlertIfPresent() {
        try {
            acceptAlert();
        }
        catch (Exception e) {
        }
    }

    public String  alertText() {
        Alert alert = WebDriverManager.getDriver().switchTo().alert();
        return alert.getText();
    }

    public WebElement waitForElement(By selector, int seconds) {
        WebDriverWait wait;
        wait = new WebDriverWait(WebDriverManager.getDriver(), seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        return WebDriverManager.getDriver().findElement(selector);
    }

}

