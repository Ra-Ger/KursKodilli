package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[@role='button' and @aria-label='Zezwól na wszystkie pliki cookie'])[2]")));
        cookiesButton.click();

        WebElement createAccount = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//a[@role='link' and @aria-label='Utwórz nowe konto'])")));
        createAccount.click();

        WebElement cookiesButton2 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[@role='button' and @aria-label='Zezwól na wszystkie pliki cookie'])[2]")));
        cookiesButton2.click();

        // dzien
        WebElement combo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='combobox' and @aria-label='Wybierz dzień']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", combo);

        String listboxId = combo.getAttribute("aria-controls");

        WebElement listbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id(listboxId)
        ));

        WebElement option = listbox.findElement(
                By.xpath(".//div[@role='option']//div[text()='10']")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

        // miesionc
         combo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='combobox' and @aria-label='Wybierz miesiąc']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", combo);

         listboxId = combo.getAttribute("aria-controls");

         listbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id(listboxId)
        ));

         option = listbox.findElement(
                By.xpath(".//div[@role='option']//div[text()='lutego']")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

        // rok
         combo = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='combobox' and @aria-label='Wybierz rok']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", combo);

         listboxId = combo.getAttribute("aria-controls");

         listbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id(listboxId)
        ));

         option = listbox.findElement(
                By.xpath(".//div[@role='option']//div[text()='2010']")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }
}
