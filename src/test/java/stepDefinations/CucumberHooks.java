package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class CucumberHooks {

	@Before //before condition of Cucumber and not junit 
	public void beforeScenario() throws IOException {
		//execute this code only when place id is null
		LoginStepDefination sd = new LoginStepDefination();
		if(LoginStepDefination.place_id==null) {
			sd.add_place_payload_with("Megharaj", "Kannada", "Kundapura");
			sd.user_calls_the_with_http_request("addPlaceAPI", "post");
			sd.extract_the_value("place_id");
		}
	}
	
}
