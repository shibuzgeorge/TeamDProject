package framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTest {

    protected static WebDriver driver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
