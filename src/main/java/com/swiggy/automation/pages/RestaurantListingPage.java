package com.swiggy.automation.pages;

import com.swiggy.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RestaurantListingPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // Dummy Locators - UPDATE THESE
    @FindBy(xpath = "//input[@placeholder='Search for restaurants and food']") // Placeholder
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='filter-veg']") // Placeholder
    private WebElement vegFilterToggle;

    @FindBy(xpath = "//div[@class='restaurant-item']") // Placeholder
    private WebElement firstRestaurant;

    @FindBy(xpath = "//button[contains(text(), 'Add')]") // Placeholder
    private WebElement firstAddItemButton;

    public RestaurantListingPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String item) {
        waitUtils.waitForVisibility(searchInput).sendKeys(item);
        // Might need to press enter or click a search icon
    }

    public void applyVegFilter() {
        waitUtils.waitForClickability(vegFilterToggle).click();
    }

    public boolean isFilterApplied() {
        // Logic to verify filter state
        return vegFilterToggle.isEnabled();
    }

    public void addFirstItemToCart() {
        waitUtils.waitForClickability(firstAddItemButton).click();
    }
}
