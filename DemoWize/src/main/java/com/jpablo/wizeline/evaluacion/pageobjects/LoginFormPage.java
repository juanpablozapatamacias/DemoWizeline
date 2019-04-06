package com.jpablo.wizeline.evaluacion.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jpablo.wizeline.evaluacion.base.BasePage;

public class LoginFormPage extends BasePage{
	
	private String user;
	private String password;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public LoginFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillUsername(String value) {
		WebElement ele = super.findElementXpath("//input[@placeholder=\'Username\']");
		ele.sendKeys(value);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillPassword(String value) {
		WebElement ele = super.findElementXpath("//input[@placeholder=\'Password\']");
		ele.sendKeys(value);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MyNotesPage clickNext() {
		WebElement ele = super.findElementXpath("//button[contains(text(),'Login')]");
		ele.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MyNotesPage(driver);
	}
}
