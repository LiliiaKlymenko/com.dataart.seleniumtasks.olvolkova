package pages;

import net.sourceforge.htmlunit.corejs.javascript.Script;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;
import utils.JsonUtils;
import utils.WebDriverManager;

import javax.xml.stream.Location;
import java.util.IdentityHashMap;

public class JsPage extends BasePage {

    @FindBy(className = "flash")
    private WebElement findMeBox;

    @FindBy(id = "process")
    private WebElement processButton;

    public JsPage enterCoordinates(Object left, Object top) {
        waitForElement(By.cssSelector("input#top"), 1).sendKeys(String.valueOf(top));
        waitForElement(By.cssSelector("input#left"), 1).sendKeys(String.valueOf(left));
        processButton.click();
        return new JsPage();
    }


    public double getTopCoordinates() {
        waitForElement(By.cssSelector("div.flash"), 1);
        String top = getElementStyleProperty("flash", "top");
        top = top.replaceAll("px", "");
        return Double.valueOf(top);
    }

    public double getLeftCoordinates() {
        waitForElement(By.cssSelector("div.flash"), 1);
        String left = getElementStyleProperty("flash", "left");
        left = left.replaceAll("px", "");
        return Double.valueOf(left);
    }

    public String getElementStyleProperty(String elementClass, String property) {
        String script = "return window.getComputedStyle(window.document.getElementsByClassName('"+ elementClass +"')[0])" +
                ".getPropertyValue('"+ property +"');";
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
        return js.executeScript(script).toString();
    }
}
