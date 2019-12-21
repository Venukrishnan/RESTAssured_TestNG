package com.employeeapi.TestCase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import com.employeeapi.TestBase.TestBase;
import com.employeeapi.Utility.TestSetUp;

public class TC001_GET_WeatherCity extends TestBase{
	
	public TestSetUp tsu;
	public TC001_GET_WeatherCity() {
		
		super();
	}
	
	@BeforeTest
	public void testSetupIntialization() throws IOException {
		
		String nameofClass=this.getClass().getSimpleName();
		System.out.println("Class Name"+nameofClass);	
		tsu.assignTestData(nameofClass);
		tsu.intiateExecution();
	}

}
