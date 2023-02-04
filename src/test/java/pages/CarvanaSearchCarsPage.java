package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchCarsPage extends CarvanaBasePage {
    public CarvanaSearchCarsPage(){
        super();
    }

    @FindBy(css = "div[data-qa='menu-flex'] button")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

}
