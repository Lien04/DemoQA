package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import common.TestBase;
import pages.BrowserWindowsPage;
import pages.NewTabPage;
import pages.NewWindowMessagePage;
import pages.NewWindowPage;

public class BrowserWindowsTests extends TestCase {
	@Test
	public void verifyNewTab() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(testBase.webDriver);
		browserWindowsPage.base.goToPage("https://demoqa.com/browser-windows");
		NewTabPage newTabPage = browserWindowsPage.clickNewTabButton();
		assertEquals(browserWindowsPage.windowSize, 2);
		String actualText = newTabPage.base.getTextByLocator(newTabPage.lbSamplePage);
		assertEquals(actualText, "This is a sample page");
	}
	
	@Test
	public void verifyNewWindow() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(testBase.webDriver);
		browserWindowsPage.base.goToPage("https://demoqa.com/browser-windows");
		NewWindowPage newWindowPage = browserWindowsPage.clickNewWindow();
		assertEquals(browserWindowsPage.windowSize, 2);
		String actualText = newWindowPage.base.getTextByLocator(newWindowPage.lbSamplePage);
		assertEquals(actualText, "This is a sample page");
	}
	
	@Test
	public void verifyNewWindowMessage() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(testBase.webDriver);
		browserWindowsPage.base.goToPage("https://demoqa.com/browser-windows");
		NewWindowMessagePage newWindowMessagePage = browserWindowsPage.clickNewWindowMessage();
		assertEquals(browserWindowsPage.windowSize, 2);
		String actualText = newWindowMessagePage.base.getTextByLocator(newWindowMessagePage.lbSamplePage);
		assertEquals(actualText, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
	}
}
