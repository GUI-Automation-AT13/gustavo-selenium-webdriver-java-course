package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextPage {
    private WebDriver driver;
    private By boxWhite = By.id("hot-spot");
    public ContextPage(WebDriver driver){
        this.driver = driver;
    }

    public void rightClickBoxWhite(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(boxWhite)).perform();
    }

    public String getTextMessage(){
        return driver.switchTo().alert().getText();
    }
}
