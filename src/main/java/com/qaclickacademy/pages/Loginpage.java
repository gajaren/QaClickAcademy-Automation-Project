package com.qaclickacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaclickacademy.baseclass.BaseTest;

public class Loginpage extends BaseTest{
	
	@FindBy (xpath = "//h1[contains(text(),'Log In to QaClickAcademy')]")
	WebElement logInText;
	
	@FindBy (id = "user_email")
	WebElement emailField;
	
	@FindBy (id = "user_password")
	WebElement passwordField;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy (xpath= "//div[contains(text(),'Invalid'])")
	WebElement invalidLoginMsg;
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean logInTextIsDisplayed()
	{
		return logInText.isDisplayed();
	}
	
	public void enterUserEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void enterUserPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public Loginpage clickloginbtn()
	{
		loginbtn.click();
		return new Loginpage(); 
	}
	
	public boolean invalidLoginMessage()
	{
		return invalidLoginMsg.isDisplayed();
	}

}
