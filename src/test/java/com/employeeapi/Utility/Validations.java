package com.employeeapi.Utility;

import org.testng.Assert;

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

}
