package Tests;

import Pages.HoverPage;
import org.testng.annotations.Test;

public class HoverPageTest extends BaseTest{
    HoverPage hoverPage;
    @Test
    public void hoverOnUser() throws InterruptedException {
        homePage.openHoverPage();
        hoverPage= new HoverPage(driver);
        hoverPage.hoveOn(2);
        Thread.sleep(3000);


    }
}
