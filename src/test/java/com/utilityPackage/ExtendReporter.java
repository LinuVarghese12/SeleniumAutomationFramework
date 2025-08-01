package com.utilityPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendReporter {

	private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("testReports/extent.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Suite Results");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
