package com.SeleniumV4.Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.Base;

public class LoginPageRahulShetty extends Base {
	WebDriver driver;
	
	By username=By.id("inputUsername");
	By password=By.name("inputPassword");
	By resetButton=By.xpath("//button[text()='Reset Login']");
	
	@Test
	public void testLoginPage() throws InterruptedException
	{
		driver=openURL("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(1000);
		driver.findElement(resetButton).click();
		String temp_password=driver.findElement(By.cssSelector(".infoMsg")).getText().split(" ")[4].split("'")[1];
		System.out.println(temp_password);

		driver.findElement(By.className("go-to-login-btn")).click();
		
		Thread.sleep(1000);
		driver.findElement(username).sendKeys("raghu");
		driver.findElement(password).sendKeys(temp_password);
		driver.findElement(By.cssSelector("[class*='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
