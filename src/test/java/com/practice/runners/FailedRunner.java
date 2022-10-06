package com.practice.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failedFromFailed-report.html"},
        glue = "com/practice/step_definitions",
        features = "@target/rerun.txt"
)

public class FailedRunner {


}
