package api.utilites;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportName;
	
	public void onStart(ITestContext textContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));//time stamp 
		reportName="Test Report - "+timeStamp+".html";
	
		sparkReporter = new ExtentSparkReporter(".//reports//"+reportName); // specify location of the report

		//sparkReporter=new ExtentSparkReporter("//reports//"+reportName); //specify location of the report 
		sparkReporter.config().setDocumentTitle("RestAssured Automation Project"); // Title of report 
		sparkReporter.config().setReportName("APIs Report Results"); // name of the report 
		sparkReporter.config().setTheme (Theme.DARK); //theme for the report
		
		extent=new ExtentReports();
		extent.attachReporter (sparkReporter);
		extent.setSystemInfo("Application", "Users API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user","Shorouq");


	}
	
	public void onTestSuccess (ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		
	}
	
	public void onTestFailure (ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed!");
		test.log(Status.FAIL,result.getThrowable().getMessage());
		
	}
	
	public void onTestSkipped (ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP,result.getThrowable().getMessage());
		
	}
	
	public void onTestFinish (ITestResult result) {
		
		extent.flush(); //make everything ready in the report  
		
	}

}
