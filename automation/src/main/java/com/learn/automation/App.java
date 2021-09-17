package com.learn.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static WebDriver driver;
    public static void main( String[] args )
    {
    	
        	//ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
             driver =new ChromeDriver();        
           // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); -->deprecated
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.findElement(By.name("q")).sendKeys("Selenium Testing");
            driver.findElement(By.name("btnK")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           // driver.findElement(By.xpath("//div[@id=\"rso\"]/div[1]/div[1]/div[1]/div[1]/div[1]/a")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //Scrolling of page
            //driver.get("http://demo.guru99.com/test/newtours/register.php");
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@class=\"d6cvqb\"]/span")));
           // driver.findElement(By.xpath("//*[@id=\"xjs\"]/table/tbody/tr/td[3]")).click();
            for(int i=3; i<=5; i++) {
            	String str = "//*[@id=\"xjs\"]/table/tbody/tr/td["+i+"]";
            	System.out.println("xpath "+str);
            	//App.clickButton("//*[@id=\"xjs\"]/table/tbody/tr/td[\"+i+\"]",driver);
            App.clickButton(str, driver);
            }
            
            
           /* Select dropdown = new Select(driver.findElement(By.name("country")));
            List<WebElement> options=dropdown.getOptions();
            System.out.println(options.size());
            for(WebElement name : options) {
            	if(name.getText().contains("WESTERN"))          
            	System.out.println(name.getText());
            }
            dropdown.selectByValue("INDIA");*/
            
    
    }
    
    public static void clickButton(String xpath, WebDriver d) {
    	d.findElement(By.xpath(xpath)).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    }
}
