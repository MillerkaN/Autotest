package Lesson6;

import Lesson6.Pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6.Configuration.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmCreateNewContactTests extends BaseTest {
    @BeforeEach
    public void goToPage(){
        driver.get(BASE_URL);
    }

    @Test
    void createNewContact() {
        new LoginPage(driver).login(CRM_LOGIN, CRM_PASSWORD)
                .navigationMenu.openNavigationMenuItem("Контрагенты");
        new PartnerSubMenu(driver).goToPageContacts();
        new ContactsPage(driver).createContact();
        new CreateContactPage(driver)
                .fillSurnameInput("Турунен")
                .fillNameInput("Тарья")
                .fillOrganisationSearch("Все организации")
                .fillJobTitleInput("Певица")
                .pushSaveAndCloseButton();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(new CreateContactPage(driver).infoAboutSuccessSavingLocatorContact)));

        assertThat(new CreateContactPage(driver).infoAboutSuccessSaving, isDisplayed());
    }
}

