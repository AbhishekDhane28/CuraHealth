//package TestClasses;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
////import Browsers.Base;
//import POMClasses.BLOGPAGE;
//import POMClasses.HOMEPAGE;
//import POMClasses.LOGO;
//
//public class TestClass {
//	
// public static void main(String[] args) throws InterruptedException {
//	 
//	 System.setProperty("webdriver.chrome.driver", "D:\\DHANE\\ADD\\Software Testing\\Automation Testing- Akash Yeole Sir\\Automation\\Java and Selenium Setup 2024\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//     //WebDriver driver = new ChromeDriver();
//		 String browserName = "edge";
//         WebDriver driver = null;
// 
//	 if(browserName.equalsIgnoreCase("chrome")) {
//		
//		    driver = new ChromeDriver();
//		}
//	 else if(browserName.equalsIgnoreCase("firefox")) {
//		    driver = new FirefoxDriver();
//	 }
//	 else if(browserName.equalsIgnoreCase("edge")) {
//		    driver = new EdgeDriver();
//	 }
//	 else {
//		 System.out.println("Provide a Valid browser name");
//	 }
//	 
//	 //HOMEPAGE
//	 driver.get("https://company.cura.healthcare/en/");
//	 Thread.sleep(3000);
//	 driver.manage().window().maximize(); 
//	 Thread.sleep(3000);
//	 HOMEPAGE homepage = new HOMEPAGE(driver);
//	 Thread.sleep(3000);
//	 homepage.clickonBlog();
//	 Thread.sleep(3000);
//	 
//	 //BLOGPAGE
//     BLOGPAGE blogpage = new BLOGPAGE(driver);
//	 Thread.sleep(3000);
//	 blogpage.clickonPublicHealth();
//	
//	 //LOGO
//	 LOGO logo = new LOGO(driver);
//	 Thread.sleep(3000);
//	 logo.clickonlogo();
//	 
//	 //HOMEPAGE
//	 Thread.sleep(3000);
//	 homepage.clickonBlog();
//	  
//	 //BLOGPAGE
//	 Thread.sleep(3000);
//	 blogpage.clickonNews();
//	 
//	//LOGO
//	Thread.sleep(3000);
//	logo.clickonlogo();
//	 
//}
//
//}
