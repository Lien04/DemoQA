package tests;

import org.testng.annotations.Test;

import pages.ButtonPage;

public class ButtonTest extends TestCase {
	@Test
	public void clickClickMe() {
		String btnClickMe = "Right Click Me";
		ButtonPage buttonsPage = new ButtonPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/buttons");
		buttonsPage.clickButton(btnClickMe);

	}

}