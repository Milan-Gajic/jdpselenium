package ui.pages.logIn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.util.List;

import static ui.pages.BasePage.Wrapper.*;
import static ui.pages.BasePage.Wrapper.click;

public class LogIn extends BasePage {
    public static String userEmail = "hr.hrm@htecgroup.com";
    public static String password = "hrm12321HRM";
    public static String baseDev1url = "https://dev1-hrm.htec.rs";
    public static String baseStageurl = "https://staging-hrm.htec.co.rs";

    public LogIn() {
        super();
    }

    //Locators
    @FindBy(xpath = "//a[@id='social-microsoft']")
    static
    WebElement MSButton;
    @FindBy(xpath = "//input[@type='email']")
    static WebElement email;
    @FindBy(xpath = "//input[@id='idSIButton9']")
    static WebElement nextBtn;
    @FindBy(xpath = "//input[@name='passwd']")
    static WebElement pass;
    @FindBy(xpath = "//input[@id='idSIButton9']")
    static WebElement singInBtn;
    @FindBy(xpath = "//input[@value='Yes']")
    static WebElement yesBtn;

    @FindBy(xpath = "//md-icon[@id='employee-edit-icon']")
    public static WebElement pen;
    @FindBy(xpath = "//md-icon[@id='employee-edit-icon']")
    List<WebElement> penElements;
    @FindBy(xpath = "(//button[contains(@class, 'toggle-logo__btn')])[2]")
    WebElement sideMenu;
    @FindBy(xpath = "//span[contains(text(), 'Teams')]")
    WebElement sideMenuTeams;

    public static void clickMSButton() {
        click(MSButton);
    }

    public static void typeEmail(String userEmail) {
        typeIn(email, userEmail);
        click(nextBtn);
    }

    public static void typePassword(String password) {
        typeIn(pass, password);
        click(singInBtn);
        click(yesBtn);
    }
}
