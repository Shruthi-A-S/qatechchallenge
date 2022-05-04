package com.mytheresa.testautomation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.*;

/**
 * Mytheresa!
 *
 */
public class App implements Locators
{
	WebDriver driver;
    public App(WebDriver driver)
    {
        this.driver = driver;
    }
    
    public void clickElement(By element) throws InterruptedException {
    	Thread.sleep(5000);
    	driver.findElement(element).click();
    }
    
    public void getLinks(By element) throws Exception{
    	Thread.sleep(5000);
    	List<WebElement> elements = driver.findElements(element);
    	Set<String> linkSet = new HashSet<String>();
    	System.out.println(elements.size());
    	for(WebElement ele:elements) {
    		linkSet.add(ele.getAttribute("href"));
    	}
    	if(linkSet.size()>0) {
    		Iterator<String> setItr = linkSet.iterator();
    		while(setItr.hasNext()) {
    			String url = setItr.next();
    			if(isValidURL(url)) {
    				HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
    				conn.setRequestMethod("HEAD");
    				conn.connect();
    				int respCode = conn.getResponseCode();
    				if(respCode ==200 || (respCode>=300 && respCode <400)) {
    					System.out.println(url+" the page returns 200 or 30x status codes");
    				} else if(respCode>=500) {
    					System.out.println(url+" the page returns no 40x status codes");
    				}
    			}
    		}
    	}
    	System.out.println(linkSet.size());
    }
    
    public boolean isValidURL(String url) {
    	if(url ==null)
    		return false;
    	return url.matches("^(http|https)://.*$");
    }
    
    public void loginMytheresa(String email,String password) throws Exception{
    	Actions action = new Actions(driver);
    	action.moveToElement(driver.findElement(Locators.byMyAccount)).perform();
    	driver.findElement(Locators.byCreateAccount).click();
    	Thread.sleep(5000);
    	driver.findElement(Locators.byEmail).sendKeys(email);
    	driver.findElement(Locators.byPassword).sendKeys(password);
    	driver.findElement(Locators.byLogin).click();
    	Thread.sleep(3000);
    }
    
    public String getText(By element) {
    	return driver.findElement(element).getText();
    }
}
