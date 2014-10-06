package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderAddressSearchSteps {

	private WebDriver driver;
	private JourneyFactory journeyFactory;

	public CourtFinderAddressSearchSteps(SharedDriver driver) {
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
	
	@Given("^I am on the courtfinder address search page$")
	public void i_am_on_the_courtfinder_address_search_page() throws Throwable {
	    journeyFactory.getCourtFinderAddressSearchPageJourney();
	    assertTrue("Unable to reach the address search page",PageFactory.getCourtFinderAddressSearchPage(driver).verifyOnPage());
	}

	@When("^I enter a (?:partial court name|court name|building name|street name|town, city or county) \"(.*?)\" and search$")
	public void i_enter_a_court_name_and_search(String courtName) throws Throwable {
	    PageFactory.getCourtFinderAddressSearchPage(driver).setAddress(courtName);
	    PageFactory.getCourtFinderAddressSearchPage(driver).clickContinueButton();
	    PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyOnPage();
	}
	
	@When("^I enter a (?:invalid address|inactive court) \"(.*?)\" and search$")
	public void i_enter_a_court_name_and_search_(String courtName) throws Throwable {
	    PageFactory.getCourtFinderAddressSearchPage(driver).setAddress(courtName);
	    PageFactory.getCourtFinderAddressSearchPage(driver).clickContinueButton();
	}

	
	@When("^I enter \"(.*?)\" and search$")
	public void i_enter_and_search(String searchText) throws Throwable {
	    PageFactory.getCourtFinderAddressSearchPage(driver).setAddress(searchText);
	    PageFactory.getCourtFinderAddressSearchPage(driver).clickContinueButton();
	    PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyOnPage();;
	}

	@Then("^I will be returned a single court result \"(.*?)\"$")
	public void i_will_be_returned_a_single_court_result(String court) throws Throwable {
	    assertTrue("Not the number of results expected",PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyNumberOfCourtsFound(1));
	    assertTrue("Unable to find a court",PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyCourtResults(court));
	    
	}
	
	@Then("^in the result page I should find within the results the following \"(.*?)\" listed$")
	public void in_the_result_page_I_should_find_within_the_results_the_following_listed(String courts) throws Throwable {
	    assertTrue("Unable to find a court",PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyCourtResults(courts));
	}
	
	@Then("^I should be prompted that the address is invalid$")
	public void i_should_be_prompted_that_the_address_is_invalid() throws Throwable {
        assertTrue("No error message displayed for entering an invalid address",
     		   PageFactory.getCourtFinderAddressSearchPage(driver).verifyErrorPromptEnterInvalidAddress());
	}	
	
	@Then("^I am prompted to enter a address$")
	public void i_am_prompted_to_enter_a_address() throws Throwable {
	    assertTrue("No error message displayed for not entering a address",
	    		   PageFactory.getCourtFinderAddressSearchPage(driver).verifyErrorPromptEnterAddress());
	}
	
	@Then("^the results should be listed in the following order:$")
	public void the_results_should_be_listed_in_the_following_order(List<String> courtResults) throws Throwable {
		assertTrue(PageFactory.getCourtFinderAddressSearchResultPage(driver).verifyCourtResultsSortOrder(courtResults));
	}
	
	@When("^I click on the \"(.*?)\" breadcrumb$")
	public void i_click_on_the_breadcrumb(String breadcrumb) throws Throwable {
		CourtFinderSearchPage page = PageFactory.getCourtFinderSearchPage(driver);
	    if (breadcrumb.trim().equalsIgnoreCase("home")){
	    	page.clickHomeBreadcrumb();
	    } else if (breadcrumb.trim().equalsIgnoreCase("Find a court or tribunal")){
	    	page.clickFindACourtBreadcrumb();
	     } else if (breadcrumb.trim().equalsIgnoreCase("Search by postcode")){
	    	page.clickSearchByPostcodeBreadcrumb();
	     } else{
		    page.clickSearchByAddressCourtBreadcrumb();
		 }
	}

	@Then("^I am redirected to the \"(.*?)\" page$")
	public void i_am_redirected_to_the_page(String page) throws Throwable {
	    if (page.trim().equalsIgnoreCase("courtfinder start"))
	       PageFactory.getCourtFinderStartPage(driver).verifyOnPage();
	    else if (page.trim().equalsIgnoreCase("Find a court or tribunal")){
	    	PageFactory.getCourtfinderSearchSelectionPage(driver).verifyOnPage();
	    	PageFactory.getCourtfinderSearchSelectionPage(driver).verifySearchByNameIsSelected();
	    } else if (page.trim().equalsIgnoreCase("Search by postcode")){
	    	PageFactory.getCourtfinderPostcodSearchPage(driver).verifyOnPage();
	    } else
	    	PageFactory.getCourtFinderAddressSearchPage(driver).verifyOnPage();
	    	
	    
	}

	@Then("^the address search input box is in focus$")
	public void the_address_search_input_box_is_in_focus() throws Throwable {
	    assertTrue("address search box is not the focus",
	    		   PageFactory.getCourtFinderAddressSearchPage(driver).verifySearchInputHasFocus());
	}


}
