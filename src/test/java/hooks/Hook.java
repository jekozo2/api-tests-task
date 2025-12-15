package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;

@Slf4j
public class Hook {


    @Before()
    public void setupTestContext(Scenario scenario) {
        String env = System.getProperty("env",
                System.getenv("ENVIRONMENT") != null ?
                        System.getenv("ENVIRONMENT") : "dev");
        log.info(String.format("Running on '[%s]' ENVIRONMENT.", env));
    }

    @AfterTest()
    public void cleanupTestContext() {
    }
}
