package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.InitPageElements;

public class HomePage extends InitPageElements {
   @FindBy(className = "title")
   private WebElement title;

    public String getPageTitle() {
        return title.getText();
    }

}
