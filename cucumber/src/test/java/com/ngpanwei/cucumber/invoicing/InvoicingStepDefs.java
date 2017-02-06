package com.ngpanwei.cucumber.invoicing;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvoicingStepDefs extends AbstractDefs {
	@Given("^on a certain day '(\\d+)-(\\d+)-(\\d+)'$")
	public void on_a_certain_day(int arg1, int arg2, int arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^processing invoices$")
	public void processing_invoices() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^merchant 'A' receive invoice$")
	public void merchant_A_receive_invoice() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
