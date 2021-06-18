/**
 * Description : Zoopla.java is test file which is having test cases for Zoopla.
 * Author      : Tushar Chawat
 * Date        : 10/06/2021
 */

package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.utility.Library;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import static com.bridgelabz.selenium.utility.IConstant.CONFIG_PATH;

public class Base {
    public static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports report;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    @BeforeTest
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        tdriver.set(driver);
        String url = Library.getProperty(CONFIG_PATH, "url");
        driver.get(url);
        report = new ExtentReports("C:\\Users\\Admin\\Zoopla_Mevan\\Extent_Report.html");
        test = report.startTest("Extent_Report");
    }

    public static WebDriver getDriver() {
        return tdriver.get();
    }

    @AfterMethod
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }
}
