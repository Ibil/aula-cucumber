package pt.ulisboa.tecnico.softeng.bank.domain.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pt.ulisboa.tecnico.softeng.bank.domain.Account;
import pt.ulisboa.tecnico.softeng.bank.domain.Bank;
import pt.ulisboa.tecnico.softeng.bank.domain.Client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountSteps {
	
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
    }

    @When("^I deposit (\\d+) dollars in an empty account$")
    public void i_deposit_dollars_in_an_empty_account(int amount) {
		assertEquals(account.getBalance(), 0);
    	account.deposit(amount);
    }
 
    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int balance) {
        assertEquals(balance, account.getBalance());
    }
    
    @Given("^my account has a balance of (\\d+) dollars$")
    public void my_account_has_a_balance_of_dollars(int balance) throws Throwable {
    	int curr_balance = account.getBalance();
    	if(curr_balance == 0) {
            account.deposit(balance);
    	} else if(curr_balance > balance) {
    		account.withdraw(curr_balance - balance);
    	} else {
    		account.deposit(balance - curr_balance);
    	}
    	
        assertEquals(balance, account.getBalance());
    }

    @When("^I withdraw (\\d+) dollars from the account$")
    public void i_withdraw_dollars_from_the_account(int amount) throws Throwable {
        account.withdraw(amount);
    }

    @Then("^the result should be (\\d+) dollars$")
    public void the_result_should_be_dollars(int balance) throws Throwable {
        assertEquals(balance, account.getBalance());
    }
    
	@After
	public void tearDown() {
		Bank.banks.clear();
	}
}