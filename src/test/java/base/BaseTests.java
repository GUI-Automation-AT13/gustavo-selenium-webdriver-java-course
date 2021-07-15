package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected EventFiringWebDriver driver;
    //private WebDriver driver;
    protected HomePage homePage;

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        setCookie();
        //  driver.get("https://the-internet.herokuapp.com/");
        //driver.manage().window().fullscreen();
//        List<WebElement> links= driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//        WebElement inputsLink= driver.findElement(By.linkText("Inputs"));
//        inputsLink.click();
        homePage = new HomePage(driver);
        //System.out.println(driver.getTitle());

    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //    public static void main(String args[]){
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE==result.getStatus())
        {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try{
            Files.move(screenshot, new File("C:\\Users\\ASUS\\Desktop\\AT-Materias\\GUI Automation\\Clases" +
                    "\\selenium-webdriver-tutorial-java\\resources\\"+result.getName()+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        }
    }

}
