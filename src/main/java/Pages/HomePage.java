package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    By Authentication_Form = By.linkText("Form Authentication");
    By HoverLink = new By.ByXPath("//a[text()='Hovers']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openAuthenticationForm(){
        click(Authentication_Form);
        return new LoginPage(driver);
    }
    public HoverPage openHoverPage(){
        click(HoverLink);
        return new HoverPage(driver);
    }

}
