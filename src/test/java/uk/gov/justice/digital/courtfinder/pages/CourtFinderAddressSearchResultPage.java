package uk.gov.justice.digital.courtfinder.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CourtFinderAddressSearchResultPage extends CourtFinderResultPage{
	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div[2]/header/h1");
	private String expectedPageTitle = "Find a court or tribunal";

	
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isTextContainedInInnerText(pageTitle, expectedPageTitle);
	}

	public CourtFinderAddressSearchResultPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyCourtResultsSortOrder(List<String> courtResults) throws Exception {
		String courtName = "";
		for (int resultIndex = 1; resultIndex <= courtResults.size()-1; resultIndex++ ){
		   courtName = (getCourtNameAtIndex(resultIndex));
           if (!courtName.equalsIgnoreCase(courtResults.get(resultIndex)))
				  return false;
		}
		return true;
	}	
	
}
