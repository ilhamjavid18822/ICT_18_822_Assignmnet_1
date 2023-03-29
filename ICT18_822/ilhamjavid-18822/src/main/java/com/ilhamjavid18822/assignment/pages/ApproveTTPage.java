package com.ilhamjavid18822.assignment.pages;

import com.ilhamjavid18822.assignment.base.TestBase;
import com.ilhamjavid18822.assignment.util.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ApproveTTPage extends TestBase {
    @FindBy(xpath = "//div[@id='selectAllButton']")
    WebElement selectAllButton;
    @FindBy(xpath = "//table/tbody[2]/tr[2]/td/input[@type='checkbox']")
    WebElement selectCheckBox;
    @FindBy(xpath = "//div/span[@id='approveButton']")
    WebElement approveButton;
    @FindBy(xpath = "//div/span[@id='rejectButton']")
    WebElement rejectButton;
    @FindBy(xpath = "//tbody[2]/tr[2]/td[2]/span[1][contains(text(),'Approved')]")
    WebElement approvalText;
    @FindBy(xpath = "//tbody[2]/tr[2]/td[2]/span[1][contains(text(),'Reject')]")
    WebElement rejectText;
    @FindBy(xpath = "//textarea[@id='rejectWeekCommentTextArea']")
    WebElement rejectReasonText;
    @FindBy(xpath = "//button/span[contains(text(),'Reject')]")
    WebElement rejectReasonButton;

    public ApproveTTPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateTitle() {
        return driver.getTitle();
    }

    public boolean acceptTt() {
        selectCheckBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        approveButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        return approvalText.isDisplayed();
    }

    public boolean rejectTt() {
        selectCheckBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        rejectButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        rejectReasonText.sendKeys("Rejected by Testing");
        rejectReasonButton.click();
        return rejectText.isDisplayed();
    }

    public boolean acceptAlltt() {
        selectAllButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        approveButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        return approvalText.isDisplayed();
    }

    public boolean rejectAlltt() {
        selectAllButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        rejectButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        return rejectText.isDisplayed();
    }

}
