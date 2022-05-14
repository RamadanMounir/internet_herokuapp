package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By EmailField     = By.id("username");
    By PasswordField  = By.id("password");
    By Login          = By.cssSelector("button.radius");

    public void register(String email , String password){
        setText(EmailField,email);
        setText(PasswordField,password);
    }
    public SecurePage login(){
        click(Login);
        return new SecurePage(driver);

    }

}
