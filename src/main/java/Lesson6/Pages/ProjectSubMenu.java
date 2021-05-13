package Lesson6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSubMenu extends BaseView {
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'Все проекты']")
    public WebElement allProjectsButton;

    public void createProject(){
        allProjectsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new AllProjectsPage(driver).createProjectButtonLocator));
    }
}
