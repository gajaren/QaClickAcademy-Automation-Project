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
	
	public String enterCountryName(String country)
	{
		countryTextField.sendKeys(country);
		return countryTextField.getText();
	}
	
	public String enterCustName(String custname)
	{
		nameTextField.sendKeys(custname);
		return nameTextField.getText();
	}
	
	public String enterShowHide(String showhide)
	{
		showHideField.sendKeys(showhide);
		return showHideField.getText();
	}
}
