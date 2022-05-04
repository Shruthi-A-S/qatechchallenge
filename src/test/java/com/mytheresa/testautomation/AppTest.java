package com.mytheresa.testautomation;


import org.testng.Reporter;
import org.testng.annotations.Test;

import junit.framework.Assert;



public class AppTest extends BaseTest{
	
    @Test
    public void aJavaScriptLogs()
    {
    	try {
    		App appComp = new App(driver);
    		appComp.clickElement(Locators.byMyAccount);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
       
    }
    
    @Test
    public void bResponseCode()
    {
    	try {
    		App appComp = new App(driver);
    		appComp.getLinks(Locators.byLinks);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
       
    }
	
	 @SuppressWarnings("deprecation")
	@Test
	    public void verifyValidLogin()
	    {
	    	try {
	    		App appComp = new App(driver);
	    		appComp.loginMytheresa(envProperty.getProperty("EmailID"), envProperty.getProperty("Password"));
	    		Assert.assertEquals(envProperty.getProperty("UserName"), appComp.getText(Locators.byWelcomeMsg));
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	       
	    }
}
