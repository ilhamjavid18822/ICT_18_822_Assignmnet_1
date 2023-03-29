package com.ilhamjavid18822.assignment.pages;

import com.ilhamjavid18822.assignment.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase {
    @FindBy(xpath = "//tr/td[contains(text(),'Reports Dashboard')]")
    WebElement reportPageDashboardText;
    public ReportsPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean validateReportPageDashboardText(){
        return reportPageDashboardText.isDisplayed();
    }

}
