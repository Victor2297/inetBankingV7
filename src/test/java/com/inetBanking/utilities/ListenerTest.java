package com.inetBanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerTest implements ITestListener{
	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @Override		
    public void onStart(ITestContext result) {
    	 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport" + (new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())) + ".html");
         
         //initialize ExtentReports and attach the HtmlReporter
         extent = new ExtentReports();
         extent.attachReporter(htmlReporter);
          
         //To add system or environment info by using the setSystemInfo method.
         extent.setSystemInfo("OS", "Windows");
         extent.setSystemInfo("Browser", "Chrome");
         
         //configuration items to change the look and feel
         //add content, manage tests etc
         htmlReporter.config().setChartVisibilityOnOpen(true);
         htmlReporter.config().setDocumentTitle("Extent Report Demo");
         htmlReporter.config().setReportName("Test Report");
         htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
         htmlReporter.config().setTheme(Theme.STANDARD);
         htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }		

    @Override		
    public void onTestFailure(ITestResult result) {
    	test = extent.createTest(result.getName());
    	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
    	test.fail(result.getThrowable());
    	//Object[] p = result.getParameters();
    	//test.log(Status.FAIL, MarkupHelper.createLabel(p[1].toString()+" FAILED ", ExtentColor.RED));
    }		

    @Override
    public void onTestSkipped(ITestResult result) {
    	test = extent.createTest(result.getName());
    	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        test.skip(result.getThrowable());
    }			

    @Override
    public void onTestSuccess(ITestResult result) {
    	test = extent.createTest(result.getName());
    	test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
    }
    
    @Override		
    public void onFinish(ITestContext result) {					
    	extent.flush();
    }
}