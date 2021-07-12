import org.junit.Test;
import framework.FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class JobRolesTest extends FunctionalTest {

    @Test
    public void goToJobRoles() {
        driver.get("http://localhost:3000/jobroles");
        WebElement table = driver.findElement(By.id("jobRolesTable"));
        String roleName = table.findElement(By.id("roleName")).getText();
        String capability = table.findElement(By.id("capability")).getText();

        assertEquals("Fail if column Role Name heading doesn't exist","Role Name", roleName);
        assertEquals("Fail if column Capability heading doesn't exist", "Capability", capability);

    }
}
