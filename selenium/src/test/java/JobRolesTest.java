import org.junit.Test;
import framework.FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class JobRolesTest extends FunctionalTest {

    @Test
    public void getAllTableHeadings() {
        driver.get("http://localhost:3000/jobroles");
        WebElement table = driver.findElement(By.id("jobRolesTable"));
        String roleName = table.findElement(By.id("roleName")).getText();
        String capability = table.findElement(By.id("capability")).getText();
        String band = table.findElement(By.id("band")).getText();
        String jobSummary = table.findElement(By.id("jobSummary")).getText();
        String specification = table.findElement(By.id("specification")).getText();

        assertEquals("Fail if column Role Name heading doesn't exist","Role Name", roleName);
        assertEquals("Fail if column Capability heading doesn't exist", "Capability", capability);
        assertEquals("Fail if column Band heading doesn't exist","Band", band);
        assertEquals("Fail if column Job Summary heading doesn't exist", "Job Summary", jobSummary);
        assertEquals("Fail if column Specification heading doesn't exist", "Specification", specification);
    }

    @Test
    public void getRoleByIdPass() {
        driver.get("http://localhost:3000/role/1");
        assertEquals(driver.findElement(By.cssSelector("h1")).getText(),"Role: Test Engineer");
    }

    @Test
    public void getRoleByIdFail() {
        driver.get("http://localhost:3000/role/random");
        assertEquals(driver.findElement(By.cssSelector("h1")).getText(),"Role not found");
    }
}
