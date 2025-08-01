package com.utilityPackage;

import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
public class ExtentListener implements ITestListener {
	private static final ExtentReports extent = ExtendReporter.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest t = extent.createTest(result.getMethod().getMethodName());
        test.set(t);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // attempt to get WebDriver from test instance (assuming TestBase has 'driver' field)
        Object instance = result.getInstance();
        try {
            WebDriver driver = (WebDriver) result.getTestClass()
                .getRealClass()
                .getField("driver")
                .get(instance);

            String screenshotPath = ScreenshotUtil.capture(driver, result.getMethod().getMethodName());
            if (screenshotPath != null) {
                test.get().addScreenCaptureFromPath(screenshotPath);
            }
        } catch (Exception e) {
            // ignore if reflection fails
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
