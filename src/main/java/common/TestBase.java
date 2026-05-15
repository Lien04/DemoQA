package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

public class TestBase {
	public WebDriver webDriver;

	public void openWeb(String browserName, String url) {
		String projectPath = System.getProperty("user.dir");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			webDriver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			// TODO
		}

		webDriver.get(url);
		webDriver.manage().window().maximize();

	}

	public void inputText(By locator, CharSequence... inputData) {
		webDriver.findElement(locator).sendKeys(inputData);
	}

	public void selectRadioButton(String xpath, String text) {
		String newXpath = replaceXpath(xpath, text);
		webDriver.findElement(By.xpath(newXpath)).click();
	}

	public void selectCheckbox(String xpath, String text) {
		if (text.contains(",")) {
			String[] data = text.split(",");
			for (String eachElement : data) {
				String newXpath = replaceXpath(xpath, eachElement.trim());
				webDriver.findElement(By.xpath(newXpath)).click();
			}
		} else {
			String newXpath = replaceXpath(xpath, text);
			webDriver.findElement(By.xpath(newXpath)).click();
		}
	}

	public String replaceXpath(String originalXpath, String inputText) {
		String result = originalXpath.replace("@param", inputText);
		return result;

	}
	
	/**
	 * Hàm click button theo text truyền vào*
	 * @param xpath
	 * @param text : text truyền vào dựa trên UI
	 */
	public void clickButton(String xpath, String text) {
		String newXPath = replaceXpath(xpath, text);
		Actions action = new Actions(webDriver);
		if(text.equalsIgnoreCase("Click Me")) {
			webDriver.findElement(By.xpath(newXPath)).click();
		}else if (text.equalsIgnoreCase("Right Click Me")) {
			WebElement element = webDriver.findElement(By.xpath(newXPath));
			action.contextClick(element).perform();
		} else if (text.equals("Double Click Me")) {
			WebElement element = webDriver.findElement(By.xpath(newXPath));
			action.doubleClick(element).perform();
		}
	
		/**
		 * method to fill one or multiple value to a combo box
		 * @param locator
		 * @param text
		 */
		public void fillComboBox(By locator, String text) {
			if (text.contains(",")) {
				String[] valueComboBox = text.split(",");
			for (String value : valueComboBox) {
				String newValue = value.trim();
				inputText(locator, newValue);
				inputText(locator,Keys.ENTER);
			}
			}
			else {
				inputText(locator, newValue);
				inputText(locator,Keys.ENTER);
			}
		}
		public void clickOnButton(By locator) {
			webDriver.findElement(locator).click();
	}
		
		public void selectDropDownBoxByVisibleText(By locator,String text) {
			WebElement dropDownElement =  webDriver.findElement(locator);
			Select select = new Select(dropDownElement);
			select.selectByContainsVisibleText(text);

		}
		public void clickOnElement(By locator) {
			webDriver.findElement(locator).click();
		}
		public String getTextByLocator(By locator) {
			
			return webDriver.findElement(locator).getText();
			
	
			
	}
}
