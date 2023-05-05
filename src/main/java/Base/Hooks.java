package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class Hooks {
    private WebDriver driver;
    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //Options.addArgument("--headless--")
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://ui.cogmento.com/");
    }
    @After(order = 2)
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] sc=screenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(sc,"image/png","screenshot");
        }
    }
    @After(order = 1)
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
