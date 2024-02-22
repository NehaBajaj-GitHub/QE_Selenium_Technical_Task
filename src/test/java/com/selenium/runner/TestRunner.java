package com.selenium.runner;

import com.selenium.common.GenerateReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.selenium.driver.SetUp;

/**
 * Runner class for Cucumber tests specifically tagged for Lloyds.
 * Initializes and tears down WebDriver before and after the test suite.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Directory path of the Cucumber feature files
        glue = {"com.selenium.steps"}, // Base package for step definitions and hooks
        tags = "@Lloyds", // Filter: Only executes tests tagged with "@Lloyds"
        dryRun = false, // When true, checks step definitions against features without executing them
        plugin = {"pretty","json:target/cucumber-reports/CucumberTestReport.json"}// Generates reports in a readable format
)
public class TestRunner {

    /**
     * Initializes the WebDriver before any tests run.
     * This setup method runs once before the entire test suite.
     */
    @BeforeClass
    public static void setUp() {
        SetUp.openBrowser(); // Opens the browser as per configuration in SetUp class
    }

    /**
     * Closes the WebDriver after all tests have completed.
     * This teardown method runs once after the entire test suite.
     */
    @AfterClass
    public static void tearDown() {
        SetUp.driver.quit(); // Properly closes the browser and ends the WebDriver session
    }

    @AfterClass
    public static void generateReport() {
        GenerateReport.generateMasterthoughtReport();
    }
}
