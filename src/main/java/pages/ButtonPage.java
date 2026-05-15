package pages;

import org.openqa.selenium.WebDriver;

public class ButtonPage extends Page {
	public String btnClick = "//button[text()='@param']";

	public ButtonPage(WebDriver dr) {
		super(dr);
	}
	public void clickButton(String text) {
		base.clickButtonByText(btnClick, text);
	}

}