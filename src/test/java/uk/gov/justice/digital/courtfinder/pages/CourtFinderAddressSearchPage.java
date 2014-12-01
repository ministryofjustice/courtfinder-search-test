package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderAddressSearchPage extends SeleniumPage {
	private String expectedErrorTextInvalidAddress = "Sorry, there are no results for";
	private By errorInvalidAddressEntered = new By.ByXPath(
			".//*[@id='content']/div[2]/div/section/p");
	private String expectedErrorTextNoAddressEntered = "You did not enter a search term. Please try again.";
	private By errorNoAddressEntered = new By.ByXPath(
			".//*[@id='content']/div[2]/div/section/p");
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");
	private By findTheRightCourtBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[2]/a");
	private By addressInput = new By.ByXPath(".//*[@id='address']");
	private By continueButton = new By.ByXPath(".//*[@id='continue']");
	private String expectedTextOnPage = "Search by name or address";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@class='page-header']/h1");

	public CourtFinderAddressSearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyerrorInvalidAddressEnteredContainsText()
			throws Exception {
		waitToGetElement(errorInvalidAddressEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorInvalidAddressEntered,
				expectedErrorTextInvalidAddress);
	}

	public boolean verifyerrorNoAddressEnteredContainsText() throws Exception {
		waitToGetElement(errorNoAddressEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNoAddressEntered,
				expectedErrorTextNoAddressEntered);
	}

	public void clickHomeBreadcrumbLink() throws Exception {
		click(homeBreadcrumbLink);
	}

	public void clickFindTheRightCourtBreadcrumbLink() throws Exception {
		click(findTheRightCourtBreadcrumbLink);
	}

	public void setTextAddressInput(String text) throws Exception {
		setText(addressInput, text);
	}

	public boolean hasFocusAddressInput() throws Exception {
		return hasFocus(addressInput);
	}

	public boolean verifyAddressInputText(String inputText) throws Exception {
		return getAttributeValue(addressInput, "value").equalsIgnoreCase(
				inputText);
	}

	public void clickContinueButton() throws Exception {
		click(continueButton);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}
}
