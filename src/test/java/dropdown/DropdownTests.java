package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOption = dropDownPage.getSelectedOptions();
        assertEquals(selectedOption.size(),1,"incorrect number of selection");
        assertTrue(selectedOption.contains(option),"option not selected");
    }

}
