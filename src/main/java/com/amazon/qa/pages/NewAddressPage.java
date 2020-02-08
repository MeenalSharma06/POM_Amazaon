package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class NewAddressPage extends TestBase{

	//page Factory
	@FindBy(xpath="//select[@name=\"address-ui-widgets-countryCode\"]")
	WebElement Country;
	
	@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement Name;
		
	@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
	WebElement Phone;

	@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
	WebElement PostalCode;

	@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressLine1\"]")
	WebElement AddressLine1;

	@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressLine2\"]")
	WebElement AddressLine2;

	@FindBy(xpath="//input[@id=\"address-ui-widgets-landmark\"]")
	WebElement Landmark;

	@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressCity\"]")
	WebElement City;
	
	@FindBy(xpath="//select[@name=\"address-ui-widgets-enterAddressStateOrRegion\"]")
	WebElement State;

	@FindBy(xpath="//select[@name=\"address-ui-widgets-addr-details-address-type\"]")
	WebElement AddressType;
	
	@FindBy(xpath="//input[@class='a-button-input'][@type='submit']")
	WebElement SubmitBtn;
		
	//Initialize page factory
	public NewAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void AddNewAddress(String country, String name, String phone, String postalCode, String address1, String address2,
			String landmark, String city, String state, String addressType) {
		
		Select selectCountry = new Select(Country);
		selectCountry.selectByVisibleText(country);
		
		Name.sendKeys(name);
		Phone.sendKeys(phone);
		PostalCode.sendKeys(postalCode);
		TestUtil.ImplicitlyWait(driver);
		AddressLine1.sendKeys(address1);
		AddressLine2.sendKeys(address2);
		Landmark.sendKeys(landmark);
		if (City.getAttribute("value").isEmpty()) {
			City.sendKeys(city); }
		TestUtil.ImplicitlyWait(driver);
		Select selectState = new Select(State);
		selectState.selectByVisibleText(state);
		TestUtil.ImplicitlyWait(driver);
		if (!addressType.isEmpty()) {
			Select selectAddressType = new Select(AddressType);
			selectAddressType.selectByVisibleText(addressType);
		}
		SubmitBtn.click();
		
		
	}	
	
}
