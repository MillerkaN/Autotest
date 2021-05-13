package Lesson6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView{

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
            public WebElement projectNameInput;
    public  By projectNameInputLocator = By.name("crm_project[name]");

    public CreateProjectPage fillProjectNameInput(String projectName) {
        projectNameInput.sendKeys(projectName);
        return this;
    }

    @FindBy(xpath = "//span[@class='select2-arrow']/..")
    public WebElement OrganisationNameSearch;

    public CreateProjectPage fillOrganisationSearch(String organisationName) throws InterruptedException {
        OrganisationNameSearch.click();
        OrganisationNameSearch.sendKeys(organisationName);
        OrganisationNameSearch.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public CreateProjectPage selectBusinessUnitSelect(String businessUnitName) {
        new Select (businessUnitSelect).selectByVisibleText(businessUnitName);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement projectCurator;

    public CreateProjectPage selectProjectCurator(String projectCuratorName) {
        new Select (projectCurator).selectByVisibleText(projectCuratorName);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement projectManager;

    public CreateProjectPage selectProjectManager(String projectManagerName) {
        new Select (projectManager).selectByVisibleText(projectManagerName);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement manager;

    public CreateProjectPage selectManager(String managerName) {
        new Select (manager).selectByVisibleText(managerName);
        return this;
    }

//    @FindBy(name = "crm_project[contactMain]")
//    public WebElement mainContact;
//
//    public CreateProjectPage selectMainContact(String mainContactName) {
//        new Select (mainContact).selectByVisibleText(mainContactName);
//        return this;
//    }

    @FindBy(xpath = "//iframe[contains(@id, 'planning')]")
            public WebElement framePlanning;


    @FindBy(xpath = "//body")
            public WebElement planningDescription;

    public CreateProjectPage fillPlanningDescription(String planningDescriptionsText) {
        driver.switchTo().frame(framePlanning);
        planningDescription.sendKeys(planningDescriptionsText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'project_requirementsManagement')]")
    public WebElement frameProjectRequirementsManagement;

    @FindBy(xpath = "//body")
    public WebElement projectRequirementsManagementDescription;

    public CreateProjectPage fillProjectRequirementsManagementDescription(String projectRequirementsManagementDescriptionText) {
        driver.switchTo().frame(frameProjectRequirementsManagement);
        projectRequirementsManagementDescription.sendKeys(projectRequirementsManagementDescriptionText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_development-uid')]")
    public WebElement frameProjectDevelopment;

    @FindBy(xpath = "//body")
    public WebElement projectDevelopmentDescription;

    public CreateProjectPage fillProjectDevelopmentDescription(String projectDevelopmentDescriptionText) {
        driver.switchTo().frame(frameProjectDevelopment);
        projectDevelopmentDescription.sendKeys(projectDevelopmentDescriptionText);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'testing')]")
    public WebElement frameTesting;

    @FindBy(xpath = "//body")
    public WebElement testingDescription;

    public CreateProjectPage fillTestingDescription(String testingDescriptionText) {
        driver.switchTo().frame(frameTesting);
        testingDescription.sendKeys(testingDescriptionText);
        driver.switchTo().defaultContent();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("select2-drop-mask")));
        return this;
    }

    @FindBy(name = "crm_project[configManagement]")
            public WebElement configManagement;

    public CreateProjectPage fillConfigManagement(String configManagementText) {
        configManagement.click();
        configManagement.sendKeys(configManagementText);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = "//*[text()='Проект сохранен']")
            public WebElement infoAboutSuccessSaving;

    public By infoAboutSuccessSavingLocator = By.xpath("//*[text()='Проект сохранен']");

}
