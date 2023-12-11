package org.productstar.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcPage {
    private final WebDriver driver;

    By oneButtonLocator = By.xpath("//div[@class='keys']/span[text()='1']");
    By plusButtonLocator = By.xpath("//div[@class='keys']/span[text()='+']");
    By equalButtonLocator = By.xpath("//div[@class='keys']/span[text()='=']");
    By resultField = By.xpath("//div[@class='screen']");
    By spinnerImg = By.id("spinner");

    public CalcPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOne() {
        driver.findElement(oneButtonLocator).click();
    }

    public void clickPlus() {
        driver.findElement(plusButtonLocator).click();
    }

    public void clickEquals() {
        driver.findElement(equalButtonLocator).click();
    }

    public void checkResult(int expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(spinnerImg)));
        String result = driver.findElement(resultField).getText();
        assertEquals(expectedResult, Integer.parseInt(result));
    }
}
