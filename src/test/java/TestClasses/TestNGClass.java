//package TestClasses;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import Browsers.Base;
//import POMClasses.BLOGPAGE;
//import POMClasses.HOMEPAGE;
//import POMClasses.LOGO;
//
//public class TestNGClass extends Base {
//	
//	WebDriver driver;
//	HOMEPAGE homepage;
//	BLOGPAGE blogpage;
//	LOGO logo;
//	
//	
//	@BeforeTest
//	@Parameters("browsername")
//	public void launchbrowser(String browser) throws InterruptedException{
//		
//		System.out.println(browser);
//		Thread.sleep(3000);
//		if(browser.equals("Chrome"))
//	    {
//		    driver = Base.openChromeBrowser();
//	    }
//		
//		Thread.sleep(3000);
//		if(browser.equals("Firefox"))
//		{
//			driver = Base.openFirefoxBrowser();
//		}
//		
//		Thread.sleep(3000);
//        if(browser.equals("Edge"))
//        {
//        	driver = Base.openEdgeBrowser();
//        }
//}
//	
//	@BeforeClass
//	
//	public void createPOMObject() throws InterruptedException {
//		homepage = new HOMEPAGE(driver);
//		blogpage = new BLOGPAGE(driver);
//		logo = new LOGO(driver);
//	    Thread.sleep(3000);
//		driver.get("https://company.cura.healthcare/en/");
//	}
//	
//	
//	@BeforeMethod
//	
//	public void clickonblog() throws InterruptedException {
//		Thread.sleep(3000);
//		homepage.clickonBlog();
//	}
//	
//	
//	@Test (priority = 1)
//	public void clickonpublichealth() throws InterruptedException {
//		Thread.sleep(3000);
//		blogpage.clickonPublicHealth();
//	}
//	
//	
//	@Test (priority = 2)
//	public void clickonnews() throws InterruptedException {
//		Thread.sleep(3000);
//		blogpage.clickonNews();
//	}
//	
//	
//	@AfterMethod
//	public void clickonLogo() throws InterruptedException {
//		Thread.sleep(3000);
//		logo.clickonlogo();
//	}
//	
//	
//	@AfterClass
//	public void clearObject() throws InterruptedException {
//	Thread.sleep(3000);
//	homepage = null;
//	blogpage = null;
//	logo = null;
//	}
//	
//	
//	@AfterTest
//	public void closedBrowser() throws InterruptedException {
//	Thread.sleep(3000);
//	driver.close();	
//	driver = null;
//	System.gc();
//	}
//}
