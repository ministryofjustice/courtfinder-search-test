package uk.gov.justice.digital.courtfinder.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import java.util.List;

import org.openqa.selenium.WebDriver;

import uk.gov.justice.digital.courtfinder.factories.JourneyFactory;
import uk.gov.justice.digital.courtfinder.step.HtmlStepContext;
import uk.gov.justice.digital.courtfinder.step.HtmlStepContextSingleton;
import uk.gov.justice.digital.courtfinder.webdriver.SharedDriver;


public class WebsitePageVerificationSteps {
	
	private final WebDriver driver;
	private final JourneyFactory journeyFactory;
	private HtmlStepContext htmlStepContext = HtmlStepContextSingleton.getInstance();
	
	public WebsitePageVerificationSteps(SharedDriver driver) {
		this.driver = driver;
		journeyFactory = new JourneyFactory(driver);
	}	
	
	@Given("^I verify that the following text exists:$")
	public void i_verify_that_the_following_text_exists(List<List<String>> list) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@Given("^I have the following elements:$")
	public void i_have_the_following_elements(List<List<String>> list) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@When("^I have verified all the elements exist$")
	public void i_have_verified_all_the_elements_exist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I can generate the source code for the page \"(.*?)\"$")
	public void i_can_generate_the_source_code_for_the_page(String filename) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
