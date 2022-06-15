package ui.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ui.browser.BrowserName;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static ui.browser.Browser.*;


public class BasePage {

    public BasePage() {
        startDriver(BrowserName.CHROME);
        PageFactory.initElements(driver, this);
    }

    public static class Waits {
        static WebDriverWait wait = new WebDriverWait(driver, 10);

        public static void waitToBeVisible(WebElement element) {
            try {
                wait.until((ExpectedConditions.visibilityOf(element)));
            } catch (Exception exception) {
                System.out.println("Element " + element + " is not visible.");
            }
        }

        static void waitToBeClickable(WebElement element) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception exception) {
                System.out.println("Element " + element + " is not clickable.");
            }
        }
    }

    public static class Wrapper {
        static JavascriptExecutor js = (JavascriptExecutor) driver;

        public static void typeIn(WebElement element, String text) {
            Waits.waitToBeClickable(element);
            element.click();
//        element.clear();
            element.sendKeys(text);
        }

        public static void click(WebElement element) {
            Waits.waitToBeClickable(element);
            try {
                element.click();
            } catch (Exception e) {
                clickJS(element);
            }
        }

        static void clickJS(WebElement element) {
            Waits.waitToBeClickable(element);
            js.executeScript("arguments[0].click();", element);
        }

        public static void clear(WebElement element) {
            Waits.waitToBeClickable(element);
            element.clear();
        }
    }

    //Screen size page screenshot
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    //Whole page screenshot
    public static void takeAshotFullPage() throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png", new File("C:\\Users\\Milan Gajic\\Documents\\QA JDP\\SeleniumSS\\Ashot\\fullpage.png"));
    }

    //Element screenshot
    public static void takeElementScreenshot(WebElement element) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);
        ImageIO.write(screenshot.getImage(), "png", new File("C:\\Users\\Milan Gajic\\Documents\\QA JDP\\SeleniumSS\\Ashot\\element.png"));
    }
    //Pronaci drugi tool za screenshot


}
