package MyHooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class AmazonHooks {
	
	@Before(order = 1)
	public void setUp_browser(Scenario sc) {
		System.out.println("Launch chrome browser");
		System.out.println(sc.getName());
	}
	
	@Before(order = 2)
	public void setUp_Url() {
		System.out.println("Launch amazon app");
	}
	
	@After(order = 1)
	public void tearDown_logout(Scenario sc) {
		System.out.println("Logout from the app");
		System.out.println(sc.getStatus());
	}
	
	@After(order = 2)
	public void tearDown_close() {
		System.out.println("Close the browser");
	}
	
	@BeforeStep
	public void takeScreenshot() {
		System.out.println("Take screenshot before each step");
	}
	
	@AfterStep
	public void refresh() {
		System.out.println("Refresh after each step");
	}
}
