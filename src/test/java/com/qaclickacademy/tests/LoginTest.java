package com.qaclickacademy.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qaclickacademy.baseclass.BaseTest;
import com.qaclickacademy.pages.Homepage;
import com.qaclickacademy.pages.Loginpage;

public class LoginTest extends BaseTest{
	
	Homepage homepage;
	Loginpage loginpage;
	
	public static final String LOGIN_ASSERT_FAIL = "Something is wrong with Invalid Login message.";
		
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
		homepage.clickNoThanksbtn();
		loginpage=homepage.clickLoginbtn();
		loginpage.enterUserEmail(prop.getProperty("username"));
		loginpage.enterUserPassword(prop.getProperty("password"));
		loginpage=loginpage.clickloginbtn();
		Assert.assertTrue(loginpage.invalidLoginMessage(), LOGIN_ASSERT_FAIL);
	}
	
	@AfterMethod
	public void terDown()
	{
		driver.quit();
	}
	
	
}
