package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderCourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderListViewPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchErrorPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderPostcodSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;


public class PageFactory {

	
	public static CourtFinderStartPage getCourtFinderStartPage(WebDriver driver){
		return new CourtFinderStartPage(driver);
	}
	
	public static CourtfinderSearchSelectionPage getCourtfinderSearchSelectionPage(WebDriver driver){
		return new CourtfinderSearchSelectionPage(driver);
	}	
	
	public static CourtfinderPostcodSearchPage getCourtfinderPostcodSearchPage(WebDriver driver){
		return new CourtfinderPostcodSearchPage(driver);
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
	
	public static CourtFinderSearchErrorPage getCourtFinderSearchErrorPage(WebDriver driver){
		return new CourtFinderSearchErrorPage(driver);
	}
	
	public static CourtFinderCourtDetailsPage getCourtFinderCourtDetailsPage(WebDriver driver){
		return new CourtFinderCourtDetailsPage(driver);
	}
	

	public static CourtFinderAddressSearchResultPage getCourtFinderAddressSearchResultPage(
			WebDriver driver) {
		return new CourtFinderAddressSearchResultPage(driver);
	}
	
}
