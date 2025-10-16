package pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CountrySelectionPage;

public class HomePage extends BasePage {
    private final By buyForFirstTimeBtn = By.cssSelector("button[data-hrl-bo='purchase-for-new-customer']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BasePage clickOnBuyForFirstTimeBtn(PurchaseType purchaseType) {
        clickOnElement(buyForFirstTimeBtn);
        switch (purchaseType) {
            case FIRSTPURCHASE:
                return new CountrySelectionPage(driver);
            case REPEATPURCHASE:
                break;
            default:
                throw new UnsupportedCommandException("Page not exist");
        }
        return null;
    }
}
