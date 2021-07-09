package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    public static WebDriver driver;

    public static void openBrowser() {
        driver = new ChromeDriver();
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
