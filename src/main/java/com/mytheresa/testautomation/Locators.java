package com.mytheresa.testautomation;

import org.openqa.selenium.By;

public interface Locators {

	public static final By byMyAccount = By.id("myaccount");
	public static final By byLinks = By.tagName("a");
	public static final By byCreateAccount = By.xpath("//div[@class='new-users']//button");
	public static final By byEmail = By.xpath("//div[@id='qa-login-email']//input");
	public static final By byPassword = By.xpath("//div[@id='qa-login-password']//input");
	public static final By byLogin = By.xpath("//div[@id='qa-login-button']//button");
	public static final By byWelcomeMsg = By.xpath("//li/p[@class='welcome-msg']");
}
