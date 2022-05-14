package Tests;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class BaseTest {
    HomePage homePage;
    private String URL="https://the-internet.herokuapp.com/";
    public WebDriver driver;


    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName)
    {

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();

            driver=new ChromeDriver();
        }

        else if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();

            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome-headless"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        homePage=new HomePage(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(URL);

    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            System.out.println("Faild!");
            System.out.println("Taking Screenshot.......");
            Helper.captureScreenshot(driver,result.getName());
        }


    }
}
