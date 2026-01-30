package com.swiggy.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class WaitUtils {

    private static final Logger LOGGER = LogManager.getLogger(WaitUtils.class);
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver, Duration timeout) {
        this.wait = new WebDriverWait(driver, timeout);
    }

    // Convenience constructor that uses explicit.wait from config
    public WaitUtils(WebDriver driver) {
        int seconds = ConfigReader.getIntProperty("explicit.wait", 10);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitForVisibility(WebElement element) {
        LOGGER.debug("Waiting for visibility of element: {}", element);
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        LOGGER.debug("Element visible: {}", element);
        return el;
    }

    public WebElement waitForClickability(WebElement element) {
        LOGGER.debug("Waiting for element to be clickable: {}", element);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        LOGGER.debug("Element is clickable: {}", element);
        return el;
    }

    public WebElement waitForPresence(By locator) {
        LOGGER.debug("Waiting for presence of locator: {}", locator);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        LOGGER.debug("Element present for locator: {}", locator);
        return el;
    }

    public Boolean waitForTextMatched(By locator, String pattern) {
        LOGGER.info("Waiting for text matching pattern '{}' on locator: {}", pattern, locator);
        Boolean result = wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(pattern)));
        LOGGER.info("Text matched pattern '{}' for locator: {} -> {}", pattern, locator, result);
        return result;
    }

    public void waitForUrlToContain(String fraction) {
        LOGGER.debug("Waiting for URL to contain: {}", fraction);
        wait.until(ExpectedConditions.urlContains(fraction));
        LOGGER.debug("URL now contains: {}", fraction);
    }
}
