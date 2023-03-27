package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    String sheetName = "userData";

    public UserPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = homePage.clickOnUsersLink();
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
//    @Test(priority = 4)
//    public void validateUserAdditionTest(){
//        String bgColor = usersPage.validateUserAddition();
//        Assert.assertEquals(bgColor,"rgba(231, 244, 230, 1)");
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
