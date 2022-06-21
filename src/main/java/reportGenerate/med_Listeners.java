package reportGenerate;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.GenerateReport;

public class med_Listeners implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Start " + context.getName());
		extent = GenerateReport.createReport();
		test = extent.startTest(context.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test " + result.getName() + " Succeed!");
		test.log(LogStatus.PASS, result.getName() + " is passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test " + result.getName() + " Failed!");
		test.log(LogStatus.FAIL, result.getName() + " is failed!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test " + result.getName() + " Skipped!");
		test.log(LogStatus.SKIP, result.getName() + " is skipped!");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("End " + context.getName());
		extent.endTest(test);
		extent.flush();
	}

}
