package pt.ulisboa.tecnico.softeng.bank.domain.cucumber.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pt.ulisboa.tecnico.softeng.bank.domain.Account;
import pt.ulisboa.tecnico.softeng.bank.domain.Bank;
import pt.ulisboa.tecnico.softeng.bank.domain.Client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BankConstructorSteps {
	
	private static final String BANK_CODE = "BK01";
	private static final String BANK_NAME = "Money";
	
    private Bank bank;
	private Client client;
	private Account account;

    @Before
    public void setUp() {
		this.bank = new Bank(BANK_NAME, BANK_CODE);
		this.client = new Client(this.bank, "Rui");
		this.account = new Account(this.bank, client);
    }
	
	@Given("^I have an account$")
    public void i_have_an_account() throws Throwable {
		assertNotNull(bank);
		assertNotNull(client);
		assertNotNull(account);
		assertEquals(account.getBalance(), 0);
    }

    @When("^I deposit (\\d+) dollars in an empty account$")
    public void i_deposit_dollars_in_an_empty_account(int amount) {
    	account.deposit(amount);
    }
 
    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int balance) {
        assertEquals(balance, account.getBalance());
    }
}