package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends Page {
	public By lbSamplePage = By.id("sampleHeading");
	public NewWindowPage(WebDriver dr) {
		super(dr);
		
	}
}
