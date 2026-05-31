package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.FramePage;

public class FrameTest extends TestCase{
	@Test
	public void verifyText() {
		FramePage framePage = new FramePage(testBase.webDriver);
		framePage.base.goToPage("https://demoqa.com/frames");
		framePage.driver.switchTo().frame("frame1");
		String actualResult = framePage.base.getTextByLocator(framePage.lbSampleHeadding);
		assertEquals(actualResult,"This is a sample page" );
		framePage.driver.switchTo().defaultContent();
		framePage.driver.switchTo().frame("frame2");
		String actualResultFrame2 = framePage.base.getTextByLocator(framePage.lbSampleHeadding);
		assertEquals(actualResultFrame2, "This is a sample page");
	}
}
