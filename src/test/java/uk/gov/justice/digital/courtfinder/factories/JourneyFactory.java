package uk.gov.justice.digital.courtfinder.factories;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderAreaOfLawSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;

public class JourneyFactory {
	
	private final WebDriver driver;


	public JourneyFactory(WebDriver driver) {
		this.driver = driver;
		
	}


	
	public void getCourtFinderStartPageJourney(){
		driver.get(FakeDataFactory.getCourtFinderStartPageUrl());
	}
	
	public void getCourtFinderSearchSelecionPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		CourtFinderStartPage page = PageFactory.getCourtFinderStartPage(driver);
		assertTrue("Unable to reach the start page",
				   page.verifyOnPage());
		page.clickStartButton();
	}
	
	public void getCourtFinderAreaOfLawSelectionPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		CourtFinderStartPage page = new CourtFinderStartPage(driver);
		assertTrue("Unable to reach the start page",
				  page.verifyOnPage());		
		page.clickStartButton();
	}

	public void getCourtFinderPostcodeSearchPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		CourtFinderStartPage page = new CourtFinderStartPage(driver);
		assertTrue("Unable to reach the start page",
				  page.verifyOnPage());
		page.clickStartButton();
	}
	
	public void getCourtFinderAddressSearchPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		CourtFinderStartPage page = new CourtFinderStartPage(driver);
		assertTrue("Unable to reach the start page",
				  page.verifyOnPage());
		page.clickaddressSearch();
	}
	

}
