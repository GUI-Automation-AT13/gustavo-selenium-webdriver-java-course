package tasks;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TasksChapter8 extends BaseTests {

    @Test
    public void testWysiwyg() {
        var framesPage = homePage.clickFrames();
        framesPage.clickNestedFramesLin();
        assertEquals(framesPage.getFrameLeft(),"LEFT", "Text frame is incorrect");
        assertEquals(framesPage.getFrameBody(),"BOTTOM", "Text frame is incorrect");
    }
}