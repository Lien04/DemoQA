package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends Page {
	public By lbSampleHeadding = By.id("sampleHeading");
	
	public FramePage(WebDriver dr) {
		super(dr);
	}
	

}
