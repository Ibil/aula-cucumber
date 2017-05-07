package pt.ulisboa.tecnico.softeng.bank.domain.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:cucumber/bank.feature",
        glue = "pt.ulisboa.tecnico.softeng.bank.domain.cucumber.steps"
)


public class RunBankConstructorTest {
	
}