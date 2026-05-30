package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage extends Page {
	public By btnNewTab = By.id("tabButton");
	public By btnNewWindow = By.id("windowButton");
	public By btnNewWindowMessage = By.id("messageWindowButton");
	public int windowSize;
	public BrowserWindowsPage(WebDriver dr) {
		super(dr);
	}
	
	public NewTabPage clickNewTabButton() {
		base.clickOnElement(btnNewTab);
		Set<String> windowHandles = base.webDriver.getWindowHandles();
		windowSize = windowHandles.size();
		List<String> tabs = new ArrayList<>(windowHandles);
		base.webDriver.switchTo().window(tabs.get(1));
		return new NewTabPage(driver);
	}
	
	public NewWindowPage clickNewWindow() {
		base.clickOnElement(btnNewWindow);
		Set<String> windowHandles = base.webDriver.getWindowHandles();
		windowSize = windowHandles.size();
		List<String> tabs = new ArrayList<>(windowHandles);
		base.webDriver.switchTo().window(tabs.get(1));
		return new NewWindowPage(driver);

	}
	
	public NewWindowMessagePage clickNewWindowMessage() {
		String originalWindow = driver.getWindowHandle();
		base.clickOnElement(btnNewWindowMessage);
//		Set<String> windowHandles = base.webDriver.getWindowHandles();
//		windowSize = windowHandles.size();
//		List<String> tabs = new ArrayList<>(windowHandles);
//		System.out.println("abc" +windowSize);
//		base.webDriver.switchTo().window(tabs.get(1));
		for(String window: driver.getWindowHandles()) {
			if(!window.equals(originalWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		String currentUrl = driver.getCurrentUrl();
		System.out.println("url" +currentUrl);
		return new NewWindowMessagePage(driver);
	}
}
