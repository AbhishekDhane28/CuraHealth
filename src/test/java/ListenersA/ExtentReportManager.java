package ListenersA;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Browsers.Base;

public class ExtentReportManager implements ITestListener 
{
public ExtentSparkReporter sparkReporter;//UI of the report
public ExtentReports extent; //populate common info on the report
public ExtentTest test; //creating test case entries in the report and update status of the test methods

String repName;

public void onStart(ITestContext testContext) {
	
	/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Date dt = new Date();
	String currentdatetimestamp = df.format(dt);
	*/
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
	
	repName = "Test-Report-" + timeStamp + ".html";
	sparkReporter = new ExtentSparkReporter (".\\reports\\" + repName); //specify location of the report

    sparkReporter.config().setDocumentTitle("Automation Report"); //Title of report
    sparkReporter.config().setReportName("Functional Testing"); //name of the report
    sparkReporter.config().setTheme(Theme.DARK);

    extent=new ExtentReports();
    extent.attachReporter(sparkReporter);
    
    extent.setSystemInfo("Computer Name", "localhost");
    extent.setSystemInfo("User Name", System.getProperty("user.name"));
    extent.setSystemInfo("Environment", "QA");
    
    String os = testContext.getCurrentXmlTest().getParameter("os");
    extent.setSystemInfo("Operating System", os);
    
    String browser = testContext.getCurrentXmlTest().getParameter("browser");
    extent.setSystemInfo("Browser Name", browser);
}


public void onTestSuccess(ITestResult result)
{
	test = extent.createTest(result.getTestClass().getName()); //create a new entry in the report
    test.assignCategory(result.getMethod().getGroups());  //to display groups in report
	test.log(Status.PASS,result.getName() + "got successfully executed"); //update status p/f/s
}


public void onTestFailure(ITestResult result)
{
	test = extent.createTest(result.getTestClass().getName()); 
	test.assignCategory(result.getMethod().getGroups());
	
    test.log(Status.FAIL,result.getName()+ "got Failed");
    test.log(Status.INFO,result.getThrowable().getMessage());
    
    try {
    	  String imgPath = new Base().captureScreen(result.getName());
    	  test.addScreenCaptureFromPath(imgPath);
    	  
      }   catch (IOException e1) {
    	  e1.printStackTrace();
    }
}

public void onTestSkipped(ITestResult result)
{
	test = extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.SKIP,result.getName()+ "got SKIPPED");
	test.log(Status.INFO, result.getThrowable().getMessage());
}


public void onFinish(ITestContext testcontext) {
	extent.flush();
	
	//For opening the report automatically
	String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
	File extentReport = new File(pathOfExtentReport);
	
	try {
		Desktop.getDesktop().browse(extentReport.toURI());
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	//Following code is for sending the mail through Gmail but don't use it frequently.
	//Use max 1 time.
	//otherwise Gmail id may be blocked
	//In company there is corporate id so no issue will happen there.
/*	try {
		URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
	
		//Create the email message
		ImageHtmlEmail email = new ImageHtmlEmail();
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googlemail.com");  //Used for GmailId
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("abhishekdhane28@gmail.com",""));
		email.setSSLOnConnect(true);
		email.setFrom("abhishekdhane28@gmail.com");  //Sender
		email.setSubject("Test Results");
		email.setMsg("Please find Attached Report");
		email.addTo("abhidhane93@gmail.com");   //Receiver
		email.attach(url, "extent report", "please check report");
		email.send();  //send the email
	}
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	*/
}
}
