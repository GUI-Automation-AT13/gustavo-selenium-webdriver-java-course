package tasks;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TasksChapter7 extends BaseTests {
    @Test
    public void testSlideToWholeNumber() {
        String number = "4";
        var contextPage = homePage.clickContext();
        contextPage.rightClickBoxWhite();
        String expected = contextPage.getTextMessage();
        String actual= "You selected a context menu";
        assertEquals(expected, actual);
    }
}
