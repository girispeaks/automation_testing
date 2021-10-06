package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
				 glue = {"com.qa.stepdefinitions", "AppHooks"},
				 plugin = {"pretty"},
				 monochrome = true)

//"com.aventstack.extentreports.cucumber.adaptor.ExtentCucumberAdaptor:"
public class MyTestRunner {

}


