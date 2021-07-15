package tasks;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TasksChapter10 extends BaseTests {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickDropDown();
        dropDownPage.comboBox();

        String[] option = {"Option 1", "Option 2"};
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.containsAll(Arrays.asList(option)), "Option not selected");
    }
}
