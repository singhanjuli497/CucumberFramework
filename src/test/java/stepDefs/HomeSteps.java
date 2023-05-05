package stepDefs;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage;
    public HomeSteps(HomePage homePage){
        this.homePage =homePage;
    }
    @Then("I should be navigate to home page")
    public void i_should_be_navigate_to_home_page() {
        String actualHome =homePage.homePageTextValidation();
        System.out.println(actualHome + "******");
        Assert.assertTrue(homePage.homePageTextValidation().equals("Anjuli Singh"));
    }
}
