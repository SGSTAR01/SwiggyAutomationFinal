package com.swiggy.automation.pages;

import com.swiggy.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LandingPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // Dummy Locators - UPDATE THESE
    @FindBy(xpath = "//input[@id='location']") // Placeholder
    private WebElement locationInput;

    @FindBy(xpath = "//button[@id='find-restaurants']") // Placeholder
    private WebElement findFoodButton;

    @FindBy(xpath = "//div[@class='suggestions']") // Placeholder
    private WebElement firstSuggestion;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterLocation(String location) {
        waitUtils.waitForVisibility(locationInput).sendKeys(location);
        // data-testid="address-pl-input"
        // Logic to select from dropdown could go here
    }

    public void selectFirstSuggestion() {
        waitUtils.waitForClickability(firstSuggestion).click();
    }

    public void clickFindFood() {
        waitUtils.waitForClickability(findFoodButton).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
