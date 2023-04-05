package com.SeleniumV4.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import com.base.Base;


public class RelativeLocatorsPractice extends Base {

	WebDriver driver;

	@Test
	public void newRelativeLocators()
	{
		driver=openURL("https://rahulshettyacademy.com/angularpractice/");
		
//		1)above(WebElement) ->below example email box is above the password:

			WebElement password = driver.findElement(By.id("exampleInputPassword1"));
			WebElement email = driver.findElement(with(By.tagName("input")).above(password));
			email.sendKeys("xyz@gmail.com");

//		2)below(WebElement)

			WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
			driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

//		3)toLeftOf(WebElement)

			WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
			driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

//		4)toRightOf(WebElement)

			WebElement rdb = driver.findElement(By.id("inlineRadio1"));
			System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
			
			driver.quit();
	}

}
