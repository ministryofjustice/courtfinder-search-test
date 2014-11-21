package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtfinderPostcodeSearchPage extends CourtFinderSearchPage {
	
	private By searchPostcode = new By.ByXPath(".//*[@name='postcode']");
	
	private By continueButton = new By.ById("continue");
	
	private By pageTitle = new By.ByXPath(".//*[@class='page-header']/h1");
	private String expectedPageTitle = "Enter postcode";
	
	private By errorNoPostcodeEntered = new By.ByXPath(".//*[@class='validation-error']/span");
	private By errorNorthernIrelandPostcode = new By.ByXPath(".//*[@class='postcode-error validation-error']/span");
	private By errorScotlandPostcode = new By.ByXPath(".//*[@id='scotland']/em");
	private By errorInvalidPostcode = new By.ByXPath(".//*[@class='postcode-error validation-error']/span");

	private String expectedErrorTextNoPostcodeEntered = "You did not enter a postcode. Please try again.";
	private String expectedErrorTextNorthernIrelandPostcode = "Aside from immigration tribunals";
	private String expectedErrorTextScotlandPostcode = "This tool shows courts and tribunals in England and Wales";
	private String expectedErrorTextInvalidPostcode = "Sorry, your postcode";

	
	//private By legalProblems = new By.ByXPath(".//*[@id='aol-one']");
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}
	
	public void clickContinue() throws Exception{
		click(continueButton);
	}
	
	public boolean verifySearchPostcodeInput(String postcode) throws Exception{
		return getAttributeValue(getElement(searchPostcode), "value").equalsIgnoreCase(postcode);
	}

	
	public void setSearchPostcode(String postcode) throws Exception{
		setText(searchPostcode, postcode);
	}

	public CourtfinderPostcodeSearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyErrorPromptEnterPostcode() throws Exception {
		waitToGetElement(errorNoPostcodeEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNoPostcodeEntered, expectedErrorTextNoPostcodeEntered);
	}
	
	public boolean verifyErrorPromptNorthernIreland() throws Exception {
		waitToGetElement(errorNorthernIrelandPostcode, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNorthernIrelandPostcode, expectedErrorTextNorthernIrelandPostcode);
	}

	public boolean verifyErrorPromptScotland() throws Exception {
		waitToGetElement(errorScotlandPostcode, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorScotlandPostcode, expectedErrorTextScotlandPostcode);
	}


	public boolean verifySearchInputHasFocus() throws Exception {
		
		return driver.switchTo().activeElement().equals(getElement(searchPostcode));
	}

	public boolean verifyErrorPromptInvalidPostcode() throws Exception {
		waitToGetElement(errorInvalidPostcode, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorInvalidPostcode, expectedErrorTextInvalidPostcode);
	}

}
