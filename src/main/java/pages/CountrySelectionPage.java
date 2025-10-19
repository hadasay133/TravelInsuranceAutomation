package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountrySelectionPage extends BasePage{

    private final By dateSelectionBtn=  By.className("MuiButton-label");
    private  final int DEFAULT_TIMEOUT=45;
    public CountrySelectionPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCountryBtn(String country){
        clickOnElement(getCountryBtn(country),DEFAULT_TIMEOUT);

    }
    private By getCountryBtn(String country){
        return By.xpath("//div[contains(text(), '"+country+"')]");

    }
    public SelectionDatePage clickOnDateSelectionBtn(){
        clickOnElement(dateSelectionBtn,DEFAULT_TIMEOUT);
        return  new SelectionDatePage(driver);

    }
}
