package uk.gov.justice.digital.courtfinder.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;

public class CourtFinderPostcodeSearchResultPage extends SeleniumPage {
	private String courtName = ".//*[@id='court-results']/li[%d]/h2";
	private String courtAddress = ".//*[@id='court-results']/li[%d]/div/p/span[@class='court-address']";
	private String courtTown = ".//*[@id='court-results']/li[%d]/div/p/span[@class='court-town']";
	private String courtPostcode = ".//*[@id='court-results']/li[%d]/div/p/span[@class='court-postcode']";
	private String courtDX = ".//*[@id='court-results']/li[%d]/div[1]/p[2]/span[2]";
	private String courtNumber = ".//*[@id='court-results']/li[%d]/div[1]/p[2]/span[4]";
	private String moreDetailsLink = ".//*[@id='court-results']/li[%d]/p/a";
	private String areasOfLawList = ".//*[@id='court-results']/li[%d]/div[2]/ul/li";
	private String distanceFromPostcode = ".//*[@id='court-results']/li[%d]/div[3]/p[2]";
	private String googleMap = ".//*[@id='court-results']/li[%d]/div[3]/p[3]/a";
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
	private String expectedTextOnPage = "earch results";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='search-results-page']/header/h1");

	public CourtFinderPostcodeSearchResultPage(WebDriver driver) {
		super(driver);
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

	public boolean verifyNumberOfCourtResultsContainsText(String text)
			throws Exception {
		return getText(numberOfCourtResults).contains(text);
	}

	public String getNumberOfCourtResultsText() throws Exception {
		return getText(numberOfCourtResults);
	}

	public boolean verifyCourtNameText(int row, String courtNameText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtName, row)), courtNameText);
	}

	public boolean verifyCourtNameContainsText(int row, String courtNameText)
			throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(courtName, row)), courtNameText);
	}

	public boolean verifyCourtAddressText(int row, String courtAddressText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtAddress, row)),
				courtAddressText);
	}

	public boolean verifyCourtAddressContainsText(int row,
			String courtAddressText) throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(courtAddress, row)),
				courtAddressText);
	}

	public boolean verifyCourtTownText(int row, String courtTownText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtTown, row)), courtTownText);
	}

	public boolean verifyCourtTownContainsText(int row, String courtTownText)
			throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(courtTown, row)), courtTownText);
	}

	public boolean verifyCourtPostcodeText(int row, String courtPostcodeText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtPostcode, row)),
				courtPostcodeText);
	}

	public boolean verifyCourtPostcodeContainsText(int row,
			String courtPostcodeText) throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(courtPostcode, row)),
				courtPostcodeText);
	}

	public boolean verifyCourtDXText(int row, String courtDXText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtDX, row)), courtDXText);
	}

	public boolean verifyCourtDXContainsText(int row, String courtDXText)
			throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(courtDX, row)), courtDXText);
	}

	public boolean verifyCourtNumberText(int row, String courtNumberText)
			throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(courtNumber, row)),
				courtNumberText);
	}

	public boolean verifyCourtNumberContainsText(int row, String courtNumberText)
			throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(courtNumber, row)),
				courtNumberText);
	}

	public void clickMoreDetailsLink(int row) throws Exception {
		click(new By.ByXPath(String.format(moreDetailsLink, row)));
	}

	public boolean verifyareasOfLawListTextInList(int row, String listItemPath,
			String listItemText) throws Exception {
		List<WebElement> elements = getElements(new By.ByXPath(String.format(
				listItemPath, row)));
		for (int index = 1; index < elements.size(); index++) {
			if (elements.get(index).getText().equalsIgnoreCase(listItemText))
				return true;
		}
		return false;
	}

	public boolean verifyDistanceFromPostcodeText(int row,
			String distanceFromPostcodeText) throws Exception {
		return isInnerTextEqualToExpectedText(
				new By.ByXPath(String.format(distanceFromPostcode, row)),
				distanceFromPostcodeText);
	}

	public boolean verifyDistanceFromPostcodeContainsText(int row,
			String distanceFromPostcodeText) throws Exception {
		return isTextContainedInInnerText(
				new By.ByXPath(String.format(distanceFromPostcode, row)),
				distanceFromPostcodeText);
	}

	public void clickGoogleMap(int row) throws Exception {
		click(new By.ByXPath(String.format(googleMap, row)));
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}
}
