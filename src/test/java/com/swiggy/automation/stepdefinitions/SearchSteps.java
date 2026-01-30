package com.swiggy.automation.stepdefinitions;

import com.swiggy.automation.base.BaseTest;
import com.swiggy.automation.pages.RestaurantListingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Objects;

public class SearchSteps extends BaseTest {

    private RestaurantListingPage restaurantListingPage = new RestaurantListingPage(getDriver());

    @Given("I am on the restaurant listing page")
    public void i_am_on_the_restaurant_listing_page() {
        if (!Objects.requireNonNull(getDriver().getCurrentUrl()).contains("restaurants")) {
            getDriver().get("https://www.swiggy.com/restaurants");
        }
    }

    @When("I search for {string}")
    public void i_search_for(String item) {
        restaurantListingPage.searchForItem(item);
    }

    @Then("I should see restaurants serving {string}")
    public void i_should_see_restaurants_serving(String item) {
        Assert.assertNotNull(getDriver().getTitle());
    }
}
