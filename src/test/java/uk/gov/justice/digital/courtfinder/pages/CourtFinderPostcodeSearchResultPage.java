package uk.gov.justice.digital.courtfinder.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderPostcodeSearchResultPage extends SeleniumPage {
	private String expectedTextOnPage = "earch results";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='search-results-page']/header/h1");
	private By homeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li/a");
	private By findTheRightCourtBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[2]/a");
	private By aboutYourIssueBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[3]/a");
	private By searchByPostcodeBreadcrumbLink = new By.ByXPath(
			".//*[@id='global-breadcrumb']/ol/li[4]/a");
	private By numberOfCourtResults = new By.ByXPath(
			".//*[@id='number-of-results']");
	private String courtName = ".//*[@id='court-results']/li[1]/h2";
	private String courtAddress = ".//*[@id='court-results']/li[%d]/div/p/span[@class='court-address']";
	private String courtTown = ".//*[@id='court-results']/li[%d]/div/p/span[@class='court-town']";
	private String courtPostcode = ".//*[@id='court-results']/li[%d]/div/p/span[@class='court-postcode']";
	private String courtDX = ".//*[@id='court-results']/li[%d]/div[1]/p[2]/span[2]";
	private String courtNumber = ".//*[@id='court-results']/li[%d]/div[1]/p[2]/span[4]";
	private String moreDetailsLink = ".//*[@id='court-results']/li[%d]/p/a";
	private String areasOfLawList = ".//*[@id='court-results']/li[%d]/div[2]/ul/li";
	private String distanceFromPostcode = ".//*[@id='court-results']/li[%d]/div[3]/p[2]";
	private String googleMap = ".//*[@id='court-results']/li[%d]/div[3]/p[3]/a";

	public CourtFinderPostcodeSearchResultPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}

	public void clickHomeBreadcrumbLink() throws Exception {
		click(homeBreadcrumbLink);
	}

	public void clickFindTheRightCourtBreadcrumbLink() throws Exception {
		click(findTheRightCourtBreadcrumbLink);
	}

	public void clickAboutYourIssueBreadcrumbLink() throws Exception {
		click(aboutYourIssueBreadcrumbLink);
	}

	public void clickSearchByPostcodeBreadcrumbLink() throws Exception {
		click(searchByPostcodeBreadcrumbLink);
	}

	public boolean verifyNumberOfCourtResultsText(String text) throws Exception {
		return getText(numberOfCourtResults).equalsIgnoreCase(text);
	}

	public boolean verifycourtName(int row, String courtNameText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtName, row)), courtNameText);
	}

	public boolean verifycourtAddress(int row, String courtAddressText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtAddress, row)),
				courtAddressText);
	}

	public boolean verifycourtTown(int row, String courtTownText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtTown, row)), courtTownText);
	}

	public boolean verifycourtPostcode(int row, String courtPostcodeText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtPostcode, row)),
				courtPostcodeText);
	}

	public boolean verifycourtDX(int row, String courtDXText) throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtDX, row)), courtDXText);
	}

	public boolean verifycourtNumber(int row, String courtNumberText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtNumber, row)),
				courtNumberText);
	}

	public void clickMoreDetailsLink(int row) throws Exception {
		click(new By.ByXPath(String.format(moreDetailsLink, row)));
	}

	public boolean verifyareasOfLawListTextInList(int row, String textItem)
			throws Exception {
		List<WebElement> elements = getElements(new By.ByXPath(String.format(
				areasOfLawList, row)));
		for (int index = 1; index < elements.size(); index++) {
			if (elements.get(index).getText().equalsIgnoreCase(textItem))
				return true;
		}
		return false;
	}

	public boolean verifydistanceFromPostcode(int row,
			String distanceFromPostcodeText) throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(distanceFromPostcode, row)),
				distanceFromPostcodeText);
	}

	public void clickGoogleMap(int row) throws Exception {
		click(new By.ByXPath(String.format(googleMap, row)));
	}
}
