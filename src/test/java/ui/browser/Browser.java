package ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
    public static WebDriver driver = null;

    public static void startDriver(BrowserName browser) {
        if (driver == null) {
            switch (browser) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:/Users/Milan Gajic/Documents/QA JDP/MyMavenProject/src/webdrivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.edge.driver","C:/Users/Milan Gajic/Documents/QA JDP/MyMavenProject/src/webdrivers/msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
            }
        }
    }
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
