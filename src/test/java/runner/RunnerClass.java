package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Lenovo\\Hameed\\CucumberProject\\src\\test\\java\\feature\\demo.feature",
		glue= {"step"},
		plugin= {"pretty","html/target/cucumber/demo.HTML"}
		)
public class RunnerClass {
}
