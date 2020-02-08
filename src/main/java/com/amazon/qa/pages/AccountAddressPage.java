package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class AccountAddressPage extends TestBase{

	
	//Page Factory
	@FindBy(xpath = "//div[@id='ya-myab-plus-address-icon']")
	WebElement NewAddress;
	
	//Initialize page factory
	public AccountAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public List<WebElement> GetEditList() {
		List<WebElement> Edit = driver.findElements(By.xpath("//a[contains(text(),'Edit')]"));
		return Edit;
	}
	
	
	public List<WebElement> GetRemoveList() {
		List<WebElement> Remove = driver.findElements(By.xpath("//a[contains(text(),'Remove')]"));
		return Remove;
	}
	
	public NewAddressPage AddNewAddress() {
		NewAddress.click();
		return new NewAddressPage();
	}
	
}
