package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderFooterPage extends SeleniumPage {
	private String expectedTextOnPage = "All content is available under the";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='content']/div/header/h1");
	private By footerHelp = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/ul/li[1]/a");
	private By footerCookiesLink = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/ul/li[2]/a");
	private By footerContactLink = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/ul/li[3]/a");
	private By footerCymraegLink = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/ul/li[4]/a");
	private By footerApiLink = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/ul/li[5]/a");
	private By footerMOJDigitalServicesLink = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/ul/li[6]/a");
	private By footerOpenLicenseLink = new By.ByXPath(
			".//*[@id='footer']/div/div/div[1]/div/p/a");
	private By footerCrownCopyright = new By.ByXPath(
			".//*[@id='footer']/div/div/div[2]/a");

	public CourtFinderFooterPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}

	public void clickFooterHelp() throws Exception {
		click(footerHelp);
	}

	public void clickFooterCookiesLink() throws Exception {
		click(footerCookiesLink);
	}

	public void clickFooterContactLink() throws Exception {
		click(footerContactLink);
	}

	public void clickFooterCymraegLink() throws Exception {
		click(footerCymraegLink);
	}

	public void clickFooterApiLink() throws Exception {
		click(footerApiLink);
	}

	public void clickFooterMOJDigitalServicesLink() throws Exception {
		click(footerMOJDigitalServicesLink);
	}

	public void clickFooterOpenLicenseLink() throws Exception {
		click(footerOpenLicenseLink);
	}

	public void clickFooterCrownCopyright() throws Exception {
		click(footerCrownCopyright);
	}
}
