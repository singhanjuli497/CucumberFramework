package pages;

import Base.GenericFunctions;
import Base.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends GenericFunctions {

@FindBy(xpath="//*[text()='Anjuli  Singh']")
    WebElement homePageHeaderText;
    WebDriver driver;

    WebDriverWait webDriverWait;
    public HomePage(Hooks hooks) {
        super(hooks);
        driver = hooks.getDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver, this);
    }
    public String homePageTextValidation(){
        webDriverWait.until(ExpectedConditions.visibilityOf(homePageHeaderText));
       return getElementText(homePageHeaderText);
    }
}
