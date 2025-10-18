package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountrySelectionPage extends BasePage{

    private final By dateSelectionBtn=  By.className("MuiButton-label");
    public CountrySelectionPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCountryBtn(String country){
        clickOnElement(getCountryBtn(country));

    }
    private By getCountryBtn(String country){
        return By.xpath("//div[contains(text(), '"+country+"')]");

    }
    public SelectionDatePage clickOnDateSelectionBtn(){
        clickOnElement(dateSelectionBtn);
        return  new SelectionDatePage(driver);

    }
}
