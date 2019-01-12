package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBase {
	static String filepath;
	static String browser;
	static public Properties prop;
	static public WebDriver driver;

	public testBase(){
		try{
			FileInputStream fip = new FileInputStream(
					"C:\\Goutham\\Eclipse workspace\\SampleMavenProject\\src\\main\\java\\com\\crm\\configurations\\config.properties");
			prop = new Properties();
			prop.load(fip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		
	}

	public void Initialize() {
		browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Goutham\\Software Dump\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Goutham\\Software Dump\\Gecko driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));

	}

}
