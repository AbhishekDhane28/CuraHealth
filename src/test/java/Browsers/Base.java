package Browsers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

public class Base {
	
		public static WebDriver openChromeBrowser() {
			System.setProperty("webdriver.chrome.driver","D:\\DHANE\\ADD\\Software Testing\\Automation Testing- Akash Yeole Sir\\Automation\\Java and Selenium Setup 2024\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
			return driver;
			}
			
			
		public static WebDriver openFirefoxBrowser() {
			System.setProperty("webdriver.gecko.driver","D:\\DHANE\\ADD\\Software Testing\\Automation Testing- Akash Yeole Sir\\Automation\\Java and Selenium Setup 2024\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		    WebDriver driver = new FirefoxDriver();
			return driver;
		}
		
		
		public static WebDriver openEdgeBrowser() {
			System.setProperty("webdriver.edge.driver","D:\\DHANE\\ADD\\Software Testing\\Automation Testing- Akash Yeole Sir\\Automation\\Java and Selenium Setup 2024\\edgedriver_win64\\msedgedriver.exe");
		    WebDriver driver = new EdgeDriver();
			return driver;
			
}
        public String captureScreen(String tname) throws IOException{
        	
        	String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        	
			TakesScreenshot driver = null;
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        	
        	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+ timestamp + ".png";
        	File targetFile = new File(targetFilePath);
        	
        	sourceFile.renameTo(targetFile);
        	
        	return targetFilePath;
        }
        
        public static WebDriver driver;
        public Logger logger;    //Log4j
        public Properties p;
        
        
        @Parameters({"os", "browser"})
        public void setup(String os, String br) throws IOException
        {
        	//Loading config.properties file
        	FileReader file= new FileReader(".src//test//resources//config.properties");
        	p=new Properties();
			p.load(file);
        	
            logger = LogManager.getLogger(this.getClass());   //loG4J2
        	
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
        	DesiredCapabilities capabilities = new DesiredCapabilities();
        	
        	//os
        	if(os.equalsIgnoreCase("windows"))
        	{
        		capabilities.setPlatform(Platform.WIN11);
        	}
        	else if (os.equalsIgnoreCase("mac"))
        	{
        		capabilities.setPlatform(Platform.MAC);
        	}
        	else
        	{
        		System.out.println("No matching os");
        		return;
        	}
        	
        	//browser
        	switch(br.toLowerCase())
        	{
        	case "chrome": capabilities.setBrowserName("chrome"); break;
        	case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
        	default: System.out.println("No matching browser"); return;
        	}
        	
        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }
        
        if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
        	switch(br.toLowerCase())
        	{
        	case "chrome": driver=new ChromeDriver(); break;
        	case "edge" : driver=new EdgeDriver(); break;
        	case "firefox" : driver=new FirefoxDriver(); break;
        	default: System.out.println("Invalid browser name"); return;
        	}
        }
        
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
        }
        
        
}