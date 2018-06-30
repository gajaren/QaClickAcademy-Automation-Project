package com.qaclickacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaclickacademy.baseclass.BaseTest;

public class Practicepage extends BaseTest{
	
	@FindBy (xpath ="//*[@id='autocomplete']")
	WebElement countryTextField;
	
	@FindBy (id ="name")
	WebElement nameTextField;
	
	@FindBy (name="show-hide")
	WebElement showHideField;
	
	public Practicepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterCountryName(String country)
	{
		countryTextField.sendKeys(country);
	}
	
	public void enterCustName(String custname)
	{
		nameTextField.sendKeys(custname);
	}
	
	public void enterShowHide(String showhide)
	{
		showHideField.sendKeys(showhide);
	}
}
