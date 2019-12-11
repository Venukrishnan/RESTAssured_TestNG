package com.employeeapi.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.employeeapi.TestBase.TestBase;

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
	
	

}
