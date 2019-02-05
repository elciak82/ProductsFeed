package ProductsFeed;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@ombreTest",
//        features = "src/test/resources/ProductsFeed/addProducts.feature",
        plugin = {"pretty", "html:target/cucumber-html-report"}
//        ,glue = {"ProductsFeed"}
        )
public class RunOmbreTest {
}
