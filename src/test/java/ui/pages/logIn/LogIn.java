package ui.pages.logIn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ui.browser.Browser;
import ui.pages.BasePage;
import ui.pages.profile.BasicPage;

import java.util.List;

import static ui.pages.BasePage.Wrapper.*;
import static ui.pages.BasePage.Wrapper.click;

public class LogIn extends BasePage {
    public static String userEmail = "hr.hrm@htecgroup.com";
    public static String password = "hrm12321HRM";
    public static String baseDev1url = "https://dev1-hrm.htec.rs";
    public static String baseStageurl = "https://staging-hrm.htec.co.rs";

    static BasicPage basicPage;

    public LogIn() {
        basicPage = new BasicPage();
    }

    //Locators
    @FindBy(xpath = "//a[@id='social-microsoft']")
    public static WebElement MSButton;
    @FindBy(xpath = "//input[@type='email']") static WebElement email;
    @FindBy(xpath = "//input[@id='idSIButton9']") static WebElement nextBtn;
    @FindBy(xpath = "//input[@name='passwd']") static WebElement pass;
    @FindBy(xpath = "//input[@id='idSIButton9']") static WebElement singInBtn;
    @FindBy(xpath = "//input[@value='Yes']") static WebElement yesBtn;
    @FindBy(xpath = "//md-icon[@id='employee-edit-icon']") public static WebElement pen;
    @FindBy(xpath = "//md-icon[@id='employee-edit-icon']") List<WebElement> penElements;
    @FindBy(xpath = "(//button[contains(@class, 'toggle-logo__btn')])[2]") WebElement sideMenu;
    @FindBy(xpath = "//span[contains(text(), 'Teams')]") WebElement sideMenuTeams;
    @FindBy(xpath = "//button[@class='mat-menu-trigger status-menu__button']")
    static WebElement statusMenu;
    @FindBy(xpath = "//mat-icon[contains(text(), 'arrow_drop_down')]") WebElement statusMenuArrow;
    @FindBy(xpath = "//mat-icon[contains(text(), ' exit_to_app ')]")
    static WebElement singOutButton;

    public static void logIn() throws Exception {
        Browser.driver.get(LogIn.baseStageurl);
        Browser.driver.manage().window().maximize();
        click(MSButton);
//        LogIn.typeEmail(LogIn.userEmail);
        typeIn(email, userEmail);
        click(nextBtn);
//        LogIn.typePassword(LogIn.password);
        typeIn(pass, password);
        click(singInBtn);
        click(yesBtn);
        String title = Browser.driver.getTitle();
        Assert.assertEquals(title, "HRM", "Title is not same.");
        BasePage.Waits.waitToBeVisible(basicPage.pen);
        takeSnapShot(Browser.driver, "C:\\Users\\Milan Gajic\\Documents\\QA JDP\\SeleniumSS\\test.png");
        takeAshotFullPage();
    }

    public static void logOut(){
        click(statusMenu);
        click(singOutButton);
    }

}
