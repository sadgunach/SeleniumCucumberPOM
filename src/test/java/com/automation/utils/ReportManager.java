package com.automation.utils;

import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



	public class ReportManager {
	    private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> featureTest = new ThreadLocal<>();
	    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	        }
	        return extent;
	    }

	    public static void setScenario(ExtentTest test) { scenarioTest.set(test); }
	    public static ExtentTest getScenario() { return scenarioTest.get(); }
	}

