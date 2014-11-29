package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderPostcodeSearchPage extends SeleniumPage {
	private String expectedTextOnPage = "Enter postcode";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='postcode-page']/header/h1");
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");
	private By findTheRightCourtBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[2]/a");
	private By aboutYourIssueBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[3]/a");
	private By postcodeInput = new By.ByXPath(".//*[@id='postcode']");
	private By continueButton = new By.ById("continue");
	private By errorInvalidPostcodeEntered = new By.ByXPath(
			".//*[@id='postcode-page']/div/section/p");
	private String expectedErrorTextInvalidPostcode = "You did not enter a valid postcode. Please try again.";
	private By errorNoPostcodeEntered = new By.ByXPath(
			".//*[@id='postcode-page']/div/section/p");
	private String expectedErrorTextNoPostcodeEntered = "You did not enter a search term. Please try again.You did not enter a postcode. Please try again.";
	private By errorNorthernIrelandPostcode = new By.ByXPath(
			".//*[@id='postcode-page']/section/p");
	private String expectedErrorTextNorthernIrelandPostcode = "Aside from immigration tribunals, this tool does not return results for Northern Ireland.";
	private By errorScotlandPostcode = new By.ByXPath(".//*[@id='scotland']/em");
	private String expectedErrorTextScotlandPostcode = "This tool shows courts and tribunals in England and Wales";

	public CourtFinderPostcodeSearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}

	public void clickHomeBreadcrumbLink() throws Exception {
		click(homeBreadcrumbLink);
	}

	public void clickFindTheRightCourtBreadcrumbLink() throws Exception {
		click(findTheRightCourtBreadcrumbLink);
	}

	public void clickAboutYourIssueBreadcrumbLink() throws Exception {
		click(aboutYourIssueBreadcrumbLink);
	}

	public void setTextPostcodeInput(String text) throws Exception {
		setText(postcodeInput, text);
	}

	public boolean hasFocuspostcodeInput() throws Exception {
		return hasFocus(postcodeInput);
	}

	public boolean verifypostcodeInputText(String inputText) throws Exception {
		return getAttributeValue(postcodeInput, "value").equalsIgnoreCase(
				inputText);
	}

	public void clickContinueButton() throws Exception {
		click(continueButton);
	}

	public boolean verifyerrorInvalidPostcodeEntered() throws Exception {
		waitToGetElement(errorInvalidPostcodeEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorInvalidPostcodeEntered,
				expectedErrorTextInvalidPostcode);
	}

	public boolean verifyerrorNoPostcodeEntered() throws Exception {
		waitToGetElement(errorNoPostcodeEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNoPostcodeEntered,
				expectedErrorTextNoPostcodeEntered);
	}

	public boolean verifyerrorNorthernIrelandPostcode() throws Exception {
		waitToGetElement(errorNorthernIrelandPostcode, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNorthernIrelandPostcode,
				expectedErrorTextNorthernIrelandPostcode);
	}

	public boolean verifyerrorScotlandPostcode() throws Exception {
		waitToGetElement(errorScotlandPostcode, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorScotlandPostcode,
				expectedErrorTextScotlandPostcode);
	}
}
