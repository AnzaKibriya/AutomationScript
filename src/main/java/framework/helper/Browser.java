package framework.helper;

import java.nio.file.Paths;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {

	// protected static String url = "http://htester.kualitee.com/";
	// protected String browserName = "firefox";

	protected static final String BROWSER_CHROME = "chrome";
	protected static final String BROWSER_FIREFOX = "firefox";
	protected static final String BROWSER_EDGE = "edge";
	protected static final String BROWSER_IE = "ie";

	public static WebDriver GetBrowser(String browserName) {
		WebDriver driver;

		String driverPath = Common.GetDriverFolderPath();

		if (browserName.equals(BROWSER_CHROME)) {
			//String path = "/home/awais/Documents/Drivers/geckodriver";
			driverPath = Paths.get(driverPath + "chromedriver.exe").toAbsolutePath().toString();
			System.setProperty("webdriver.chrome.driver", driverPath);

			ChromeOptions cOptions = new ChromeOptions();
			cOptions.addArguments("test-type");
			//cOptions.addArguments("start-maximized");
			cOptions.addArguments("--js-flags=--expose-gc");
			cOptions.addArguments("--enable-precise-memory-info");
			cOptions.addArguments("--disable-popup-blocking");
			cOptions.addArguments("--disable-default-apps");
			cOptions.addArguments("disable-infobars");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			cOptions.setExperimentalOption("prefs", prefs);

			//cOptions.addArguments("--incognito");
			//cOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(cOptions);
		} else if (browserName.equals(BROWSER_FIREFOX)) {
			driverPath = Paths.get(driverPath + "geckodriver").toAbsolutePath().toString();
			System.setProperty("webdriver.gecko.driver", driverPath);
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability("marionette", true);

			driver = new FirefoxDriver(dc);
		} else if (browserName.equals(BROWSER_EDGE)) {
			driverPath = Paths.get(driverPath + "MicrosoftWebDriver.exe").toAbsolutePath().toString();
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
		}
		// IEDriverServer
		else if (browserName.equals(BROWSER_IE)) {
			driverPath = Paths.get(driverPath + "IEDriverServer.exe").toAbsolutePath().toString();
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
		} else
			throw new IllegalArgumentException("Could not find supported browser: " + browserName);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().window().maximize();

		return driver;

	}

}

