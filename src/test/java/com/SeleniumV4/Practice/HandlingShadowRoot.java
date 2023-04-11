package com.SeleniumV4.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.Base;

public class HandlingShadowRoot extends Base {
	WebDriver driver;

	@Test
	public void shadowRootPractice() {
		driver = openURL("chrome://downloads/");

		WebElement root1 = driver.findElement(By.cssSelector("downloads-manager"));
		SearchContext shadowRoot1 = (SearchContext) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", root1);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("#toolbar"));
		SearchContext shadowRoot2 = (SearchContext) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", root2);

		WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
		SearchContext shadowRoot3 = (SearchContext) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", root3);

		WebElement root4 = shadowRoot3.findElement(By.cssSelector("cr-toolbar-search-field"));
		SearchContext shadowRoot4 = (SearchContext) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", root4);

		WebElement searchElement = shadowRoot4.findElement(By.cssSelector("#searchInput"));
		searchElement.sendKeys("Hello");

	}

	@Test
	public void svgElementsPractice() throws InterruptedException
	{
		driver=openURL("https://www.covid19india.org/");
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div/div[9]/div[1]"))).click();
		
		
		List<WebElement> graphPoints = driver.findElements(By.xpath("(//*[name()='svg' and @preserveAspectRatio='xMidYMid meet'])[6]//*[local-name()='circle']"));
 
		Actions action = new Actions(driver);
		for(WebElement point: graphPoints) 
		{
			action.moveToElement(point).perform();
			System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']/div/h2")).getText());
		}
	}

}
