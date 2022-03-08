package com.rozkland.stepDefs;

import com.rozkland.pages.HomePage;
import com.rozkland.utilities.Driver;
import com.rozkland.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FailStepDef {

	private HomePage homePage = new HomePage();
	private String appTime;

	@When("The user check the {string} section")
	public void the_user_check_the_section(String string) {
		appTime = homePage.getTimeFromApp();
	}

	@Then("The time is displayed in {string} time zone")
	public void the_Time_Is_Displayed_In_Time_Zone(String timeZone) {
		Assert.assertEquals(Utils.getLocalTimeHHmm(timeZone), appTime);
	}


	@When("The user tries to select a previous date")
	public void the_user_tries_to_select_a_previous_date() {
		homePage.clickPreviousDate();
		homePage.clickPreviousDate();
		homePage.clickPreviousDate();
	}

	@Then("The user is not allowed to select a previous date")
	public void the_user_is_not_allowed_to_select_a_previous_date() {
		Assert.assertEquals(Utils.getLocalDateddMMyy(),homePage.getDateFromApp());
	}

	@And("The user goes back to previous page")
	public void the_user_goes_back_to_previous_page() {
		Utils.waitForURLContains("queryPage",4);
		Driver.getDriver().navigate().back();
	}

	@When("The user click on the FROM field")
	public void the_user_click_on_the_FROM_field() {
		homePage.clickFromfield();
	}

	@Then("THe user should see {string} in English")
	public void the_user_should_see_in_English(String recentlySearched) {
		Assert.assertEquals(recentlySearched,homePage.getTextRecentlySearched());
	}



}
