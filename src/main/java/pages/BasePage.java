package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    private final int DEFAULT_WAIT_SECONDS = 45;


    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    private WebElement waitForVisibility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void clickOnElement(By locator) {
        WebElement webElement = waitForVisibility(locator,DEFAULT_WAIT_SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public String getTextOfElement(By locator) {
        return waitForVisibility(locator,DEFAULT_WAIT_SECONDS).getText();
    }


}
