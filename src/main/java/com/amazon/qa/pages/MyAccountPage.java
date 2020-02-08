package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class MyAccountPage extends TestBase{

	//Page Factory
	@FindBy(xpath="//div[@data-card-identifier='AddressesAnd1Click']")
	WebElement AddressPage;
	

	//Initialize page factory
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AccountAddressPage Addresses() {
		AddressPage.click();
		return new AccountAddressPage();
	}
}
