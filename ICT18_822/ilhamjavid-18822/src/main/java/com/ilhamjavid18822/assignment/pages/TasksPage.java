package com.ilhamjavid18822.assignment.pages;

import com.ilhamjavid18822.assignment.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends TestBase {
    @FindBy(xpath = "//div[contains(text(),'All Customers')]")
    WebElement AllcustomersTitle;

    public TasksPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateAllcustomersTitle() {
        return AllcustomersTitle.isDisplayed();
    }
}
