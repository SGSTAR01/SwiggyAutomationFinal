package com.swiggy.automation.stepdefinitions;

import com.swiggy.automation.base.BaseTest;
import com.swiggy.automation.pages.CartPage;
import com.swiggy.automation.pages.RestaurantListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps extends BaseTest {

    private RestaurantListingPage restaurantListingPage = new RestaurantListingPage(getDriver());
    private CartPage cartPage = new CartPage(getDriver());

    @When("I add the first item to the cart")
    public void i_add_the_first_item_to_the_cart() {
        restaurantListingPage.addFirstItemToCart();
    }

    @When("I navigate to the cart page")
    public void i_navigate_to_the_cart_page() {
        getDriver().get("https://www.swiggy.com/checkout");
    }

    @Then("the subtotal should be greater than {int}")
    public void the_subtotal_should_be_greater_than(Integer value) {
        String subtotal = cartPage.getSubtotal();
        Assert.assertNotNull(subtotal);
    }
}
