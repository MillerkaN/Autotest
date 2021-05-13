package Lesson6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllProjectsPage extends BaseView{

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class = 'btn back icons-holder-text ']")
    public WebElement createProjectButton;

    public By createProjectButtonLocator = By.xpath("//a[@class = 'btn back icons-holder-text ']");

    public void createProject(){
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectPage(driver).projectNameInputLocator));
    }
}
