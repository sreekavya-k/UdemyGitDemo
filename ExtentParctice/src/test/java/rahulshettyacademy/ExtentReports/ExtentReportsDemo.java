package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {

	ExtentReports extent;
	@BeforeTest
	public void config() {
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationResults");
		reporter.config().setDocumentTitle("Test results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "HareKrishna");
		
	}
	@Test
	public void initialDemo() {
	ExtentTest test =	extent.createTest("Intital Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		//test.addScreenCaptureFromBase64String(null);
		test.fail("Result do not match");
		driver.close();
		extent.flush();
	}
}
