package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import myData.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CrudAppTestSuite {
    private static final String BASE_URL = "https://ra-ger.github.io/";
    private WebDriver driver;
    private WebDriver driverTrello;
    private Random generator;

    @BeforeEach
    void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    void cleanUpAfterTest() {
        if (driver != null) {
            driver.quit();
        }
        if (driverTrello != null) {
            driverTrello.quit();
        }
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class=\"datatable__field-value\" and text()=\"" + taskName + "\"]")
        ));

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[1]")));

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();

                    WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    alertWait.until(ExpectedConditions.alertIsPresent()).accept();
                });
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;

        driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        WebDriverWait trelloWait = new WebDriverWait(driverTrello, Duration.ofSeconds(15));

        driverTrello.findElement(By.id("user")).sendKeys(Data.login);
        driverTrello.findElement(By.id("password")).sendKeys(Data.password);
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();

        trelloWait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));

        driverTrello.findElement(By.id("password")).sendKeys(Data.password);
        driverTrello.findElement(By.id("login-submit")).submit();

        trelloWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"board-tile\"]")));

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);

        trelloWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span")));

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteCrudAppTestTask(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }

    private void deleteCrudAppTestTask(String taskName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathExpression = String.format(
                "//form[contains(@class, 'datatable__row') and .//p[@data-task-name-paragraph and text()='%s']]//button[@data-task-delete-button]",
                taskName
        );

        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        deleteButton.click();
    }
}