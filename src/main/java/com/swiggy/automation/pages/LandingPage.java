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


    @FindBy(xpath = "//input[@id='location']")
    private WebElement locationInput;


    @FindBy(xpath = "//div[@role='button' and @tabindex='2']")
    private WebElement firstSuggestion;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterLocation(String location) {

        waitUtils.waitForVisibility(locationInput).clear();
        System.out.println(locationInput.getText());
        waitUtils.waitForVisibility(locationInput).sendKeys(location);
        // data-testid="address-pl-input"
        // Logic to select from dropdown could go here
    }

    public void selectFirstSuggestion() {
        waitUtils.waitForClickability(firstSuggestion).click();
    }

}
