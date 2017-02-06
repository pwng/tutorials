package com.ngpanwei.cucumber.invoicing;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true, 
		features = "src/test/resources/features" ,
		plugin = {"pretty", "html:target/cucumber"}
)
public class InvoicingTests {

}
