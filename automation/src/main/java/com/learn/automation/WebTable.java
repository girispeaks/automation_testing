package com.learn.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
	@Test
	public static void accessWebTable() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testuserautomation.github.io/WebTable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int rows = driver.findElements(By.xpath("//table/tbody/tr")).size();
		int colms = driver.findElements(By.xpath("//table/tbody/tr[1]/th")).size();
		//print 3rd row 2nd column
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
		System.out.println("Third row --- second column element is "+ele.getText());
		
		
		//click the checkbox based on the name Diaz
		//SoftAssert sa = new SoftAssert();
		String name = "Diaz";
		for(int i=2;i<=rows;i++)
			for(int j=2;j<=colms;j++) {
				String findName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(findName.equals(name)) {
					driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input")).click();
					Assert.assertTrue(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input")).isSelected());
				}
				//break;
			}
		//sa.assertAll();
		
	}

}	
