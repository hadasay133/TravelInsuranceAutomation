package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CountrySelectionPage;
import pages.SelectionDatePage;
import pages.homePage.HomePage;
import pages.homePage.PurchaseType;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;

public class FirstPurchaseTest {
    private final WebDriver driver;
    private final HomePage homePage;
    private final SelectionDatePage selectionDatePage;
    private final LocalDate startDate = LocalDate.now();
    private final LocalDate endDate =startDate.plusDays(29);
    private final SoftAssert softAssert;

    public FirstPurchaseTest() {

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        selectionDatePage = new SelectionDatePage(driver);
        softAssert = new SoftAssert();

    }

    @BeforeTest
    public void setUp() {
        driver.get("https://digital.harel-group.co.il/travel-policy");
        driver.manage().window().maximize();

    }

    @Test
    public void FirstPurchaseFlowTest() {
        CountrySelectionPage countrySelectionPage= (CountrySelectionPage) homePage.clickOnBuyForFirstTimeBtn(PurchaseType.FIRSTPURCHASE);
        softAssert.assertEquals(driver.getCurrentUrl(),"https://digital.harel-group.co.il/travel-policy/wizard/destination");
        countrySelectionPage.clickOnCountryBtn("קנדה");
        countrySelectionPage.clickOnDateSelectionBtn();
        selectionDatePage.chooseVacationDate(startDate,endDate);
        softAssert.assertEquals(selectionDatePage.getTotalDays(),"סה\"כ: 30 ימים");
        selectionDatePage.clickOnPassengerDetailsBtn();
        Assert.assertEquals(driver.getCurrentUrl(),"https://digital.harel-group.co.il/travel-policy/wizard/travelers");
    }
    @AfterTest
    public void afterTest() {
        driver.quit();

    }
}
