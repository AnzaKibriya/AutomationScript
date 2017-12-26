package framework.helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import framework.datalayer.DataSet;



public class BaseCase {
	public static WebDriver driver;
	public ExtentReports report = null;
	public ExtentTest logger = null;

	private String htmlPath = Common.reportPath + "SparkXYZTestReport.html";


	// protected String browserName = "chrome";

	@AfterMethod
	public void AfterMethod()
	{
		report.endTest(logger);
		report.flush();


	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		//DataSet.FillExistingCredentials();

		DataSet.FillNewCredentials();
		report = new ExtentReports(htmlPath, true);
		///////////////////
		driver = Browser.GetBrowser(DataSet.browserRequired);
		System.out.println(" -- Browser Opened");
//		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://google.com");

	}




	@AfterSuite
	public void tearDown() {

//		report.endTest(logger);
//		report.flush();
		//report.close();
		// System.out.println(" -- Before Test Suite");
//		 driver.close();
//		 driver.quit();
//		report.close();
		driver.get(htmlPath);
		System.out.println(" -- Finished Tests");
//		String desktopPath = System.getProperty("user.home") + "\\" + "Desktop";
//		String htmlPath = desktopPath + "\\HappyGrassHopperTestReport.html";
//
//		driver.get(htmlPath);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (driver != null) {
//			 driver.close();
//			 driver.quit();


		}
		// report.end

	}

}
