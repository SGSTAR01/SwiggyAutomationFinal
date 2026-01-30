package com.swiggy.automation.stepdefinitions;

import com.swiggy.automation.base.BaseTest;
import com.swiggy.automation.pages.RestaurantListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FilterSteps extends BaseTest {

    private RestaurantListingPage restaurantListingPage = new RestaurantListingPage(getDriver());

    @When("I apply the {string} filter")
    public void i_apply_the_filter(String filterName) {
        if (filterName.equalsIgnoreCase("Veg Only")) {
            restaurantListingPage.applyVegFilter();
        }
    }

    @Then("the {string} filter should be active")
    public void the_filter_should_be_active(String filterName) {
        if (filterName.equalsIgnoreCase("Veg Only")) {
            Assert.assertTrue(restaurantListingPage.isFilterApplied());
        }
    }
}
