package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POMClasses.BLOGPAGE;
import POMClasses.HOMEPAGE;
import POMClasses.LOGO;

public class TestNGClass1 {

	
	WebDriver driver;
	HOMEPAGE homepage;
	BLOGPAGE blogpage;
	LOGO logo;
	
	@BeforeClass
	public void launchbrowser() {
		System.setProperty("webdriver.edge.driver", "D:\\DHANE\\ADD\\Software Testing\\Automation Testing- Akash Yeole Sir\\Automation\\Java and Selenium Setup 2024\\edgedriver_win64\\msedgedriver.exe");
	    driver = new EdgeDriver();
	}
	
    @BeforeMethod
	
	public void clickonblog() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://company.cura.healthcare/en/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		homepage = new HOMEPAGE(driver);
		homepage.clickonBlog();
		
		blogpage= new BLOGPAGE(driver);
		logo = new LOGO(driver);
	}
    
    @Test (priority = 1 , invocationCount=2)
	public void clickonpublichealth() throws InterruptedException {
		Thread.sleep(3000);
		blogpage.clickonPublicHealth();
	}
	
    @Test (priority = 2)
	public void clickonnews() throws InterruptedException {
    Thread.sleep(3000);
		//blogpage.clickonNews();
	}

    @AfterMethod
	public void clickonLogo() throws InterruptedException {
		Thread.sleep(3000);
		logo.clickonlogo();
	}
    
    @AfterClass
    public void closebrowser() {
    	driver.close();
    }
}
