package node.SeleniumTest;

import org.junit.jupiter.api.Test;

class DummyTest extends BaseIntegrationTest {

    @Test
    public void goToBrowser() {
        driver.get("http://www.google.com");
    }
}
