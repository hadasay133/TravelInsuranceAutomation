package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;


    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    private WebElement waitForVisibility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void clickOnElement(By locator,int seconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement webElement = waitForVisibility(locator, seconds);
        localWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public String getTextOfElement(By locator,int seconds) {
        return waitForVisibility(locator,seconds).getText();
    }


}
