package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderRangeValue = By.id("range");
    private By slider = By.cssSelector("input[type='range']");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void findValue(String number){
        while(!(getSliderValue().equals(number))){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue(){
        return driver.findElement(sliderRangeValue).getText();
    }
}
