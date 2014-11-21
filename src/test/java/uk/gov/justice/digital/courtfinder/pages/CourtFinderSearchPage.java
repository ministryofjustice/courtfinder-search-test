package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderSearchPage extends SeleniumPage{
	
	private By homeBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[1]/a");
	private By aboutYourIssueBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[3]/a");
	private By findACourtOrTribunalBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[2]/a");
	private By searchByPostcodeBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[4]/a");


	public CourtFinderSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickHomeBreadcrumb() throws Exception {
		click(homeBreadcrumb);
		
	}

	public void clickFindACourtOrTribunalBreadcrumb() throws Exception {
		click(findACourtOrTribunalBreadcrumb);
		
	}

	public void clickAboutYourIssueCourtBreadcrumb() throws Exception {
		click(aboutYourIssueBreadcrumb);
		
	}

	public void clickSearchByPostcodeBreadcrumb() throws Exception {
		click(searchByPostcodeBreadcrumb);
		
	}
}
