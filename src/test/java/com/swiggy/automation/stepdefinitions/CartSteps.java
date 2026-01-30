package com.swiggy.automation.stepdefinitions;

import com.swiggy.automation.base.BaseTest;
import com.swiggy.automation.pages.CartPage;
import com.swiggy.automation.pages.RestaurantListingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CartSteps extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(CartSteps.class);
    private final RestaurantListingPage restaurantListingPage = new RestaurantListingPage(getDriver());
    private final CartPage cartPage = new CartPage(getDriver());

    @When("I add the first item to the cart")
    public void i_add_the_first_item_to_the_cart() {
        LOGGER.info("Step: add the first item to the cart");
        restaurantListingPage.addFirstItemToCart();
    }

    @And("I navigate to the cart page")
    public void i_navigate_to_the_cart_page() {
        LOGGER.info("Step: navigate to cart page");
        cartPage.navigateToCart();
    }

    @Then("the subtotal should be greater than {int}")
    public void the_subtotal_should_be_greater_than(Integer value) {
        LOGGER.info("Step: verify subtotal is greater than {}", value);
        String subtotal = cartPage.getSubtotal();
        LOGGER.info("Subtotal obtained: {}", subtotal);
        Assert.assertNotNull(subtotal, "Subtotal should not be null");

        // Normalize subtotal string to a numeric value. Remove currency symbols and commas.
        String normalized = subtotal.replaceAll("[^0-9.]", "");
        double subtotalValue = 0.0;
        try {
            if (!normalized.isEmpty()) {
                subtotalValue = Double.parseDouble(normalized);
            }
        } catch (NumberFormatException nfe) {
            LOGGER.error("Unable to parse subtotal to a number: '{}'", subtotal, nfe);
            Assert.fail("Unable to parse subtotal to a number: '" + subtotal + "'");
        }

        Assert.assertTrue(subtotalValue > value, "Expected subtotal (" + subtotalValue + ") to be greater than " + value);
    }
}
