package com.nopCommerce.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;
    Properties prop;

    //resource folder has to be under test folder always. it's a mistake here in this program
    public WebDriver initialiseDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\goldenguitar\\IdeaProjects\\Login\\src\\test\\resources\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("edgedriver")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\goldenguitar\\IdeaProjects\\NovPOMFramework\\src\\main\\resources\\Browserdrivers\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();

        } else if (browserName.equals("gekodriver")) {
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\goldenguitar\\IdeaProjects\\NovPOMFramework\\src\\main\\resources\\Browserdrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        } else {
            System.out.println(browserName + "Browser name is invalid, please entre correct browser name");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));


        return driver;
    }

    public Properties initialiseProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\goldenguitar\\IdeaProjects\\Login\\src\\test\\resources\\TestData\\Config.properties.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Properties could not be loaded....");
            e.printStackTrace();
        }
        return prop;


    }
}



