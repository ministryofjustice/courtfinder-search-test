package uk.gov.justice.digital.courtfinder.factories;

public class FakeDataFactory {

	
	public static String getCourtFinderStartPageUrl(){
		if (ConfigurationFactory.getEnvironment().toUpperCase().equalsIgnoreCase(ConfigurationFactory.developmentEnvironment))
		       return "http://54.72.152.89/";
		//return "http://127.0.0.1:8000/";
		//return "http://54.72.152.89/";
		//return "http://ec2-54-171-103-31.eu-west-1.compute.amazonaws.com/";
		return "https://courtfinder-production-187177264.eu-west-1.elb.amazonaws.com/";
	}
	

}
