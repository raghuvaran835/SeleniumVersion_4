package com.SeleniumV4.Practice;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT extends Base{
	
	@Test
	public void fileUploadExercise() throws InterruptedException, IOException
	{
		WebDriver driver=openURL("https://the-internet.herokuapp.com/upload");
		
		Actions act=new Actions(driver);
		
		WebElement upload=driver.findElement(By.xpath("//input[@name='file']"));
		act.moveToElement(upload).click().build().perform();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\raghuvr\\Documents\\AutoIT Script\\fileupload.exe");
		
	}
	
	@Test
	public void fileDownloadAndVerify() throws InterruptedException
	{
		// download the file in default download folder
		WebDriver driver=openURL("https://the-internet.herokuapp.com/download");
		
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
		//Verify the file in download directory
		File f=new File("C:\\Users\\raghuvr\\Downloads\\some-file.txt");
		if(f.exists())
		{
			System.out.println("file downloaded successfully");
		}
	}
	
	@Test
	public void fileDownloadWithSpecificDirectoryAndVerify() throws InterruptedException
	{
		// download the file in Specific location
		String downloadPath=System.getProperty("user.dir")+"\\download";
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//setting the download path
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    chromePrefs.put("download.default_directory", downloadPath);
	    options.setExperimentalOption("prefs", chromePrefs);
	    
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/download");
		
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
		
		File f=new File(downloadPath+"/some-file.txt");
		if(f.exists())
		{
			System.out.println("file downloaded successfully");
			if(f.delete())
			{
				System.out.println("File deleted Successfully");
			}
		}
		else
		{
			System.out.println("file not downloaded");
		}
		
	}

}
