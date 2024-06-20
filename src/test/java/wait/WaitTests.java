package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage= homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),
                "Hello World!",
                "loaded text incorrect");
    }
    @Test
    public void testWaitUntilHidden2(){
        var loadingPage= homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),
                "Hello World!",
                "loaded text incorrect");
    }
}
