package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablePage extends Page {
	public By txtSearchBox = By.id("searchBox");
	public By lbFirstName = By.xpath("//tbody/tr/td[1]");
	public By lbLastName = By.xpath("//tbody/tr/td[2]");
	public By lbEmail = By.xpath("//tbody/tr/td[3]");
	public By lbAge = By.xpath("//tbody/tr/td[4]");
	public By lbSalary = By.xpath("//tbody/tr/td[5]");
	public By lbDepartment = By.xpath("//tbody/tr/td[6]");
	public By btnAdd = By.id("addNewRecordButton");
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public By txtAge = By.id("age");
	public By txtSalary = By.id("salary");
	public By txtDepartment = By.id("department");
    public By btnSubmit = By.id("submit");
	public By btnDelete = By.xpath("//tbody/tr/td[1]/following-sibling::td[6]//span[@title='Delete']//*[local-name()='svg']");
	public WebTablePage(WebDriver dr) {
		super(dr);
		
	}
	
}
