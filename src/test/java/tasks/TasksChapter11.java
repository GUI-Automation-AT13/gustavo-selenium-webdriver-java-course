package tasks;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TasksChapter11 extends BaseTests {

    @Test
    public void testWindowTabs(){
        var buttonPage = homePage.clickDynamicLoading().clickExample2OpenNewTap();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonIsDisplayed());
    }
}
