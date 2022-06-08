package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartPage {
	
	private WebDriver driver;
	
	// 1. By Locators: OR
		private By username = By.id("txtUsername");
		private By password = By.id("txtPassword");
		private By signInButton = By.id("btnLogin");
		private By welcome = By.id("welcome");

		// 2. Constructor of the page class:
		public OpenCartPage(WebDriver driver) {
				this.driver = driver;
			}

		// 3. page actions: features(behavior) of the page the form of methods:

		public String getOpenCartPageTitle() {
			return driver.getTitle();
		}


}
