package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import com.thoughtworks.selenium.webdriven.commands.IsChecked;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtfinderSearchSelectionPage extends SeleniumPage {
	
	private By pageTitle = new By.ByXPath(".//*[@id='search-index-page']/header/h1");
	private String expectedPageTitle =  "Find the right court or tribunal";
	
	private By postcodeSearch = new By.ByXPath(".//*[@id='start-button']");
	private By addressSearch  = new By.ByXPath(".//*[@id='search-index-page']/ul/li[1]/a");
	private By listView       = new By.ByXPath(".//*[@id='search-index-page']/ul/li[2]/a");
	
	private By breadcrumbHome = new By.ByXPath(".//*[@id='global-breadcrumb']/ol/li/a");
	
	
	private By continueButton  = new By.ById("continue");
	
	
	public void clickPostcodeSearch() throws Exception{
		click(postcodeSearch);
	}
	
	public void clickaddressSearch() throws Exception{
		click(addressSearch);
	}
	
	public void clickListView() throws Exception{
		click(listView);
	}

	public CourtfinderSearchSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyOnPage() throws Exception{
		waitForPageLoaded();
	  	return isTextContainedInInnerText(pageTitle, expectedPageTitle);
	}

	public void clickHomeBreadcrumb() throws Exception {
		click(breadcrumbHome);		
	}

	public boolean verifyDefaultPageSettings() throws Exception {
		return isSelected(addressSearch);
	}

	public boolean verifySearchByNameIsSelected() throws Exception {
		return isSelected(addressSearch);
		
	}

}
