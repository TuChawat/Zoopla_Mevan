/**
 * Description : Zoopla.java is test file which is having test cases for Zoopla.
 * Author      : Tushar Chawat
 * Date        : 10/06/2021
 */

package com.bridgelabz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_City {
    @FindBy(xpath = "//a[@data-testid = 'header-logo'] ")
    WebElement Home;

    @FindBy(xpath = "//input[@id = 'header-location']")
    WebElement Loaction;

    @FindBy(xpath = "//button[text() = 'Search']")
    WebElement Search;

    @FindBy(xpath = "//select[@id = 'sort-order-dropdown']")
    WebElement Sort;

    @FindBy(xpath = "//option[text() = 'Lowest price']")
    WebElement price;

    public Search_City(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchItem() throws InterruptedException {
        Home.click();
        Loaction.sendKeys("London");
        Search.click();
        Sort.click();
        price.click();
        Thread.sleep(2000);
    }
}
