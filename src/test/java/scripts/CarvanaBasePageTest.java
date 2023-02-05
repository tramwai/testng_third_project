package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaBasePage;
import utilities.TestData;
import utilities.Waiter;

public class CarvanaBasePageTest extends CarvanaBase{


    @BeforeMethod
    public void setPage(){
        carvanaBasePage = new CarvanaBasePage();
    }

    /**
    Test Case 1:
        Test name = Validate Carvana home page title and url
        Test priority = 1
        Given user is on "https://www.carvana.com/"
        Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
        And validate url equals  "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndURL(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
    }

    /**
    Test Case 2:
        Test name = Validate the Carvana logo
        Test priority = 2
        Given user is on "https://www.carvana.com/"
        Then validate the logo of the “Carvana” is displayed
     */

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateLogo() {
        Waiter.waitForVisibilityOfElement(carvanaBasePage.logo, 30);
        Assert.assertTrue(carvanaBasePage.logo.isDisplayed());
    }

    /**
    Test Case 3:
        Test name = Validate the main navigation section items
        Test priority = 3
        Given user is on "https://www.carvana.com/"
        Then validate the navigation section items below are displayed
        |HOW IT WORKS     	|
        |ABOUT CARVANA    	|
        |SUPPORT & CONTACT	|
     */
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavItems(){
        Waiter.pause(30);
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(carvanaBasePage.mainNavigationItems.get(i).isDisplayed());
            Assert.assertEquals(carvanaBasePage.mainNavigationItems.get(i).getText(),
                                                    TestData.mainNavigationItemsText[i]);
        }
    }

    /**
    Test Case 4:
        Test name = Validate the sign in error message
        Test priority = 4
        Given user is on "https://www.carvana.com/"
        When user clicks on “SIGN IN” button
        Then user should be navigated to “Sign in” modal
        When user enters email as johndoe@gmail.com
        And user clicks on "CONTINUE" button
        And user enters password as "abcd1234"
        And user clicks on "SIGN IN" button
        Then user should see error message as "Email address and/or password combination is incorrect.
     */
    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInErrorMessage(){
        // user clicks on “SIGN IN” button
        carvanaBasePage.signInButton.click();
        // user should be navigated to “Sign in” modal
        // When user enters email as johndoe@gmail.com
        Waiter.waitForElementTobeClickable(carvanaBasePage.emailInputBox, 30);
        carvanaBasePage.emailInputBox.sendKeys(TestData.userEmail);
        carvanaBasePage.continueButton.click();
        // user enters password as "abcd1234"
        carvanaBasePage.passwordInputBox.sendKeys(TestData.invalidPassword);
        // user clicks on "SIGN IN" button
        carvanaBasePage.modalSignInButton.click();
        // user should see error message as "Email address and/or password combination is incorrect.
        Assert.assertEquals(carvanaBasePage.signInErrorMessage.getText(), TestData.signInErrorMessage);
    }

    /**
    Test Case 5:
        Test name = Validate the search filter options and search button
        Test priority = 5
        Given user is on "https://www.carvana.com/"
        When user clicks on "SEARCH CARS" link
        Then user should be routed to "https://www.carvana.com/cars"
        And user should see filter options
        |PAYMENT & PRICE     	|
        |MAKE & MODEL	    	|
        |BODY TYPE		|
        |YEAR & MILEAGE     	|
        |FEATURES	    	|
        |MORE FILTERS		|
     */
    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFilterOptionsAndSearchButton(){
        Waiter.waitForVisibilityOfElement(carvanaBasePage.searchCarsLink, 30);
        Waiter.waitForElementTobeClickable(carvanaBasePage.searchCarsLink, 30);
        // When user clicks on "SEARCH CARS" link
        carvanaBasePage.searchCarsLink.click();
        // Then user should be routed to "https://www.carvana.com/cars"
        Assert.assertEquals(driver.getCurrentUrl(), TestData.searchCarsURL);
        //  And user should see filter options
        for (int i = 0; i < 6; i++) {
            Waiter.waitForVisibilityOfElement(carvanaSearchCarsPage.filterOptions.get(i), 30);
            Assert.assertTrue(carvanaSearchCarsPage.filterOptions.get(i).isDisplayed());
            Assert.assertEquals(carvanaSearchCarsPage.filterOptions.get(i).getText(), TestData.searchCarsFilterOptionsTexts[i]);
        }
    }


    /**
    Test Case 6:
        Test name = Validate the search result tiles
        Test priority = 6
        Given user is on "https://www.carvana.com/"
        When user clicks on "SEARCH CARS" link
        Then user should be routed to "https://www.carvana.com/cars"
        When user enters "mercedes-benz" to the search input box
        And user clicks on "GO" button in the search input box
        Then user should see "mercedes-benz" in the url
        And validate each result tile

        VALIDATION OF EACH TILE INCLUDES BELOW
        Make sure each result tile is displayed with below information
        1. an image
        2. add to favorite button
        3. tile body
        ALSO VALIDATE EACH TILE BODY:
        Make sure each tile body has below information
        1. Inventory type - text should be displayed and should not be null or empty
        2. Year-Make-Model information - text should be displayed and should not be null or empty
        3. Trim-Mileage information - text should be displayed and should not be null or empty
        4. Price - Make sure that each price is more than zero
        5. Monthly Payment information - text should be displayed and should not be null or empty
        6. Down Payment information - text should be displayed and should not be null or empty
        7. Delivery chip must be displayed, and text is not null or empty
     */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateSearchResultsTiles(){
        Waiter.waitForVisibilityOfElement(carvanaBasePage.searchCarsLink, 30);
        Waiter.waitForElementTobeClickable(carvanaBasePage.searchCarsLink, 30);
        // When user clicks on "SEARCH CARS" link
        carvanaBasePage.searchCarsLink.click();
        // Then user should be routed to "https://www.carvana.com/cars"
        Waiter.waitForVisibilityOfElement(carvanaSearchCarsPage.filterOptions.get(1), 30);
        Assert.assertEquals(driver.getCurrentUrl(), TestData.searchCarsURL);
        // When user enters "mercedes-benz" to the search input box
        carvanaSearchCarsPage.searchInputBox.sendKeys(TestData.mercedesBenzText);
        //  And user clicks on "GO" button in the search input box
        carvanaSearchCarsPage.goButton.click();
        Waiter.pause(3);

        // validate all result pages
        //while (carvanaSearchResultsPage.nextPageButton.isEnabled()){

            // then user should see "mercedes-benz" in the url
            Assert.assertTrue(driver.getCurrentUrl().contains(TestData.mercedesBenzText));

            // And validate each result tile
            // Make sure each result tile is displayed with below information
            for (int i = 0; i < carvanaSearchResultsPage.tiles.size(); i++) {
                // 1. an image
                Assert.assertTrue(carvanaSearchResultsPage.tileImages.get(i).isDisplayed());
                // 2. add to favorite button
                Assert.assertTrue(carvanaSearchResultsPage.tileFavoriteButtons.get(i).isDisplayed());
                // 3. tile body
                Assert.assertTrue(carvanaSearchResultsPage.tileBody.get(i).isDisplayed());

                // Make sure each tile body has below information
                // 1. Inventory type - text should be displayed and should not be null or empty
                Assert.assertTrue(carvanaSearchResultsPage.tileInventoryType.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchResultsPage.tileInventoryType.get(i).getText());
                Assert.assertFalse(carvanaSearchResultsPage.tileInventoryType.get(i).getText().isEmpty());

                // 2. Year-Make-Model information - text should be displayed and should not be null or empty
                Assert.assertTrue(carvanaSearchResultsPage.tileYearMakeAndModel.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchResultsPage.tileYearMakeAndModel.get(i).getText());
                Assert.assertFalse(carvanaSearchResultsPage.tileYearMakeAndModel.get(i).getText().isEmpty());

                // 3. Trim-Mileage information - text should be displayed and should not be null or empty
                Assert.assertTrue(carvanaSearchResultsPage.tileTrimAndMileage.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchResultsPage.tileTrimAndMileage.get(i).getText());
                Assert.assertFalse(carvanaSearchResultsPage.tileTrimAndMileage.get(i).getText().isEmpty());

                // 4. Price - Make sure that each price is more than zero
                Assert.assertTrue(carvanaSearchResultsPage.tilePrice.get(i).isDisplayed());
                Assert.assertTrue(Double.parseDouble(carvanaSearchResultsPage.tilePrice.get(i).getText()
                        .replaceAll("[^0-9]", "")) > 0);

                // 5. Monthly Payment information - text should be displayed and should not be null or empty
                Assert.assertTrue(carvanaSearchResultsPage.tileMonthlyPaymentInfo.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchResultsPage.tileMonthlyPaymentInfo.get(i).getText());
                Assert.assertFalse(carvanaSearchResultsPage.tileMonthlyPaymentInfo.get(i).getText().isEmpty());

                // 6. Down Payment information - text should be displayed and should not be null or empty
                Assert.assertTrue(carvanaSearchResultsPage.tileDownPaymentInfo.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchResultsPage.tileDownPaymentInfo.get(i).getText());
                Assert.assertFalse(carvanaSearchResultsPage.tileDownPaymentInfo.get(i).getText().isEmpty());

                // 7. Delivery chip must be displayed, and text is not null or empty
                Assert.assertTrue(carvanaSearchResultsPage.tileDeliveryChips.get(i).isDisplayed());
                Assert.assertNotNull(carvanaSearchResultsPage.tileDeliveryChips.get(i).getText());
                Assert.assertFalse(carvanaSearchResultsPage.tileDeliveryChips.get(i).getText().isEmpty());
            }
            // click on the next page button
           // Waiter.waitForVisibilityOfElement(carvanaSearchResultsPage.nextPageButton, 30);
            //Waiter.waitForElementTobeClickable(carvanaSearchResultsPage.nextPageButton, 30);
            //carvanaSearchResultsPage.nextPageButton.click();
       //}
    }
}
