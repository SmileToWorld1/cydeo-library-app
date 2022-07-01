package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.HomePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.UsersPage;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UsersModule_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    UsersPage usersPage = new UsersPage();

    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        loginPage.login("librarian1@library","qU9mrvur");
    }
    @Given("user click on {string} button")
    public void user_click_on_link(String buttonName) {
        homePage.clickNavigationBarsButtons(buttonName);
    }
    @When("user should see below headers")
    public void user_should_see_below_headers(List<String> columnsNames) {
       List<WebElement> headers = usersPage.headers;
        List<String> actualColumnNames = new ArrayList<>();
        for (WebElement element : headers) {
            actualColumnNames.add(element.getText());
        }
        Assert.assertTrue(columnsNames.equals(actualColumnNames));
    }



}
