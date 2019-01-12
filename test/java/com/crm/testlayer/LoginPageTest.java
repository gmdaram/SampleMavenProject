package com.crm.testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pagelayer.*;
import com.crm.qa.base.testBase;

public class LoginPageTest extends testBase {
	
	public static LoginPage loginpage;
	public static HomePage homepage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		Initialize();
		loginpage=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageCRMLogoTest()
	{
		Assert.assertTrue(loginpage.validateCRMLogoOnLoginPage());
		
	}
	
	@Test(priority=0)
	public void loginPageTitleTest(){
		Assert.assertEquals(loginpage.validateLoginPageTitle(),"#1 Free CRM software in the cloud for sales and service","Login page title is not as expected");
	}
	
	@Test(priority=2)
	public void validateLoginTest() throws InterruptedException{
		homepage=loginpage.validateLogin(prop.getProperty("Username"), prop.getProperty("Pwd"));
		
		
	}
	
	@AfterMethod
	public void dispose(){
		driver.quit();
	}
	
	

}
