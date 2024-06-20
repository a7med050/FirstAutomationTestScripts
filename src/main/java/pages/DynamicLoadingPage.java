package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpath_Format= "//*[@id=\"content\"]/div/a[1]";
    private String linkXpath2_Format= "//*[@id=\"content\"]/div/a[2]";
    private By link_example1 = By.xpath(String.format(linkXpath_Format,"Example 1"));
    private By link_example2 = By.xpath(String.format(linkXpath2_Format,"Example 2"));

    public DynamicLoadingPage(WebDriver driver){
        this.driver=driver;
    }
    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_example1).click();
        return new DynamicLoadingExample1Page(driver);
    }
    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(link_example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

}
