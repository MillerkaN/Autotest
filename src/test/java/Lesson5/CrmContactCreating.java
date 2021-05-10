package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CrmContactCreating {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeTest
    void webDriverSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
        login();
    }

    @Test(description = "Создание нового контактного лица в CRM")
    void CrmContactCreating() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"))).perform();

        driver.findElement(By.xpath("//li[@data-route = 'crm_contact_index']/a")).click();

        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Кенонен8");

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Тахво8");

        driver.findElement(By.xpath("//span[@class = 'select2-arrow']")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Все " +
                "организации");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Портной");
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

       // webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(By.name("crm_contact[jobTitle]"), "Портной"));

//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(50))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//        wait.until(driver -> driver.findElement(
//                By.name("crm_contact[jobTitle]"))
//                .getText()
//                .equals("Портной"));

//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.attributeContains(By.name("crm_contact[jobTitle]"), "text", "Портной"));

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо " +
                "сохранено']")));

        assertTrue(driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']")).isDisplayed());
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    private void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
