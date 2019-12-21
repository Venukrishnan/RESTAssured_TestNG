package com.employeeapi.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.employeeapi.TestBase.TestBase;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class TestSetUp extends XLUtils{
	
	XLUtils xlutils=new XLUtils();
	TestBase testbase=new TestBase();
	public int columnCount;
	public String ExcelLoc;
	public String Excelsheet;
	public String cellValue;
	
	
	public List<String> ReadTestCaseList() throws IOException {
		
		ExcelLoc=TestBase.ExcelFileLoc;
		Excelsheet=TestBase.ExcelSheet;
		
		List<String> testCaseList=new ArrayList<String>();
		
		int rowCount=XLUtils.getRowCount(ExcelLoc, Excelsheet);
		if (rowCount > 0) {
			columnCount=XLUtils.getCellCount(ExcelLoc, Excelsheet, 1);
		}
		
		for (int i=1;i<=rowCount;i++) {
			
			for(int j=0;j<columnCount;j++) {
				
				cellValue=XLUtils.getCellData(ExcelLoc, Excelsheet, i, j+1);
				if (cellValue.equalsIgnoreCase("YES")) {
					
					cellValue=XLUtils.getCellData(ExcelLoc, Excelsheet, i, j);
					testCaseList.add(cellValue);
					
				}
			
			}
		}
		
		return testCaseList;
	}	
	
	
	public List<String> getTestDetails(String testName) throws IOException {
		
		List<String> TestData=new ArrayList<String>();
		int rowCount=XLUtils.getRowCount(ExcelLoc, Excelsheet);
		if (rowCount > 0) {
			columnCount=XLUtils.getCellCount(ExcelLoc, Excelsheet, 0);
			System.out.println("Column count "+columnCount);
		}
		for (int i=1;i<=rowCount;i++) {		
				cellValue=XLUtils.getCellData(ExcelLoc, Excelsheet, i, 0);
				if (cellValue.equalsIgnoreCase(testName)) {
					for (int j=2;j<columnCount;j++) {
						cellValue=XLUtils.getCellData(ExcelLoc, Excelsheet, i, j);
						TestData.add(cellValue);
					}
				break;
				}
		} 
		
		return TestData;
	}
	
	public void assignTestData(String testName) throws IOException {
	
		List<String> TestDataList=new ArrayList<String>();
		TestDataList=getTestDetails(testName);
		TestBase.RequestType=TestDataList.get(0);
		TestBase.BaseURI=TestDataList.get(1);
		TestBase.URL=TestDataList.get(2);
		TestBase.Authenticator=TestDataList.get(3);
		AuthenticationParameter=TestDataList.get(4);
		TestBase.RequestParameters=TestDataList.get(5);
		TestBase.ResponseType=TestDataList.get(6);
		TestBase.HeaderVerification=TestDataList.get(7);
		TestBase.BodyVerification=TestDataList.get(8);
	}
	
	public void intiateExecution() {
		
		RestAssured.baseURI=TestBase.BaseURI;
		
		if (Authenticator!=null) {
			
			switch (Authenticator) {
				
			case "PreemptiveBasicAuthScheme":preemtiveBasicAuthScheme();
			default: System.out.println("Undefined Authenticator"); 	
			
			}
			
		}
		
		TestBase.httpRequest=RestAssured.given();
		if (TestBase.RequestType.equalsIgnoreCase("GET")) {
			
		}
		if (TestBase.RequestType.equalsIgnoreCase("POST")) {
			
		}
	}
	
	public void GETRequest() {
		
		response=httpRequest.request(Method.GET, URL);
	}
	
	public void preemtiveBasicAuthScheme() {
		
		String userName="";
		String password="";
		
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		if (AuthenticationParameter.contains("Username_") || AuthenticationParameter.contains("Password_")) {
			
			if (AuthenticationParameter.contains(":")) {
				
				String[] credentials=AuthenticationParameter.split(":");
				String userName_temp= credentials[0];
				String password_temp= credentials[1];
				String[] credentials_un=userName_temp.split("_");
				userName=credentials_un[0];		
				String[] credentials_pw=password_temp.split("_");
				password=credentials_pw[0];
				
			}
			else if (AuthenticationParameter.contains("Username_")) {
				
				String[] credentials_un=AuthenticationParameter.split("_");
				userName=credentials_un[0];
			}
			else if (AuthenticationParameter.contains("Password_")) {
				
				String[] credentials_pw=AuthenticationParameter.split("_");
				password=credentials_pw[0];
			}
			
		}
		if (userName!=null) {
			
			authscheme.setUserName(userName);
		}
		if (password!=null) {
			
			authscheme.setPassword(password);
		}
		
		RestAssured.authentication=authscheme;
	}

}
