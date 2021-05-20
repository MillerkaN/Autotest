package Lesson8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PartnerSubMenu {

    private SelenideElement contactsButton = $(By.xpath("//span[text() = 'Контактные лица']/ancestor :: a"));

    public void goToPageContacts(){
        contactsButton.click();
    }
}
