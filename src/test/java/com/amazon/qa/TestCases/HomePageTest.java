package com.amazon.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	
	
    public HomePageTest() throws IOException{
    	super();
    }
    
    @BeforeMethod
    public void SetUp() {
    	Initialization();
    	homePage = new HomePage();
    }
    
    @Test(priority=1)
    public void HomePageTitleTest() {
    	String Title;
    	Title = homePage.HomePageTitle();
    	Assert.assertEquals(Title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }
    
    @AfterMethod
    public void TearDown() {
    	driver.quit();
    }
}
