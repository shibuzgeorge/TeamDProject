package SeleniumTest;

import org.junit.Test;

public class APITest extends SetUp {

    @Test
    public void OpenAPILocalhost() {
        driver.get("http://localhost:8080");
    }
}
