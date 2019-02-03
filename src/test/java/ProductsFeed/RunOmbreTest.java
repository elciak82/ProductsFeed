package ProductsFeed;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ProductsFeed/ombre.feature",
        plugin = {"pretty", "html:target/cucumber-html-report"}
//        ,glue = {"ProductsFeed"}
        )
public class RunOmbreTest {
}
