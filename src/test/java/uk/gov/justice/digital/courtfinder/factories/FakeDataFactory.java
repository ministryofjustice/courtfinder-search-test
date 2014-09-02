package uk.gov.justice.digital.courtfinder.factories;

public class FakeDataFactory {

	
	public static String getCourtFinderStartPageUrl(){
		if (ConfigurationFactory.getEnvironment() == ConfigurationFactory.localEnvironment)
		    return "http://54.72.152.89/";
		return "http://172.31.30.243/";
	}
	

}
