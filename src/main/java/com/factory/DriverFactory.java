package com.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	Properties prop;
	OptionsManager optinonsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser value is: " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optinonsManager.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optinonsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	
	/**
	 * this method is used to initialize the properties
	 */
	public Properties init_prop() {

		prop = new Properties();
		FileInputStream ip = null;

		// mvn clean install -Denv="qa"
		String envName = System.getProperty("env").trim();
		System.out.println("Running tests on environment: " + envName);

		if (envName == null) {
			System.out.println("No env is given....hence running it on QA enviornment");
			try {
				ip = new FileInputStream("./src/test/resource/configs/qa.config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else {
			try {
				switch (envName.toLowerCase()) {
				case "qa":
					System.out.println("running it on QA env");
					ip = new FileInputStream("./src/test/resource/configs/qa.config.properties");
					break;
				case "stage":
					System.out.println("running it on stage env");
					ip = new FileInputStream("./src/test/resource/configs/stage.config.properties");
					break;
				case "dev":
					System.out.println("running it on dev env");
					ip = new FileInputStream("./src/test/resource/configs/dev.config.properties");
					break;
				case "uat":
					System.out.println("running it on uat env");
					ip = new FileInputStream("./src/test/resource/configs/uat.config.properties");
					break;
				case "prod":
					System.out.println("running it on QA env");
					ip = new FileInputStream("./src/test/resource/configs/config.properties");
					break;

				default:
					System.out.println("Please pass the right environment...." + envName);
					break;
				}

			} catch (Exception e) {

			}

		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	
}
