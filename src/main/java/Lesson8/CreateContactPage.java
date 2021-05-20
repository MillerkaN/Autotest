package Lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

public class CreateContactPage {

    private SelenideElement surnameInput = $(By.name("crm_contact[lastName]"));

    @Step("Заполнение поля 'Фамилия'")
    public CreateContactPage fillSurnameInput(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }

    private SelenideElement nameInput = $(By.name("crm_contact[firstName]"));

    @Step("Заполнение поля 'Имя'")
    public CreateContactPage fillNameInput(String name) {
        nameInput.sendKeys(name);
        return this;
    }
    private SelenideElement organisationNameClick = $(By.xpath("//span[@class = 'select2-arrow']"));
    private SelenideElement organisationNameInput = $(By.xpath("//input[@class='select2-input select2-focused']"));
    //private SelenideElement organisationNameEnter = $(By.xpath("//input[@class='select2-input select2-focused']\""));

    @Step("Выбор организации")
    public CreateContactPage fillOrganisationSearch(String organisationName) {
        organisationNameClick.click();
        organisationNameInput.sendKeys(organisationName);
        organisationNameInput.sendKeys(Keys.ENTER);
        return this;
    }

    private SelenideElement jobTitleInput = $(By.name("crm_contact[jobTitle]"));

    @Step("Заполнение поля 'Должность'")
    public CreateContactPage fillJobTitleInput(String jobTitle) {
        jobTitleInput.sendKeys(jobTitle);
        return this;
    }

    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]"));

    @Step("Клик по кнопке 'Сохранить и закрыть'")
    public CreateContactPage pushSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }

    public SelenideElement infoAboutSuccessSaving = $(By.xpath("//*[text()='Контактное лицо сохранено']"));
}
