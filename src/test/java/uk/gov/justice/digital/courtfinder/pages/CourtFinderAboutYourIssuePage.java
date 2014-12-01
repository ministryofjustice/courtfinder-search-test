package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderAboutYourIssuePage extends SeleniumPage {
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");
	private By findTheRightCourtBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[2]/a");
	private By continueButton = new By.ById("continue");
	private By newClaimRadioButton = new By.ById("spoe-start");
	private By inContactRadioButton = new By.ById("spoe-continue");
	private String expectedTextOnPage = "About your issue";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='spoe-page']/header/h1");

	public CourtFinderAboutYourIssuePage(WebDriver driver) {
		super(driver);
	}

	public void clickHomeBreadcrumbLink() throws Exception {
		click(homeBreadcrumbLink);
	}

	public void clickFindTheRightCourtBreadcrumbLink() throws Exception {
		click(findTheRightCourtBreadcrumbLink);
	}

	public void clickContinueButton() throws Exception {
		click(continueButton);
	}

	public void clickNewClaimRadioButton() throws Exception {
		click(newClaimRadioButton);
	}

	public void clickInContactRadioButton() throws Exception {
		click(inContactRadioButton);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}
}
