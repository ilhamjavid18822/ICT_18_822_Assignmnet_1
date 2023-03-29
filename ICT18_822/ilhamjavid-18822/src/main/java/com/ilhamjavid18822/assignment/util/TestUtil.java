package com.ilhamjavid18822.assignment.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.ict18801.assignment.base.TestBase.driver;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
    public static String TESTDATA_EXCELSHEET_PATH = "E:\\STUDY MATERIAL SEM 8\\Emerging Technology\\Assignments\\1\\ICT-18-801\\src\\main\\java\\com\\ict18801\\assignment\\data\\TestData.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    /**
     * This function is used to read test data from Excel sheet and store them in a 2D object array
     **/
    public static Object[][] getTestData(String sheetName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(TESTDATA_EXCELSHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

            }
        }
        return data;
    }

    /**
     * this function used to capture screenshots when a test gets failed
     **/
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        File destFile = new File(currentDir + "\\screenshot\\" + System.currentTimeMillis() + ".png");
        FileHandler.copy(scrFile, destFile);
    }
}


