import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import framework.FunctionalTest;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;


public class CompetenciesTest extends FunctionalTest {

    @Test
    public void dropDownDefaultTextIsCorrect() {
        driver.get("http://localhost:3000/bands");
        driver.findElement(By.id("defaultMySelectOption")).click();

        String expectedText = "Select an Option";
        String result = driver.findElement(By.id("defaultMySelectOption")).getText();

        assertEquals(result, expectedText);
    }

    @Test
    public void dropDownSelectedText() {
        driver.get("http://localhost:3000/bands");
        driver.findElement(By.id("defaultMySelectOption")).click();

        String notExpectedText = "Apprentice";
        String result = driver.findElement(By.id("bandSelectApprentice")).getText();

        System.out.println("notExpectedText:" + notExpectedText);
        System.out.println("result:" + result);

        assertEquals(result, notExpectedText);
    }

    @Test
    public void competencyTableHeadersAreCorrect() {
        driver.get("http://localhost:3000/bands");
        driver.findElement(By.id("defaultMySelectOption")).click();

        driver.findElement(By.id("bandSelectApprentice")).click();

        String competencyNameHeaderText = driver.findElement(By.id("competencyName")).getText();
        String competencyDescriptionHeaderText = driver.findElement(By.id("competencyDescription")).getText();

        String compNameHeaderExpected = "Competency Name";
        String compDescriptionHeaderExpected = "Description";

        assertEquals(competencyNameHeaderText, compNameHeaderExpected);
        assertEquals(competencyDescriptionHeaderText, compDescriptionHeaderExpected);
    }



}




