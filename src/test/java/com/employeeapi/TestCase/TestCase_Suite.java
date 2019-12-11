package com.employeeapi.TestCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employeeapi.TestBase.TestBase;

public class TestCase_Suite extends TestBase{

	
	@Test
	public void TC001_GET_F1_Driver() {
		System.out.println("Test");	
	}
	
	@BeforeTest
	public void bTest() {
		System.out.println("Before Test");
	}
	
}
