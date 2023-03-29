package com.ilhamjavid18822.assignment.tests;

import com.ilhamjavid18822.assignment.base.TestBase;
import com.ilhamjavid18822.assignment.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ReportsPage reportsPage;
    TasksPage tasksPage;
    UsersPage usersPage;
    ApproveTTPage approveTTPage;


    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        reportsPage = new ReportsPage();
        tasksPage = new TasksPage();
        usersPage = new UsersPage();
        approveTTPage=new ApproveTTPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void titleTest() {
        String title = homePage.validateTitle();
        Assert.assertEquals(title, "actiTIME - Login", "incorrect title");
        logger.info(title);
    }

    @Test(priority = 2)
    public void usernameTest() {
        boolean isVisible = homePage.VerifyUsername();
        Assert.assertTrue(isVisible, "User name incorrect");
        logger.info(isVisible);
    }

    @Test(priority = 3)
    public void clickOnTasksPageTest() {
        tasksPage = homePage.ClickTasks();
    }

    @Test(priority = 4)
    public void clickOnReportsPageTest() {
        reportsPage = homePage.ClickReports();
    }


    @Test(priority = 5)
    public void clickOnUserPageTest() {
        usersPage = homePage.ClickUsers();
    }
    @Test(priority = 6)
    public void clickOnApproveTTPageTest(){
        approveTTPage=homePage.ClickApproveTimeTrack();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
