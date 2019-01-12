package com.crm.qa.pagelayer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.testBase;

public class LoginPage extends testBase {
	
	@FindBy(xpath="//a[@class='navbar-brand']/img[@alt='free crm logo']")
	WebElement crmLogo;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='navbar-collapse']/ul/li[2]/a/font[text()='Sign Up']")
	WebElement signup;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		String title=driver.getTitle();
		return title;
		
	}
	
	public boolean validateCRMLogoOnLoginPage(){
		boolean logodisplayed=crmLogo.isDisplayed();
		return logodisplayed;
	}
	
	public HomePage validateLogin(String Username, String Password) throws InterruptedException{
		username.sendKeys(Username);
		password.sendKeys(Password);
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		
		return new HomePage();
		
	}
	
	
	
	

}
