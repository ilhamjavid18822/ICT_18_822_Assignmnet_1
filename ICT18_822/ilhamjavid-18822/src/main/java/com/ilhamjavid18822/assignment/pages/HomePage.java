package com.ilhamjavid18822.assignment.pages;

import com.ilhamjavid18822.assignment.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//a[contains(@class,'userProfileLink username ')]")
    WebElement username;
    @FindBy(xpath = "//a[contains(@class,'content tasks')]")
    WebElement tasks;
    @FindBy(xpath = "//a[contains(@class,'content reports')]")
    WebElement reports;
    @FindBy(xpath = "//div[contains(text(),'Users')]")
    WebElement users;
    @FindBy(xpath = "//a[contains(text(),'Approve Time-Track')]")
    WebElement ApproveTimeTrackButton;
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String validateTitle() {
        logger.info(driver.getTitle());
        return driver.getTitle();
    }

    public boolean VerifyUsername() {
        logger.info(username.isDisplayed());
        return username.isDisplayed();
    }

    public TasksPage ClickTasks() {
        tasks.click();
        return new TasksPage();
    }

    public ReportsPage ClickReports() {
        reports.click();
        return new ReportsPage();
    }

    public UsersPage ClickUsers() {
        users.click();
        return new UsersPage();
    }
    public ApproveTTPage ClickApproveTimeTrack(){
        ApproveTimeTrackButton.click();
        return new ApproveTTPage();
    }

}
