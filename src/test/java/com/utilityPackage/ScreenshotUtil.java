package com.utilityPackage;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

public class ScreenshotUtil {
	public static String capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = String.valueOf(Instant.now().toEpochMilli());
            String destPath = "reports/screenshots/" + name + "_" + timestamp + ".png";
            Path dest = Path.of(destPath);
            Files.createDirectories(dest.getParent());
            Files.copy(src.toPath(), dest);
            return destPath;
        } catch (Exception e) {
            // fallback: return null if capture fails
            return null;
        }
    }

}
