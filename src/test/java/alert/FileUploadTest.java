package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTest extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.UploadFile
                ("D:\\projects\\FirstTest\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(),
                "chromedriver.exe",
                "uploaded file incorrect");
    }
}
