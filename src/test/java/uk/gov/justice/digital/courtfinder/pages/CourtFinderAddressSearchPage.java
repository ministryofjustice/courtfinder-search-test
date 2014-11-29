package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderAddressSearchPage extends SeleniumPage {
	private String expectedTextOnPage = "Search by name or address";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@class='page-header']/h1");
	private By addressInput = new By.ByXPath(".//*[@id='address']");
	private By continueButton = new By.ByXPath(".//*[@id='continue']");
	private By errorInvalidAddressEntered = new By.ByXPath(
			".//*[@id='content']/div[2]/div/section/p");
	private String expectedErrorTextInvalidAddress = "Sorry, there are no results for";
	private By errorNoAddressEntered = new By.ByXPath(
			".//*[@id='content']/div[2]/div/section/p");
	private String expectedErrorTextNoAddressEntered = "You did not enter a search term. Please try again.";

	public CourtFinderAddressSearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
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

	public boolean verifyerrorInvalidAddressEntered() throws Exception {
		waitToGetElement(errorInvalidAddressEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorInvalidAddressEntered,
				expectedErrorTextInvalidAddress);
	}

	public boolean verifyerrorNoAddressEntered() throws Exception {
		waitToGetElement(errorNoAddressEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNoAddressEntered,
				expectedErrorTextNoAddressEntered);
	}
}
