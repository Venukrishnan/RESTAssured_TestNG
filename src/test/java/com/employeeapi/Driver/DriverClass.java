package com.employeeapi.Driver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.ClassLoaderRepository;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.employeeapi.TestCase.TestCase_Suite;
import com.employeeapi.Utility.TestSetUp;
import com.sun.tools.jxc.gen.config.Classes;

public class DriverClass extends TestSetUp{
	
	static TestSetUp testsetup=new TestSetUp();
	public static XmlClass publicTestClass;
		
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
			
		XmlSuite xmlSuite=new XmlSuite();
		xmlSuite.setName("TestRestAssured");
		xmlSuite.setParallel("false");
		xmlSuite.setVerbose(1);
		
		XmlTest xmlTest=new XmlTest(xmlSuite);
		xmlTest.setName("Test1");
		xmlTest.setPreserveOrder("true");
		
		
		
		List<XmlClass> list=new ArrayList<XmlClass>();
		
		List<String> Testlist=new ArrayList<String>();
		Testlist=testsetup.ReadTestCaseList();
		for (int j=0;j<Testlist.size();j++) {
			Class<?> cb=classLoader(Testlist.get(j));
			publicTestClass=new XmlClass(cb);
			list.add(publicTestClass);
		}
		
		
		
		xmlTest.setXmlClasses(list);
		
		TestNG testng=new TestNG();
		List<XmlSuite> suites=new ArrayList<XmlSuite>();
		suites.add(xmlSuite);
		testng.setXmlSuites(suites);
		
		testng.run();
		
		
	}
	
	public static Class<?> classLoader(String TestName) throws ClassNotFoundException {
		
		String className="com.employeeapi.TestCase."+TestName;
		ClassLoader classLoader = DriverClass.class.getClassLoader();
		Class<?> b=classLoader.loadClass(className);
		return b;
	}

}




//
//TestNG testng=new TestNG();
//testng.setTestClasses(new Class[] {b});
//testng.run();

////@BeforeTest
////public void testSetUp() {
////
////}
////
////
//@Test
//public void TestDriver() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
////
////TestCase_Suite testObject=new TestCase_Suite();
////
////java.lang.reflect.Method m = TestCase_Suite.class.getDeclaredMethod("TC001_GET_F1_Driver");
////m.invoke(testObject);
//
//ClassLoader classLoader = DriverClass.class.getClassLoader();
//try {
//    Class aClass = classLoader.loadClass("com.employeeapi.TestCase.TestCase_Suite");
//    System.out.println("aClass.getName() = " + aClass.getName());
//   
//} catch (ClassNotFoundException e) {
//    e.printStackTrace();
//}
//
//
//
//}


