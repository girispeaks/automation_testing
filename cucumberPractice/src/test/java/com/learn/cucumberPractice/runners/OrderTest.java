package com.learn.cucumberPractice.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/com/learn/cucumberPractice/feature/Order.feature"},
				 glue = {"com.learn.cucumberPractice.stepDefinition", "MyHooks"},
				 plugin = {"usage", "json:target/MyReports/report.json"
						           , "junit:target/MyReports/report.xml"
						           , "html:target/MyReports/report.html"},
				 monochrome = true
				 
				 )
public class OrderTest {

}
