package com.selenium.driver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Initializes the WebDriver for Selenium tests.
 * Utilizes WebDriverManager to automate the management of the driver binary.
 */
public class SetUp {

    public static WebDriver driver; // Static WebDriver instance to be shared across tests.

    /**
     * Sets up the ChromeDriver using WebDriverManager and opens a browser window.
     * This method is annotated with @Before to ensure it runs before any Cucumber scenario.
     */
    @Before
    public static void openBrowser() {
        WebDriverManager.chromedriver().setup(); // Automatically sets up the ChromeDriver.
        driver = new ChromeDriver(); // Initializes the ChromeDriver.
        driver.manage().window().maximize(); // Maximizes the browser window.
    }

}
