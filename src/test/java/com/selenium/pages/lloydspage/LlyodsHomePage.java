package com.selenium.pages.lloydspage;

import com.selenium.driver.SetUp;
import com.selenium.pages.basepage.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page object for Lloyds Bank's homepage.
 */
public class LlyodsHomePage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(LlyodsHomePage.class);
    private static final String HOME_PAGE_URL = "https://www.lloydsbank.com/";

    // WebElement for the 'Find a branch' icon.
    @FindBy(xpath = "//span[contains(text(),'Find a branch')]")
    private WebElement findBranchIcon;

    /**
     * Constructor to initialize web elements on the Lloyds Bank homepage.
     */
    public LlyodsHomePage() {
        PageFactory.initElements(SetUp.driver, this);
    }

    /**
     * Navigates to the Lloyds Bank homepage and waits for the page to load completely.
     */
    public void goToHomePage() {
        LOGGER.info("Navigating to the Lloyds Bank homepage.");
        driver.get(HOME_PAGE_URL);
        wait.forLoading(10); // Waits up to 10 seconds for page loading to complete.
    }

    /**
     * Clicks on the 'Find a branch' icon after ensuring it is visible on the page.
     */
    public void clickFindBranch() {
        LOGGER.info("Scrolling to and clicking on 'Find a branch'.");
        // Scrolls the 'Find a branch' icon into view.
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", findBranchIcon);

        wait.forLoading(2); // Waits briefly to let UI settle.

        findBranchIcon.click();
    }
}
