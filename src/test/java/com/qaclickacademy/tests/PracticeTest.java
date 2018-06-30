package com.qaclickacademy.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaclickacademy.baseclass.BaseTest;
import com.qaclickacademy.pages.Homepage;
import com.qaclickacademy.pages.Practicepage;
import com.qaclickacademy.utility.Utilities;

public class PracticeTest extends BaseTest{
	
	Homepage homepage;
	Practicepage practicepage;
		
	public PracticeTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialize();
		homepage=new Homepage();
		practicepage=new Practicepage();
		homepage.clickNoThanksbtn();
		practicepage=homepage.clickPracticeLink();
	}
	
	@DataProvider
	public Object[][] setTestData() throws IOException
	{
		return Utilities.readExcelFile("practice");
	}
	
	@Test(dataProvider="setTestData")
	public void enterinfoTest(String country,String name,String showhide)
	{
		practicepage.enterCountryName(country);
		practicepage.enterCustName(name);
		practicepage.enterShowHide(showhide);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
