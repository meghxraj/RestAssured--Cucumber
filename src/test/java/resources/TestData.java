package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.location;

public class TestData {

	public AddPlace addPlacePayload(String name,String language, String address) {
		AddPlace sr = new AddPlace();
		sr.setAccuracy(50);
		sr.setAddress(address);
		sr.setLanguage(language);
		sr.setName(name);
		sr.setPhone_number("9877843210");
		sr.setWebsite("www.googley.com");
		List<String> ls= new ArrayList<String>();
		ls.add("type1");
		ls.add("type 2");
		sr.setTypes(ls);
		location loc = new location();
		loc.setLat(38.383494);
		loc.setLng(33.427362);
		sr.setLocation(loc);
		return sr;
	}
	
	public String deletPlacePayload(String placeID) {
		return ("{\r\n  \"place_id\":\""+placeID+"\"\r\n}");
	}
}
