package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import pages.AlertsPage;

public class AlertsTest extends TestCase{
	@Test
	public void verifyAlertWithAButton() {
		AlertsPage alertsPage = new AlertsPage(testBase.webDriver);
		alertsPage.base.goToPage("https://demoqa.com/alerts");
		alertsPage.base.clickOnElement(alertsPage.btnAlert);
		Alert alert = alertsPage.driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		assertEquals(actualAlertMessage, "You clicked a button");
	}
	
	@Test
	public void verifyAlertWithATime() {
		AlertsPage alertsPage = new AlertsPage(testBase.webDriver);
		alertsPage.base.goToPage("https://demoqa.com/alerts");
		alertsPage.base.clickOnElement(alertsPage.btnTimeAlert);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Alert alert = alertsPage.driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		assertEquals(actualAlertMessage, "This alert appeared after 5 seconds");
	}
	
	@Test
	public void verifyAlertWithAConfirm() {
		AlertsPage alertsPage = new AlertsPage(testBase.webDriver);
		alertsPage.base.goToPage("https://demoqa.com/alerts");
		alertsPage.base.clickOnElement(alertsPage.btnConfirm);
		Alert alert = alertsPage.driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		assertEquals(actualAlertMessage, "Do you confirm action?");
	}
	
	@Test
	public void verifyAlertWithAPrompt() {
		AlertsPage alertsPage = new AlertsPage(testBase.webDriver);
		alertsPage.base.goToPage("https://demoqa.com/alerts");
		alertsPage.base.clickOnElement(alertsPage.btnPrompt);
		Alert alert = alertsPage.driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		assertEquals(actualAlertMessage, "Please enter your name");
		String inputText = "Lien";
		alert.sendKeys(inputText);
		alert.accept();
		String promptText = alertsPage.base.getTextByLocator(alertsPage.lbPromptText);
		String actualResult = promptText.replace("You entered ", "");
		assertEquals(actualResult, inputText);
	}
}
