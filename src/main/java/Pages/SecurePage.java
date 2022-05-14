package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage{

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    By AlertMessage = By.xpath("//div[@id='flash']");
    By     logout     = By.xpath("//a[@class='button secondary radius']");


public String getAlertText(){
    return driver.findElement(AlertMessage).getText();
}
    public LoginPage Logout(){
        click(logout);
        return new LoginPage(driver);
    }


}
