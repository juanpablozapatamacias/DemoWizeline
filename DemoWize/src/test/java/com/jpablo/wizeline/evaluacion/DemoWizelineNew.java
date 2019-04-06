package com.jpablo.wizeline.evaluacion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jpablo.wizeline.evaluacion.base.BasePage;
import com.jpablo.wizeline.evaluacion.pageobjects.LoginFormPage;
import com.jpablo.wizeline.evaluacion.pageobjects.LoginPage;
import com.jpablo.wizeline.evaluacion.pageobjects.MyNotesPage;

public class DemoWizelineNew  {

	private WebDriver driver = null;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.gecko.driver","C:\\jpablo\\programacion\\java\\qa\\DemoWize\\drivers\\geckodriver\\geckodriver.exe");
		
		driver = new BasePage(driver).getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://testapp.galenframework.com/");
	}
	
	@Test
	public void login() {
		LoginPage loginMain = new LoginPage(driver);
		
		LoginFormPage form = loginMain.clickLogin();
		form.setUser("testuser@example.com");
		form.setPassword("test123");
		
		form.fillUsername(form.getUser());
		form.fillPassword(form.getPassword());
		
		MyNotesPage notes = form.clickNext();
		
		Assert.assertTrue(notes.isMyNotesVisible(), "Test Case failed ...");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
		System.out.println("Test execution completed ...");
	}

}
