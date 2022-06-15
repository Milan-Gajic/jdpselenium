package ui.tests.teams;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import ui.pages.profile.BasicPage;
import ui.pages.teams.AddTeamPage;
import ui.pages.teams.TeamsCommonPage;

import static ui.pages.BasePage.Wrapper.click;

public class CreateTeam {

    BasicPage basicPage;
    TeamsCommonPage teamsCommonPage;
    AddTeamPage addTeamPage;

    public CreateTeam() {
        basicPage = new BasicPage();
        teamsCommonPage = new TeamsCommonPage();
        addTeamPage = new AddTeamPage();
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
