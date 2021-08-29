Feature: Validate Place API

@AddPlace
 Scenario Outline: Verify if Place is added successfully with Add API
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls the "addPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And extract the value "place_id"
    And verify "place_id" created maps to "<name>" using "getPlaceAPI" with "Get" method

    Examples: 
      | name        | language | address |
      | RestAssured | java     | mysore  |
  #   | Selenium		| webdriver | google |
  
@DeletePlace 
Scenario: Verify if Delete place API functionality is working
	Given Delete payload
  When user calls the "deletePlaceAPI" with "POST" http request
  Then the API call is success with status code 200
  And "status" in response body is "OK"
  
  #test comment for git command