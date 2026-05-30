package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowMessagePage extends Page {
	public By lbSamplePage = By.xpath("//body");
	public NewWindowMessagePage(WebDriver dr) {
		super(dr);
	}
	

}
