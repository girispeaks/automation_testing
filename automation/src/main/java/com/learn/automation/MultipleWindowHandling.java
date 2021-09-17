package com.learn.automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandling {
	
	@Test
	public void handleWindows() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String mainWindow = driver.getWindowHandle();
		System.out.println("main window name "+mainWindow);
		//handling a tab
		driver.findElement(By.id("tabButton")).click();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		while(itr.hasNext()){
			String childWindow = itr.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("Child window is "+childWindow);
			}
		
			//if(!itr.equals(mainWindow))
			//	driver.switchTo().window("itr");
		}
		System.out.println("Header of the child window is "+ driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		allWindows.clear();
		//handling a window
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("windowButton")).click();
		allWindows = driver.getWindowHandles();
		itr = allWindows.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("Header of child window "+driver.findElement(By.id("sampleHeading")).getText());
			}
		}
		
		driver.close();
		allWindows.clear();
		//handling message window
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("messageWindowButton")).click();
		allWindows = driver.getWindowHandles();
		itr = allWindows.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				//below code not working.. find out
				//System.out.println("Message is "+driver.findElement(By.xpath("/html/body/")).getText());
			}
		}
		driver.close();
		driver.quit();
		
	}
	

}
