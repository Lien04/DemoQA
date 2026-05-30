package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTabPage extends Page {
	public By lbSamplePage = By.id("sampleHeading");
	public NewTabPage(WebDriver dr) {
		super(dr);
		
	}

}
