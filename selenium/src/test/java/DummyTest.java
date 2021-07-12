package test.java;

import org.junit.Test;

import framework.FunctionalTest;

public class DummyTest extends FunctionalTest {

    @Test
    public void signMeUp() {
        driver.get("http://www.google.com");
    }
}
