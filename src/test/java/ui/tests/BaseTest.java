package ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.logIn.LogIn;

public class BaseTest {
    @BeforeMethod
    public void LogIn() throws Exception {
        LogIn.logIn();
    }
    @AfterMethod
    public void LogOut(){
        LogIn.logOut();
    }

}
