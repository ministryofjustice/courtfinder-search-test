package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderAreaOfLawSearchSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderCourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderListViewPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchPage;



public class PageFactory {

	
	public static CourtFinderStartPage getCourtFinderStartPage(WebDriver driver){
		return new CourtFinderStartPage(driver);
	}
	
	
	public static CourtFinderPostcodeSearchPage getCourtFinderPostcodSearchPage(WebDriver driver){
		return new CourtFinderPostcodeSearchPage(driver);
	}	
	
	public static CourtFinderListViewPage getCourtFinderListViewPage(WebDriver driver){
		return new CourtFinderListViewPage(driver);
	}	

	public static CourtFinderAddressSearchPage getCourtFinderAddressSearchPage(WebDriver driver){
		return new CourtFinderAddressSearchPage(driver);
	}

	public static CourtFinderPostcodeSearchResultPage getCourtFinderPostcodeSearchResultPage(WebDriver driver){
		return new CourtFinderPostcodeSearchResultPage(driver);
	}	
	
	
	public static CourtFinderCourtDetailsPage getCourtFinderCourtDetailsPage(WebDriver driver){
		return new CourtFinderCourtDetailsPage(driver);
	}
	

	public static CourtFinderAddressSearchResultPage getCourtFinderAddressSearchResultPage(
			WebDriver driver) {
		return new CourtFinderAddressSearchResultPage(driver);
	}

	
	public static CourtFinderAreaOfLawSearchSelectionPage getCourtFinderAreaOfLawSearchSelectionPage(WebDriver driver){
		return new CourtFinderAreaOfLawSearchSelectionPage(driver);
	}
	
}
