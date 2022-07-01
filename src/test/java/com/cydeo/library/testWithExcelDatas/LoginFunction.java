package com.cydeo.library.testWithExcelDatas;

import com.cydeo.library.pages.HomePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginFunction {
    @Before
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url"));
    }
    @After
    public void teardown(){
        Driver.closeDriver();
    }

    @Test
    public void loginCredentials() throws IOException {

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        String filePath = "CydeoLibraryApp.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("library2");

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            loginPage.login(sheet.getRow(i).getCell(1).toString(),sheet.getRow(i).getCell(2).toString());
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
            wait.until(ExpectedConditions.visibilityOf(homePage.accountHolder));
            Assert.assertTrue(Driver.getDriver().getTitle().equals("Library"));
            homePage.accountHolder.click();
            homePage.logout.click();
        }

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            loginPage.login(sheet.getRow(i).getCell(6).toString(),sheet.getRow(i).getCell(7).toString());
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
            wait.until(ExpectedConditions.visibilityOf(homePage.accountHolder));
            Assert.assertTrue(Driver.getDriver().getTitle().equals("Library"));
            homePage.accountHolder.click();
            homePage.logout.click();
        }
    }

}
