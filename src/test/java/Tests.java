import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.browser.Browser;
import ui.pages.BasePage;
import ui.pages.logIn.LogIn;
import ui.pages.profile.BasicPage;
import ui.pages.teams.AddTeamPage;
import ui.pages.teams.TeamsCommonPage;

import static ui.pages.BasePage.*;
import static ui.pages.BasePage.Wrapper.*;
import static ui.pages.BasePage.takeSnapShot;


public class Tests {
    LogIn logIn;
    AddTeamPage addTeamPage;
    BasicPage basicPage;
    TeamsCommonPage teamsCommonPage;

    public Tests() {
        addTeamPage = new AddTeamPage();
        logIn = new LogIn();
        basicPage = new BasicPage();
        teamsCommonPage = new TeamsCommonPage();
    }

    @Test(priority = 0)
    public void logIn() throws Exception {
        Browser.driver.get(LogIn.baseStageurl);
        Browser.driver.manage().window().maximize();
        LogIn.clickMSButton();
        LogIn.typeEmail(LogIn.userEmail);
        LogIn.typePassword(LogIn.password);
        String title = Browser.driver.getTitle();
        Assert.assertEquals(title, "HRM", "Title is not same.");
        Waits.waitToBeVisible(basicPage.pen);
        takeSnapShot(Browser.driver, "C:\\Users\\Milan Gajic\\Documents\\QA JDP\\SeleniumSS\\test.png");
    }

    @Test(priority = 1, enabled = true)
    @Description("Set Technology and domain")
    public void techAndDomain() {
        click(basicPage.edit);
        click(basicPage.selectTechnology);
        click(basicPage.dotNet);
        Assert.assertTrue(basicPage.dotNet.isDisplayed());
        click(basicPage.check);
    }

    @Test(priority = 1, enabled = true)
    @Description("Find an count multiple 'pen' elements")
    public void penElements() {
        Waits.waitToBeVisible(basicPage.pen);
        System.out.println("Number of pen elements is: " + basicPage.penElements.size());
        Assert.assertEquals(basicPage.penElements.size(), 6, "Number of pen elements not ok");
    }

    @Test(priority = 2, enabled = true)
    @Description("Get attribute")
    public void findAttribute() {
        Waits.waitToBeVisible(basicPage.star);
        System.out.println("Attribute 'role' of star element is " + basicPage.star.getAttribute("role"));
    }

    @Test(priority = 3, enabled = true)
    @Description("Add a new team")
    public void addNewTeam() {
        click(basicPage.sideMenu);
        click(basicPage.sideMenuTeams);
        TeamsCommonPage.clickAddNewTeamButton();
        AddTeamPage.createTeam("Novi tim", "Deskripcija");
    }
}
