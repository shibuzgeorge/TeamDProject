import org.junit.Test;
import framework.FunctionalTest;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class LatticeTest extends FunctionalTest {

    @Test
    public void checkTableLayout() {
        driver.get("http://localhost:3000/capability/Engineering");
        assertEquals(driver.findElement(By.linkText("Principal")).getText(), "Principal");
        assertEquals(driver.findElement(By.linkText("Software Engineer")).getText(), "Software Engineer");
        assertEquals(driver.findElement(By.id("Architecture")).getText(), "Architecture");
        assertEquals(driver.findElement(By.linkText("Trainee")).getText(), "Trainee");
        assertEquals(driver.findElement(By.linkText("Lead Test Engineer")).getText(), "Lead Test Engineer");
    }

    @Test
    public void checkBandsAreCorrect(){
        driver.get("http://localhost:3000/capability/engineering");
        assertEquals(driver.findElement(By.linkText("Principal")).getText(), "Principal");
        assertEquals(driver.findElement(By.linkText("Manager")).getText(), "Manager");
        assertEquals(driver.findElement(By.linkText("Consultant")).getText(), "Consultant");
        assertEquals(driver.findElement(By.linkText("Senior Associate")).getText(), "Senior Associate");
        assertEquals(driver.findElement(By.linkText("Associate")).getText(), "Associate");
        assertEquals(driver.findElement(By.linkText("Trainee")).getText(), "Trainee");
        assertEquals(driver.findElement(By.linkText("Apprentice")).getText(), "Apprentice");
    }

    @Test
    public void checkThreeRandomRolesAreRight(){
        driver.get("http://localhost:3000/capability/engineering");
        assertEquals(driver.findElement(By.linkText("Senior Product Specialist")).getText(), "Senior Product Specialist");
        assertEquals(driver.findElement(By.linkText("Principal Architect")).getText(), "Principal Architect");
        assertEquals(driver.findElement(By.linkText("Test Engineer")).getText(), "Test Engineer");
        assertEquals(driver.findElement(By.linkText("Lead Software Engineer")).getText(), "Lead Software Engineer");
    }

    @Test
    public void checkBandURL() {
        driver.get("http://localhost:3000/capability/Engineering");
        assertEquals("http://localhost:3000/bands/7", driver.findElement(By.id("Principal")).getAttribute("href"));
    }

    @Test
    public void checkRoleURL() {
        driver.get("http://localhost:3000/capability/Engineering");
        assertEquals("http://localhost:3000/role/16", driver.findElement(By.id("Lead Software Engineer")).getAttribute("href"));
    }
}
