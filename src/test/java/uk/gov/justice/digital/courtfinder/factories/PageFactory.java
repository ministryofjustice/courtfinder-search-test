package uk.gov.justice.digital.courtfinder.factories;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAreaOfLawSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderCourtDetailsPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderListViewPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderAddressSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderPostcodeSearchResultPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderPostcodeSearchPage;
import uk.gov.justice.digital.courtfinder.pages.CourtfinderSearchSelectionPage;


public class PageFactory {

	
	public static CourtFinderStartPage getCourtFinderStartPage(WebDriver driver){
		return new CourtFinderStartPage(driver);
	}
	
	public static CourtfinderSearchSelectionPage getCourtfinderSearchSelectionPage(WebDriver driver){
		return new CourtfinderSearchSelectionPage(driver);
	}	
	
	public static CourtfinderPostcodeSearchPage getCourtfinderPostcodSearchPage(WebDriver driver){
		return new CourtfinderPostcodeSearchPage(driver);
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
	
	public static CourtFinderSearchPage getCourtFinderSearchPage(WebDriver driver){
		return new CourtFinderSearchPage(driver);
	}
	
	public static CourtFinderAreaOfLawSelectionPage getCourtFinderAreaOfLawSelectionPage(WebDriver driver){
		return new CourtFinderAreaOfLawSelectionPage(driver);
	}
	
}
