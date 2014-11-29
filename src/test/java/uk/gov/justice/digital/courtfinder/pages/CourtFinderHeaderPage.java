package uk.gov.justice.digital.courtfinder.pages;


import org.openqa.selenium.WebDriver;
import uk.gov.justice.digital.courtfinder.page.SeleniumPage;
import org.openqa.selenium.By;


public class CourtFinderHeaderPage extends SeleniumPage {
	private String expectedTextOnPage = "All content is available under the";
	private By expectedTextOnPageSelector = new By.ByXPath(
			".//*[@id='content']/div/header/h1");
	private By govUKLink = new By.ByXPath(".//*[@id='logo']");
	private By betaLink = new By.ByXPath(
			".//*[@id='global-header']/div/div[2]/div/a[2]");
	private By feedbackLink = new By.ByXPath(".//*[@id='feedback-banner']/a");

	public CourtFinderHeaderPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyOnPage() throws Exception {
		waitForPageLoaded();
		return isTextContainedInInnerText(expectedTextOnPageSelector,
				expectedTextOnPage);
	}

	public void clickGovUKLink() throws Exception {
		click(govUKLink);
	}

	public void clickBetaLink() throws Exception {
		click(betaLink);
	}

	public void clickFeedbackLink() throws Exception {
		click(feedbackLink);
	}
}
