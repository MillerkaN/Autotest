package Lesson6;

import Lesson6.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
