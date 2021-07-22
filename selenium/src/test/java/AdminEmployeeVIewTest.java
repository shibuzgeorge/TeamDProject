import framework.FunctionalTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdminEmployeeVIewTest extends FunctionalTest {

    @Test
    public void loginAsEmployeeHomePageView() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Employee", driver);
        assertEquals("Welcome employee", driver.findElement(By.cssSelector("h1")).getText());
        driver.get("http://localhost:3000/");
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#jobroles .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#capabilityleaders .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#bands .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#training .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#addjobfamily .card-img-top"));
            assert(elements.size() == 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#jobfamily .card-img-top"));
            assert(elements.size() == 0);
        }

    }

    @Test
    public void loginAsAdminHomePageView() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        assertEquals("Welcome admin", driver.findElement(By.cssSelector("h1")).getText());
        driver.get("http://localhost:3000/");
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#jobroles .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#capabilityleaders .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#bands .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#training .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#addjobfamily .card-img-top"));
            assert(elements.size() == 1);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#jobfamily .card-img-top"));
            assert(elements.size() == 1);
        }
    }
}
