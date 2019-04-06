package com.jpablo.wizeline.evaluacion.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jpablo.wizeline.evaluacion.base.BasePage;

public class MyNotesPage extends BasePage {
	
	public MyNotesPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isMyNotesVisible() {
		boolean band = false;
		WebElement ele = super.findElementXpath("//h2[contains(text(),\'My Notes\')]");
		if(ele.isDisplayed()) band = true;
		return band;
	}
}
