package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SelectionDatePage extends BasePage{
    private final By passengerDetailsBtn = By.id("nextButton");
    private final By totalDays = By.cssSelector("span[data-hrl-bo='total-days']");

    public SelectionDatePage(WebDriver driver) {
        super(driver);
    }
    private By getBtnDateElement(LocalDate date){
        return new By.ByCssSelector("button[data-hrl-bo='"+date+"']");
    }
    public void chooseVacationDate(LocalDate startDate ,LocalDate endDate ){
        clickOnElement(getBtnDateElement(startDate));
        clickOnElement(getBtnDateElement(endDate));

    }
    public void clickOnPassengerDetailsBtn(){
        clickOnElement(passengerDetailsBtn);
    }

    public String getTotalDays(){
       return getTextOfElement(totalDays);

    }
}
