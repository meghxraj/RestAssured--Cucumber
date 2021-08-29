package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

public class LoginStepDefination extends Utils {
	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	TestData data=new TestData();
	static String place_id;
	
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	  
		
		req = given().spec(requestSpecification())
			.body(data.addPlacePayload(name,language,address)); // now the request is created separately and assigned to RequestSpecification 
		
	}

	@When("user calls the {string} with {string} http request")
	public void user_calls_the_with_http_request(String resource, String method) {
	    
		
		APIResources resourceURI = APIResources.valueOf(resource); //constructor will we called with the value of resource which is passed from the feature
		System.out.println("Resource URI is "+ resourceURI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
			response =req.when().post(resourceURI.getResource());
		else if (method.equalsIgnoreCase("Get"))
			response = req.when().get(resourceURI.getResource());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer statusCode) {

	    assertEquals(response.getStatusCode(),200);
	    
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expvalue) {
	  
		assertEquals(getJsonPath(response,keyValue),expvalue);
	}
	
	@Then("extract the value {string}")
	public void extract_the_value(String keyvalue) {
		
		place_id = getJsonPath(response,keyvalue);
	}
	

	@Then("verify {string} created maps to {string} using {string} with {string} method")
	public void verify_created_maps_to_using_with_method(String key, String expvalue, String resource, String method)  throws IOException {
	    
		req = given().spec(requestSpecification()).queryParam(key,place_id);
		
		user_calls_the_with_http_request(resource, method); //reusing the method which is already created to get resource and methods
		assertEquals(getJsonPath(response,"name"),expvalue);
		System.out.println("Test Completed");
	}
	
	@Given("Delete payload")
	public void delete_payload() throws IOException {
		req = given().spec(requestSpecification()).body(data.deletPlacePayload(place_id));
		
	}


}
