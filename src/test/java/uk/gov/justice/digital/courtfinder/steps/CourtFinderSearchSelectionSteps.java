package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderSearchSelectionSteps {
	
	private WebDriver      driver;
	private JourneyFactory journeyFactory;
	
	public CourtFinderSearchSelectionSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}
	
	@Then("^I am redirected to the postcode search page$")
	public void i_am_redirected_to_the_postcode_search_page() throws Throwable {
	    assertTrue("Unable to reach the postcode search page",
	    		   PageFactory.getCourtFinderPostcodSearchPage(driver).verifyOnPage());
	                
	}


	@Then("^I am redirected to the name and address search page$")
	public void i_am_redirected_to_the_name_and_address_search_page() throws Throwable {
	    assertTrue("Unable to reach the name and address search page",
	    		   PageFactory.getCourtFinderAddressSearchPage(driver).verifyOnPage());    
	}


	@Then("^I am redirected to the list view page$")
	public void i_am_redirected_to_the_list_view_page() throws Throwable {
	    assertTrue("Unable to reach the list view page", 
	    		   PageFactory.getCourtFinderListViewPage(driver).verifyOnPage());
	}	
	

	@Then("^I am redirected to the courtfinder start page$")
	public void i_am_redirected_to_the_courtfinder_start_page() throws Throwable {
	    assertTrue("Unable to reach the courtfinder start page",
	    		  PageFactory.getCourtFinderStartPage(driver).verifyOnPage());
	}
	
	
	@Then("^I am redirected to the area of law selection page$")
	public void i_am_redirected_to_the_area_of_law_selection_page() throws Throwable {
	    assertTrue("Unable to reach the area of law selection page",PageFactory.getCourtFinderAreaOfLawSearchSelectionPage(driver).verifyOnPage());
	}


}
