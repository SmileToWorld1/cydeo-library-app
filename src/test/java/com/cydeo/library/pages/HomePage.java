package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement accountHolder;

    @FindBy(partialLinkText = "Log Out")
    public WebElement logout;

    @FindBy(id = "user_count")
    public WebElement usersCount;

    @FindBy(xpath = "//h2[@id='user_count']/following-sibling::h6")
    public WebElement usersText;

    @FindBy(id = "book_count")
    public WebElement booksCount;

    @FindBy(xpath = "//h2[@id='book_count']/following-sibling::h6")
    public WebElement booksText;

    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksCount;

    @FindBy(xpath = "//h2[@id='borrowed_books']/following-sibling::h6")
    public WebElement borrowedBooksText;

    public void clickNavigationBarsButtons(String buttonName){
        Driver.getDriver().findElement(By.xpath("//a[@href='#"+buttonName.toLowerCase()+"']")).click();
    }


}
