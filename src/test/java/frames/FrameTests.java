package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwig(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();
        String text1 ="Hello ";
        String text2 ="Ahmed!";
        editorPage.setTextArea(text1);
        editorPage.setTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(),
                text1+text2,
                "text from editor is incorrect");
    }

}
