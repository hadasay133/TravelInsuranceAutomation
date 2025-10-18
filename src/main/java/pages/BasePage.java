package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;


    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(45));
    }


    private WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnElement(By locator) {
        WebElement webElement = waitForVisibility(locator);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public String getTextOfElement(By locator) {
        return waitForVisibility(locator).getText();
    }


}
