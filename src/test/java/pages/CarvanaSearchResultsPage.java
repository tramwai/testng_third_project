package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchResultsPage extends CarvanaBasePage {
    public CarvanaSearchResultsPage() {
        super();
    }

    @FindBy(css = "result-tile")
    public List<WebElement> tiles;

    @FindBy(css = ".vehicle-image")
    public List<WebElement> tileImages;

    @FindBy(css = ".favorite-vehicle")
    public List<WebElement> tileFavoriteButtons;

    @FindBy(css = ".tk-shell")
    public List<WebElement> tileBody;

    @FindBy(css = "div[data-qa='base-inventory-type']")
    public List<WebElement> tileInventoryType;

    @FindBy(css = ".year-make")
    public List<WebElement> tileYearMakeAndModel;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> tileTrimAndMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> tilePrice;

    @FindBy(css = ".monthly-payment")
    public List<WebElement> tileMonthlyPaymentInfo;

    @FindBy(css = ".down-payment")
    public List<WebElement> tileDownPaymentInfo;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> tileDeliveryChips;

    @FindBy(css = "button[data-cv-test='Cv.Search.Pagination.NextPageButton']")
    public WebElement nextPageButton;

}
