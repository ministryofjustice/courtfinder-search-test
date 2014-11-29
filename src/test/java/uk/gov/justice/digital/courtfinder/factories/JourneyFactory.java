package uk.gov.justice.digital.courtfinder.factories;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.pages.CourtFinderAreaOfLawSearchSelectionPage;
import uk.gov.justice.digital.courtfinder.pages.CourtFinderStartPage;


public class JourneyFactory {
	
	private final WebDriver driver;


	public JourneyFactory(WebDriver driver) {
		this.driver = driver;
		
	}


	
	public void getCourtFinderStartPageJourney() throws Exception{
		driver.get(FakeDataFactory.getCourtFinderStartPageUrl());
		PageFactory.getCourtFinderStartPage(driver).verifyOnPage();
	}
	
	
	public void getCourtFinderAreaOfLawSelectionPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		PageFactory.getCourtFinderStartPage(driver).clickStartButton();
	}

	public void getCourtFinderPostcodeSearchPageJourney(String areaOfLaw) throws Exception{
		getCourtFinderStartPageJourney();
		PageFactory.getCourtFinderStartPage(driver).clickStartButton();
		CourtFinderAreaOfLawSearchSelectionPage page = PageFactory.getCourtFinderAreaOfLawSearchSelectionPage(driver);
		if (areaOfLaw.equalsIgnoreCase("adoption"))
		       page.clickAdoptionRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("bankruptcy"))
			   page.clickBankruptcyRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("children"))
				   page.clickChildrenRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("civil partnership"))
				   page.clickCivilPartnershipRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("crime"))
				   page.clickCrimeRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("divorce"))
				   page.clickDivorceRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("employment"))
				   page.clickEmploymentRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("forced marriage"))
				   page.clickForcedMarriageRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("housing possession"))
				   page.clickHousingPosessionRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("immigration"))
				   page.clickImmigrationRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("money claims"))
				   page.clickMoneyClaimsRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("probate"))
				   page.clickProbateRadiobutton();
			else if (areaOfLaw.equalsIgnoreCase("social security"))
				   page.clickSocialSecurityRadiobutton();
			else
				throw new Exception("Unknown area of law: " + areaOfLaw);
			page.clickContinueButton();	
	}
	
	public void getCourtFinderAddressSearchPageJourney() throws Exception{
		getCourtFinderStartPageJourney();
		PageFactory.getCourtFinderStartPage(driver).clickAddressSearchLink();
	}
	

}
