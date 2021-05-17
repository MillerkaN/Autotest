package Lesson6.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPage extends BaseView {
    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement surnameInput;
    public By surnameInputLocator = By.name("crm_contact[lastName]");

    @Step("Заполнение поля 'Фамилия'")
    public CreateContactPage fillSurnameInput(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement nameInput;

    @Step("Заполнение поля 'Имя'")
    public CreateContactPage fillNameInput(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[@class='select2-arrow']/..")
    public WebElement OrganisationNameSearch;

    @Step("Выбор организации")
    public CreateContactPage fillOrganisationSearch(String organisationName) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-overlay")));
        OrganisationNameSearch.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='\"Континент+\"']")));
        OrganisationNameSearch.sendKeys(organisationName);
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Все орг')]")));
        OrganisationNameSearch.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitleInput;

    @Step("Заполнение поля 'Должность'")
    public CreateContactPage fillJobTitleInput(String jobTitle) {
        jobTitleInput.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @Step("Клик по кнопке 'Сохранить и закрыть'")
    public CreateContactPage pushSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }

    @FindBy(xpath = infoAboutSuccessSavingLocatorContact)
    public WebElement infoAboutSuccessSaving;
    public static final String infoAboutSuccessSavingLocatorContact = "//*[text()='Контактное лицо сохранено']";
}
