package com.jpablo.wizeline.evaluacion.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jpablo.wizeline.evaluacion.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginFormPage clickLogin() {
		
		WebElement ele = super.findElementXpath("//button[@type='button']");
		ele.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new LoginFormPage(driver);
	}
}
