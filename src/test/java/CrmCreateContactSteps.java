import Lesson8.*;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrmCreateContactSteps {
    @Given("I am authorized")
    public void iAmAuthorized() {
        new LoginPage().login("Applanatest1", "Student2020!");
    }

    @Given("I am on contact page")
    public void iAmOnContactPage() {
        new MainPage().navigationMenu.openNavigationMenuItem("Контрагенты");
        new PartnerSubMenu().goToPageContacts();
        new ContactsPage().createContact();
    }

    @When("I fill surname field")
    public void iFillSurnameField() {
        new CreateContactPage().fillSurnameInput("Turunen");
    }

    @And("I fill first name field")
    public void iFillFirstNameField() {
        new CreateContactPage().fillNameInput("Тарья");
    }

    @And("I fill and select organisation")
    public void iFillAndSelectOrganisation() {
        new CreateContactPage().fillOrganisationSearch("Все организации");
    }

    @And("I fill position")
    public void iFillPosition() {
        new CreateContactPage().fillJobTitleInput("Певица");
    }

    @And("I click save and close button")
    public void iClickSaveAndCloseButton() {
        new CreateContactPage().pushSaveAndCloseButton();
    }

    @Then("I see message about success saving")
    public void iSeeMessageAboutSuccessSaving() {
        new CreateContactPage().infoAboutSuccessSaving.shouldBe(Condition.visible);
    }
}
