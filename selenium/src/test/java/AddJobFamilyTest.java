import org.junit.Test;
import framework.FunctionalTest;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddJobFamilyTest extends FunctionalTest{

    @Test
    public void checkPageUIElementsLoadCorrectly(){
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();
        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();
        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/addjobfamily");
        WebElement header = driver.findElement(By.id("familyHeader"));
        WebElement nameTextBox = driver.findElement(By.id("jobFamilyName"));
        WebElement capabilityDropDown = driver.findElement(By.id("capability"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        assertEquals("Header text incorrect",header.getText(), "Add New Job Family");
        assertTrue("Job Family Name text entry not displayed",nameTextBox.isDisplayed());
        assertTrue("Capability drop down not present", capabilityDropDown.isDisplayed());
        assertTrue("Submit button not displayed", submitButton.isDisplayed());
    }

    @Test
    public void checkValidEntryIsInsertedCorrectly(){
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();
        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/addjobfamily");
        WebElement nameTextBox = driver.findElement(By.id("jobFamilyName"));
        WebElement capabilityDropDown = driver.findElement(By.id("capability"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        nameTextBox.sendKeys("Data Security");
        capabilityDropDown.sendKeys("Cyber Security");
        submitButton.click();

        WebElement successfulMessage = driver.findElement(By.id("message-dialog-box"));

        assertEquals(successfulMessage.getText(), "Inserted successfully");
    }

    @Test
    public void checkInvalidEntryIsNotInserted() {
        driver.get("http://localhost:3000/home");
        driver.findElement(By.id("logout")).click();
        loginAsA("Admin", driver);
        driver.get("http://localhost:3000/addjobfamily");
        WebElement nameTextBox = driver.findElement(By.id("jobFamilyName"));
        WebElement capabilityDropDown = driver.findElement(By.id("capability"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        nameTextBox.sendKeys("Engineering");
        capabilityDropDown.sendKeys("Engineering");
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error-dialog-box"));

        assertEquals(errorMessage.getText(), "Error\nJob Family already exists within this capability please select another capability or enter a different job family name");
    }
}
