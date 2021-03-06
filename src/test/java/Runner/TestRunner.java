package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature",
        glue = {"stepDefinitions"},
        plugin = {"html:target/cucumber-html-report"},
        tags = {"@tag"}

)

public class TestRunner {


}
