package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EBayTestingApp {
    public static final String SEARCHFIELD = "_nkw";                       // [1]

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME); // [2]
        driver.get("https://www.ebay.com/");                                 // [3]

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name(SEARCHFIELD)));

        searchField.sendKeys("Laptop");
        searchField.submit();
        wait.until(ExpectedConditions.titleContains("Laptop"));

        driver.quit();
    }
}