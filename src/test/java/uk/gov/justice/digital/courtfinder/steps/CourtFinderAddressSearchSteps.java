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
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchResultPage;
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
		assertTrue("Unable to reach the address search page", PageFactory
				.getCourtFinderAddressSearchPage(driver).verifyOnPage());
	}

	@When("^on the courtfinder address search page I click on the \"(.*?)\" breadcrumb$")
	public void on_the_courtfinder_address_search_page_I_click_on_the_breadcrumb(
			String breadcrumb) throws Throwable {
		CourtFinderAddressSearchPage page = PageFactory
				.getCourtFinderAddressSearchPage(driver);
		page.verifyOnPage();
		if (breadcrumb.equalsIgnoreCase("Home"))
			page.clickHomeBreadcrumbLink();
		else if (breadcrumb.equalsIgnoreCase("Find a court or tribunal"))
			page.clickFindTheRightCourtBreadcrumbLink();
		else
			throw new Exception("Unknown breadcrumb: " + breadcrumb);
	}

	@When("^I enter a (?:partial court name|court name|building name|street name|town, city or county) \"(.*?)\" and search$")
	public void i_enter_a_court_name_and_search(String courtName)
			throws Throwable {
		PageFactory.getCourtFinderAddressSearchPage(driver)
				.setTextAddressInput(courtName);
		PageFactory.getCourtFinderAddressSearchPage(driver)
				.clickContinueButton();
		PageFactory.getCourtFinderAddressSearchResultPage(driver)
				.verifyOnPage();
	}

	@When("^I enter a (?:invalid address|inactive court) \"(.*?)\" and search$")
	public void i_enter_a_court_name_and_search_(String courtName)
			throws Throwable {
		PageFactory.getCourtFinderAddressSearchPage(driver)
				.setTextAddressInput(courtName);
		PageFactory.getCourtFinderAddressSearchPage(driver)
				.clickContinueButton();
	}

	@When("^I enter \"(.*?)\" and search$")
	public void i_enter_and_search(String searchText) throws Throwable {
		PageFactory.getCourtFinderAddressSearchPage(driver)
				.setTextAddressInput(searchText);
		PageFactory.getCourtFinderAddressSearchPage(driver)
				.clickContinueButton();
		PageFactory.getCourtFinderAddressSearchResultPage(driver)
				.verifyOnPage();
		;
	}

	@When("^on the courtfinder address result search page I click on the \"(.*?)\" breadcrumb$")
	public void on_the_courtfinder_address_result_search_page_I_click_on_the_breadcrumb(
			String breadcrumb) throws Throwable {
		CourtFinderAddressSearchResultPage page = PageFactory
				.getCourtFinderAddressSearchResultPage(driver);
		page.verifyOnPage();
		if (breadcrumb.equalsIgnoreCase("Home"))
			page.clickHomeBreadcrumbLink();
		else if (breadcrumb.equalsIgnoreCase("Find a court or tribunal"))
			page.clickFindTheRightCourtBreadcrumbLink();
		else if (breadcrumb.equalsIgnoreCase("Search by name or address"))
			page.clickSearchByNameOrAddressBreadcrumbLink();
		else
			throw new Exception("Unknown breadcrumb: " + breadcrumb);
	}

	@When("^select the court link on row (\\d+) of the address search results$")
	public void select_the_court_link_on_row_of_the_address_search_results(
			int row) throws Throwable {
		CourtFinderAddressSearchResultPage page = PageFactory
				.getCourtFinderAddressSearchResultPage(driver);
		page.verifyOnPage();
		page.clickMoreDetailsLink(row);
	}

	@Then("^I will be returned a single court result \"(.*?)\"$")
	public void i_will_be_returned_a_single_court_result(String court)
			throws Throwable {
		assertTrue("Not the number of results expected", PageFactory
				.getCourtFinderAddressSearchResultPage(driver)
				.verifyNumberOfCourtResultsText(Integer.toString(1)));
		assertTrue("Unable to find a court",
				PageFactory.getCourtFinderAddressSearchResultPage(driver)
						.verifyCourtNameText(1, court));

	}

	@Then("^I should be prompted that the address is invalid$")
	public void i_should_be_prompted_that_the_address_is_invalid()
			throws Throwable {
		assertTrue(
				"No error message displayed for entering an invalid address",
				PageFactory.getCourtFinderAddressSearchPage(driver)
						.verifyerrorInvalidAddressEnteredContainsText());
	}

	@Then("^I am prompted to enter a address$")
	public void i_am_prompted_to_enter_a_address() throws Throwable {
		assertTrue("No error message displayed for not entering a address",
				PageFactory.getCourtFinderAddressSearchPage(driver)
						.verifyerrorNoAddressEnteredContainsText());
	}

	@Then("^the results should be listed in the following order:$")
	public void the_results_should_be_listed_in_the_following_order(
			List<String> courtResults) throws Throwable {
		for (int index = 1; index < courtResults.size(); index++)
			assertTrue(PageFactory
					.getCourtFinderAddressSearchResultPage(driver)
					.verifyCourtNameText(index, courtResults.get(index)));
	}

	@Then("^I am redirected to the \"(.*?)\" page$")
	public void i_am_redirected_to_the_page(String page) throws Throwable {
		if (page.equalsIgnoreCase("Home"))
			PageFactory.getCourtFinderStartPage(driver).verifyOnPage();
		if (page.equalsIgnoreCase("Fina a court or tribunal"))
			PageFactory.getCourtFinderStartPage(driver).verifyOnPage();
		if (page.equalsIgnoreCase("Search by postcode"))
			PageFactory.getCourtFinderPostcodSearchPage(driver).verifyOnPage();
	}

	@Then("^the address search input box is in focus$")
	public void the_address_search_input_box_is_in_focus() throws Throwable {
		assertTrue("address search box is not the focus", PageFactory
				.getCourtFinderAddressSearchPage(driver).hasFocusAddressInput());
	}

	@Then("^I will be returned court result \"(.*?)\" in (\\d+) row$")
	public void i_will_be_returned_court_result_in_row(String courtNameText,
			int row) throws Throwable {
		CourtFinderAddressSearchResultPage page = PageFactory
				.getCourtFinderAddressSearchResultPage(driver);
		page.verifyOnPage();
		assertTrue("Court not found.", page.verifyCourtNameText(row, courtNameText));
	}

	@Then("^for in (\\d+) row the court- \"(.*?)\" postal address- \"(.*?)\" is displayed$")
	public void for_in_row_the_court_postal_address_is_displayed(int row,
			String courtNameText, String courtAddressText) throws Throwable {
		CourtFinderAddressSearchResultPage page = PageFactory.getCourtFinderAddressSearchResultPage(driver);
		page.verifyOnPage();
		assertTrue("Invalid court name", page.verifyCourtNameText(row, courtNameText));
		assertTrue("Invalid postal address", page.verifyCourtAddressContainsText(row, courtAddressText));
	}
}
