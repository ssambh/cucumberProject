package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "./src/test/java/features/PersonalizeYourStore.feature",
		glue="stepDefinitions",
		dryRun=false,
		plugin= {"pretty","html:target/cucumberResults.html"}
		) 

public class TestRunner {

	
}
