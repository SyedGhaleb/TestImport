package FrameWorkDesignTestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FramWorkDesginResources.ExtentReportstest;

public class ListenersTest extends BaseTest implements ITestListener  {

	ExtentReports extent = ExtentReportstest.getExtentReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 test =extent.createTest(result.getMethod().getMethodName());
		 extentest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentest.get().log(Status.PASS	, "Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentest.get().fail(result.getThrowable());
		
     try {

    	 driver	= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	
	} catch (Exception e1) {	
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(),driver);
		} 
		
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	extent.flush();
	}

}
