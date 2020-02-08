package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	
	
	//Page Factory
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	//@FindBy(xpath="//a[@id='nav-link-accountList']/descendant::span[@class='nav-line-1']")
	WebElement SignInMenu;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-ya-signin\"]/descendant::span[@class='nav-action-inner']")
	WebElement FlyoutSignInbtn;
	
	@FindBy(xpath="//i[@class=\"a-icon a-icon-logo\"]")
	WebElement MainLogo;	
	
	@FindBy(xpath="//i[@class=\"a-icon a-icon-domain-uk a-icon-domain\"]")
	WebElement DomainLogo;	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchBar;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement SearchGoBtn;
	
	@FindBy(xpath="//a[@id=\"nav-cart\"]")
	WebElement CartBtn;
	
	//Initialize page factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public String HomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateMainLogo() {
		return MainLogo.isDisplayed();
	}
	
	public boolean ValidateDomainLogo() {
		return DomainLogo.isDisplayed();
	}

	public LoginPage GetLoginPage() {
		//Actions actions = new Actions(driver);
		//actions.moveToElement(SignInMenu).build().perform();
		SignInMenu.click();
		TestUtil.ImplicitlyWait(driver);
		//TestUtil.PageLoadTimeout(driver);
		//FlyoutSignInbtn.click();
		//TestUtil.ImplicitlyWait(driver);
		return new LoginPage();
	}
	
	public MyAccountPage GetMyAccountPage() {
		SignInMenu.click();
		//driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		return new MyAccountPage();
	}
	
	public CartPage GetCartPage() {
		CartBtn.click();
		return new CartPage();
	}
	
	public SearchPage GetSearchPage(String SearchText) {
		SearchBar.sendKeys(SearchText);
		SearchGoBtn.click();
		
		return new SearchPage();
	}
}
