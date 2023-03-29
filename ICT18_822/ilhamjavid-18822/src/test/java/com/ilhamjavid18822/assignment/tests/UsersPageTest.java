package com.ilhamjavid18822.assignment.tests;

import com.ilhamjavid18822.assignment.base.TestBase;
import com.ilhamjavid18822.assignment.pages.HomePage;
import com.ilhamjavid18822.assignment.pages.LoginPage;
import com.ilhamjavid18822.assignment.pages.UsersPage;
import com.ilhamjavid18822.assignment.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class UsersPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    String sheetName = "userData";

    public UsersPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        usersPage = homePage.ClickUsers();
    }

    @Test(priority = 1)
    public void validateUsersTextTest() {
        boolean isVisible = usersPage.validateUsersText();
        Assert.assertTrue(isVisible, "The text Users is not visible");
    }

    @Test(priority = 2)
    public void clickNewUserButtonTest() {
        boolean isPannelVisible = usersPage.clickNewUserButton();
        Assert.assertTrue(isPannelVisible);
    }

    @DataProvider
    public Object[][] getDataFromSheet() {
        Object[][] data = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getDataFromSheet")
    public void fillTheFormTest(String firstname, String middlename, String lastname, String email) {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        usersPage.fillTheForm(firstname, lastname, middlename, email);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
