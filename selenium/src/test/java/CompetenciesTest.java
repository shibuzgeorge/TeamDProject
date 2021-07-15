import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import framework.FunctionalTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

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




