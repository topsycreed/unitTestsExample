package org.productstar.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.productstar.Constants.BASE_URL;

public class HomePage {
    private final WebDriver driver;

    By calcButtonLocator = By.xpath("//a[text()='Slow calculator']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public CalcPage openCalcPage() {
        driver.findElement(calcButtonLocator).click();
        return new CalcPage(driver);
    }
}
