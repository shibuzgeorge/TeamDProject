import org.junit.Test;
import framework.FunctionalTest;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobRolesTest extends FunctionalTest {

    @Test
    public void checkRoleNameColumnExistsOnJobRolesTable(){
        driver.get("http://localhost:3000/jobroles");
        WebElement table = driver.findElement(By.id("jobRolesTable"));
        String roleName = table.findElement(By.id("roleName")).getText();

        assertEquals("Fail if column Role Name heading doesn't exist","Role Name", roleName);
    }

    @Test
    public void checkCapabilityColumnExistsOnJobRolesTable(){
        driver.get("http://localhost:3000/jobroles");
        WebElement table = driver.findElement(By.id("jobRolesTable"));
        String capability = table.findElement(By.id("capability")).getText();

        assertEquals("Fail if column Capability heading doesn't exist", "Capability", capability);
    }

    @Test
    public void checkAccordionWorksOnJobRolesTable(){
        driver.get("http://localhost:3000/jobroles");
        WebElement accordionButton = driver.findElement(By.id("accordionButtonId3"));
        accordionButton.click();
        WebElement accordionBody = driver.findElement(By.id("accordionBodyId3"));
        String accordionBodyText = accordionBody.getText();
        String expectedReturn = "The development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologiesThe development of high-quality solutions which integrate AI and ML technologies";

        assertEquals(expectedReturn, accordionBodyText);

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
        driver.manage().window().setSize(new Dimension(1434, 818));
        driver.findElement(By.id("roleName 3")).click();
        assertEquals(driver.findElement(By.id("roleName 3")).getText(), "Apprentice AI Engineer");
        driver.findElement(By.id("capability3")).click();
        assertEquals(driver.findElement(By.id("capability3")).getText(), "Artificial Intelligence");
        driver.findElement(By.id("jobFamily3")).click();
        assertEquals(driver.findElement(By.id("jobFamily3")).getText(), "Artificial Intelligence (AI) Engineering");
        driver.findElement(By.id("band3")).click();
        assertEquals(driver.findElement(By.id("band3")).getText(), "Apprentice");
    }
}
