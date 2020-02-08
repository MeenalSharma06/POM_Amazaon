package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class LoginPage extends TestBase{

	//PageFactory
	@FindBy(name="email")
	WebElement UserID;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement ContinueBtn;
	
	@FindBy(id="signInSubmit")
	WebElement SignInBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement ForgotPassLink;
	
	@FindBy(xpath="//a[contains(text(),'Change')]")
	WebElement ChangeLink;
	
	@FindBy(name="rememberMe")
	WebElement rememberMeCheckBox;

	@FindBy(xpath="//i[@class=\"a-icon a-icon-logo\"]")
	WebElement MainLogo;	
	
	@FindBy(xpath="//i[@class=\"a-icon a-icon-domain-uk a-icon-domain\"]")
	WebElement DomainLogo;	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateMainLogo() {
		return MainLogo.isDisplayed();
	}
	
	public boolean ValidateDomainLogo() {
		return DomainLogo.isDisplayed();
	}
	
	public boolean ValidateUserID(String User) {
		UserID.sendKeys(User);
		ContinueBtn.click();
		TestUtil.PageLoadTimeout(driver);
		return SignInBtn.isDisplayed();
	}
	
	public boolean ValidateSignIn(String Pass) {
		Password.sendKeys(Pass);
		SignInBtn.click();
		TestUtil.PageLoadTimeout(driver);
		return (!SignInBtn.isDisplayed());
	}
	
	public void Login(String user, String pass) {
		UserID.sendKeys(user);
		ContinueBtn.click();
		TestUtil.PageLoadTimeout(driver);
		Password.sendKeys(pass);
		SignInBtn.click();
		TestUtil.PageLoadTimeout(driver);
	}
	
}

