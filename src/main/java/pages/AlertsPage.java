package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends Page{
	public By btnAlert = By.id("alertButton");
	public By btnTimeAlert = By.id("timerAlertButton");
	public By btnConfirm = By.id("confirmButton");
	public By btnPrompt = By.id("promtButton");
	public By lbPromptText = By.id("promptResult");
	public AlertsPage(WebDriver dr) {
		super(dr);
	}

}
