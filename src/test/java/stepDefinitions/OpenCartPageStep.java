package stepDefinitions;

import com.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.OpenCartPage;

public class OpenCartPageStep {
	
	private OpenCartPage cartPage= new OpenCartPage(DriverFactory.getDriver());
	
	@Given("Open the application")
	public void open_the_application() {	
		System.out.println("Page Title : " + cartPage.getOpenCartPageTitle());
	}

	@And("Verify the title")
	public void verify_the_title() {
		System.out.println("Page Title : " + cartPage.getOpenCartPageTitle());
	}

}
