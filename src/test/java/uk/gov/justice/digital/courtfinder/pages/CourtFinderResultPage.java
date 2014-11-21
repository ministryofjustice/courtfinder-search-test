package uk.gov.justice.digital.courtfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import uk.gov.justice.digital.courtfinder.page.SeleniumPage;

public class CourtFinderResultPage extends SeleniumPage {
	
	protected By courts = new By.ByXPath(".//*[@id='court-results']/li");
	protected String courtTitle = ".//*[@id='court-results']/li[%d]/h2";
	protected String courtAddress = ".//*[@id='court-results']/li[%d]//*[@class='court-address']";
	protected String courtTown   = ".//*[@id='court-results']/li[1]//*[@class='court-town']";
	protected String courtPostcode   = ".//*[@id='court-results']/li[1]//*[@class='court-postcode']";
	protected By numberOfResults = new By.ById("number-of-results");	
	protected String courtAreaOfLaws = ".//*[@id='court-results']/li[%d]//*[@class='court-aol']/ul/li";
	protected String courtAreaOfLaw = ".//*[@id='court-results']/li[%d]//*[@class='court-aol']/ul/li[%d]/span";
	protected By homeBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[1]/a");
	protected By findCourtBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[2]/a");
    protected By searchByPostcodeBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[2]/a");
    protected By searchByAddressBreadcrumb = new By.ByXPath(".//*[@role='breadcrumbs']/li[2]/a");
    
    protected String courtTitleLink = ".//*[@id='court-results']/li[%d]/p/a";
    
	
	public void clickHomeBreadcrumb() throws Exception {
		click(homeBreadcrumb);
		
	}

	public void clickFindACourtBreadcrumb() throws Exception {
		click(findCourtBreadcrumb);
		
	}
	
	public void clickSearchByAddressBreadcrumb() throws Exception {
		click(searchByAddressBreadcrumb);
		
	}

	public void clickSearchByPostcodeBreadcrumb() throws Exception {
		click(searchByPostcodeBreadcrumb);
		
	}

	public CourtFinderResultPage(WebDriver driver) {
		super(driver);
	}

	public int getNumberOfResults() throws Exception{
		try
		{
			return getElements(courts).size();
		}catch( Exception e){
			return 0;
		}
	}	
	
	
	public int getNumberOfResultsShownInTextLabel() throws Exception{
		String result = "";
		try
		{
			result = getText(numberOfResults);
		}catch( Exception e){
			return -1;
		}
		return Integer.valueOf(result);
	}	
	
	public boolean verifyCourtResults(String courts) throws Exception {
		String[] results = courts.split(",");
		String courtName = "";
		boolean courtFound = false;
        //loop results
		for (int resultIndex = 1; resultIndex <= getNumberOfResults(); resultIndex++ ){
		   courtName = (getCourtNameAtIndex(resultIndex));
		   courtFound =false;
		   for (int index = 0; index < results.length;index++){
			   if (courtName.equalsIgnoreCase(results[index]))
				  courtFound = true;
		    }
		if (courtFound)
			break;
		}
		return courtFound;
	}
	
	public boolean verifyNumberOfCourtsFound(int numberOfCourtsFound) throws NumberFormatException, Exception {
		return ( getNumberOfResults() == numberOfCourtsFound);
	}	
	
	public String getCourtNameAtIndex(int index) throws Exception{
		String text = getText(new By.ByXPath(String.format(courtTitle, index))); 
		return text;
	}
	
	public String getCourtAddressAtIndex(int index) throws Exception{
		String text = getText(new By.ByXPath(String.format(courtAddress, index))); 
		return text;
	}
	
	public String getCourtPostcodeAtIndex(int index) throws Exception{
		String text = getText(new By.ByXPath(String.format(courtPostcode, index))); 
		return text;
	}
	
	public String getCourtTownAtIndex(int index) throws Exception{
		String text = getText(new By.ByXPath(String.format(courtTown, index))); 
		return text;
	}
	
	public int getNumberOfAreasOfCourtForCourt(int courtIndex){
		try
		{
			return getElements(new ByXPath(String.format(courtAreaOfLaws,courtIndex))).size();
		}catch( Exception e){
			return 0;
		}		
	}
	
	public String getCourtTownAtIndex(int courtIndex, int courtAreaOfLawIndex) throws Exception{
		String text = getText(new By.ByXPath(String.format(courtAreaOfLaw, courtIndex,courtAreaOfLawIndex))); 
		return text;
	}
	

}
