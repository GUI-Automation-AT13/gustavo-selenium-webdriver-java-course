package tasks;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TasksChapter6 extends BaseTests {
    @Test
    public void testSlideToWholeNumber(){
        String number = "4";
        var sliderPage = homePage.clickHorizonalSlider();
        sliderPage.findValue(number);
        assertEquals(sliderPage.getSliderValue(), number);
    }
}
