package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import common.TestBase;

public class  TestCase {
	TestBase testBase = new TestBase();
	@BeforeMethod
	public void setUp() {
		
		testBase.openWeb("chrome", "https://demoqa.com/");
	}
	
//	@AfterTest
	public void tearDown() {
		testBase.webDriver.quit();
	}
}