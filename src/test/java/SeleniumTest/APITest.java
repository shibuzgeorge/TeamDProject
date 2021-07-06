package SeleniumTest;

import org.junit.jupiter.api.Test;

public class APITest extends SetUp {

    @Test
    public void goToBrowser() {
        driver.get("http://www.google.com");
    }
}
