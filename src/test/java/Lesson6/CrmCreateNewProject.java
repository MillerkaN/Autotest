package Lesson6;

import Lesson6.Pages.AllProjectsPage;
import Lesson6.Pages.CreateProjectPage;
import Lesson6.Pages.LoginPage;
import Lesson6.Pages.ProjectSubMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6.Configuration.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmCreateNewProject extends BaseTest {

    @BeforeEach
    public void goToPage(){
        driver.get(BASE_URL);
    }

    @Test
    void createNewProject() throws InterruptedException {
        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Проекты");
        new ProjectSubMenu(driver).createProject();
        new AllProjectsPage(driver).createProject();
        new CreateProjectPage(driver)
                .fillProjectNameInput("test165")
                .fillOrganisationSearch("Все орг")
                .selectBusinessUnitSelect("Research & Development")
                .selectProjectCurator("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Applanatest1 Applanatest1 Applanatest1")
                .selectManager("Applanatest1 Applanatest1 Applanatest1")
//                .selectMainContact("Иванов Фёдор")
                .fillPlanningDescription("Планирование")
                .fillProjectRequirementsManagementDescription("Управление требованиями")
                .fillProjectDevelopmentDescription("Разработка")
                .fillTestingDescription("Тестирование")
                .fillConfigManagement("Управление конфигурацией")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new CreateProjectPage(driver).infoAboutSuccessSavingLocator));
        assertThat(new CreateProjectPage(driver).infoAboutSuccessSaving, isDisplayed());
    }
}

