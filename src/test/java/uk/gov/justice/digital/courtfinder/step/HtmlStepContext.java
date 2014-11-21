package uk.gov.justice.digital.courtfinder.step;

public class HtmlStepContext {
	
	private String postcode;
	
	public void setPostcode(String postcode){
		this.postcode = postcode;
	}
	
	public String getPostcode(){
		return this.postcode;
	}
	
	public void reset(){
		postcode = "";
	}

}
