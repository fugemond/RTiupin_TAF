package core;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;

@Log4j2
@CucumberOptions(
        features = "src/test/java/core/tests/launches/features",
        glue = {"steps.ui"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
