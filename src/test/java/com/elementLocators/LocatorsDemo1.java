package com.elementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocatorsDemo1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.driver.chrome", "D:\\workspace_selenium\\ElementLocatorV1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("tear down");
		driver.quit();
	}

	//@Test
	public void validatingSearchInEcommerce() {		
		
		driver.get("http://automationpractice.com/index.php");
		
		//ID& name
		driver.findElement(By.id("search_query_top")).sendKeys("Tshirt");
		driver.findElement(By.name("submit_search")).click();
		
		//linkText, Partial Linked Text
		driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Chiffon Dress")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		//tagName, class name
		//Mostly tagName and className used to locate multiple elements on web page
		//To find total slides
		int sliderNo = driver.findElements(By.className("homeslider-container")).size();
		System.out.println(sliderNo);
		
		//ToFind link counts
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
	}
	
	//@Test
	public void enterUserNamePasswordInFB() {
		
		driver.get("https://www.facebook.com/");
		
		//Tag & CLASS
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("lnuqqys#4&&##");
		//Tag & ID
		driver.findElement(By.cssSelector("input#pass")).sendKeys("asplaq331208ldl");
		//Tag & attribute
		driver.findElement(By.cssSelector("button[name=login]")).click();
		
		boolean res=driver.findElement(By.cssSelector("img._97vu")).isDisplayed();
		System.out.println(res);
		
		
	}
	
	//@Test
	public void absXpath() {
				
		driver.get("http://automationpractice.com/index.php");
		
		//absolute xpath
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]")).sendKeys("Tshirt");
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();
			
	}
	
	//@Test
	public void relXpath() {
		
		driver.get("http://automationpractice.com/index.php");
		
		//relative xpath
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Tshirt");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	}
	
	//@Test
	public void relXpathWithOr() {
		
		driver.get("http://automationpractice.com/index.php");
		
		//relative xpath with OR
		driver.findElement(By.xpath("//input[@type='text' or @placeholder='Search']")).sendKeys("Tshirt");
		driver.findElement(By.xpath("//button[@type='submit' or @name='submit_search']")).click();
		
	}
	//@Test
	public void relXpathWithAnd() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//input[@type='text' and @autocomplete='off']")).sendKeys("Tshirt");
		driver.findElement(By.xpath("//button[@type='submit' and @name='submit_search']")).click();
		
	}
	//@Test
	public void relXpathWithContains() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//input[contains(@class,'query')]")).sendKeys("Tshirt");
		driver.findElement(By.xpath("//button[contains(@type,'ubm')]")).click();
	}
	
	//@Test
	public void relXpathWithStartsWith() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//input[starts-with(@id,'sear')]")).sendKeys("Tshirt");
		driver.findElement(By.xpath("//button[starts-with(@name,'submit')]")).click();
	}
	
	@Test
	public void relXpathText() {
		driver.get("http://automationpractice.com/index.php");
		boolean res=driver.findElement(By.xpath("//a[text()='Contact us']")).isDisplayed();
		System.out.println(res);
		driver.findElement(By.xpath("//a[text()='Contact us']")).click();
	}
	
	@Test
	public void relXpathChained() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//form[@id='searchbox']//input[@name='search_query']")).sendKeys("Tshirt");
		driver.findElement(By.xpath("//form[@id='searchbox']//button[@type='submit']")).click();
		
	}
	
	
	
	
	
	
	
	
	
}
