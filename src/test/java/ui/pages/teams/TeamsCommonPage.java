package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;


public class TeamsCommonPage extends BasePage {
    String searchTerm;


    //Locators
    @FindBy(xpath = "//span[contains(text(),'+ Team')]")
    public static WebElement newTeambutton;
    @FindBy(xpath = "//input[@placeholder='Search teams']")
    WebElement searchBar;

    public static void clickAddNewTeamButton() {
        BasePage.Wrapper.click(newTeambutton);
    }
}

