package com.selenium.common;

/**
 * Utility class containing common functions for use in Selenium tests.
 */
public class CommonFunctions {

    /**
     * Pauses the execution for a specified number of seconds.
     * This method uses Thread.sleep() to introduce a forced wait.
     *
     * @param seconds The number of seconds to wait.
     */
    public void forceWaitForTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000L); // Multiply by 1000 to convert seconds to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Re-interrupt the current thread to handle the InterruptedException properly
            e.printStackTrace();
        }
    }
}
