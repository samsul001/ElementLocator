package com.elementLocators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class xpathAxesDemo1 {

	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.driver.chrome", "D:\\workspace_selenium\\ElementLocatorV1\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closingBrowser() {
		driver.quit();
	}
	
	//@Test
	public void xpathAxes() {
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		//self node
		String text = driver.findElement(By.xpath("//a[contains(text(),'DCM Shriram')]/self::a")).getText();
		System.out.println("Text capture from self node is: "+text);
		
		//parent node
		String text1 = driver.findElement(By.xpath("//a[contains(text(),'DCM Shriram')]/parent::td")).getText();
		System.out.println("Text capture from parent node is: "+text1);
		
		//ancestor node
		String text2=driver.findElement(By.xpath("//a[contains(text(),'DCM Shriram')]/ancestor::tr")).getText();
		System.out.println("Text capture from ancestor node is: "+text2);
		
		//child node
		List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'Cyient Ltd.')]/ancestor::tr/child::*"));
		System.out.println("Size of child node is: "+childs.size());
		
		//descendant
		List<WebElement> descendants = driver.findElements(By.xpath("//a[contains(text(),'Motilal Oswal Financ')]/ancestor::tr/descendant::*"));
		System.out.println("Size of descendants node is: "+descendants.size());
		
		//Following
		List<WebElement> followingNodes = driver.findElements(By.xpath("//a[contains(text(),'Motilal Oswal Financ')]/ancestor::tr/following::tr"));
		System.out.println("Size of following node is: "+followingNodes.size());
		
		//Preceding
		List<WebElement> precedingNodes = driver.findElements(By.xpath("//a[contains(text(),'Motilal Oswal Financ')]/ancestor::tr/preceding::td"));
		System.out.println("Size of preceding node is: "+precedingNodes.size());
		
		//Following-sibling
		List<WebElement> followingSiblingNodes=driver.findElements(By.xpath("//a[contains(text(),'Motilal Oswal Financ')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Size of following sibling node is: "+followingSiblingNodes.size());
		
		//Preceding sibling
		List<WebElement> PrecedingSiblingNodes=driver.findElements(By.xpath("//a[contains(text(),'Motilal Oswal Financ')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Size of preceding sibling node is: "+PrecedingSiblingNodes.size());
		}
	
	@Test
	public void findXpathAxesExamples() {
		
		//Find the sign up button from the registration form in the Facebook apllication (child)
		driver.get("https://www.facebook.com/r.php");
		WebElement signUpButton=driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[10]/button"));
		System.out.println("Signup button is present: "+signUpButton.isDisplayed());
		
		//find firstname field from SignUp button in facebook (parent)
		//System.out.println(driver.findElement(By.xpath("//button[@id='u_0_14_Qt']/parent::*/parent::*/child::div[1]/div/div[1]")).isDisplayed());
		
		//Identify password from mobile number field in facebook (Following) 
		//System.out.println(driver.findElement(By.xpath("//input[@id='u_0_s_go']/following::input[2]")).isDisplayed());
		
		//locate mobile number from new password field in facebook (preceding)
		System.out.println("Mobile number is present: "+driver.findElement(By.xpath("//input[@id='password_step_input']/preceding::input[2]")).isDisplayed());
		
		//locate surname from female radio button in facebook (ancestor)
		//System.out.println("Surname is present: "+driver.findElement(By.xpath("//input[@id='u_0_4_P1']/ancestor::div[2]/div[1]/div/div[2]")).isDisplayed());
		
		//identify the search text box from the google search button present in the google seach home page (parent)
		driver.get("https://www.google.com/");
		System.out.println("Google searc is present: "+driver.findElement(By.xpath("//input[@name='btnK']/parent::*/parent::*/parent::*/child::div[1]")).isDisplayed());
		
		
		//identify Best Sellers link from the amazon search box present in the amazon home page (Following)
		driver.get("https://www.amazon.in/");
		System.out.println("Best seller link is present: "+driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/following::a[text()='Best Sellers']")).isDisplayed());
		
		//Identify the Hello, sign in from the amazon search text box present in the amazon home page (Following)
		System.out.println("Hello, sign in link is present: "+driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/following::span[text()='Hello, Sign in']")).isDisplayed());
		
		//ientify mobile link which is part of menu bar-amazon (Descendant)
		System.out.println("Mobile link is present in menu bar-amazon: "+driver.findElement(By.xpath("//div[@id='nav-xshop']/descendant::a[text()='Mobiles']")).isDisplayed());
		
	}
	

}
