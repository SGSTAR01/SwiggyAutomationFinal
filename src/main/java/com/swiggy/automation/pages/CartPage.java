package com.swiggy.automation.pages;

import com.swiggy.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // Dummy Locators - UPDATE THESE
    @FindBy(xpath = "//div[@class='cart-subtotal']") // Placeholder
    private WebElement subtotalText;

    @FindBy(xpath = "//button[text()='Checkout']") // Placeholder
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getSubtotal() {
        return waitUtils.waitForVisibility(subtotalText).getText();
    }

    public boolean isCheckoutButtonDisplayed() {
        return checkoutButton.isDisplayed();
    }
}
