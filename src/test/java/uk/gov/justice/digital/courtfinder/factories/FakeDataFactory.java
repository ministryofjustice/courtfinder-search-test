package uk.gov.justice.digital.courtfinder.factories;

public class FakeDataFactory {

	
	public static String getCourtFinderStartPageUrl(){
		if (ConfigurationFactory.getEnvironment() == ConfigurationFactory.developmentEnvironment)
		    return "http://127.0.0.1:8000/";
		return "http://54.72.152.89/";
	}
	

}
