import framework.FunctionalTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class EditJobFamilyTest extends FunctionalTest {

    @Test
    public void checkJobFamilyNameAndCapabilityDisplayedInEdit() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/editjobfamily/1");
        {
            String value = driver.findElement(By.id("jobFamilyName")).getAttribute("value");
            assertEquals("Testing and Quality Assurance", value);
        }
        {
            String value = driver.findElement(By.id("capability")).getAttribute("value");
            assertEquals("Engineering", value);
        }
    }

    @Test
    public void editOnlyJobFamilyNameSuccess() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/editjobfamily/1");
        driver.findElement(By.id("jobFamilyName")).clear();
        driver.findElement(By.id("jobFamilyName")).sendKeys("Testing and Quality Assuranc");
        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Success! Updated successfully", driver.findElement(By.cssSelector(".alert")).getText());
        driver.findElement(By.cssSelector(".btn-outline-secondary")).click();
        assertEquals("Testing and Quality Assuranc", driver.findElement(By.id("jobFamilyName1")).getText());

        //rollback
        driver.get("http://localhost:3000/editjobfamily/1");
        driver.findElement(By.id("jobFamilyName")).clear();
        driver.findElement(By.id("jobFamilyName")).sendKeys("Testing and Quality Assurance");
        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Success! Updated successfully", driver.findElement(By.cssSelector(".alert")).getText());

    }

    @Test
    public void editOnlyCapabilitySuccess() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/editjobfamily/1");
        {
            WebElement dropdown = driver.findElement(By.id("capability"));
            dropdown.findElement(By.xpath("//option[. = 'Artificial Intelligence']")).click();
        }
        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Success! Updated successfully", driver.findElement(By.cssSelector(".alert")).getText());
        driver.findElement(By.cssSelector(".btn-outline-secondary")).click();
        assertEquals("Artificial Intelligence", driver.findElement(By.id("capability1")).getText());

        //rollback
        driver.get("http://localhost:3000/editjobfamily/1");
        {
            WebElement dropdown = driver.findElement(By.id("capability"));
            dropdown.findElement(By.xpath("//option[. = 'Engineering']")).click();
        }
        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Success! Updated successfully", driver.findElement(By.cssSelector(".alert")).getText());

    }

    @Test
    public void editBothJobFamilyNameCapabilitySuccess() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/editjobfamily/1");
        {
            WebElement dropdown = driver.findElement(By.id("capability"));
            dropdown.findElement(By.xpath("//option[. = 'Artificial Intelligence']")).click();
        }
        driver.findElement(By.id("jobFamilyName")).clear();
        driver.findElement(By.id("jobFamilyName")).sendKeys("Testing and Quality Assuranc");

        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Success! Updated successfully", driver.findElement(By.cssSelector(".alert")).getText());
        driver.findElement(By.cssSelector(".btn-outline-secondary")).click();
        assertEquals("Testing and Quality Assuranc", driver.findElement(By.id("jobFamilyName1")).getText());
        assertEquals("Artificial Intelligence", driver.findElement(By.id("capability1")).getText());

        //rollback
        driver.get("http://localhost:3000/editjobfamily/1");
        {
            WebElement dropdown = driver.findElement(By.id("capability"));
            dropdown.findElement(By.xpath("//option[. = 'Engineering']")).click();
        }
        driver.findElement(By.id("jobFamilyName")).clear();
        driver.findElement(By.id("jobFamilyName")).sendKeys("Testing and Quality Assurance");
        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Success! Updated successfully", driver.findElement(By.cssSelector(".alert")).getText());

    }

    @Test
    public void editBothJobFamilyNameCapabilityWhichAlreadyExists() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/editjobfamily/1");
        {
            WebElement dropdown = driver.findElement(By.id("capability"));
            dropdown.findElement(By.xpath("//option[. = 'Artificial Intelligence']")).click();
        }
        driver.findElement(By.id("jobFamilyName")).clear();
        driver.findElement(By.id("jobFamilyName")).sendKeys("Artificial Intelligence (AI) Engineering");

        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Error! Job Family already exists within this capability please select another capability or enter a different job family name.", driver.findElement(By.cssSelector(".alert")).getText());
        driver.findElement(By.cssSelector(".btn-outline-secondary")).click();
        assertEquals("Testing and Quality Assurance", driver.findElement(By.id("jobFamilyName1")).getText());
        assertEquals("Engineering", driver.findElement(By.id("capability1")).getText());

    }

    @Test
    public void editJobFamilyNameWhichAlreadyExistsInCapability() {
        //Log out first
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();

        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/editjobfamily/1");
        driver.findElement(By.id("jobFamilyName")).clear();
        driver.findElement(By.id("jobFamilyName")).sendKeys("Engineering");

        driver.findElement(By.cssSelector(".btn-success")).click();
        assertEquals("Error! Job Family already exists within this capability please select another capability or enter a different job family name.", driver.findElement(By.cssSelector(".alert")).getText());
        driver.findElement(By.cssSelector(".btn-outline-secondary")).click();
        assertEquals("Testing and Quality Assurance", driver.findElement(By.id("jobFamilyName1")).getText());
        assertEquals("Engineering", driver.findElement(By.id("capability1")).getText());

    }
}
