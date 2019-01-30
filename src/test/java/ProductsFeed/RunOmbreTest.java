package ProductsFeed;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ProductsFeed/ombre.feature"
        ,glue = {"OmbreStepsdefs"}
        )

public class RunOmbreTest {
}
