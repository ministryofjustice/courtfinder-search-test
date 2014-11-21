package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;



public class CourtFinderStartPage extends SeleniumPage {
	
	private By pageTitle = new By.ByXPath(".//*[@id='content']/div/header/h1");
	private String expectedPageTitleText = "Find the right court or tribunal";
	
	private By startButton = new By.ById("start-button");
	private By addressSearchLink = new By.ByXPath(".//*[@id='search-index-page']/div/div[2]/ul/li[1]/a"); 
	private By a2zListLink = new By.ByXPath("");
	
	public void clickA2ZList() throws Exception{
		click(a2zListLink);
	}

	public CourtFinderStartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartButton() throws Exception{
		click(startButton);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
		return isInnerTextEqualToExpectedText(pageTitle, expectedPageTitleText);
	}

	public void clickaddressSearch() throws Exception {
		click(addressSearchLink);
	}

}
