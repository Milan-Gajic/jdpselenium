package ui.pages.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.util.List;

public class BasicPage extends BasePage {
    @FindBy(xpath = "//mat-icon[contains(text(),'edit')]") public WebElement edit;
    @FindBy(xpath = "//mat-select[@id='mat-select-0']") public  WebElement selectTechnology;
    @FindBy(xpath = "//span[text()='.Net']") public WebElement dotNet;
    @FindBy(xpath = "//mat-icon[contains(text(),'done')]") public WebElement check;
    @FindBy(xpath = "//md-icon[@aria-label='basic']") public WebElement star;
    @FindBy(xpath = "//md-icon[@id='employee-edit-icon']") public WebElement pen;
    @FindBy(xpath = "//md-icon[@id='employee-edit-icon']") public List<WebElement> penElements;
    @FindBy(xpath = "(//button[contains(@class, 'toggle-logo__btn')])[2]") public WebElement sideMenu;
    @FindBy(xpath = "//span[contains(text(), 'Teams')]") public WebElement sideMenuTeams;
    @FindBy(xpath = "//div[@class='col base-margin']") public WebElement positionsSection;
}
