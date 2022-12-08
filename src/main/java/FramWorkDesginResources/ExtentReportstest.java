package FramWorkDesginResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportstest {

	ExtentReports extent;

	public static ExtentReports getExtentReportObject() {

		// ExtentReports and ExtentSparkReporter

		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setReportName("Selenium Automation");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Syed Ghaleb");
		return extent;

	}

}
