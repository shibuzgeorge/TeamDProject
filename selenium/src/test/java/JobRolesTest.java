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
    public void testAccordionTruncatedText() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.cssSelector(".col:nth-child(1) .card-img-top")).click();
        assertEquals(driver.findElement(By.id("accordionButtonId3")).getText(),"The development of high-quality solutions ...");
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
    public void assertCapabilitiesFilterShows(){
        driver.get("http://localhost:3000/jobroles");
        assertEquals(driver.findElement(By.id("capFilterButtonLabel")).getText(), "↓ Capabilities Filters:");
    }

    @Test
    public void assertJobFamiliesFilterShows(){
        driver.get("http://localhost:3000/jobroles");
        assertEquals(driver.findElement(By.id("jobFamilyFilterButtonLabel")).getText(), "↓ Job Families Filters:");
    }

    @Test
    public void assertFirstCapabilitiesFilterIsShowing(){
        driver.get("http://localhost:3000/jobroles");
        driver.findElement(By.id("capFilterButtonLabel")).click();
        assertEquals(driver.findElement(By.id("arTypeSwitchLabel")).getText(), "Artificial Intelligence");
    }

    @Test
    public void assertFirstJobFamiliesFilterIsShowing(){
        driver.get("http://localhost:3000/jobroles");
        driver.findElement(By.id("jobFamilyFilterButtonLabel")).click();
        assertEquals(driver.findElement(By.id("familyID0SwitchLabel")).getText(), "Artificial Intelligence (AI) Engineering");
    }

    @Test
    public void whenFilteringAllCapabilitiesButCybersecurityExpectExactJobRole(){
        driver.get("http://localhost:3000/jobroles");
        driver.findElement(By.id("capFilterButtonLabel")).click();
        driver.findElement(By.id("arTypeSwitchLabel")).click();
        driver.findElement(By.id("daTypeSwitchLabel")).click();
        driver.findElement(By.id("enTypeSwitchLabel")).click();
        driver.findElement(By.id("plTypeSwitchLabel")).click();
        assertEquals(driver.findElement(By.linkText("Security Architect")).getText(), "Security Architect");
    }

    @Test
    public void whenFilteringAllJobFamiliesButSecurityEngineeringExpectExactJobRole(){
        driver.get("http://localhost:3000/jobroles");
        driver.findElement(By.id("jobFamilyFilterButtonLabel")).click();
        driver.findElement(By.id("familyID0SwitchLabel")).click();
        driver.findElement(By.id("familyID2SwitchLabel")).click();
        driver.findElement(By.id("familyID3SwitchLabel")).click();
        driver.findElement(By.id("familyID4SwitchLabel")).click();
        driver.findElement(By.id("familyID5SwitchLabel")).click();
        driver.findElement(By.id("familyID6SwitchLabel")).click();
        driver.findElement(By.id("familyID7SwitchLabel")).click();
        driver.findElement(By.id("familyID8SwitchLabel")).click();
        assertEquals(driver.findElement(By.id("jobFamily7")).getText(), "Security Engineering");
    }

}
