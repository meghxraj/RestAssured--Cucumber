package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", // path of the feature file - can give exact locatoin of features or just the package
		glue = {"stepDefinations"}, //stepDefinations package
		//tags="@DeletePlace"
		plugin = "json:target/jsonReports/cumcumber-test-report.json"
		)
public class TestRunner {
	
}
