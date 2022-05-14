package Tests;

import Pages.LoginPage;
import Pages.SecurePage;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;

public class registerationTest extends BaseTest{
    String email = "tomsmith";
    String password = "SuperSecretPassword!";

    @Test
    public void successfulRegisteration() throws InterruptedException {
        LoginPage   loginPage = homePage.openAuthenticationForm();
        loginPage.register(email,password);
        SecurePage securePage = loginPage.login();
        Assert.assertTrue(securePage.getAlertText()
                .contains("You logged into a secure area!")
                ,"alertfu");
        securePage.Logout();




    }

}
