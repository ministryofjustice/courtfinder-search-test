package uk.gov.justice.digital.courtfinder.factories;

public class FakeDataFactory {

	
	public static String getCourtFinderStartPageUrl(){
		if (ConfigurationFactory.getEnvironment().toUpperCase().equalsIgnoreCase(ConfigurationFactory.developmentEnvironment))
		       return "http://54.72.152.89/";
		return "http://127.0.0.1:8000/";
	}
	

}
