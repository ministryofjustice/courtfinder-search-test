package uk.gov.justice.digital.courtfinder.pages;


import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;


public class CourtFinderStartPage extends SeleniumPage {
	private String expectedTextOnPage = "Find the right court or tribunal";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='content']/div/header/h1");
	private By startButton = new By.ById("start-button");
	private By addressSearchLink = new By.ByXPath(
			".//*[@id='search-index-page']/div/div[2]/ul/li[1]/a");
	private By a2ZListLink = new By.ByXPath(
			".//*[@id='search-index-page']/div/div[2]/ul/li[2]/a");
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");

	public CourtFinderStartPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}

	public void clickStartButton() throws Exception {
		click(startButton);
	}

	public void clickAddressSearchLink() throws Exception {
		click(addressSearchLink);
	}

	public void clickA2ZListLink() throws Exception {
		click(a2ZListLink);
	}

	public void clickHomeBreadcrumbLink() throws Exception {
		click(homeBreadcrumbLink);
	}
}
