import framework.FunctionalTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class TrainingTest extends FunctionalTest {

    @Test
    public void getTrainingDetailsForApprentice() {
        driver.get("http://localhost:3000/training");
        driver.findElement(By.id("band")).click();
        {
            WebElement dropdown = driver.findElement(By.id("band"));
            dropdown.findElement(By.xpath("//option[. = 'Apprentice']")).click();
        }

        assertEquals("Mindset Modules", driver.findElement(By.cssSelector(".pType h4")).getText());
        assertEquals("Category: Professional Skills", driver.findElement(By.cssSelector(".pType .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(1) .btn")).getText() );
        assertEquals("https://kainossoftwareltd.sharepoint.com/L%26D/SitePages/Mindset.aspx", driver.findElement(By.cssSelector(".col-6:nth-child(1) a")).getAttribute("href") );

        assertEquals("Java Development", driver.findElement(By.cssSelector(".tType h4")).getText());
        assertEquals("Category: Technical skills", driver.findElement(By.cssSelector(".tType .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(2) .btn")).getText());
        assertEquals("http://jer.metapath.org/JavaCourse/", driver.findElement(By.cssSelector(".col-6:nth-child(2) a")).getAttribute("href") );

    }

    @Test
    public void checkDataForOnlyProfessionalSkills() {
        driver.get("http://localhost:3000/training");
        driver.findElement(By.id("band")).click();
        {
            WebElement dropdown = driver.findElement(By.id("band"));
            dropdown.findElement(By.xpath("//option[. = 'Associate']")).click();
        }
        driver.findElement(By.id("tTypeSwitch")).click();
        driver.findElement(By.id("dTypeSwitch")).click();

        assertEquals(3, driver.findElement(By.cssSelector(".row")).findElements(By.cssSelector(".pType")).size());

        assertEquals("Mindset Modules", driver.findElement(By.cssSelector(".pType h4")).getText());
        assertEquals("Category: Professional Skills", driver.findElement(By.cssSelector(".pType .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(1) .btn")).getText() );
        assertEquals("https://kainossoftwareltd.sharepoint.com/L%26D/SitePages/Mindset.aspx", driver.findElement(By.cssSelector(".col-6:nth-child(1) a")).getAttribute("href") );

        assertEquals("Effective Time Management", driver.findElement(By.cssSelector(".col-6:nth-child(2) h4")).getText());
        assertEquals("Category: Professional Skills", driver.findElement(By.cssSelector(".col-6:nth-child(2) .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(2) .btn")).getText() );
        assertEquals("https://kainossoftwareltd.sharepoint.com/L%26D/SitePages/Time-Management.aspx", driver.findElement(By.cssSelector(".col-6:nth-child(2) a")).getAttribute("href") );

        assertEquals("Presenting With Impact", driver.findElement(By.cssSelector(".col-6:nth-child(3) h4")).getText());
        assertEquals("Category: Professional Skills", driver.findElement(By.cssSelector(".col-6:nth-child(3) .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(3) .btn")).getText() );
        assertEquals("https://kainossoftwareltd.sharepoint.com/L%26D/SitePages/Presenting-with-Impact.aspx", driver.findElement(By.cssSelector(".col-6:nth-child(3) a")).getAttribute("href") );
    }

    @Test
    public void checkDataForOnlyTechnicalSkills() {
        driver.get("http://localhost:3000/training");
        driver.findElement(By.id("band")).click();
        {
            WebElement dropdown = driver.findElement(By.id("band"));
            dropdown.findElement(By.xpath("//option[. = 'Apprentice']")).click();
        }
        driver.findElement(By.id("pTypeSwitch")).click();
        driver.findElement(By.id("dTypeSwitch")).click();

        assertEquals(1, driver.findElement(By.cssSelector(".row")).findElements(By.cssSelector(".tType")).size());

        assertEquals("Java Development", driver.findElement(By.cssSelector(".tType h4")).getText());
        assertEquals("Category: Technical skills", driver.findElement(By.cssSelector(".tType .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(2) .btn")).getText());
        assertEquals("http://jer.metapath.org/JavaCourse/", driver.findElement(By.cssSelector(".col-6:nth-child(2) a")).getAttribute("href") );
    }

    @Test
    public void checkDataForOnlyDevelopmentProgrammes() {
        driver.get("http://localhost:3000/training");
        driver.findElement(By.id("band")).click();
        {
            WebElement dropdown = driver.findElement(By.id("band"));
            dropdown.findElement(By.xpath("//option[. = 'Senior Associate']")).click();
        }
        driver.findElement(By.id("tTypeSwitch")).click();
        driver.findElement(By.id("pTypeSwitch")).click();

        assertEquals(1, driver.findElement(By.cssSelector(".row")).findElements(By.cssSelector(".dType")).size());

        assertEquals("Managing Change", driver.findElement(By.cssSelector(".dType h4")).getText());
        assertEquals("Category: Development programmes", driver.findElement(By.cssSelector(".dType .list-group-item:nth-child(2)")).getText());
        assertEquals("See more", driver.findElement(By.cssSelector(".col-6:nth-child(5) .btn")).getText());
        assertEquals("https://kainossoftwareltd.sharepoint.com/L%26D/SitePages/Managing-Change.aspx", driver.findElement(By.cssSelector(".col-6:nth-child(5) a")).getAttribute("href") );
    }
}
