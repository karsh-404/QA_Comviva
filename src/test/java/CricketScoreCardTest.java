import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CricketScoreCardTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();

        driver = new FirefoxDriver(options);

        driver.get("https://www.espncricinfo.com/series/zimbabwe-in-sri-lanka-2023-24-1412536/sri-lanka-vs-zimbabwe-1st-odi-1412539/live-cricket-score");
    }

    @Test
    public void printPlayerDataAndBelow() {
        WebElement scorecardLink = driver.findElement(By.linkText("Scorecard"));
        scorecardLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scorecardTable = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ci-scorecard-table")));

        WebElement additionalRow1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ds-flex ds-px-4 ds-border-b ds-border-line ds-py-3 ds-bg-ui-fill-translucent-hover']")));
        List<WebElement> cells1 = additionalRow1.findElements(By.xpath(".//span"));
        printRow(cells1);

        WebElement additionalRow2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//thead[@class='ds-bg-fill-content-alternate ds-text-left']")));
        List<WebElement> cells2 = additionalRow2.findElements(By.xpath(".//th"));
        printRow(cells2);

        WebElement playerDataRow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[contains(td, 'Avishka Fernando')]")));
        List<WebElement> cells = playerDataRow.findElements(By.tagName("td"));
        printRow(cells);

        List<WebElement> allRows = scorecardTable.findElements(By.xpath("//tr"));
        boolean foundSpecifiedRow = false;

        for (WebElement row : allRows) {
            if (foundSpecifiedRow) {
                List<WebElement> cellsBelow = row.findElements(By.tagName("td"));
                printRow(cellsBelow);
            }

            if (row.equals(playerDataRow)) {
                foundSpecifiedRow = true;
            }
        }
    }

    private void printRow(List<WebElement> cells) {
        for (WebElement cell : cells) {
            System.out.printf("%-30s", cell.getText());
        }
        System.out.println();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
