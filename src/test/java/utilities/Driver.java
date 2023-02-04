package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // declare driver
    private static WebDriver driver;

    // constructor
    private Driver() {
    }

    // method to instantiate driver
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            // setup driver
            WebDriverManager.chromedriver().setup();
            // create new instance of the driver
            driver = new ChromeDriver();
            // maximize window
            driver.manage().window().maximize();
            // add implicit wait
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
        }
        return driver;
    }

    // method for quiting driver
    public static void quitDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}
