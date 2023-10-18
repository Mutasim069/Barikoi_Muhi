package utilities;

import java.time.Duration;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
	
	private static String browserName= System.getProperty("browser", "chrome");
	private static final ThreadLocal<WebDriver> LOCAL_DRIVER= new ThreadLocal<WebDriver>();
	
	@BeforeSuite
	public static synchronized void setBrowser() {
		WebDriver driver= getBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		setDriver(driver);
	}
	
	@AfterSuite
	public static synchronized void getBrowser() {
		getDriver().quit();
	}
	
	
	public static WebDriver getBrowser(String browserName) {
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "edge":
			return new EdgeDriver();

		default:
			throw new RuntimeException("Browser not found using the name '"+browserName+"' ff!");
		}
	}
	
	public static void setDriver(WebDriver driver) {
		DriverSetup.LOCAL_DRIVER.set(driver);
	}
	
	public static WebDriver getDriver() {
		return LOCAL_DRIVER.get();
	}

}
