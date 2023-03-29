package com.ilhamjavid18822.assignment.tests;

import com.ilhamjavid18822.assignment.base.TestBase;
import com.ilhamjavid18822.assignment.pages.HomePage;
import com.ilhamjavid18822.assignment.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "actiTIME - Login","Incorrect page Title");
        logger.info(title);
    }

    @Test(priority = 2)
    public void logoTest() {
        boolean isdisplayed = loginPage.validateLogo();
        Assert.assertTrue(isdisplayed,"The log is not visible");
        logger.info(isdisplayed);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
