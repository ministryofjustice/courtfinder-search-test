package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAreaOfLawSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderPostcodeSearchPage;
import uk.gov.justice.digital.courtfinder.step.HtmlStepContext;
import uk.gov.justice.digital.courtfinder.step.HtmlStepContextSingleton;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderPostcodeSearchSteps {

	private WebDriver driver;
	private JourneyFactory journeyFactory;
	private HtmlStepContext htmlStepContext = new HtmlStepContextSingleton().getInstance();

	public CourtFinderPostcodeSearchSteps(SharedDriver driver) {
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}

	@Given("^I am on the courtfinder postcode search page$")
	public void i_am_on_the_courtfinder_postcode_search_page() throws Throwable {
		htmlStepContext.reset();
		journeyFactory.getCourtFinderAreaOfLawSelectionPageJourney();
		CourtFinderAreaOfLawSelectionPage page = new CourtFinderAreaOfLawSelectionPage(driver);
		assertTrue("Unable to reach the area of law selection page", page.verifyOnPage());
		page.setAreaOfLaw("All courts and tribunals");
		page.clickContinue();
	}
	
	@Given("^I am on the courtfinder area of law selection page$")
	public void i_am_on_the_courtfinder_area_of_law_selection_page() throws Throwable {
	    journeyFactory.getCourtFinderAreaOfLawSelectionPageJourney();
	    assertTrue("Unable to reach the Area of Law Selection page",
	    		  PageFactory.getCourtFinderAreaOfLawSelectionPage(driver).verifyOnPage());
	}

	@When("^I enter an area of law \"(.*?)\" and select continue$")
	public void i_enter_an_area_of_law_and_select_continue(String areoOfLaw) throws Throwable {
		CourtFinderAreaOfLawSelectionPage page = PageFactory.getCourtFinderAreaOfLawSelectionPage(driver);
		page.verifyOnPage();
	    page.setAreaOfLaw(areoOfLaw);
	    page.clickContinue();
	}

	@When("^I enter a (?:Scottish|Northern Ireland) postcode \"(.*?)\" and select continue$")
	public void i_enter_a_postcode_and_select_continue_(String postcode) throws Throwable {
		htmlStepContext.setPostcode(postcode);
	    CourtfinderPostcodeSearchPage page = PageFactory.getCourtfinderPostcodSearchPage(driver);
	    page.verifyOnPage();
	    page.setSearchPostcode(postcode);
	    page.clickContinue();
	}

	@When("^I enter a postcode \"(.*?)\" and select continue$")
	public void i_enter_a_postcode_and_select_continue(String postcode) throws Throwable {
		htmlStepContext.setPostcode(postcode);
	    CourtfinderPostcodeSearchPage page = PageFactory.getCourtfinderPostcodSearchPage(driver);
	    page.verifyOnPage();
	    page.setSearchPostcode(postcode);
	    page.clickContinue();
	}
	

	@Then("^I am returned an error message that Northern Ireland is not supported except for immigration$")
	public void i_am_returned_an_error_message_that_Northern_Ireland_is_not_supported_except_for_immigration()
			throws Throwable {
		assertTrue("NI Error not found", PageFactory.getCourtfinderPostcodSearchPage(driver).verifyErrorPromptNorthernIreland());
	}
	
	@Then("^I am returned an error message that courtfinder only supports courts in England and Wales$")
	public void i_am_returned_an_error_message_that_courtfinder_only_supports_courts_in_England_and_Wales() throws Throwable {
		assertTrue("Scottish Error not found", PageFactory.getCourtfinderPostcodSearchPage(driver).verifyErrorPromptScotland());
	}

	@When("^select the \"(.*?)\" link in the postcode search results$")
	public void select_the_link_in_the_postcode_search_results(String court) throws Throwable {
	    PageFactory.getCourtFinderPostcodeSearchResultPage(driver).clickCourtTitle(court);
	}

	@Then("^I am redirected to the selected \"(.*?)\" details page$")
	public void i_am_redirected_to_the_selected_details_page(String court) throws Throwable {
	    assertTrue("Court title on details page is not as expected",PageFactory.getCourtFinderCourtDetailsPage(driver).verifyCourtTitle(court));
	}
	
	@Then("^the total number of search results (\\d+) should be displayed$")
	public void the_total_number_of_search_results_should_be_displayed(int numberOfCourtsFound) throws Throwable {
	    assertTrue("Invalid number of courts found",PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyNumberOfCourtsFound(numberOfCourtsFound));
	}
	
	@Then("^I am prompted that the searched postcode could not be found$")
	public void i_am_prompted_that_the_searched_postcode_could_not_be_found() throws Throwable {
        assertTrue("No error message displayed for entering an invalid postcode",
        		   PageFactory.getCourtfinderPostcodSearchPage(driver).verifyErrorPromptInvalidPostcode());
	}
	
	@When("^I select continue$")
	public void i_select_continue() throws Throwable {
	    PageFactory.getCourtfinderPostcodSearchPage(driver).clickContinue();
	}

	@Then("^I am prompted to enter a postcode$")
	public void i_am_prompted_to_enter_a_postcode() throws Throwable {
	    assertTrue("No error message displayed for not entering a postcode"
	    		   ,PageFactory.getCourtfinderPostcodSearchPage(driver).verifyErrorPromptEnterPostcode());
	}
	
	
	@Then("^for the \"(.*?)\" the dx \"(.*?)\" and courtnumber \"(.*?)\" are displayed$")
	public void for_the_the_dx_and_courtnumber_are_displayed(String court, String dx, String courtnumber) throws Throwable {
	    assertTrue("Invalid dx number",PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtDX(court,dx));
	    assertTrue("Invalid court number",PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtNumber(court,courtnumber));

	}


	@Then("^for the \"(.*?)\" the \"(.*?)\" is displayed$")
	public void for_the_the_is_displayed(String court, String courtaddress) throws Throwable {
	   assertTrue(PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyCourtAddress(court,courtaddress));
	}
	
	@Then("^I am redirected to the postcode results with the court \"(.*?)\" first in the results$")
	public void i_am_redirected_to_the_postcode_results_with_the_court_first_in_the_results(String courtName) throws Throwable {
	    assertTrue("court not found",(PageFactory.getCourtFinderAddressSearchResultPage(driver).getCourtNameAtIndex(1).equalsIgnoreCase(courtName)));
	}

	@Then("^the postcode search input box is in focus$")
	public void the_postcode_search_input_box_is_in_focus() throws Throwable {
	    assertTrue("postcode search box is not the focus",
	    		   PageFactory.getCourtfinderPostcodSearchPage(driver).verifySearchInputHasFocus());
	}

	@When("^I enter a invalid postcode \"(.*?)\" and search$")
	public void i_enter_a_invalid_postcode_and_search(String postcode) throws Throwable {
		htmlStepContext.setPostcode(postcode);
	    PageFactory.getCourtfinderPostcodSearchPage(driver).setSearchPostcode(postcode);
	    PageFactory.getCourtfinderPostcodSearchPage(driver).clickContinue();
	}

	@Then("^I should be prompted that the postcode is invalid$")
	public void i_should_be_prompted_that_the_postcode_is_invalid() throws Throwable {
	  assertTrue("Error prompt for invalid postcode not found",PageFactory.getCourtfinderPostcodSearchPage(driver).verifyErrorPromptInvalidPostcode());
	}
	
	@Then("^I am redirected to the postcode results displaying the closest \"(.*?)\"$")
	public void i_am_redirected_to_the_postcode_results_displaying_the_closest(String courtNames) throws Throwable {
		assertTrue("Unable to reach the postcode results page", PageFactory.getCourtFinderPostcodeSearchResultPage(driver).verifyOnPage());
		String[] courts = courtNames.split(",");
		for (int index = 0; index < courts.length; index++){
			String court = courts[index];
	         assertTrue("court not found: " + court,(PageFactory.getCourtFinderAddressSearchResultPage(driver).getCourtNameAtIndex(index+1)).equalsIgnoreCase(court));
		}
	}
	
	@Then("^the input box should contain the postcode entered$")
	public void the_input_box_should_contain_the_postcode_entered() throws Throwable {
	    assertTrue("Postcode is invalid", PageFactory.getCourtfinderPostcodSearchPage(driver).verifySearchPostcodeInput(htmlStepContext.getPostcode()));
	}
	
	
}
