package SeleniumTest;

import org.junit.Test;

public class APITest extends SetUp {

    @Test
    public void goToBrowser() {
        driver.get("http://www.google.com");
    }
}
