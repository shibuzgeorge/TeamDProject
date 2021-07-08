package node.SeleniumTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JobRolesTest extends BaseIntegrationTest {

    @Test
    public void goToJobRoles() {
        driver.get("http://localhost:3000/jobroles");
        WebElement table = driver.findElement(By.id("jobRolesTable"));
        String roleName = table.findElement(By.id("roleName")).getText();
        String capability = table.findElement(By.id("capability")).getText();

        Assertions.assertEquals("Role Name", roleName, "Fail if column Role Name heading doesn't exist");
        Assertions.assertEquals("Capability", capability, "Fail if column Capability heading doesn't exist");

    }
}
