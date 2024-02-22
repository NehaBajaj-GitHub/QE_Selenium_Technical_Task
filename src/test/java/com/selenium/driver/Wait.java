package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Custom wait utility to facilitate explicit and forced waits in Selenium tests.
 */
public class Wait {

    private WebDriver driver;

    /**
     * Constructor to initialize the Wait utility with a WebDriver instance.
     * @param driver The WebDriver instance for executing waits.
     */
    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits until a specific condition is met or the timeout expires.
     * @param condition The condition that must be met.
     * @param timeoutMessage The message to display if the timeout is exceeded.
     * @param timeout The maximum time to wait for the condition (in seconds).
     */
    private void waitUntilCondition(ExpectedCondition<?> condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    /**
     * Waits for the page to complete loading.
     * @param timeout The maximum time to wait for the page to load (in seconds).
     */
    public void forLoading(int timeout) {
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    /**
     * Implements a forced wait or sleep for a specified duration.
     * @param timeToWait The time to wait in seconds.
     */
    public void forceWait(int timeToWait) {
        try {
            Thread.sleep(timeToWait * 1000L); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            e.printStackTrace();
        }
    }
}
