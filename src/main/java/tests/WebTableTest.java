package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import common.Utils;
import pages.WebTablePage;
import tests.models.RegistrationForm;

public class WebTableTest extends TestCase {
	@Test(testName = "Registration Form", dataProvider = "WebTable_TC01")
	public void searchByFirstName(RegistrationForm registrationForm) {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		// String firstName = "Alden";
		// add new record
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		// search record before add
		webTablePage.base.inputText(webTablePage.txtSearchBox, registrationForm.firstName);
		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
		webTablePage.base.clickOnElement(webTablePage.btnAdd);
		webTablePage.base.inputText(webTablePage.txtFirstName, registrationForm.firstName);
		webTablePage.base.inputText(webTablePage.txtLastName, registrationForm.lastName);
		webTablePage.base.inputText(webTablePage.txtEmail, registrationForm.email);
		webTablePage.base.inputText(webTablePage.txtAge, registrationForm.age);
		webTablePage.base.inputText(webTablePage.txtSalary, registrationForm.salary);
		webTablePage.base.inputText(webTablePage.txtDepartment, registrationForm.department);
		webTablePage.base.clickOnElement(webTablePage.btnSubmit);
		// search record
		webTablePage.base.inputText(webTablePage.txtSearchBox, registrationForm.firstName);
		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
		AssertJUnit.assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbFirstName), registrationForm.firstName);
		webTablePage.base.clickOnElement(webTablePage.btnDelete);
	}

	@Test
	    public void searchByLastName() {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		String lastName = "Cantrell";
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.base.inputText(webTablePage.txtSearchBox, lastName);
		webTablePage.base.inputText(webTablePage.txtSearchBox, Keys.ENTER);
		AssertJUnit.assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbLastName), lastName);
	}

	@Test
		public void searchByEmail() {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		String email = "cierra@example.com";
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.base.inputText(webTablePage.txtSearchBox,email);
		webTablePage.base.inputText(webTablePage.txtSearchBox,Keys.ENTER);
		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbEmail),email);
	}

	@Test
		public void searchByAge() {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		String age = "39";
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.base.inputText(webTablePage.txtSearchBox,age);
		webTablePage.base.inputText(webTablePage.txtSearchBox,Keys.ENTER);
		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbAge),age);
	}

	@Test
		public void searchBySalary() {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		String salary = "10000";
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.base.inputText(webTablePage.txtSearchBox,salary);
		webTablePage.base.inputText(webTablePage.txtSearchBox,Keys.ENTER);
		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbSalary),salary);
	}

	@Test
		public void searchByDepartment() {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		String department = "Insurance";
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.base.inputText(webTablePage.txtSearchBox,department);
		webTablePage.base.inputText(webTablePage.txtSearchBox,Keys.ENTER);
		assertEquals(webTablePage.base.getTextByLocator(webTablePage.lbDepartment),department);
	}

	@DataProvider(name = "WebTable_TC01")
	public RegistrationForm[] readWebTableData() {
		Utils utils = new Utils();
		String[][] data = utils.readDataFromCSV("WebTable_TC01.csv");
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.firstName = data[0][0];
		registrationForm.lastName = data[0][1];
		registrationForm.email = data[0][2];
		registrationForm.age = data[0][3];
		registrationForm.salary = data[0][4];
		registrationForm.department = data[0][5];
		RegistrationForm[] registrationForms = new RegistrationForm[1];
		registrationForms[0] = registrationForm;
		return registrationForms;
	}
}
