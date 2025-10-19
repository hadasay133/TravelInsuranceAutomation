package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
     private final By buyForFirstTimeBtn = By.cssSelector("button[data-hrl-bo='purchase-for-new-customer']");
    private  final int DEFAULT_TIMEOUT=45;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CountrySelectionPage clickOnBuyForFirstTimeBtn() {
        clickOnElement(buyForFirstTimeBtn,DEFAULT_TIMEOUT);
                return new CountrySelectionPage(driver);
    }

    public static HomePage goToToHomePage(WebDriver driver){
        driver.get("https://digital.harel-group.co.il/travel-policy");
        driver.manage().window().maximize();
        return new HomePage(driver);


    }
}
