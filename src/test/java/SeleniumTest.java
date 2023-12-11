import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.productstar.pageObject.CalcPage;
import org.productstar.pageObject.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.productstar.Constants.BASE_URL;

@ExtendWith(SeleniumJupiter.class)
public class SeleniumTest {
    @Test
    void openSite(ChromeDriver driver) {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }

    @Test
    void openCalc(ChromeDriver driver) {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.findElement(By.xpath("//a[text()='Slow calculator']")).click();
        WebElement title = driver.findElement(By.xpath("//h1[@class='display-6']"));
        assertEquals("Slow calculator", title.getText());
    }

    @Test
    void checkCalcSum(ChromeDriver driver) throws InterruptedException {
        driver.get(BASE_URL);

        //locators
        By calcButtonLocator = By.xpath("//a[text()='Slow calculator']");
        By oneButtonLocator = By.xpath("//div[@class='keys']/span[text()='1']");
        By plusButtonLocator = By.xpath("//div[@class='keys']/span[text()='+']");
        By equalButtonLocator = By.xpath("//div[@class='keys']/span[text()='=']");
        By resultField = By.xpath("//div[@class='screen']");

        //actions
        driver.findElement(calcButtonLocator).click();
        driver.findElement(oneButtonLocator).click();
        driver.findElement(plusButtonLocator).click();
        driver.findElement(oneButtonLocator).click();
        driver.findElement(equalButtonLocator).click();

        //assertions
        Thread.sleep(5000);
        assertEquals("2", driver.findElement(resultField).getText());
    }

    @Test
    void checkCalcSumPageObject(ChromeDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CalcPage calcPage = homePage.openCalcPage();
        calcPage.clickOne();
        calcPage.clickPlus();
        calcPage.clickOne();
        calcPage.clickEquals();
        calcPage.checkResult(2);
    }
}
