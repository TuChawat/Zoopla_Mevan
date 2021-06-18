/**
 * Description : Zoopla.java is test file which is having test cases for Zoopla.
 * Author      : Tushar Chawat
 * Date        : 10/06/2021
 */

package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.utility.Library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bridgelabz.selenium.utility.IConstant.CONFIG_PATH;

public class Login_Zoopla {
    @FindBy(xpath = "//button[text() = 'Accept all cookies' and @class = 'ui-button-primary ui-cookie-accept-all-medium-large']")
    WebElement Cookies;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/header/div/div/div[1]/div/ul/li[5]/a")
    WebElement Signin;

    @FindBy(xpath = "//*[@id=\"input-email-address\"]")
    WebElement Email;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    WebElement Pass;
    
    @FindBy(xpath = "//button[text() = 'Sign in']")
    WebElement Button;

    @FindBy(xpath = "//a[text() = 'My Zoopla']")
    WebElement Assert;

    public Login_Zoopla(WebDriver driver) { PageFactory.initElements(Base.driver, this);
    }

    public void loggedin() throws InterruptedException {
        Cookies.click();
        Signin.click();
        String user = Library.getProperty(CONFIG_PATH, "user");
        Email.sendKeys(user);
        String pass = Library.getProperty(CONFIG_PATH, "pass");
        Pass.sendKeys(pass);
        Button.click();
        Thread.sleep(2000);
        String Account = Assert.getText();
    }
}
