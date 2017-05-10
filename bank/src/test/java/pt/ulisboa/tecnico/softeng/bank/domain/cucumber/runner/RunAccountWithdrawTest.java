package pt.ulisboa.tecnico.softeng.bank.domain.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome = true,
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:cucumber/account_withdraw.feature",
        glue = "pt.ulisboa.tecnico.softeng.bank.domain.cucumber.steps"
)

public class RunAccountWithdrawTest {

}
