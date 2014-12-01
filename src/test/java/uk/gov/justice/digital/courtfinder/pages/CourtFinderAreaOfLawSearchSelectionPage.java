package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderAreaOfLawSearchSelectionPage extends SeleniumPage {
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");
	private By findTheRightCourtBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[2]/a");
	private By allAreasOfLawRadiobutton = new By.ByXPath(".//*[@id='aol-0']");
	private By adoptionRadiobutton = new By.ByXPath(".//*[@id='aol-1']");
	private By bankruptcyRadiobutton = new By.ByXPath(".//*[@id='aol-2']");
	private By childrenRadiobutton = new By.ByXPath(".//*[@id='aol-3']");
	private By civilPartnershipRadiobutton = new By.ByXPath(".//*[@id='aol-4']");
	private By crimeRadiobutton = new By.ByXPath(".//*[@id='aol-5']");
	private By domesticViolenceRadioButton = new By.ByXPath(".//*[@id='aol-6']");
	private By divorceRadiobutton = new By.ByXPath(".//*[@id='aol-7']");
	private By employmentRadiobutton = new By.ByXPath(".//*[@id='aol-8']");
	private By forcedMarriageRadiobutton = new By.ByXPath(".//*[@id='aol-9']");
	private By housingPosessionRadiobutton = new By.ByXPath(
			".//*[@id='aol-10']");
	private By immigrationRadiobutton = new By.ByXPath(".//*[@id='aol-11']");
	private By moneyClaimsRadiobutton = new By.ByXPath(".//*[@id='aol-12']");
	private By probateRadiobutton = new By.ByXPath(".//*[@id='aol-13']");
	private By socialSecurityRadiobutton = new By.ByXPath(".//*[@id='aol-14']");
	private By continueButton = new By.ByXPath(".//*[@id='continue']");
	private String expectedTextOnPage = "About your issue";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='content']/div/header/h1");

	public CourtFinderAreaOfLawSearchSelectionPage(WebDriver driver) {
		super(driver);
	}

	public void clickHomeBreadcrumbLink() throws Exception {
		click(homeBreadcrumbLink);
	}

	public void clickFindTheRightCourtBreadcrumbLink() throws Exception {
		click(findTheRightCourtBreadcrumbLink);
	}

	public void clickAllAreasOfLawRadiobutton() throws Exception {
		click(allAreasOfLawRadiobutton);
	}

	public void clickAdoptionRadiobutton() throws Exception {
		click(adoptionRadiobutton);
	}

	public void clickBankruptcyRadiobutton() throws Exception {
		click(bankruptcyRadiobutton);
	}

	public void clickChildrenRadiobutton() throws Exception {
		click(childrenRadiobutton);
	}

	public void clickCivilPartnershipRadiobutton() throws Exception {
		click(civilPartnershipRadiobutton);
	}

	public void clickCrimeRadiobutton() throws Exception {
		click(crimeRadiobutton);
	}

	public void clickDomesticViolenceRadioButton() throws Exception {
		click(domesticViolenceRadioButton);
	}

	public void clickDivorceRadiobutton() throws Exception {
		click(divorceRadiobutton);
	}

	public void clickEmploymentRadiobutton() throws Exception {
		click(employmentRadiobutton);
	}

	public void clickForcedMarriageRadiobutton() throws Exception {
		click(forcedMarriageRadiobutton);
	}

	public void clickHousingPosessionRadiobutton() throws Exception {
		click(housingPosessionRadiobutton);
	}

	public void clickImmigrationRadiobutton() throws Exception {
		click(immigrationRadiobutton);
	}

	public void clickMoneyClaimsRadiobutton() throws Exception {
		click(moneyClaimsRadiobutton);
	}

	public void clickProbateRadiobutton() throws Exception {
		click(probateRadiobutton);
	}

	public void clickSocialSecurityRadiobutton() throws Exception {
		click(socialSecurityRadiobutton);
	}

	public void clickContinueButton() throws Exception {
		click(continueButton);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}
}
