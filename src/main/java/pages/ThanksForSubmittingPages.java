package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThanksForSubmittingPages extends Page {
	public String lblXpath = "//td[text()='@param']/following-sibling::td"; 

	public ThanksForSubmittingPages(WebDriver dr) {
		super(dr);
		
	}
	public String getActualText(String fieldName) {
		String newlblXpath = base.replaceXpath(lblXpath, fieldName);
		By locator = By.xpath(newlblXpath);
		String actualResult = base.getTextByLocator(locator);
		return actualResult;

	}

}
