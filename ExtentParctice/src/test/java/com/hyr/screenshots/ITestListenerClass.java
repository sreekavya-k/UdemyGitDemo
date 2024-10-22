package com.hyr.screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest    implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
	//This is by getting method name
		/*
		 * try { System.out.println("Test name "+result.getMethod().getMethodName());
		 * captureScreenshot(result.getMethod().getMethodName()+".jpg"); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		//This is by using Testname
		try {
			System.out.println(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
			captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
}
