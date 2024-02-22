package com.selenium.common;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to generate detailed HTML reports from Cucumber JSON output
 * using the Masterthought Cucumber Reporting tool.
 */
public class GenerateReport {

    /**
     * Generates HTML reports from Cucumber JSON files.
     */
    public static void generateMasterthoughtReport() {
        try {
            // Directory where the report will be saved
            File reportOutputDirectory = new File("target/cucumber-reports");

            // List of Cucumber JSON files to be included in the report
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("target/cucumber-reports/CucumberTestReport.json"); // Path to JSON file

            // Project name displayed in the report
            String projectName = "LloydsSeleniumTest";

            // Configuration for the report
            Configuration configuration = new Configuration(reportOutputDirectory, projectName);

            // Creating and generating the report
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();
        } catch (Exception e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
        }
    }
}
