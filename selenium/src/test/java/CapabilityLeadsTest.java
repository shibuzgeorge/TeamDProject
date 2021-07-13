import org.junit.Test;
import framework.FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CapabilityLeadsTest extends FunctionalTest{
    @Test
    public void assertTextIsValidOnLeadersCapabilityPage() {
        driver.get("http://localhost:3000/capabilityleaders");
        driver.findElement(By.id("imageID0")).click();
        driver.findElement(By.id("modalBodyID0")).click();
        String expectedReturn = "Come join the Engineering team";
        String result = driver.findElement(By.id("modalBodyID0")).getText();

        assertEquals(result, expectedReturn);
    }

    @Test
    public void assertModalCloseButtonExists() {
        driver.get("http://localhost:3000/capabilityleaders");
        driver.findElement(By.id("imageID0")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#modal0 .btn-close"));
            assert(elements.size() > 0);
        }
    }
}
