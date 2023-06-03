package com.elementLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class shadowDOM {
	
WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.driver.chrome", "D:\\workspace_selenium\\ElementLocatorV1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("tear down");
		driver.quit();
	}
	
	//@Test
	public void shadowDomElements() {
		driver.get("https://books-pwakit.appspot.com/");
		
		WebElement root= driver.findElement(By.tagName("book-app"));
		
		//Javascript executor class is created and assigned to driver by typecasting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowDom1= (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
		
		WebElement appHeader = shadowDom1.findElement(By.cssSelector("[effects=waterfall]"));
		WebElement appToolbar = appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		WebElement bookInputDecorator = appToolbar.findElement(By.tagName("book-input-decorator"));
		
		bookInputDecorator.findElement(By.cssSelector("input#input")).sendKeys("Testing");
		
	}
	
	@Test
	public void shadowDomElements1() {
		driver.get("https://shop.polymer-project.org/");
		
		WebElement shopApp = driver.findElement(By.tagName("shop-app"));
		
		WebElement shadowDom1 = getShadowDom(shopApp, driver);
		
		WebElement ironPages = shadowDom1.findElement(By.cssSelector("iron-pages[role=main]"));
		WebElement shopName = ironPages.findElement(By.tagName("shop-home"));		
		WebElement shadowDom2 = getShadowDom(shopName, driver);
		shadowDom2.findElement(By.cssSelector("div:nth-child(2) > shop-button > a")).click();
		
		
	}
	
	WebElement getShadowDom(WebElement element, WebDriver driver){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", element);
		return shadowDom;
				
	}
	
	
	
	
	
	
	
	
	
	
	

}
