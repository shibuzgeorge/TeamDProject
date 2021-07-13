import org.junit.Test;
import framework.FunctionalTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
        String jobFamily = table.findElement(By.id("jobFamily")).getText();


        assertEquals("Fail if column Band heading doesn't exist","Band", band);
        assertEquals("Fail if column Job Summary heading doesn't exist", "Job Summary", jobSummary);
        assertEquals("Fail if column Capability heading doesn't exist", "Capability", capability);
        assertEquals("Fail if column job Family heading doesn't exist", "Job Family", jobFamily);
        assertEquals("Fail if column Specification heading doesn't exist", "Specification", specification);
        assertEquals("Fail if column Role Name heading doesn't exist","Role Name", roleName);
    }

    @Test
    public void checkAccordionTextExpandedIsCorrect() {
        driver.get("http://localhost:3000/jobroles");
        driver.findElement(By.id("accordionButtonId3")).click();
        driver.findElement(By.id("accordionBodyId3")).click();
        assertEquals(driver.findElement(By.id("accordionBodyId3")).getText(), "The development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologies");
    }

    @Test
    public void checkAccordionHeaderTruncatedText(){
        driver.get("http://localhost:3000/jobroles");
        WebElement accordionButton = driver.findElement(By.id("accordionButtonId3"));
        accordionButton.click();
        WebElement accordionBody = driver.findElement(By.id("accordionBodyId3"));
        String accordionBodyText = accordionBody.getText();
        String expectedReturn = "The development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologies";

        assertEquals(expectedReturn, accordionBodyText);

    }

    @Test
    public void assertSortByWorksCorrectly() {
        driver.get("http://localhost:3000/jobroles");
        driver.findElement(By.id("roleName 3")).click();
        assertEquals(driver.findElement(By.id("roleName 3")).getText(), "Apprentice AI Engineer");
        driver.findElement(By.id("capability3")).click();
        assertEquals(driver.findElement(By.id("capability3")).getText(), "Artificial Intelligence");
        driver.findElement(By.id("jobFamily3")).click();
        assertEquals(driver.findElement(By.id("jobFamily3")).getText(), "Artificial Intelligence (AI) Engineering");
        driver.findElement(By.id("band3")).click();
        assertEquals(driver.findElement(By.id("band3")).getText(), "Apprentice");
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
