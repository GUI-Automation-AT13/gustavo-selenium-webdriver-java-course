package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private String frameTop = "frame-top";
    private String frameLeft = "frame-left";
    private String frameButton = "frame-bottom";
    private By body = By.tagName("body");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNestedFramesLin() {
        driver.findElement(By.linkText("Nested Frames")).click();
    }

    public String getFrameLeft() {
        switchToEditArea(frameTop);
        switchToEditArea(frameLeft);
        String text = driver.findElement(body).getText();
        switchToMainArea();
        switchToMainArea();
        return text;
    }

    public String getFrameBody() {
        switchToEditArea(frameButton);
        String text = driver.findElement(body).getText();
        switchToMainArea();
        return text;
    }

    private void switchToEditArea(String area) {
        driver.switchTo().frame(area);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
