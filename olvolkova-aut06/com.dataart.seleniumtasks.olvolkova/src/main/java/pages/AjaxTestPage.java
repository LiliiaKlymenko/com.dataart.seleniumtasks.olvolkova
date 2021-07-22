package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class AjaxTestPage extends BasePage {

    @FindBy(id = "result")
    private WebElement result;

    @FindBy(id = "calc")
    private WebElement calculateButton;

    @FindBy(id = "clear")
    private WebElement clearButton;

    public AjaxTestPage enterValues(Object  x, Object  y) {
        waitForElement(By.cssSelector("input#x"), 1).sendKeys(String.valueOf(x));
        waitForElement(By.cssSelector("input#y"), 1).sendKeys(String.valueOf(y));
        calculateButton.click();
        return new AjaxTestPage();
    }

    public String getResult() {
        return waitForElement(By.cssSelector("div#result"), 5).getText();
    }
}
