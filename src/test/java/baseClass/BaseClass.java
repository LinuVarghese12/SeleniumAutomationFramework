package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.utilityPackage.ConfigReader;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		String baseUrl= ConfigReader.get("baseUrl");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		
		driver.get(baseUrl);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

	
}
