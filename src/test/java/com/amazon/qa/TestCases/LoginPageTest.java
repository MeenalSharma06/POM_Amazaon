package com.amazon.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	
    public LoginPageTest() throws IOException{
    	super();
    }
    
    @BeforeMethod
    public void SetUp() {
    	Initialization();
    	homePage = new HomePage();
    	loginPage = homePage.GetLoginPage();
    }
    
    @Test(priority=1)
    public void LoginPageTitleTest() {
    	String Title;
    	Title = loginPage.LoginPageTitle();
    	Assert.assertEquals(Title, "Amazon Sign In");
    }
    
    @AfterMethod
    public void TearDown() {
    	driver.quit();
    }
    
}