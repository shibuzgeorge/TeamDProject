package node.SeleniumTest;

import org.junit.jupiter.api.Test;

class DummyTest extends BaseIntegrationTest {

    @Test
    public void goToBrowser() {
        driver.get("http://127.0.0.1/3000/jobRoles");
    }
}
