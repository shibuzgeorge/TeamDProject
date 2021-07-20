import framework.FunctionalTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class RoleTest extends FunctionalTest {

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

    @Test
    public void checkCorrectResponsibility() {
        driver.get("http://localhost:3000/role/3");
        driver.findElement(By.cssSelector("h2:nth-child(14)")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(14)")).getText(),"Role Responsibilities: As a Trainee Artificial Intelligence (AI) Engineer in Kainos, you’ll be responsible for contributing to the development of high-quality solutions which integrate AI and ML technologies that delight our customers and impact the lives of users worldwide.");
    }

    /**
     * This test checks that the field titles are present and correct
     */
    @Test
    public void checkCorrectFields() {
        driver.get("http://localhost:3000/role/3");
        driver.findElement(By.cssSelector("h1 > u")).click();
        assertEquals(driver.findElement(By.cssSelector("h1 > u")).getText(),"Role:");
        driver.findElement(By.cssSelector("h2:nth-child(4) > u")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(4) > u")).getText(),"Summary:");
        driver.findElement(By.cssSelector(".govuk-template__body")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(6) > u")).getText(),"Capability:");
        driver.findElement(By.cssSelector("h2:nth-child(8) > u")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(8) > u")).getText(),"Band:");
        driver.findElement(By.cssSelector("h2:nth-child(10) > u")).click();
        driver.findElement(By.cssSelector("h2:nth-child(10) > u")).click();
        driver.findElement(By.cssSelector(".govuk-template__body")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".govuk-template__body"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(10) > u")).getText(),"Specification:");
        driver.findElement(By.cssSelector("h2:nth-child(12) > u")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(12) > u")).getText(),"Job Family:");
        driver.findElement(By.cssSelector("h2:nth-child(14) > u")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(14) > u")).getText(),"Role Responsibilities:");
    }

    @Test
    public void checkCorrectFieldContents() {
        driver.get("http://localhost:3000/role/3");
        driver.findElement(By.cssSelector("h1")).click();
        assertEquals(driver.findElement(By.cssSelector("h1")).getText(),"Role: Apprentice AI Engineer");
        driver.findElement(By.cssSelector("h2:nth-child(4)")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(4)")).getText(),"Summary: The development of high-quality solutions which integrate AI and ML technologies");
        driver.findElement(By.cssSelector("h2:nth-child(6)")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(6)")).getText(),"Capability: Artificial Intelligence");
        driver.findElement(By.cssSelector("h2:nth-child(8)")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(8)")).getText(),"Band: Apprentice");
        driver.findElement(By.cssSelector("h2:nth-child(12)")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(12)")).getText(),"Job Family: Artificial Intelligence (AI) Engineering");
        driver.findElement(By.cssSelector("h2:nth-child(14)")).click();
        assertEquals(driver.findElement(By.cssSelector("h2:nth-child(14)")).getText(),"Role Responsibilities: As a Trainee Artificial Intelligence (AI) Engineer in Kainos, you’ll be responsible for contributing to the development of high-quality solutions which integrate AI and ML technologies that delight our customers and impact the lives of users worldwide.");
    }

    @Test
    public void checkSpecificationURL() {
        driver.get("http://localhost:3000/role/3");
        assertEquals("https://kainossoftwareltd.sharepoint.com/:b:/g/people/Eci7E2WouKdNr5A-q3F9f8wBe9UEdviulHqKp0LVh3BH3A?e=gEI9JV", driver.findElement(By.id("specificationLink")).getAttribute("href"));
    }
}
