package com.learn.automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {
	
	@Test
	public void frames() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/guru99home/");
		//int noOfFrames = driver.findElements(By.tagName("iframe")).size();
		//System.out.println("No of Frames "+noOfFrames);
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("html/body/a/img")).click();
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String childWindow : allWindows)
			if(!mainWindow.equals(childWindow))
				driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//*[@id=\"post-542\"]/div/div/p[4]/a")).isDisplayed();
		
		//*[@id="post-542"]/div/div/p[4]/a
		
	}

}
