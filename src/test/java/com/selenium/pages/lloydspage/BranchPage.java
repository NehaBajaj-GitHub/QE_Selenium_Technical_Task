package com.selenium.pages.lloydspage;

import com.selenium.pages.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertNotNull;
import com.selenium.driver.SetUp;

/**
 * Page object for interacting with the Branch Details page.
 * Provides functionality to retrieve and validate the branch's phone number.
 */
public class BranchPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(BranchPage.class);

    // WebElement for the branch's main phone number.
    @FindBy(id = "phone-main")
    private WebElement phoneNumber;

    /**
     * Constructor that initializes web elements on the Branch Details page.
     */
    public BranchPage() {
        PageFactory.initElements(SetUp.driver, this);
    }

    /**
     * Validates and prints the branch's phone number.
     * Asserts that the phone number is present and logs it to the console.
     */
    public void getBranchPhoneNumber() {
        // Assert that the phone number is not null and print it.
        String phoneText = phoneNumber.getText();
        assertNotNull("Phone number was not found", phoneText);
        logger.info("Branch Phone Number: {}", phoneText);

       /* if (SetUp.driver != null) {
            SetUp.driver.quit();
        }*/
    }

}
