package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends Page {
	public By txtFistName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	//public By rdGender = By.xpath("//*[@for='gender-radio-2']");
	public String rdGender = "//label[text()='@param']";
	public By txtMobile = By.id("userNumber");
	public By txtDateOfBirth = By.id("dateOfBirthInput");
	public By ddlYear = By.xpath("//*[@class='react-datepicker__year-selcet']");
	public By ddlMonth = By.xpath("//*[@class='react-datepicker__month-selcet']");
	public By lblDay = By.xpath("//div [@role='row'][@param");
	public By cbSubject = By.id("subjectsInput");
	public String chkHobbies = "//label[text()='@param']";
	public By txtPicture = By.id("uploadPicture");
	public By txtCurrentAddress = By.id("currentAddress");
	public By cbState = By.id("react-select-3-input");
	public By cbCity = By.id("react-select-4-input");
	public By btnSubmit = By.id("submit");
	
	public PracticeFormPage(WebDriver dr) {
		super(dr);
		
	}

	public ThanksForSubmittingPages inputData( String firstName ,String lastName,String email, String gender ,String mobileNumber ,String dateOfBirth ,String subject, String hobbies ,String picture ,String currentAddress ,String state ,String city) {
	base.inputText(txtFistName, firstName);
	base.inputText(txtLastName, lastName);
	base.inputText(txtEmail, email);
	base.selectRadioButton(rdGender,gender );
	base.inputText(txtMobile, mobileNumber);
	selectDateOfBirth(dateOfBirth);
	base.inputText(txtDateOfBirth, dateOfBirth);
	base.fillComboBox(cbSubject, subject);
	base.selectCheckbox(chkHobbies, hobbies);
	base.inputText(txtPicture, picture);
	base.inputText(txtCurrentAddress, currentAddress);
	base.fillComboBox(cbState, state);
	base.fillComboBox(cbCity, city);
	base.clickOnElement(clickSubmit);
	return.new ThanksForSubmittingPages(driver);
	
	
	}
	public void selectDateOfBirth(String dateOfBirth) {
		String[] dateOfBirths = dateOfBirth.split("");
		base.clickOnButton(txtDateOfBirth);
		base.selectDropDownBoxByVisibleText(ddlYear, dateOfBirths[2].toString());
		base.selectDropDownBoxByVisibleText(ddMonth, dateOfBirths[1].toString());
		String newDayXpath = lblDay.replace("@param1", "3").replace("@param2", dateOfBirths[0]);
		base.clickOnElement(By.xpath(newDayXpath));
	}
}
