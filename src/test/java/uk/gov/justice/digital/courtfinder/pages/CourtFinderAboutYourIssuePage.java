package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderAboutYourIssuePage extends SeleniumPage {
	private String expectedTextOnPage = "About your issue";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='spoe-page']/header/h1");
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");
	private By findTheRightCourtBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[2]/a");
	private By continueButton = new By.ById("continue");
	private By newClaimRadioButton = new By.ById("spoe-start");
	private By inContactRadioButton = new By.ById("spoe-continue");

	public CourtFinderAboutYourIssuePage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}

	public void homeBreadcrumbLinkClick() throws Exception {
		click(homeBreadcrumbLink);
	}

	public void findTheRightCourtBreadcrumbLinkClick() throws Exception {
		click(findTheRightCourtBreadcrumbLink);
	}

	public void continueButtonClick() throws Exception {
		click(continueButton);
	}

	public void newClaimRadioButtonClick() throws Exception {
		click(newClaimRadioButton);
	}

	public void inContactRadioButtonClick() throws Exception {
		click(inContactRadioButton);
	}
}
