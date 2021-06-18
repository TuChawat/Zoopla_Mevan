/**
 * Description : Zoopla.java is test file which is having test cases for Zoopla.
 * Author      : Tushar Chawat
 * Date        : 10/06/2021
 */

package com.bridgelabz.selenium;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.listner.TestNGListner;
import com.bridgelabz.selenium.pages.Login_Zoopla;
import com.bridgelabz.selenium.pages.Print_Properties;
import com.bridgelabz.selenium.pages.Search_City;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.bridgelabz.selenium.utility.Screenshot.capture;

@Listeners(TestNGListner.class)
public class ZooplaTest extends Base {
    public Login_Zoopla login;
    public Search_City Search;
    public Print_Properties Print;

    @Test(priority = 0)
    public void loginZoopla() throws InterruptedException, IOException {
        login = new Login_Zoopla(driver);
        login.loggedin();
        String Account = driver.findElement(By.xpath("//a[text() = 'My Zoopla']")).getText();
        Assert.assertEquals("My Zoopla", Account);
        if (Account.equals("My Zoopla")){
            test.log(LogStatus.PASS, "Navigated to My account");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Login Test Failed");
        }
    }

    @Test(priority = 1)
    public void searchCity() throws InterruptedException, IOException {
        Search = new Search_City(driver);
        Search.searchItem();
        String Location = driver.findElement(By.xpath("//span[text() = 'London property for sale']")).getText();
        Assert.assertEquals("London property for sale", Location);
        if (Location.equals("London property for sale")){
            test.log(LogStatus.PASS, "Navigated to properties at London");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "search Test Passed");
        }else {
            test.log(LogStatus.FAIL, "Test Failed");
            test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "search Test Failed");
        }
    }

    @Test(priority = 2)
    public void printProperties() {
        Print = new Print_Properties(driver);
        Print.printListOfProperties();
    }
}
