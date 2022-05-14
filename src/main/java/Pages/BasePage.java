package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
   static WebDriver driver;
   public BasePage(WebDriver driver){
       PageFactory.initElements(driver,this);
       BasePage.driver=driver;
   }
    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void setText(By locator1 , String value){
        driver.findElement(locator1).sendKeys(value);
    }

    static By Target;
    protected static void scroll(){
        JavascriptExecutor js =((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);",Target);
        click(Target);
    }
}



