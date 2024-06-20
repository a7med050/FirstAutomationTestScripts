package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver){
        this.driver=driver;
    }

    /**
     *
     * @param index 1- based
     */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
    }

    private Dimension getNumberOfParagraphsPresent(){
        return driver.findElement(textBlocks).getSize();
    }
}
