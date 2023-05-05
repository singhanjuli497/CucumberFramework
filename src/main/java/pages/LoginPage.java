package pages;

import Base.GenericFunctions;
import Base.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends GenericFunctions {
    @FindBy(name = "email")
    private WebElement userNameTextBox;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextBox;
    @FindBy(css = "[class*='submit']")
    private WebElement loginButton;

    @FindBy(xpath="//p[text()='Invalid login']")
    private WebElement errorMessageAtLogin;

    WebDriver driver;
    WebDriverWait webDriverWait;

    public LoginPage(Hooks hooks){
        super(hooks);
        driver = hooks.getDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        PageFactory.initElements(driver,this);
    }
    public void fillUsernameTextBox(String username){
        enterText(userNameTextBox, username);
    }
    public void fillPasswordTextBox(String password){
        enterText(passwordTextBox, password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String openLoginPage(String url) {
      return getOpenPageTitle();
    }
    public String errorMessage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(errorMessageAtLogin));
        return getElementText(errorMessageAtLogin);
    }
}