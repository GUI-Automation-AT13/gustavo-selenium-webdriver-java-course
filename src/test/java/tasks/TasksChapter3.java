package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TasksChapter3 {
    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        //driver.manage().window().fullscreen();
        WebElement inputsLink= driver.findElement(By.linkText("Shifting Content"));
        inputsLink.click();

        WebElement example1Link= driver.findElement(By.linkText("Example 1: Menu Element"));
        example1Link.click();

        List<WebElement> links= driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static void main(String args[]){
        TasksChapter3 test = new TasksChapter3();
        test.setUp();
    }
}
