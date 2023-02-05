package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaBasePage;
import pages.CarvanaSearchCarsPage;
import pages.CarvanaSearchResultsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CarvanaBase {

    public WebDriver driver;
    //SoftAssert softAssert;
    CarvanaBasePage carvanaBasePage;
    CarvanaSearchCarsPage carvanaSearchCarsPage;
    CarvanaSearchResultsPage carvanaSearchResultsPage;


    // before anything, setup page
    @BeforeMethod
    public void setup(){
        // initialize the driver
        driver = Driver.getDriver();
        // get the URL
        driver.get(ConfigReader.getProperty("appURL"));
        //softAssert = new SoftAssert();
        carvanaSearchCarsPage = new CarvanaSearchCarsPage();
        carvanaSearchResultsPage = new CarvanaSearchResultsPage();
    }

    // after method for quiting driver
    @AfterMethod
    public void teardown(){
       // softAssert.assertAll();
        Driver.quitDriver();
    }
}
