package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TasksChapter4 {
    private WebDriver driver;
    @Test
    public void forgotPassword(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.id("email")).sendKeys("gzhuanca@freeorg01.com");
        assertEquals(driver.findElement(By.id("content")).getText(),
                "Forgot Password\n" + "E-mail\n" + "Retrieve password");
        driver.quit();
    }
}
