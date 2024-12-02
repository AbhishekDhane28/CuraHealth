package ListenersA;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{
	
	public void onStart(ITestContext context) {
		//Will execute only once before starting all the test methods.
	    System.out.println("Test execution is started");
	  }
	
	public void onTestStart(ITestResult result) {
		//Will execute multiple times before starting every test method.
	    System.out.println("Test Started");
	  }
	
	public void onTestSuccess(ITestResult result) {
		//Will execute whenever any test method is passed.
	   System.out.println("Test Passed");
	  }
	
	public void onTestFailure(ITestResult result) {
		//Will execute whenever any test method is failed.
		System.out.println("Test Failed");
	  }
	
	public void onTestSkipped(ITestResult result) {
		//Will execute whenever any test method is skipped.
		System.out.println("Test Skipped");
	  }
	
	public void onFinish(ITestContext context) {
		//Will execute once all test methods execution gets completed.
		System.out.println("Test execution is completed");
	  }
}
