package framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTest {

    protected static WebDriver driver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Before
    public void login() {
        driver.get("http://localhost:3000/login");
        driver.findElement(By.name("username")).sendKeys("employee");
        driver.findElement(By.name("password")).sendKeys("employeepass");
        driver.findElement(By.cssSelector("input:nth-child(3)")).click();
    }

    public void loginAsA(String role, WebDriver driver) {
        if (role.equals("Admin")){
            driver.get("http://localhost:3000/login");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("adminpass");
            driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        } else{
            driver.get("http://localhost:3000/login");
            driver.findElement(By.name("username")).sendKeys("employee");
            driver.findElement(By.name("password")).sendKeys("employeepass");
            driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        }
    }

    @After
    public void cleanUp() {
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
