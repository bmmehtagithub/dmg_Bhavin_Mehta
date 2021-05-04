package com.mailtravel.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverHelpers {
    public static WebDriver driver;
    public String browserToExecute="chrome";


    //public String browserToExecute="chrome";

    public void closeBrowser() {
        driver.quit();
        driver=null;
    }


    public void openBrowser() {
        switch (browserToExecute) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    public void maximiseBrowser() {
        driver.manage().window().maximize();
    }

    public void applyImpWaits() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }
    public void navigateToUrl() {
        driver.get("https://www.mailtravel.co.uk/");
    }
}

