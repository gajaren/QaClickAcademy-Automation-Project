package com.qaclickacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaclickacademy.baseclass.BaseTest;

public class Homepage extends BaseTest{
	
	@FindBy ( xpath = "//span[contains(text(),'Login')]")
	WebElement loginbtn;
	
	@FindBy ( xpath = "//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[6]/div/div/button")
	WebElement noThanksbtn;
	
	@FindBy (xpath = "//a[contains(text(),'Practice')]")
	WebElement practiceLink;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Loginpage clickLoginbtn()
	{
		loginbtn.click();
		return new Loginpage();
	}
	
	public void clickNoThanksbtn()
	{
		noThanksbtn.click();
	}
	
	public Practicepage clickPracticeLink()
	{
		practiceLink.click();
		return new Practicepage();
	}

}
	