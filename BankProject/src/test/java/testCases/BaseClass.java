package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		System.setProperty("org.freemarker.loggerLibrary", "none");
		
		logger = LogManager.getLogger(BaseClass.class.getName());

		//logger = Logger.getLogger("BankProject");
		//logger = Logger.getLogger(BaseClass.class.getName());
		PropertyConfigurator.configure("log4j2.properties");
		
		
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		
		}else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		
		}else if(br.equals("edge")){
			
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenshotTaken");
	}
	
	public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return(generatedString);
	}
	public String randomNum() {
		
		String generatedNum = RandomStringUtils.randomNumeric(4);
		return(generatedNum);
	}
	
	
}