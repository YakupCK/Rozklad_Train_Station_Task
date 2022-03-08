package com.rozkland.stepDefs;

import com.rozkland.pages.HomePage;
import com.rozkland.pages.ResultPage;
import com.rozkland.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class PassStepDef {

	private HomePage homePage = new HomePage();
	private ResultPage resultPage = new ResultPage();

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {
		homePage.goHomePage();
		homePage.closeInitialPopUp();
	}

	@When("The user select {string} as a departure")
	public void the_user_select_as_a_departure(String departure) {
		homePage.setDepartureFrom(departure);
	}

	@When("The user select {string} as a destination")
	public void the_user_select_as_a_destination(String destination) {
		homePage.setDestinationTo(destination);
	}

	@And("The user search for trains")
	public void the_User_Search_For_Trains() {
		homePage.clickSearchBtn();
	}

	@Then("The user can find available trains")
	public void the_user_can_find_available_trains() {
		resultPage.verifySearchTrains();
	}

	@When("The user does not select anything as a destination")
	public void the_user_does_not_select_anything_as_a_destination() {
		homePage.setDestinationTo("");
	}

	@Then("The user can not proceed")
	public void the_user_can_not_proceed() {
		Assert.assertEquals(ConfigReader.getProperty("url"),homePage.getURL());
	}

	@Then("A warning message should be displayed")
	public void a_warning_message_should_be_displayed() {
		homePage.verifyTooltip();
	}

	@When("The user does not select anything as a departure")
	public void the_user_does_not_select_anything_as_a_departure() {
		homePage.setDepartureFrom("");

	}

}
