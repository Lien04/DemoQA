package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import common.TestBase;

public class  TestCase {
	public TestBase testBase; 
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		testBase = new TestBase();
		System.out.println("abc");
		testBase.openWeb("chrome", "https://demoqa.com/");
		System.out.println("xyz");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		testBase.webDriver.quit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}