package com.qaclickacademy.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qaclickacademy.baseclass.BaseTest;
import com.qaclickacademy.pages.Homepage;
import com.qaclickacademy.pages.Loginpage;
import com.qaclickacademy.pages.Practicepage;

public class HomeTest extends BaseTest{
	
	Homepage homepage;
	Loginpage loginpage;
	Practicepage practicepage;
	
	public static final String LOGIN_PAGE_ERROR = "Could not direct to login page";
	
	public HomeTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		homepage=new Homepage();
		homepage.clickNoThanksbtn();
	}
	
	
	@Test (priority=1)
	public void clickLoginbtnTest()
	{
		loginpage=homepage.clickLoginbtn();
		Assert.assertTrue(loginpage.logInTextIsDisplayed(),LOGIN_PAGE_ERROR);
	}
	
	@Test (priority=2)
	public void clickPracticeLinkTest()
	{
		practicepage=homepage.clickPracticeLink();
		Assert.assertEquals(BaseTest.driver.getTitle(),"Practice Page");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
