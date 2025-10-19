package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CountrySelectionPage;
import pages.SelectionDatePage;
import pages.HomePage;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;

public class FirstPurchaseTest {
    private WebDriver driver;
    private final SoftAssert softAssert;
    private HomePage homePage;

    public FirstPurchaseTest() {

        softAssert = new SoftAssert();

    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        homePage= HomePage.goToToHomePage(driver);
    }

    @Test
    public void firstPurchaseFlowTest() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(29);
        CountrySelectionPage countrySelectionPage= homePage.clickOnBuyForFirstTimeBtn();
        countrySelectionPage.clickOnCountryBtn("קנדה");
        SelectionDatePage selectionDatePage = countrySelectionPage.clickOnDateSelectionBtn();
        selectionDatePage.chooseVacationDate(startDate,endDate);
        softAssert.assertEquals(
                selectionDatePage.getTotalDays(),
                "סה\"כ: 30 ימים",
                "Error: Total days displayed is incorrect"
        );
        selectionDatePage.clickOnPassengerDetailsBtn();
        softAssert.assertEquals(
                driver.getCurrentUrl(),
                "https://digital.harel-group.co.il/travel-policy/wizard/travelers",
                "Error: Failed to navigate to the 'Passenger Details' page"
        );
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();

    }
}
