package com.employeeapi.Utility;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Validations {
	
	public void verifyContentType(String actual, String expected) {
		
		Assert.assertEquals(actual, expected,"Content Type not matching");
		
	}
	
	public void verifyStatusCode(int actual, int expected) {
		
		Assert.assertEquals(actual, expected,"Status code not matching");
		
	}
	
	public void verifyStatusLine(String actual, String expected) {
		
		Assert.assertEquals(actual, expected,"Status line not matching");
	}
	
	public void verifyResponseBody(String responseBody, String expected) {
		
		Assert.assertEquals(expected.contains(expected), true, "Expected string not found");
	}
	
	public void verifyHeaderValidations(String actual, String expected) {
		
		Assert.assertEquals(actual, expected,"Header value "+actual+" not matching");
	}
	
	public void verifyJSONVal(String JSONNode, String expected, Response response) {
		
		JsonPath jsonpath=response.jsonPath();
		String actual=jsonpath.get(JSONNode);
		Assert.assertEquals(actual, expected,"Value not matching "+"Expected: "+expected+" Actual: "+actual);
	}
}
