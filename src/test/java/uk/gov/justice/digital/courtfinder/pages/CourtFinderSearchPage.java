package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderSearchPage extends SeleniumPage{
	
	private By homeBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[1]/a");
	private By findCourtBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[2]/a");
	private By searchByPostcodeBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[3]/a");
	private By searchByAddressBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[3]/a");


	public CourtFinderSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickHomeBreadcrumb() throws Exception {
		click(homeBreadcrumb);
		
	}

	public void clickFindACourtBreadcrumb() throws Exception {
		click(findCourtBreadcrumb);
		
	}

	public void clickSearchByPostcodeBreadcrumb() throws Exception {
		click(searchByPostcodeBreadcrumb);
		
	}

	public void clickSearchByAddressCourtBreadcrumb() throws Exception {
		click(searchByAddressBreadcrumb);
		
	}
}
