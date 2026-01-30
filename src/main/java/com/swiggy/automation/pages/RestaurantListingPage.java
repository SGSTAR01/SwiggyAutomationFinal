package com.swiggy.automation.pages;

import com.swiggy.automation.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RestaurantListingPage {

    private static final Logger LOGGER = LogManager.getLogger(RestaurantListingPage.class);
    private WebDriver driver;
    private WaitUtils waitUtils;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search for restaurants and food']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[text()='Veg']")
    private WebElement vegFilterToggle;

    @FindBy(xpath = "//div[text()='More Details'][1]")
    private WebElement firstRestaurant;

    @FindBy(xpath = "//div[@role='dialog']//div[text()='']")
    private WebElement firstAddItemButton;

    public RestaurantListingPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String item) {
        LOGGER.info("Searching for item: {}", item);
        waitUtils.waitForClickability(searchButton).click();
        waitUtils.waitForVisibility(searchInput).sendKeys(item, Keys.ENTER);
    }

    public void applyVegFilter() {
        LOGGER.info("Applying veg filter");
        waitUtils.waitForClickability(vegFilterToggle).click();
    }

    public boolean isFilterApplied() {
        // Logic to verify filter state
        return vegFilterToggle.isEnabled();
    }

    public void addFirstItemToCart() {
        LOGGER.info("Adding first restaurant's first item to cart");
        waitUtils.waitForClickability(firstRestaurant).click();
        waitUtils.waitForClickability(firstAddItemButton).click();
        LOGGER.info("Add to cart click performed");
    }
}
