package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.*;



@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/resources/functionalTests",
			glue={"stepDefinations"},
			plugin = {"pretty","html:target/reports/cucumber.html"}
		

		
		)


	public class TestRunner {


}