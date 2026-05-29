package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import common.Utils;
import pages.WebTablePage;
import tests.models.RegistrationForm;

public class WebTableTest extends TestCase {
	@Test(testName = "Registration Form", dataProvider = "WebTable_TC01")
	public void searchBy(RegistrationForm registrationForm) {
		WebTablePage webTablePage = new WebTablePage(testBase.webDriver);
		webTablePage.base.goToPage("https://demoqa.com/webtables");
		webTablePage.searchByText(registrationForm.searchText);
		String searchResult = webTablePage.base.getTextByLocator(webTablePage.lbSearchResult);
		if (searchResult.isEmpty() || searchResult.isBlank()) {
			webTablePage.createData(registrationForm);
			webTablePage.searchByText(registrationForm.searchText);
		}
		assertEquals(webTablePage.getSearchResult(registrationForm.searchText, registrationForm.searchBy),registrationForm.searchText,"searchBy "+registrationForm.searchBy);
		
	}
	
	@DataProvider(name = "WebTable_TC01")
	public RegistrationForm[] readDataForNewRecord() {
		Utils utils = new Utils();
		String[][] data = utils.readDataFromCSV("WebTable_Search.csv");
		RegistrationForm[] registrationForms = new RegistrationForm[data.length];
		for (int i = 0; i < data.length; i++) {
			RegistrationForm registrationForm = new RegistrationForm();
			registrationForm.firstName = data[i][0];
			registrationForm.lastName = data[i][1];
			registrationForm.age = data[i][2];
			registrationForm.email = data[i][3];
			registrationForm.salary = data[i][4];
			registrationForm.department = data[i][5];
			registrationForm.searchBy = data[i][6];
			registrationForm.searchText = data[i][7];
			registrationForms[i] = registrationForm;
		}
		return registrationForms;
	}
}
