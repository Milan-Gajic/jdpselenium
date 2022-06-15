package ui.pages.teams;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.sql.Wrapper;

import static ui.pages.BasePage.Wrapper.click;
import static ui.pages.BasePage.Wrapper.typeIn;

public class AddTeamPage extends BasePage {


    //Locators
    @FindBy(xpath = "//input[@formcontrolname='name']")
    static WebElement teamNameInput;
    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    static WebElement teamDescriptionInput;
    @FindBy(xpath = "//mat-select[@formcontrolname='branch']")
    static WebElement teamBranchselect;
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    static WebElement createButton;
    @FindBy(xpath = "//span[contains(text(),'Banja Luka')]")
    static WebElement banjaLukabranch;

    public static void createTeam(String teamName, String teamDescription) {
//        BasePage.Wrapper wrapper = new Wrapper();
        typeIn(teamNameInput,teamName);
        click(teamDescriptionInput);
        typeIn(teamDescriptionInput,teamDescription);
        click(teamBranchselect);
        click(banjaLukabranch);
        click(createButton);
    }
}