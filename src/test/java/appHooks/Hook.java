package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	

	public DriverFactory driverFactory;
	public Properties prop;
	public WebDriver driver;
	
	@Before
    public void launchBrowser() {
        System.out.println("This will run before the Scenario");
       // String browserName = configFileReader.getBrowser();// Invoke browser from config file
		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();
		//driver = driverFactory.init_driver(browserName);
		driver = driverFactory.init_driver(prop);
		
    }
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		//driver.quit();
	}

}
