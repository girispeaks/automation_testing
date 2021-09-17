package com.learn.cucumberPractice.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/learn/cucumberPractice/feature"},
		glue = {"com.learn.cucumberPractice.stepDefinition"},
		plugin = {"pretty"},
		//tags = "@regression or @smoke"
		tags = "@all"
		)

public class UberTest {

}
