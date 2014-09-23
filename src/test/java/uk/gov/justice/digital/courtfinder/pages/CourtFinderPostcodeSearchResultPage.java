package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CourtFinderPostcodeSearchResultPage extends CourtFinderResultPage {


	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div/header/h1");
	private String expectedPageTitle = "Find a court or tribunal";
	
	private By errorInvalidPostcode = new By.ByXPath(".//*[@id='content']/div/section");
	private String expectedErrorTextInvalidPostcode = "Sorry, your postcode";

	private String courtDX = ".//*[@id='content']/div/div/ul/li[%d]/div[2]/p[2]/span[2]";
	private String courtNumber = ".//*[@id='content']/div/div/ul/li[%d]/div[2]/p[2]/span[4]";
	

	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitle);
	}

	public CourtFinderPostcodeSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public int getCourtIndex(String courtName) throws Exception{
		String court = "";
        //loop results
		for (int resultIndex = 1; resultIndex <= getNumberOfResults(); resultIndex++ ){
		   court = (getCourtNameAtIndex(resultIndex));
		   if (court.equalsIgnoreCase(courtName)){
				return resultIndex; 
		   }
		}				
		throw new Exception("No court found for : " + courtName);
	}
	


	public void clickCourtTitle(String court) throws Exception {
		String courtName = "";
        //loop results
		for (int resultIndex = 1; resultIndex <= getNumberOfResults(); resultIndex++ ){
		   courtName = (getCourtNameAtIndex(resultIndex));
		   if (courtName.equalsIgnoreCase(court)){
				click(new By.ByXPath(String.format(courtTitle, resultIndex))); 
				break;
		   }
		}		
	}
	
	



	public boolean verifyErrorNoResultsFound() throws Exception {
		return isTextContainedInInnerText(errorInvalidPostcode, expectedErrorTextInvalidPostcode);
	}

	public boolean verifyCourtDX(String court, String dx) throws Exception {
		if (isTextContainedInInnerText(new By.ByXPath(String.format(courtDX, getCourtIndex(court))), dx))
			return true;
		return false;
	}
	

	public boolean verifyCourtNumber(String court, String courtnumber) throws Exception {
		if (isTextContainedInInnerText(new By.ByXPath(String.format(courtNumber, getCourtIndex(court))), courtnumber))
			return true;
		return false;
	}

	public boolean verifyCourtAddress(String court, String courtaddress) throws Exception {
		if (getCourtAddressAtIndex(getCourtIndex(court)).contains(courtaddress))
			return true;
		return false;
	}
	

}
