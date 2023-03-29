package com.ilhamjavid18822.assignment.tests;

import com.ilhamjavid18822.assignment.base.TestBase;
import com.ilhamjavid18822.assignment.pages.ApproveTTPage;
import com.ilhamjavid18822.assignment.pages.HomePage;
import com.ilhamjavid18822.assignment.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApproveTTPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ApproveTTPage approveTTPage;

    public ApproveTTPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        approveTTPage = homePage.ClickApproveTimeTrack();
    }

    @Test(priority = 1)
    public void validateTitleTest() {
        String title = approveTTPage.validateTitle();
        Assert.assertEquals(title, "actiTIME - Approve Time-Track", "title mis-matched");
    }

    @Test(priority = 2)
    public void acceptTtTest() {
        Assert.assertTrue(approveTTPage.acceptTt());
    }

    @Test(priority = 3)
    public void rejectTtTest() {
        Assert.assertTrue(approveTTPage.rejectTt());
    }

    /**
     * this method will accept all the tt in the list. so temporarily this method is disabled
     **/
    @Test(enabled = false)
    public void acceptAllttTest() {
        Assert.assertTrue(approveTTPage.acceptAlltt());
    }

    /**
     * once acceptAllttTest trigger all the tt data will be deleted.
     * so there is no point to trigger rejectAllttTest() test
     **/
    @Test(enabled = false)
    public void rejectAllttTest() {
        Assert.assertTrue(approveTTPage.rejectAlltt());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
