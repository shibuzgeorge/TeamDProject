import framework.FunctionalTest;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

public class LoginTest extends FunctionalTest {

    @Test
    public void loginAsEmployee() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Employee", driver);
        assertEquals("Welcome employee", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void loginAsAdmin() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        assertEquals("Welcome admin", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void invalidLoginAndLogBackIn() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        driver.get("http://localhost:3000/login");
        driver.findElement(By.name("username")).sendKeys("random");
        driver.findElement(By.name("password")).sendKeys("random");
        driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        assertEquals("Error", driver.findElement(By.cssSelector("figcaption")).getText());
        assertEquals("Invalid credentials", driver.findElement(By.cssSelector("p")).getText());

        loginAsA("Employee", driver);
        assertEquals("Welcome employee", driver.findElement(By.cssSelector("h1")).getText());
    }

}
