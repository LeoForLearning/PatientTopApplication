package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.*;
import pageObjects.ScorePage;

public class StepDefinition {

	FinalPage finalpage = new FinalPage();
	HomePage homepage = new HomePage();
	ScorePage scorepage = new ScorePage();

	@Given("I launch browser {string}")
	public void i_launch_browser(String browser) {
		homepage.startApplication(browser);
	}

	@Given("I navigate to patienttop checkup application")
	public void i_navigate_to_patienttop_checkup_application() {
		homepage.enterUrl();
	}

	@When("I Enter {string} in the practise name text box")
	public void i_Enter_in_the_practise_name_text_box(String name) {
		try {
			homepage.enterPractiseName(name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("I validate {string} is displayed in drop down and user is able to select it.")
	public void i_validate_is_displayed_in_drop_down_and_user_is_able_to_select_it(String string) {

		try {
			homepage.selectPractiseName(string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		;

	}

	@Then("I validate all Address and Website details are autopopulated")
	public void i_validate_all_Address_and_Website_details_are_autopopulated() {
		homepage.validateAddressField();
	}

	@Then("I select {string} in the speciality section")
	public void i_select_in_the_speciality_section(String string) {
		try {
			homepage.enterSpecialityDropdown(string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("I Click on {string}")
	public void i_Click_on(String string) {
		try {
			homepage.clickButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("I Get scores for competitors , Google Ranking, Web Presence , Website and Reputation")
	public void i_Get_scores_for_competitors_Google_Ranking_Web_Presence_Website_and_Reputation() {
		try {
			scorepage.validateScore();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("I validate the same scores are displayed in Summary page for Google Ranking, Web Presence , Website and Reputation")
	public void i_validate_the_same_scores_are_displayed_in_Summary_page_for_Google_Ranking_Web_Presence_Website_and_Reputation() {
		try {
			finalpage.compareScore();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
