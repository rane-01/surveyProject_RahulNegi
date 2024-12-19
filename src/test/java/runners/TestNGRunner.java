package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:/SurveyProject/src/test/resources/features/homePageInvalidCountry.feature",  // Correct file path
    glue = "stepDefinitions",  // Path to your step definition package
    plugin = {"pretty", "html:target/cucumber-reports.html"},  // Optional: output reports
    monochrome = true  // Optional: makes the console output more readable
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    // No need for runCucumber method, TestNGCucumberTests will handle the execution
}
