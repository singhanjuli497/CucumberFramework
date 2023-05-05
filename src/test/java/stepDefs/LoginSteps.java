package stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
   // private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    LoginPage loginPage;
    public LoginSteps(LoginPage loginPage){
        this.loginPage = loginPage;
    }
    @Given("I am on login page")
    public void i_am_on_login_page() {
       // loginPage.openPage("https://ui.cogmento.com/");
       String title = loginPage.getOpenPageTitle();
        Assert.assertEquals(title, "Cogmento CRM");
    }
    @When("I enter Username as {string} and password as {string}")
    public void i_enter_username_as_and_password_as(String username, String password) {
        //LOGGER.debug("Login page validation");
        loginPage.fillUsernameTextBox(username);
        loginPage.fillPasswordTextBox(password);
    }
    @And("I click on login button")
    public void i_click_on_login_button() {
        loginPage.clickOnLoginButton();
    }
    @Then("I should get error message {string}")
    public void i_should_get_error_message(String string) {
        //loginPage.errorMessage();
       // LOGGER.info("");
        Assert.assertEquals(string, loginPage.errorMessage());
    }
}
