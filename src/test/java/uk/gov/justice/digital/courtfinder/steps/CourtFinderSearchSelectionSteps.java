package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderSearchSelectionSteps {
	
	private WebDriver      driver;
	private JourneyFactory journeyFactory;
	
	public CourtFinderSearchSelectionSteps(SharedDriver driver){
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}
	
	@Given("^I am on the court finder search selection page$")
	public void i_am_on_the_court_finder_search_selection_page() throws Throwable {
	    journeyFactory.getCourtFinderSearchSelecionPageJourney();
	    assertTrue("Unable to reach the courtfinder search selection page",
	    		   PageFactory.getCourtfinderSearchSelectionPage(driver).verifyOnPage());
	}

	@When("^I select the postcode search and click continue$")
	public void i_select_the_postcode_search_and_click_continue() throws Throwable {
	    CourtfinderSearchSelectionPage page = PageFactory.getCourtfinderSearchSelectionPage(driver);
	    page.clickPostcodeSearch();
	}

	@Then("^I am redirected to the postcode search page$")
	public void i_am_redirected_to_the_postcode_search_page() throws Throwable {
	    assertTrue("Unable to reach the postcode search page",
	    		   PageFactory.getCourtfinderPostcodSearchPage(driver).verifyOnPage());
	                
	}

	@When("^I select the name and address search and click continue$")
	public void i_select_the_name_and_address_search_and_click_continue() throws Throwable {
	    CourtfinderSearchSelectionPage page = PageFactory.getCourtfinderSearchSelectionPage(driver);
	    page.clickaddressSearch();
	}

	@Then("^I am redirected to the name and address search page$")
	public void i_am_redirected_to_the_name_and_address_search_page() throws Throwable {
	    assertTrue("Unable to reach the name and address search page",
	    		   PageFactory.getCourtFinderAddressSearchPage(driver).verifyOnPage());    
	}

	@When("^I select the list view  search and click continue$")
	public void i_select_the_list_view_search_and_click_continue() throws Throwable {
	    CourtfinderSearchSelectionPage page = PageFactory.getCourtfinderSearchSelectionPage(driver);
	    page.clickListView();
	}

	@Then("^I am redirected to the list view page$")
	public void i_am_redirected_to_the_list_view_page() throws Throwable {
	    assertTrue("Unable to reach the list view page", 
	    		   PageFactory.getCourtFinderListViewPage(driver).verifyOnPage());
	}	
	
	@When("^I select the home breadcrumb$")
	public void i_select_the_home_breadcrumb() throws Throwable {
	    PageFactory.getCourtfinderSearchSelectionPage(driver).clickHomeBreadcrumb();
	}

	@Then("^I am redirected to the courtfinder start page$")
	public void i_am_redirected_to_the_courtfinder_start_page() throws Throwable {
	    assertTrue("Unable to reach the courtfinder start page",
	    		  PageFactory.getCourtFinderStartPage(driver).verifyOnPage());
	}
	
	@Then("^the name and address search is selected by default$")
	public void the_name_and_address_search_is_selected_by_default() throws Throwable {
	    assertTrue("The Name and Address is not selected as default",
	    		  PageFactory.getCourtfinderSearchSelectionPage(driver).verifyDefaultPageSettings() 
	    		  );
	}
	
	@Then("^I am redirected to the area of law selection page$")
	public void i_am_redirected_to_the_area_of_law_selection_page() throws Throwable {
	    assertTrue("Unable to reach the area of law selection page",PageFactory.getCourtFinderAreaOfLawSelectionPage(driver).verifyOnPage());
	}


}
