package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.actitime.qa.base.TestBase.driver;
import static com.actitime.qa.base.TestBase.initialization;

public class UserAddStepDefinitions extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    String sheetName = "userData";
    TestUtil testUtil;
    @Given("admin navigated to Actitime Loging Page")
    public void admin_navigated_to_actitime_loging_page() {
        initialization();
        loginPage =  new LoginPage();
    }

    @When("admin enter credentials and I click on Loging button")
    public void admin_enter_credentials_and_i_click_on_loging_button() {
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
    }

    @When("admin can be able to successfuly loging to Actitime")
    public void admin_can_be_able_to_successfuly_loging_to_actitime() {
        boolean logo = homePage.validateActiTimeLogo();
        Assert.assertTrue(logo);
    }

    @When("admin click on the Users section")
    public void admin_on_the_users_section() {
        usersPage=homePage.clickOnUsersLink();
    }

    @Then("admin should be able to successfuly switch Users Section")
    public void admin_should_be_able_to_successfuly_switch_users_section() {
        boolean usersText=usersPage.validateUsersText();
        Assert.assertTrue(usersText);
    }

    @When("admin Click on the New User button")
    public void admin_click_on_the_new_user_button() {
        usersPage.clickNewUserButton();
    }

    @Then("admin can be able to fill the New user Form and click on submit button and verify the creation")
    public void admin_can_be_able_to_fill_the_new_user_form_and_click_on_submit_button() {
       usersPage.fillTheForm("Ahamed","Aathil","A","ahamedaathil.5@gmail.com");
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
