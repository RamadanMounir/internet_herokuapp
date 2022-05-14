package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverPage extends BasePage{


    public HoverPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> users = driver.findElements(By.xpath("//div[@class='figure']"));
    By profile= new By.ByLinkText("View profile");
    Actions action = new Actions(driver);


    public void hoveOn(int Userindex){

        action.moveToElement((WebElement) users.get(Userindex)).build().perform();
        driver.findElement(profile).click();

    }

}
