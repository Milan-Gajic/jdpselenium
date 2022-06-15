package ui.tests.logIn;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.browser.Browser;
import ui.pages.BasePage;
import ui.pages.logIn.LogIn;
import ui.pages.profile.BasicPage;

import static ui.pages.BasePage.*;

public class LogInTest {
    LogIn logIn;
    BasicPage basicPage;

    public LogInTest() {
        logIn = new LogIn();
        basicPage = new BasicPage();
    }

    @Test(priority = 0)
    public void logIn() throws Exception {
        Browser.driver.get(LogIn.baseStageurl);
        Browser.driver.manage().window().maximize();
        LogIn.clickMSButton();
        LogIn.typeEmail(LogIn.userEmail);
        LogIn.typePassword(LogIn.password);
        String title = Browser.driver.getTitle();
        Assert.assertEquals(title,"HRM", "Title is not same.");
        BasePage.Waits.waitToBeVisible(basicPage.pen);
        takeSnapShot(Browser.driver, "C:\\Users\\Milan Gajic\\Documents\\QA JDP\\SeleniumSS\\test.png");
        takeAshotFullPage();
        takeElementScreenshot(basicPage.positionsSection);
    }
}
