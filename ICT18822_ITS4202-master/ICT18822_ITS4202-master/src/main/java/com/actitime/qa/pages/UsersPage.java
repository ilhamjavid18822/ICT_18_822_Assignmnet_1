package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends TestBase  {
    org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UsersPage.class);
    @FindBy(xpath = "//div[contains(text(),'Users')]")
    WebElement usersText;
    @FindBy(xpath = "//div[contains(text(),'New User')]")
    WebElement newUserButton;
    @FindBy(xpath = "//div[contains(@class,'create_user_sliding_panel sliding_panel components_panelContainer')]")
    WebElement newUserSidePannel;
    @FindBy(xpath = "//div[contains(text(),'Add User')]")
    WebElement addUserText;
    @FindBy(xpath = "//input[@placeholder='First Name' and @id='createUserPanel_firstNameField']")
    WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='MI' and @id='createUserPanel_middleNameField']")
    WebElement middlename;
    @FindBy(xpath = "//input[@placeholder='Last Name' and @id='createUserPanel_lastNameField']")
    WebElement lastname;
    @FindBy(xpath = "//input[@placeholder='Email' and @id='createUserPanel_emailField']")
    WebElement email;
    @FindBy(xpath = "//div[contains(text(),'Save & Send Invitation')]")
    WebElement saveButton;
    @FindBy(xpath = "//tbody/tr[1]/td[1][@class='userNameCell first']")
    WebElement addedUser;
    @FindBy(xpath = "//div[@class='createUserPanel_accountCreatedContainer']/div[@class='closeLink']/span[contains(text(),'Close')]")
    WebElement closeButton;

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateUsersText() {
        return usersText.isDisplayed();
    }

    public boolean clickNewUserButton() {
        newUserButton.click();
        String cssValue = newUserSidePannel.getCssValue("display");
        return cssValue.contains("block") && addUserText.isDisplayed();
    }

    public String fillTheForm(String fname, String lname, String mname, String mail) {
        clickNewUserButton();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        WebDriverWait wait = new WebDriverWait(driver, TestUtil.PAGE_LOAD_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name' and @id='createUserPanel_firstNameField']")));
        firstname.sendKeys(fname);
        log.info(firstname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='MI' and @id='createUserPanel_middleNameField']")));
        middlename.sendKeys(mname);
        log.info(middlename);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name' and @id='createUserPanel_lastNameField']")));
        lastname.sendKeys(lname);
        log.info(lastname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email' and @id='createUserPanel_emailField']")));
        email.sendKeys(mail);
        log.info(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Save & Send Invitation')]")));
        saveButton.click();
        log.info(saveButton);
        closeButton.click();
        String bgColor=addedUser.getCssValue("background-color");
        return bgColor;
    }
//    public String validateUserAddition(){
//        String bgColor=addedUser.getCssValue("background-color");
//        return bgColor;
//    }
}
