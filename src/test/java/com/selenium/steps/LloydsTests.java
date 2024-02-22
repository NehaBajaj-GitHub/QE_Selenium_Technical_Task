package com.selenium.steps;

import com.selenium.common.ExcelReader;
import com.selenium.pages.lloydspage.BranchFinderPage;
import com.selenium.pages.lloydspage.BranchPage;
import com.selenium.pages.lloydspage.LlyodsHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Step definitions for Lloyds Bank website tests, including navigation, branch searching, and information retrieval.
 */
public class LloydsTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(LloydsTests.class);
    private final LlyodsHomePage llyodsHomePage;
    private final BranchPage branchPage;
    private final BranchFinderPage branchFinderPage;

    /**
     * Initializes page objects for the Lloyds Bank website.
     */
    public LloydsTests() {
        this.llyodsHomePage = new LlyodsHomePage();
        this.branchPage = new BranchPage();
        this.branchFinderPage = new BranchFinderPage();
    }

    @Given("I'm on Lloyds home page")
    public void i_m_on_lloyds_home_page() {
        LOGGER.info("Opening the Lloyds home page");
        llyodsHomePage.goToHomePage();
    }

    @When("I click findBranch")
    public void i_click_find_branch() {
        LOGGER.info("Clicking on find branch");
        llyodsHomePage.clickFindBranch();
    }

    /**
     * Fills the search box with a postcode from a specified Excel sheet and row number.
     *
     * @param sheetName Name of the Excel sheet.
     * @param rowNumber Row number in the Excel sheet.
     */
    @When("I fill search box from given sheetname {string} and row number {int}")
    public void i_fill_search_box_from_given_sheetname_and_row_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        LOGGER.info("Fetching data from sheet: {}", sheetName);
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> postCodeList = excelReader.getData("src/test/resources/data/PostcodeList.xlsx", sheetName);
        String postcode = postCodeList.get(rowNumber).get("postcode");
        LOGGER.info("Entering the postcode: {}", postcode);

        branchFinderPage.enterSearchTerm(postcode);
    }

    @When("I click searchIcon")
    public void i_click_search_icon() {
        LOGGER.info("Clicking search button");
        branchFinderPage.clickSearchIcon();
    }

    @When("I select nearest branch")
    public void i_select_nearest_branch() {
        LOGGER.info("Selecting nearest branch");
        branchFinderPage.selectNearestBranch();
    }

    @Then("I get phone number of branch")
    public void i_get_phone_number_of_branch() {
        LOGGER.info("Fetching branch phone number");
        branchPage.getBranchPhoneNumber();
    }
}
