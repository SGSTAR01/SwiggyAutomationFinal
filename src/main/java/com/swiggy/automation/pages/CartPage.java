package com.swiggy.automation.pages;

import com.swiggy.automation.utils.ConfigReader;
import com.swiggy.automation.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class CartPage {

    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);
    private WebDriver driver;
    private WaitUtils waitUtils;

    @FindBy(xpath = "//div[text()='TO PAY']/following-sibling::div")
    private WebElement subtotalText;

    @FindBy(xpath = "//a[@href='/checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@href='/checkout']//span")
    private By cartCounter;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        int timeout = ConfigReader.getIntProperty("cart.wait.timeout", 10);
        this.waitUtils = new WaitUtils(driver, Duration.ofSeconds(timeout));
        PageFactory.initElements(driver, this);
    }

    public void navigateToCart() {
        int maxRetries = ConfigReader.getIntProperty("cart.retry.count", 3);
        LOGGER.info("Navigating to cart: will attempt to wait for cart counter up to {} times", maxRetries);


        try {
            LOGGER.debug("Attempt to wait for cart counter");
            waitUtils.waitForTextMatched(cartCounter, "\\d+");
            LOGGER.info("Cart counter matched on attempt ");
        } catch (TimeoutException te) {
            LOGGER.warn("Attempt: cart counter not populated, will refresh ");
            driver.navigate().refresh();
            LOGGER.info("Clicking checkout button to open cart page");
            waitUtils.waitForClickability(checkoutButton).click();

        }
        LOGGER.info("Waiting for subtotal to be visible on cart page");
        waitUtils.waitForVisibility(subtotalText);
        LOGGER.info("Cart subtotal is visible");
    }

    public String getSubtotal() {
        LOGGER.info("Reading subtotal from cart page");
        String value = waitUtils.waitForVisibility(subtotalText).getText();
        LOGGER.info("Subtotal read: {}", value);
        return value;
    }
}

