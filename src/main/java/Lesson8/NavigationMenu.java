package Lesson8;

import Lesson6.Pages.BaseView;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class NavigationMenu {

    private List<SelenideElement> navigationMenuItems = $$(By.xpath("//ul[@class = 'nav nav-multilevel main-menu']/li"));

    public void openNavigationMenuItem(final String menuName){
        navigationMenuItems.stream().filter(element -> element.getText().equals(menuName)).findFirst().get().hover();
    }
}
