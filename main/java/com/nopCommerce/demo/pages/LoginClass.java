package com.nopCommerce.demo.pages;

import com.nopCommerce.demo.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginClass {
    WebDriver driver;
    Utils utils;

    By email = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.className("login-button");

    public LoginClass(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void doLogin(String username, String pwd) {
        utils.doSendKeys(email, username);
        utils.doSendKeys(password, pwd);
        utils.doClick(loginButton);


    }


}
