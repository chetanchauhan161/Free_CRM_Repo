package com.qa.ExtentReportListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentDemo {
	
static ExtentTest test;
static ExtentReports report;

@org.testng.annotations.BeforeClass
public static void startTest()
{
report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
test = report.startTest("ExtentDemo");
}

@org.testng.annotations.Test
public void extentReportsDemo()
{
	System.setProperty("webdriver.chrome.driver", "C:/Users/Chetan Chauhan/Downloads/chromedriver_win32/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.google.co.in");
if(driver.getTitle().equals("Google"))
{
test.log(LogStatus.PASS, "Navigated to the specified URL");
}
else{
test.log(LogStatus.FAIL, "Test Failed");
}
}

	@org.testng.annotations.AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
