package com.SeleniumV4.Practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintWebPageAsPDF {

	@Test
	public void saveWebPageAsPDF() throws IOException {
		
		// this print web page as pdf will work only in headless mode
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("headless");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		Pdf pdf=((PrintsPage) driver).print(new PrintOptions());
		
		Files.write(Paths.get("./flipkart.pdf"),OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		
	}
}
