package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TextBoxTest extends TestCase {
	@Test(groups={"regression"})
	public void submitDataSuccessfully() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\01_AutomationClass202604\\03_Practices\\02Projects\\Git\\DemoQA\\DemoQA\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver webDriver = new ChromeDriver(options);
		webDriver.get("https://demoqa.com/text-box");
		webDriver.manage().window().maximize();
		webDriver.findElement(By.id("userName")).sendKeys("test");
		webDriver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
		webDriver.findElement(By.id("currentAddress")).sendKeys("test address");
		webDriver.findElement(By.id("permanentAddress")).sendKeys("test perma address");
		webDriver.findElement(By.id("submit")).click();

	}
	
	@Test(groups="validation")
	public void submitDataFail() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\01_AutomationClass202604\\03_Practices\\02Projects\\Git\\DemoQA\\DemoQA\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver webDriver = new ChromeDriver(options);
		webDriver.get("https://demoqa.com/text-box");
		webDriver.manage().window().maximize();
		webDriver.findElement(By.id("userName")).sendKeys("Trinh Lien");
		webDriver.findElement(By.id("userEmail")).sendKeys("gmail.com");
		webDriver.findElement(By.id("currentAddress")).sendKeys("Pham Van Dong");
		webDriver.findElement(By.id("permanentAddress")).sendKeys("Ha Noi");
		webDriver.findElement(By.id("submit")).click();

	}
	
}