package com.qaclickacademy.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qaclickacademy.baseclass.BaseTest;
import com.qaclickacademy.pages.Homepage;
import com.qaclickacademy.pages.Loginpage;

public class LoginTest extends BaseTest{
	
	Homepage homepage;
	Loginpage loginpage;
	Logger log=Logger.getLogger(LoginTest.class);
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		homepage=new Homepage();
		loginpage=new Loginpage();
	}
	
	@Test
	public void InvalidLoginTest()
	{
		log.info("Clicking no thanks button");
		homepage.clickNoThanksbtn();
		loginpage=homepage.clickLoginbtn();
		loginpage.enterUserEmail(prop.getProperty("username"));
		loginpage.enterUserPassword(prop.getProperty("password"));
		loginpage=loginpage.clickloginbtn();
		Assert.assertTrue(loginpage.invalidLoginMessage(), "Something is wrong with invalid login");
	}
	
	@AfterMethod
	public void terDown()
	{
		driver.quit();
	}
	
	
}
