package com.selenium.pages.lloydspage;

import com.selenium.driver.SetUp;
import com.selenium.pages.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page object for the Branch Finder page functionality.
 */
public class BranchFinderPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(BranchFinderPage.class);

    // WebElement for the search box input field.
    @FindBy(id = "q")
    private WebElement searchBox;

    // WebElement for the search button/icon.
    @FindBy(xpath = "//button[@class='search-button Locator-button Locator-button--search']")
    private WebElement searchIcon;

    // WebElement for the nearest branch selection icon/link.
    @FindBy(xpath = "(//a[@class='Teaser-titleLink'])[1]")
    private WebElement nearestBranchIcon;

    /**
     * Initializes web elements with Selenium's PageFactory.
     */
    public BranchFinderPage() {
        PageFactory.initElements(SetUp.driver, this);
    }

    /**
     * Enters a search term into the search box and waits briefly.
     * @param searchTerm The term to be searched.
     */
    public void enterSearchTerm(String searchTerm) {
        logger.info("Entering search term: {}", searchTerm);
        searchBox.sendKeys(searchTerm);
        wait.forceWait(2); // Wait for 2 seconds after entering the search term.
    }

    /**
     * Clicks the search icon/button and waits briefly.
     */
    public void clickSearchIcon() {
        logger.info("Clicking the search icon.");
        searchIcon.click();
        wait.forceWait(2); // Wait for 2 seconds after clicking the search icon.
    }

    /**
     * Selects/clicks the nearest branch icon/link.
     */
    public void selectNearestBranch() {
        logger.info("Selecting the nearest branch.");
        nearestBranchIcon.click();
    }

}
