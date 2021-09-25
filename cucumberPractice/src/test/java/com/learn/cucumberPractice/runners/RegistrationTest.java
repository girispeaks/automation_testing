package com.learn.cucumberPractice.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/com/learn/cucumberPractice/feature/Registration.feature"},
				 glue = {"com.learn.cucumberPractice.stepDefinition"},
				 plugin = {"pretty", "json:target/MyReports/report.json"
						           , "junit:target/MyReports/report.xml"
						           , "html:target/MyReports/report.html"},
				 monochrome = true
				 
				 )

public class RegistrationTest {

}
