package com.SeleniumV4.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.base.Base;

public class MultipleTabAndMultipleWindowPractice extends Base {
	
// 	Topics Covered
//		1.Multiple Tabs 
//		2.Multiple Window
//		3.Partial Screenshot
//		4.get the dimension of the web element

	WebDriver driver;

	@Test
	public void multipleTabExercise() throws IOException, InterruptedException {
		driver = openURL("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();

		String parentTab = it.next();
		String childTab = it.next();
		driver.switchTo().window(childTab);
		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver
				.findElements(By
						.cssSelector("div[class='lower-content'] a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(3).getText();

		driver.switchTo().window(parentTab);
		WebElement name=driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		
		//Finding height and width of the WebElement
		System.out.println("Height:"+name.getRect().getDimension().height);
		System.out.println("Height:"+name.getRect().getDimension().width);
		
		//Taking Screenshot of Specific webElement
		
		File src=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Screenshots\\nameEditbox.png"));
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void multipleWindowExercise() throws InterruptedException {
		driver = openURL("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver
				.findElements(By
						.cssSelector("div[class='lower-content'] a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(4).getText();
		driver.switchTo().window(parentWindow);
		WebElement name=driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		
		//Finding height and width of the WebElement
		System.out.println("Height:"+name.getRect().getDimension().height);
		System.out.println("Height:"+name.getRect().getDimension().width);
		
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void nestedFramesExercise()
	{
		driver=openURL("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();

		//In order to access the nested frame(frame-middle), first we need to switch to parent frame(frame-top)
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
	}
}
