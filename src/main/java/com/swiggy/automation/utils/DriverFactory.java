package com.swiggy.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import com.swiggy.automation.constants.FrameworkConstants;
import java.util.*;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        if (getDriver() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
            if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
                options.addArguments("--headless");
            }

            WebDriver localDriver = new ChromeDriver(options);
            localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
            localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.set(localDriver);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
