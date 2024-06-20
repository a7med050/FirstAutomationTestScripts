package base;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.annotations.IBeforeClass;
import pages.HomePage;
import utils.WindowManager;

import javax.swing.text.Element;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        homePage = new HomePage(driver);
        setCookies();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @AfterMethod
    public void recordFailure(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("ScreenShot Taken: " + screenShot.getAbsolutePath());
            try {
                Files.move(screenShot,new File("resources/ScreenShots/" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }
    private void setCookies(){
        Cookie cookie= new Cookie.Builder("Ahmed","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}

