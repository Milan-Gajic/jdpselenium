package ui.tests.profilePage.basic;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.BasePage;
import ui.pages.profile.BasicPage;

import static ui.pages.BasePage.Wrapper.click;

public class ProfileBasicTests {
    BasicPage basicPage;

    public ProfileBasicTests() {
        basicPage = new BasicPage();
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
        BasePage.Waits.waitToBeVisible(basicPage.pen);
        System.out.println("Number of pen elements is: " + basicPage.penElements.size());
        Assert.assertEquals(basicPage.penElements.size(), 6, "Number of pen elements not ok");
    }

    @Test(priority = 2, enabled = true)
    @Description("Get attribute")
    public void findAttribute() {
        BasePage.Waits.waitToBeVisible(basicPage.star);
        System.out.println(basicPage.star.getAttribute("role"));
    }
}
