package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"org/example/StepDefs"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.json",
                "rerun:target/rerun.txt"},
        tags = "@smoke"

)

public class Runners extends AbstractTestNGCucumberTests {
}
