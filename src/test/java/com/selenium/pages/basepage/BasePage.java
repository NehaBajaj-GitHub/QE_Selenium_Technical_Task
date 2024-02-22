package com.selenium.pages.basepage;

import com.selenium.driver.SetUp;
import com.selenium.driver.Wait;
import org.openqa.selenium.WebDriver;

/**
 * Base class for all page objects.
 * Initializes WebDriver and Wait utility for use in page objects.
 */
public class BasePage {

    protected WebDriver driver; // WebDriver instance for interacting with the web browser
    protected Wait wait; // Wait utility for handling various wait conditions

    /**
     * Constructor for BasePage.
     * Initializes the WebDriver and Wait instances.
     */
    public BasePage() {
        // Retrieve the static driver instance from SetUp class
        this.driver = SetUp.driver;
        // Initialize the Wait utility with the WebDriver instance
        this.wait = new Wait(this.driver);
    }
}
