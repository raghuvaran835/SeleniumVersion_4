package com.SeleniumV4.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.Base;

public class AutoCompleteDropDown extends Base{
	WebDriver driver;
	
	@Test
	public void autoCompleteExercise() throws InterruptedException
	{
		String country="Dominica";
		driver=openURL("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
//		Dynamic xpath:
		
//		driver.findElement(By.xpath("//li[@class='ui-menu-item']/div[text()='"+country+"']")).click();
		
//		using keyboard
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.ENTER));
		driver.findElement(By.id("autocomplete")).click();
		
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	

}
