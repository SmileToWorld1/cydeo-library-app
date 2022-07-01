package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.HomePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.app.url"));
    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.emailInputBox.sendKeys("librarian1@library");

    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.passwordInputBox.sendKeys("qU9mrvur");
        loginPage.signInButton.click();
    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.emailInputBox.sendKeys("student1@library");
    }
    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.passwordInputBox.sendKeys("d5fv9BtX");
        loginPage.signInButton.click();
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.titleIs("Library"));
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Library"));
    }

    @When("user enters librarian {string}")
    public void user_enters_librarian(String str) {
        if(str.contains("@library")){
            loginPage.emailInputBox.sendKeys(str);
        }else {
            loginPage.passwordInputBox.sendKeys(str);
            loginPage.signInButton.click();
        }

    }

    @When("user enters student {string}")
    public void user_enters_student(String str) {
        if(str.contains("@library")){
            loginPage.emailInputBox.sendKeys(str);
        }else {
            loginPage.passwordInputBox.sendKeys(str);
            loginPage.signInButton.click();
        }
    }

    @When("user enters librarian username {string} and user enters librarian password {string}")
    public void user_enters_librarian_username_and_user_enters_librarian_password(String email, String password) {
        loginPage.login(email,password);
    }
    @Then("there should be {int} {string}")
    public void there_should_be(Integer int1, String string) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        if (string.equalsIgnoreCase("users")){
            wait.until(ExpectedConditions.urlToBe("https://library2.cydeo.com/#dashboard"));
            Assert.assertTrue(homePage.usersCount.getText().equals(""+int1));
        }else if (string.equalsIgnoreCase("books")){
            wait.until(ExpectedConditions.urlToBe("https://library2.cydeo.com/#dashboard"));
            Assert.assertTrue(homePage.booksCount.getText().equals(""+int1));
        }else if (string.equalsIgnoreCase("borrowed books")){
            wait.until(ExpectedConditions.urlToBe("https://library2.cydeo.com/#dashboard"));
            Assert.assertTrue(homePage.borrowedBooksCount.getText().equals(""+int1));
        }
    }

    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String email, String password) {
        loginPage.login(email,password);

    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String accountHolder) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        if (accountHolder.toLowerCase().contains("student")){
            wait.until(ExpectedConditions.urlToBe("https://library2.cydeo.com/#books"));
        }else{
            wait.until(ExpectedConditions.urlToBe("https://library2.cydeo.com/#dashboard"));
        }

        Assert.assertEquals(accountHolder,homePage.accountHolder.getText());
    }



}
