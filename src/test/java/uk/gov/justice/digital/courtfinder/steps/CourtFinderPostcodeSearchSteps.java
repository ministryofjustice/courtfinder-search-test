package uk.gov.justice.digital.courtfinder.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.factories.PageFactory;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAboutYourIssuePage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAreaOfLawSearchSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchResultPage;
import uk.gov.justice.digital.courtfinder.step.HtmlStepContext;
import uk.gov.justice.digital.courtfinder.step.HtmlStepContextSingleton;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;

public class CourtFinderPostcodeSearchSteps {

	private WebDriver driver;
	private JourneyFactory journeyFactory;
	private HtmlStepContext htmlStepContext = new HtmlStepContextSingleton()
			.getInstance();

	public CourtFinderPostcodeSearchSteps(SharedDriver driver) {
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}

	@Given("^I am on the courtfinder postcode search page$")
	public void i_am_on_the_courtfinder_postcode_search_page() throws Throwable {
		htmlStepContext.reset();
		journeyFactory.getCourtFinderAreaOfLawSelectionPageJourney();
		CourtFinderAreaOfLawSearchSelectionPage page = PageFactory
				.getCourtFinderAreaOfLawSearchSelectionPage(driver);
		assertTrue("Unable to reach the area of law selection page",
				page.verifyOnPage());
		page.clickAllAreasOfLawRadiobutton();
		page.clickContinueButton();
	}

	@Given("^I am on the courtfinder area of law selection page$")
	public void i_am_on_the_courtfinder_area_of_law_selection_page()
			throws Throwable {
		journeyFactory.getCourtFinderAreaOfLawSelectionPageJourney();
		assertTrue("Unable to reach the Area of Law Selection page",
				PageFactory.getCourtFinderAreaOfLawSearchSelectionPage(driver)
						.verifyOnPage());
	}

	@When("^I enter an area of law \"(.*?)\" and select continue$")
	public void i_enter_an_area_of_law_and_select_continue(String areaOfLaw)
			throws Throwable {
		CourtFinderAreaOfLawSearchSelectionPage page = PageFactory
				.getCourtFinderAreaOfLawSearchSelectionPage(driver);
		page.verifyOnPage();
		boolean spoe = false;
		if (areaOfLaw.equalsIgnoreCase("adoption"))
			page.clickAdoptionRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("bankruptcy"))
			page.clickBankruptcyRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("children")) {
			page.clickChildrenRadiobutton();
			spoe = true;
		} else if (areaOfLaw.equalsIgnoreCase("civil partnership"))
			page.clickCivilPartnershipRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("crime"))
			page.clickCrimeRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("divorce")) {
			page.clickDivorceRadiobutton();
		} else if (areaOfLaw.equalsIgnoreCase("domestic violence"))
			page.clickDivorceRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("employment"))
			page.clickEmploymentRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("forced marriage"))
			page.clickForcedMarriageRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("housing possession")) {
			page.clickHousingPosessionRadiobutton();
		} else if (areaOfLaw.equalsIgnoreCase("immigration"))
			page.clickImmigrationRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("money claims")) {
			page.clickMoneyClaimsRadiobutton();
			spoe = true;
		} else if (areaOfLaw.equalsIgnoreCase("probate"))
			page.clickProbateRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("social security"))
			page.clickSocialSecurityRadiobutton();
		else if (areaOfLaw.equalsIgnoreCase("all courts and tribunals"))
			page.clickAllAreasOfLawRadiobutton();
		else
			throw new Exception("Unknown area of law: " + areaOfLaw);
		page.clickContinueButton();
		if (spoe) {
			CourtFinderAboutYourIssuePage nextPage = PageFactory
					.getCourtFinderAboutYourIssuePage(driver);
			nextPage.verifyOnPage();
			nextPage.clickNewClaimRadioButton();
			nextPage.clickContinueButton();
		}
	}

	@When("^I enter a (?:Scottish|Northern Ireland) postcode \"(.*?)\" and select continue$")
	public void i_enter_a_postcode_and_select_continue_(String postcode)
			throws Throwable {
		htmlStepContext.setPostcode(postcode);
		CourtFinderPostcodeSearchPage page = PageFactory
				.getCourtFinderPostcodSearchPage(driver);
		page.verifyOnPage();
		page.setTextPostcodeInput(postcode);
		page.clickContinueButton();
	}

	@When("^on postcode search result page I click on the \"(.*?)\" breadcrumb$")
	public void on_postcode_search_result_page_I_click_on_the_breadcrumb(
			String breadcrumb) throws Throwable {
		CourtFinderPostcodeSearchResultPage page = new CourtFinderPostcodeSearchResultPage(
				driver);
		page.verifyOnPage();
		System.out.println(breadcrumb);
		if (breadcrumb.trim().equalsIgnoreCase("Home")) {
			page.clickHomeBreadcrumbLink();
		} else if (breadcrumb.trim().equalsIgnoreCase(
				"Find a court or tribunal")) {
			page.clickFindTheRightCourtBreadcrumbLink();
		} else if (breadcrumb.trim().equalsIgnoreCase("Search by postcode")) {
			page.clickSearchByPostcodeBreadcrumbLink();
		} else
			throw new Exception("Unknown breadcrumb : " + breadcrumb);
	}

	@When("^I enter a postcode \"(.*?)\" and select continue$")
	public void i_enter_a_postcode_and_select_continue(String postcode)
			throws Throwable {
		htmlStepContext.setPostcode(postcode);
		CourtFinderPostcodeSearchPage page = PageFactory
				.getCourtFinderPostcodSearchPage(driver);
		page.verifyOnPage();
		page.setTextPostcodeInput(postcode);
		page.clickContinueButton();
	}

	@When("^select the court link on row (\\d+) of the postcode search results$")
	public void select_the_court_link_on_row_of_the_postcode_search_results(
			int row) throws Throwable {
		CourtFinderPostcodeSearchResultPage page = PageFactory
				.getCourtFinderPostcodeSearchResultPage(driver);
		page.verifyOnPage();
		page.clickMoreDetailsLink(row);
	}

	@Then("^I am returned an error message that Northern Ireland is not supported except for immigration$")
	public void i_am_returned_an_error_message_that_Northern_Ireland_is_not_supported_except_for_immigration()
			throws Throwable {
		assertTrue("NI Error not found", PageFactory
				.getCourtFinderPostcodSearchPage(driver)
				.verifyerrorNorthernIrelandPostcodeContainsText());
	}

	@Then("^I am returned an error message that courtfinder only supports courts in England and Wales$")
	public void i_am_returned_an_error_message_that_courtfinder_only_supports_courts_in_England_and_Wales()
			throws Throwable {
		assertTrue("Scottish Error not found", PageFactory
				.getCourtFinderPostcodSearchPage(driver)
				.verifyerrorScotlandPostcodeContainsText());
	}

	@Then("^I am redirected to the selected \"(.*?)\" details page$")
	public void i_am_redirected_to_the_selected_details_page(String court)
			throws Throwable {
		assertTrue("Court title on details page is not as expected",
				PageFactory.getCourtFinderCourtDetailsPage(driver)
						.verifyCourtTitle(court));
	}

	@Then("^the total number of search results (\\d+) should be displayed$")
	public void the_total_number_of_search_results_should_be_displayed(
			int numberOfCourtsFound) throws Throwable {
		assertTrue(
				"Invalid number of courts found",
				PageFactory.getCourtFinderPostcodeSearchResultPage(driver)
						.verifyNumberOfCourtResultsText(
								Integer.toString(numberOfCourtsFound)));
	}

	@Then("^I am prompted that the searched postcode could not be found$")
	public void i_am_prompted_that_the_searched_postcode_could_not_be_found()
			throws Throwable {
		assertTrue(
				"No error message displayed for entering an invalid postcode",
				PageFactory.getCourtFinderPostcodSearchPage(driver)
						.verifyerrorInvalidPostcodeEnteredContainsText());
	}

	@When("^I select continue$")
	public void i_select_continue() throws Throwable {
		PageFactory.getCourtFinderPostcodSearchPage(driver)
				.clickContinueButton();
	}

	@Then("^I am prompted to enter a postcode$")
	public void i_am_prompted_to_enter_a_postcode() throws Throwable {
		assertTrue("No error message displayed for not entering a postcode",
				PageFactory.getCourtFinderPostcodSearchPage(driver)
						.verifyerrorNoPostcodeEnteredContainsText());
	}

	@Then("^I am redirected to the postcode results with the court \"(.*?)\" first in the results$")
	public void i_am_redirected_to_the_postcode_results_with_the_court_first_in_the_results(
			String courtName) throws Throwable {
		assertTrue("court not found",
				(PageFactory.getCourtFinderAddressSearchResultPage(driver)
						.verifyCourtNameText(1, courtName)));
	}

	@Then("^the postcode search input box is in focus$")
	public void the_postcode_search_input_box_is_in_focus() throws Throwable {
		assertTrue("postcode search box is not the focus", PageFactory
				.getCourtFinderPostcodSearchPage(driver)
				.hasFocusPostcodeInput());
	}

	@When("^I enter a invalid postcode \"(.*?)\" and search$")
	public void i_enter_a_invalid_postcode_and_search(String postcode)
			throws Throwable {
		htmlStepContext.setPostcode(postcode);
		PageFactory.getCourtFinderPostcodSearchPage(driver)
				.setTextPostcodeInput(postcode);
		;
		PageFactory.getCourtFinderPostcodSearchPage(driver)
				.clickContinueButton();
	}

	@Then("^I should be prompted that the postcode is invalid$")
	public void i_should_be_prompted_that_the_postcode_is_invalid()
			throws Throwable {
		assertTrue("Error prompt for invalid postcode not found", PageFactory
				.getCourtFinderPostcodSearchPage(driver)
				.verifyerrorInvalidPostcodeEnteredContainsText());
	}

	@Then("^I am redirected to the postcode results displaying the closest \"(.*?)\"$")
	public void i_am_redirected_to_the_postcode_results_displaying_the_closest(
			String courtNames) throws Throwable {
		assertTrue("Unable to reach the postcode results page", PageFactory
				.getCourtFinderPostcodeSearchResultPage(driver).verifyOnPage());
		String[] courts = courtNames.split(",");
		for (int index = 0; index < courts.length; index++) {
			String court = courts[index];
			assertTrue("court not found: " + court,
					(PageFactory.getCourtFinderAddressSearchResultPage(driver)
							.verifyCourtNameText(1, court)));
		}
	}

	@Then("^the input box should contain the postcode entered$")
	public void the_input_box_should_contain_the_postcode_entered()
			throws Throwable {
		assertTrue("Postcode is invalid", PageFactory
				.getCourtFinderPostcodSearchPage(driver)
				.verifyPostcodeInputText(htmlStepContext.getPostcode()));
	}

	@Then("^for the closest court the dx \"(.*?)\" and courtnumber \"(.*?)\" are displayed$")
	public void for_the_closest_court_the_dx_and_courtnumber_are_displayed(
			String courtDXText, String courtNumberText) throws Throwable {
		CourtFinderPostcodeSearchResultPage page = PageFactory
				.getCourtFinderPostcodeSearchResultPage(driver);
		page.verifyOnPage();
		assertTrue("Dx Number is not correct",
				page.verifyCourtDXText(1, courtDXText));
		assertTrue("Court number is invalid",
				page.verifyCourtNumberText(1, courtNumberText));
	}

	@Then("^for the closest \"(.*?)\" the postal address  \"(.*?)\",\"(.*?)\",\"(.*?)\" is displayed$")
	public void for_the_closest_the_postal_address_is_displayed(String court,
			String courtAddressText, String courtTownText,
			String courtTownPostcode) throws Throwable {
		CourtFinderPostcodeSearchResultPage page = PageFactory
				.getCourtFinderPostcodeSearchResultPage(driver);
		page.verifyOnPage();
		assertTrue("postal address is not correct",
				page.verifyCourtAddressText(1, courtAddressText));
		assertTrue("postal town is not correct",
				page.verifyCourtTownText(1, courtTownText));
		assertTrue("postal town is not correct",
				page.verifyCourtPostcodeText(1, courtTownPostcode));

	}

}
