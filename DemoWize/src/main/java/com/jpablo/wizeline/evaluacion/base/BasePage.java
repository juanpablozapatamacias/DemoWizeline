package com.jpablo.wizeline.evaluacion.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		if (driver==null)
			driver = new FirefoxDriver();
		return driver;
	}
	
	public WebElement findElementXpath(String xpath) {
		try {
			return getDriver().findElement(By.xpath(xpath));
		}
		catch(NoSuchElementException e) {
			System.out.println("El elemento no fue encontrado");
		}
		return null;
	}
	
	public List<WebElement> findElementsXpath(String xpath){
		try {
			return getDriver().findElements(By.xpath(xpath));
		}
		catch(NoSuchElementException e) {
			System.out.println("El elemento no fue encontrado");
		}
		return null;
	}
	
}
