package utility;

import com.relevantcodes.extentreports.ExtentReports;

public class GenerateReport {
	public static ExtentReports extent;

	public static ExtentReports createReport() {
		extent = new ExtentReports(
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\Medicare_automation_project\\Report\\Report.html");
		return extent;
	}
}
