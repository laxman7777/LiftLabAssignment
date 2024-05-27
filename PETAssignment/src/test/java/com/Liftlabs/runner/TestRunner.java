package com.Liftlabs.runner;

import  io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.Liftlabs.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)



public class TestRunner extends AbstractTestNGCucumberTests {
}


