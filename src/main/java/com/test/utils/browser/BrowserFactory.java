package com.test.utils.browser;

import com.test.utils.parameters.ParameterHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;


public class BrowserFactory {
    private static String browserName;

    public static BrowserDriver create() {
        ParameterHelpers paramHelper = new ParameterHelpers();
        browserName = paramHelper.getRunParameter("browser.name");
        WebDriver driver = getDriverObject();
        if (driver == null) {
            throw new IllegalArgumentException("Unsupported webdriver: " + browserName );
        }
        return new BrowserDriver(driver);
    }

    private static WebDriver getDriverObject() {
        WebDriver driver = null;

        switch (browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver","lib/driver/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "lib/driver/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "lib/driver/chromedriver");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                ChromeOptions option = new ChromeOptions();
                option.addArguments("disable-infobars");
                option.addArguments("no-sandbox");
                option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                capabilities.setCapability(ChromeOptions.CAPABILITY, option);
                driver = new ChromeDriver(capabilities);
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        return driver;
    }


}
