package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
     private final By buyForFirstTimeBtn = By.cssSelector("button[data-hrl-bo='purchase-for-new-customer']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CountrySelectionPage clickOnBuyForFirstTimeBtn() {
        clickOnElement(buyForFirstTimeBtn);
                return new CountrySelectionPage(driver);
    }
}
