package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaBasePage {

    // constructor to initialize each web element
    public CarvanaBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Carvana locators
    @FindBy(css = "div[class^='Logo__LogoWrapper']")
    public WebElement logo;

    @FindBy(css = "div[data-qa='menu-wrapper'] ")
    public List<WebElement> mainNavigationItems;

    @FindBy(css = "div[data-qa='sign-in-wrapper']")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(css = "#password")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-testid='Button']")
    public WebElement continueButton;

    @FindBy(css = "button[data-testid='Button']")
    public WebElement modalSignInButton;

    @FindBy(css = "div[class*='error-banner_'] p")
    public WebElement signInErrorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;
}
