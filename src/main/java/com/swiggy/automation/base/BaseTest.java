package com.swiggy.automation.base;

import com.swiggy.automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
