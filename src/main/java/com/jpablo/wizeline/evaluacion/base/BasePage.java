package com.jpablo.wizeline.evaluacion.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.jpablo.utilities.CommonUtilities;

//import com.jpablo.utilities.CommonUtilities;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage() {}
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		if (driver==null)
			driver = connectDriver();
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
	
	public WebDriver connectDriver() {
		System.getProperty("browser","");
		
		Properties propSystem = System.getProperties();
		Enumeration e = propSystem.propertyNames();
		
		Map<String,String> propMap = new HashMap<String, String>();
		propMap = CommonUtilities.putSysProps(e, propSystem);
		
		String projectPath = propMap.get("user.dir");
		String propBrowser = propMap.get("browser").trim().toLowerCase();
		String os = propMap.get("os.name").trim().toLowerCase();
				 
		if (propBrowser.isEmpty() || propBrowser == null){
			throw new IllegalArgumentException("Missing parameter value for browser");
		}
		else {
			String http_proxy = System.getProperty("http_proxy", "");
			String https_proxy = System.getProperty("https_proxy", "");
			
			if(os.indexOf("win")>=0) {
				if(propBrowser.contentEquals("chrome")) {
					
					ChromeOptions op = new ChromeOptions();
					
					Proxy proxy = new Proxy();
					proxy.setHttpProxy(http_proxy);
					proxy.setSslProxy(https_proxy);
					
					op.setCapability(CapabilityType.PROXY, proxy);
					
					System.setProperty("webdriver.chrome.driver", 
							projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
					
					driver = new ChromeDriver(op);	
				}
				else if(propBrowser.contentEquals("ff") || 
						propBrowser.contentEquals("firefox")) {
					FirefoxOptions dc = new FirefoxOptions();
					
					Proxy proxy = new Proxy();
					proxy.setHttpProxy(http_proxy);
					proxy.setSslProxy(https_proxy);
					
					dc.setCapability(CapabilityType.PROXY, proxy);
					
					FirefoxProfile profile = new FirefoxProfile();
					profile.setAcceptUntrustedCertificates(false);
					profile.setAssumeUntrustedCertificateIssuer(true);
					profile.setPreference("browser.download.folderList", 2);
					profile.setPreference("browser.helperApps.alwaysAsk.force", false);
					
					dc.setCapability(FirefoxDriver.PROFILE, profile);
					dc.setCapability("marionette", true);
					
					System.setProperty("webdriver.gecko.driver", 
							projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
					System.setProperty("webdriver.firefox.marionette", 
							projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
					driver = new FirefoxDriver(dc);
				}
				else if (propBrowser.contentEquals("ie") || 
						propBrowser.contentEquals("internetexplorer")) {
					System.setProperty("webdriver.ie.driver", 
							projectPath + "\\drivers\\ie\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				else {
					throw new IllegalArgumentException("Browser name is not correct or is not valid...");
				}	
			}
			else if((os.indexOf("nux")>=0) || (os.indexOf("nix")>=0)) {
				if(propBrowser.contentEquals("chrome")) {
					ChromeOptions op = new ChromeOptions();
					
					Proxy proxy = new Proxy();
					proxy.setHttpProxy(http_proxy);
					proxy.setSslProxy(https_proxy);
					
					op.setCapability(CapabilityType.PROXY, proxy);
					
					System.setProperty("webdriver.chrome.driver", 
							projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
					
					driver = new ChromeDriver(op);	
				}
				else if(propBrowser.contentEquals("ff") || 
						propBrowser.contentEquals("firefox")) {
					FirefoxOptions dc = new FirefoxOptions();
					
					Proxy proxy = new Proxy();
					proxy.setHttpProxy(http_proxy);
					proxy.setSslProxy(https_proxy);
					
					dc.setCapability(CapabilityType.PROXY, proxy);
					
					FirefoxProfile profile = new FirefoxProfile();
					profile.setAcceptUntrustedCertificates(false);
					profile.setAssumeUntrustedCertificateIssuer(true);
					profile.setPreference("browser.download.folderLisy", 2);
					profile.setPreference("browser.helperApps.alwaysAsk.force", false);
					
					dc.setCapability(FirefoxDriver.PROFILE, profile);
					dc.setCapability("marionette", true);
					
					System.setProperty("webdriver.gecko.driver", 
							projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
					System.setProperty("webdriver.firefox.marionette", 
							projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
					driver = new FirefoxDriver(dc);
				}
				else {
					throw new IllegalArgumentException("Browser name is not correct or is not valid...");
				}
			}
			else if((os.indexOf("mac")>=0) || (os.indexOf("darwin")>=0)) {
				if(propBrowser.trim().contentEquals("chrome")) {
					ChromeOptions op = new ChromeOptions();
					
					Proxy proxy = new Proxy();
					proxy.setHttpProxy(http_proxy);
					proxy.setSslProxy(https_proxy);
					
					op.setCapability(CapabilityType.PROXY, proxy);
					
					System.setProperty("webdriver.chrome.driver", 
							projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
					
					driver = new ChromeDriver(op);	
				}
				else if(propBrowser.contentEquals("ff") || 
						propBrowser.contentEquals("firefox")) {
					FirefoxOptions dc = new FirefoxOptions();
					
					Proxy proxy = new Proxy();
					proxy.setHttpProxy(http_proxy);
					proxy.setSslProxy(https_proxy);
					
					dc.setCapability(CapabilityType.PROXY, proxy);
					
					FirefoxProfile profile = new FirefoxProfile();
					profile.setAcceptUntrustedCertificates(false);
					profile.setAssumeUntrustedCertificateIssuer(true);
					profile.setPreference("browser.download.folderLisy", 2);
					profile.setPreference("browser.helperApps.alwaysAsk.force", false);
					
					dc.setCapability(FirefoxDriver.PROFILE, profile);
					dc.setCapability("marionette", true);
					
					System.setProperty("webdriver.gecko.driver", 
							projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
					System.setProperty("webdriver.firefox.marionette", 
							projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
					driver = new FirefoxDriver(dc);
				}
				else {
					throw new IllegalArgumentException("Browser name is not correct or is not valid...");
				}
			}
			else {
				throw new IllegalArgumentException("OS out of scope ...");
			}
		}
		return driver;
	}
	
}
