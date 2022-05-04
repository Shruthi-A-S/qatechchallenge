package com.mytheresa.testautomation;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	WebDriver driver;
	static Properties envProperty;
	
	
	@Parameters({"ENV","BROWSER","Username"})
	@BeforeTest
	public void beforeTest(String env,String browser,String userName) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();	
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		
		loadEnvProperty(env);
		driver.get(envProperty.getProperty("ApplicationUrl"));
		printScriptErrors();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	public static void loadEnvProperty(String env) {
		try {
			envProperty = new Properties();
			if(env.equalsIgnoreCase("local")) {
				envProperty.load(new FileReader(new File("./TestData/EnvPropertiesLocal.properties")));
			} else if(env.equalsIgnoreCase("test")) {
				envProperty.load(new FileReader(new File("./TestData/EnvPropertiesTest.properties")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printScriptErrors() {
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		if(!entries.filter(Level.SEVERE).isEmpty()) {
			System.out.println("JavaScript Errors exists");
			printMessages(entries);  
		} else if(!entries.filter(Level.WARNING).isEmpty()) {
			System.out.println("JavaScript WARNING exists");
			printMessages(entries);  
		}
	}
	
	public void printMessages(LogEntries logs) {
		if(logs!=null) {
			for(LogEntry entry:logs) {
				System.out.println(entry.getMessage());
			}
		}
	}
	
	
	@AfterMethod
	public void afterMethod() {
		printScriptErrors();
	}
}
