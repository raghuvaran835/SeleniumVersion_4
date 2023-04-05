package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorScrollingBehaviour extends Base {

	WebDriver driver;

	@Test
	public void scrollExerciseUsingJSE() throws InterruptedException {
		
//		driver = openURL("https://www.amazon.com.au/");
//		driver= openURL("https://the-internet.herokuapp.com/horizontal_slider");
		driver=openURL("https://the-internet.herokuapp.com/infinite_scroll");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
//	1.Scroll To Specific position:
		
//		js.executeScript("window.scrollTo(0,1500)");
		
//	2.Scroll up to an element:
		
//		WebElement ele=driver.findElement(By.xpath("//h2[text()='New movie: \"The Estate\"']"));
//		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		
//	3. Scroll until bottom of the Page:
		
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
//	4. Horizontal Slider WebElemet 
//		
//		WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
//		
//		slider.sendKeys(Keys.END);
		
		
//	5.scroll WebTable vertical Scroll
		js.executeScript("document.querySelector('.tableFixHead\').scrollTop=5000");
//	6.scroll WebTable vertical Scroll
		js.executeScript("document.querySelector('.tableFixHead').scrollLeft=5000");
		
		
//	5. Scroll dynamically for loading pages
		
		long initialHeight=(Long) js.executeScript("return document.body.scrollHeight");
		
		System.out.println(initialHeight);
		while(true)
		{
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(1000);
			long currentHeight=(Long) js.executeScript("return document.body.scrollHeight");
			
			System.out.println(currentHeight);
			if(initialHeight==currentHeight)
			{
				break;
			}
			initialHeight=currentHeight;
			
		}
	}

}
