package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		dryRun=false,
		features = {"src/test/resource/appFeatures/OpenCart.feature"},
		glue = {"stepDefinitions", "appHooks"},
		//tags = "@regression",
		
		plugin = {
				"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)

public class MyTestRunner {

}
