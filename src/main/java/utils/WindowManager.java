package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver=driver;
        navigate=driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void refreshPage(){
        navigate.refresh();
    }
    public void goTo(String url){
        navigate.to(url);
    }
    public void switchToTab(String tabTitle){
       var windows = driver.getWindowHandles();
       System.out.println("Number of Tabs " + windows.size());
        System.out.println("Window Handles:");
        windows.forEach(System.out::println);
        for(String window : windows ){
            System.out.println("Switching to Window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current Window Title: " + driver.getTitle());
            if (tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }
}
