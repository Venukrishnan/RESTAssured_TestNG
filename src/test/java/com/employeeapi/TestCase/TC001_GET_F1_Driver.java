package com.employeeapi.TestCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.employeeapi.TestBase.TestBase;

public class TC001_GET_F1_Driver extends TestBase{
	
	public TC001_GET_F1_Driver() {
		super();
	}
	
	@BeforeTest
	public void setuptest() {
		String nameofClass=this.getClass().getSimpleName();
		System.out.println("Class Name"+nameofClass);	
	}
	
	@Test
	public void aTest() {
		System.out.println("Test");	
	}
	
	@Test
	public void bTest() {
		System.out.println("Before Test");
	}

}
