package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderAddressSearchPage extends SeleniumPage{
	
	private By pageTitle = new By.ByXPath(".//*[@class='form-label-bold']");
	private String expectedPageTitle = "Search by name or address";
	private By addressInput = new By.ByXPath(".//*[@name='q']");

	private By continueButton = new By.ByXPath(".//*[@id='continue']");

	private By errorInvalidAddress= new By.ByXPath(".//*[@id='content']/div/section");
	private String expectedErrorTextInvalidAddress = "Sorry, there are no results for ";
	
	
	private By errorNoAddressEntered = new By.ByXPath(".//*[@id='content']/div[2]/div/section");
	private String expectedErrorTextNoAddressEntered = "You did not enter a search term. Please try again.";

	
	public boolean verifyErrorPromptEnterAddress() throws Exception {
		waitToGetElement(errorNoAddressEntered, HTTP_TIMEOUT);
		return isTextContainedInInnerText(errorNoAddressEntered, expectedErrorTextNoAddressEntered);
		
	}

	public boolean verifyErrorPromptEnterInvalidAddress() throws Exception {
		return isTextPresent(expectedErrorTextInvalidAddress);
	}	
	
	public CourtFinderAddressSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickContinueButton() throws Exception{
		click(continueButton);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}
	
	public void setAddress(String address) throws Exception{
		setText(addressInput,address);
	}
	
	
	
	

}
