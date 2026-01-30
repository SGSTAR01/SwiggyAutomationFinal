package com.swiggy.automation.stepdefinitions;

import com.swiggy.automation.base.BaseTest;
import com.swiggy.automation.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LocationSteps extends BaseTest {

    private final LandingPage landingPage = new LandingPage(getDriver());

    @Given("I am on the Swiggy landing page")
    public void i_am_on_the_swiggy_landing_page() {
        getDriver().get("https://www.swiggy.com");
    }

    @When("I enter the location {string}")
    public void i_enter_the_location(String location) {
        landingPage.enterLocation(location);
    }

    @When("I select the first suggestion")
    public void i_select_the_first_suggestion() {
        landingPage.selectFirstSuggestion();
    }

    @Then("I should be redirected to the restaurant listing page")
    public void i_should_be_redirected_to_the_restaurant_listing_page() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("swiggy"), "URL did not match expected");
    }
}
