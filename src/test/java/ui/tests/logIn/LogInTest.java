package ui.tests.logIn;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.BasePage;
import ui.pages.logIn.LogIn;

public class LogInTest {
    LogIn logIn;

    public LogInTest() {
        logIn = new LogIn();
    }

    @Test(priority = 0)
    public void logIn() throws Exception {
        LogIn.logIn();
    }
    @Test
    public void logOut() {
    LogIn.logOut();
        Assert.assertTrue(LogIn.MSButton.isDisplayed(), "Microsoft Button is not visible.");
    }
}
