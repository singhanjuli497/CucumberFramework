package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericFunctions {
     WebDriver driver;
    public GenericFunctions(Hooks hooks){
      driver = hooks.getDriver();
    }

    public String getOpenPageTitle(){
        return driver.getTitle();
    }
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clickOnElementWithJavaExecutor(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click();", element);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void selectValuebyVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void acceptAlert(WebElement element, String text) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public List<String> getAllElementTextFromList(List<WebElement> listOfWebelements) {
        List<String> elementTexts = new ArrayList<>();
        for (WebElement element : listOfWebelements) {
            elementTexts.add(element.getText());
        }
        return elementTexts;
    }

    public void mouseHoverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void selectValueFromDropdown(List<WebElement> webElementList, String visibleText) {
        for (WebElement element : webElementList) {
            if (element.getText().equals(visibleText)) {
                element.click();
                break;
            }
        }
    }
}
