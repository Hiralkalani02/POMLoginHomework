package com.nopCommerce.demo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }


    public void doClick(By locator) {
        getElement(locator).click();
    }


}
