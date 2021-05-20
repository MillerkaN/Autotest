package Lesson8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static Lesson6.Configuration.BASE_URL;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement submitButton = $(By.id("_submit"));

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage submitLogin() {
        submitButton.click();
        return page(MainPage.class);
    }

    public MainPage login(String login, String password){
        open(BASE_URL);
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        return page(MainPage.class);
    }
}
