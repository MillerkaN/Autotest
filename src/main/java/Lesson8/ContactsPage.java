package Lesson8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {

    private SelenideElement createContactButton = $(By.xpath("//a[@title = 'Создать контактное лицо']"));

    public By createContactButtonLocator = By.xpath("//a[@title = 'Создать контактное лицо']");

    public void createContact(){
        createContactButton.click();
    }
}
