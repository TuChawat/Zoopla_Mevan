package com.bridgelabz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class Print_Properties {
    public static LinkedList<String> properties = new LinkedList<>();

    @FindBy(xpath = "//a[@data-testid = 'listing-details-link']")
    List<WebElement> Name;

    @FindBy(xpath = "//div[@class = 'css-1e28vvi-PriceContainer e2uk8e8']")
    List<WebElement> Price;


    public Print_Properties(WebDriver driver) { PageFactory.initElements(driver, this);
    }

    public void printListOfProperties() {
            Iterator<WebElement> titleIterator = Name.iterator();
            while (titleIterator.hasNext()) {
                String news = titleIterator.next().getText();
                properties.add(news);
            }
            properties.forEach(element ->{
                System.out.println(element);
                System.out.println(" ");
            });
            Name.get(4).click();
    }
}
