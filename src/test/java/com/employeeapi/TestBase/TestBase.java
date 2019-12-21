package com.employeeapi.TestBase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="51838";
	public static String ExcelFileLoc="C:\\Users\\Gopu\\eclipse-workspace\\RestAssuresTest_Framework\\TestData\\RestAssuredTestData.xlsx";
	public static String ExcelSheet="EmployeeAPI";
	public static String RequestType,BaseURI,URL,Authenticator,AuthenticationParameter,RequestParameters,ResponseType,HeaderVerification,BodyVerification;
	
	public Logger logger;
	
	
	public TestBase() {
		
		logger= Logger.getLogger("EmployeesRestAPI");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

}
