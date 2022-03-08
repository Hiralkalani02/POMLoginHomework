package com.nopCommerce.demo.test;

import com.nopCommerce.demo.base.BaseClass;
import com.nopCommerce.demo.pages.LoginClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest {
    BaseClass baseClass;
    Properties prop;
    WebDriver driver;
    LoginClass loginClass;

@BeforeTest
    public void openBrowser() {
        baseClass = new BaseClass();
        prop = baseClass.initialiseProperties();
        String browser = prop.getProperty("Browser");
        driver = baseClass.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        loginClass = new LoginClass(driver);

    }
    @Test
    public void clickLoginButton(){
       loginClass.doLogin(prop.getProperty("Username"), prop.getProperty("Password"));

    }
}
