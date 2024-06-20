package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
   private WebDriver driver;
   private String editorFramId = "mce_0_ifr";
   private By textArea = By.id("tinymce");

   public WysiwygEditorPage(WebDriver driver){
       this.driver=driver;
   }
   private void switchToEditArea(){
       driver.switchTo().frame(editorFramId);
   }
   public void clearTextArea(){
       switchToEditArea();
       driver.findElement(textArea).clear();
       switchToMainArea();
   }
    public String getTextFromEditor(){
        switchToEditArea();
       String text=  driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
   private void switchToMainArea(){
       driver.switchTo().parentFrame();
   }
}
