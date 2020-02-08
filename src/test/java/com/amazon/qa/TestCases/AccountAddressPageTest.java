package com.amazon.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AccountAddressPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.MyAccountPage;
import com.amazon.qa.pages.NewAddressPage;
import com.amazon.qa.util.TestUtil;

public class AccountAddressPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	AccountAddressPage accAddressPage;
	NewAddressPage newAddress;
	
    public AccountAddressPageTest() throws IOException{
    	super();
    }
    
    @BeforeMethod
    public void SetUp() {
    	Initialization();
    	homePage = new HomePage();
    	loginPage = homePage.GetLoginPage();
    	loginPage.Login(prop.getProperty("user"), prop.getProperty("pass"));
    	myAccountPage = homePage.GetMyAccountPage();
    	accAddressPage = myAccountPage.Addresses();
    }
    
    @DataProvider
    public Object[][] GetAmazonTestData(){
    	Object data[][] = TestUtil.GetTestData("Addresses");
    	return data;
    }
    
    @Test(priority=1, dataProvider = "GetAmazonTestData")
    public void AddnewAddress(String country, String name, String phone, String postalCode, String address1, String address2,
			String landmark, String city, String state, String addressType) {
    	newAddress= accAddressPage.AddNewAddress();
    	TestUtil.PageLoadTimeout(driver);
    	newAddress.AddNewAddress(country, name, phone, postalCode, address1, address2,
    			landmark, city, state, addressType);
    }
    
    @AfterMethod
    public void TearDown() {
    	driver.quit();
    }
    

}
