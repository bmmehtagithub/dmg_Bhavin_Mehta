import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".",
        glue={"com.mailtravel.step_def", "com.mailtravel.hooks"},
        plugin ={"pretty", "html:target/cucumber-html-report","json:target/cucumber.json","rerun:target/rerun.txt"},
        dryRun = false,
        monochrome = true,
        tags = "@Regression"

)
public class RunCukesTest {
}
