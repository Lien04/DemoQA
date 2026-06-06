package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.PracticeFormPage;
import pages.ThanksForSubmittingPages;
import tests.models.StudentRegistration;

public class PracticeFormTest extends TestCase {
	@Test(dataProvider = "PracticeForm_TC01",testName = "[PracticeForm] Submit data successfully")
	public void submitDataSuccessfully_DataProvider(String firstName, String lastName, String email, String gender,
			String mobileNumber, String dateOfBirth, String subject, String hobbies, String picture,
			String currentAddress, String state, String city) {
		String picturePath = System.getProperty("user.dir") + "\\testcase\\TestData\\" + picture;		

		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");

		ThanksForSubmittingPages thanksForSubmittingPage = practiceFormPage.inputData_1(firstName, lastName, email,
				gender, mobileNumber, dateOfBirth, subject, hobbies, picture, currentAddress, state, city);
		String actualStudentName = thanksForSubmittingPage.getActualText("Student Name");
		String expectedStudentName = firstName + " " + lastName;
		assertEquals(actualStudentName, expectedStudentName);
		String actualEmail = thanksForSubmittingPage.getActualText("Student Email");
		assertEquals(actualEmail, email);
		String actualGender = thanksForSubmittingPage.getActualText("Gender");
		assertEquals(actualGender, gender);
		String actualMobileNumber = thanksForSubmittingPage.getActualText("Mobile");
		assertEquals(actualMobileNumber, mobileNumber);
		String actualDateOfBirth = thanksForSubmittingPage.getActualText("Date of Birth");
		String[] dateOfBirths = dateOfBirth.split(" ");
		String expectedDateOfBirth = dateOfBirths[0] + " " + dateOfBirths[1] + "," + dateOfBirths[2];
		assertEquals(actualDateOfBirth, expectedDateOfBirth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subjects");
		assertEquals(actualSubject, subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies, hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture, picturePath);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress, currentAddress);
		String actualStateAndCity = thanksForSubmittingPage.getActualText("State and City");
		String givenStateAndCity = state + " " + city;
		assertEquals(actualStateAndCity, givenStateAndCity);

	}

	@Test(dataProvider = "PracticeForm_TC01_1", groups = "regression test")
	public void submitDataSuccessfully(StudentRegistration studentRegistration) {
		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
	
//		String picturePath = System.getProperty("user.dir") + "\\testcase\\TestData\\" + picture;
		ThanksForSubmittingPages thanksForSubmittingPage = practiceFormPage.inputData(studentRegistration);
		String actualStudentName = thanksForSubmittingPage.getActualText("Student Name");
		String expectedStudentName = studentRegistration.firstName + " " + studentRegistration.lastName;
		assertEquals(actualStudentName, expectedStudentName);
		String actualEmail = thanksForSubmittingPage.getActualText("Student Email");
		assertEquals(actualEmail, studentRegistration.email);
		String actualGender = thanksForSubmittingPage.getActualText("Gender");
		assertEquals(actualGender, studentRegistration.gender);
		String actualMobileNumber = thanksForSubmittingPage.getActualText("Mobile");
		assertEquals(actualMobileNumber, studentRegistration.mobileNumber);
		String actualDateOfBirth = thanksForSubmittingPage.getActualText("Date of Birth");
		String[] dateOfBirths = studentRegistration.dateOfBirth.split(" ");
		String expectedDateOfBirth = dateOfBirths[0] + " " + dateOfBirths[1] + "," + dateOfBirths[2];
		assertEquals(actualDateOfBirth, expectedDateOfBirth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subjects");
		assertEquals(actualSubject, studentRegistration.subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies, studentRegistration.hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture, studentRegistration.picture);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress, studentRegistration.currentAddress);
		String actualStateAndCity = thanksForSubmittingPage.getActualText("State and City");
		String givenStateAndCity = studentRegistration.state + " " + studentRegistration.city;
		assertEquals(actualStateAndCity, givenStateAndCity);
	}

	@Test(groups = "validation")
	public void TC_02(String firstName, String lastName, String email, String gender,
			String mobileNumber, String dateOfBirth, String subject, String hobbies, String picture,
			String currentAddress, String state, String city) {
		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
		String picturePath = System.getProperty("user.dir") + "\\testcase\\TestData\\" + picture;
		ThanksForSubmittingPages thanksForSubmittingPage = practiceFormPage.inputData_1(firstName, lastName, email,
				gender, mobileNumber, dateOfBirth, subject, hobbies, picture, currentAddress, state, city);
		String actualStudentName = thanksForSubmittingPage.getActualText("Student Name");
		String expectedStudentName = firstName + " " + lastName;
		assertEquals(actualStudentName, expectedStudentName);
		String actualEmail = thanksForSubmittingPage.getActualText("Student Email");
		assertEquals(actualEmail, email);
		String actualGender = thanksForSubmittingPage.getActualText("Gender");
		assertEquals(actualGender, gender);
		String actualMobileNumber = thanksForSubmittingPage.getActualText("Mobile");
		assertEquals(actualMobileNumber, mobileNumber);
		String actualDateOfBirth = thanksForSubmittingPage.getActualText("Date of Birth");
		String[] dateOfBirths = dateOfBirth.split(" ");
		String expectedDateOfBirth = dateOfBirths[0] + " " + dateOfBirths[1] + "," + dateOfBirths[2];
		assertEquals(actualDateOfBirth, expectedDateOfBirth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subjects");
		assertEquals(actualSubject, subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies, hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture, picturePath);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress, currentAddress);
		String actualStateAndCity = thanksForSubmittingPage.getActualText("State and City");
		String givenStateAndCity = state + " " + city;
		assertEquals(actualStateAndCity, givenStateAndCity);
	}
	
	@DataProvider(name = "PracticeForm_TC01")
	public String[][] readDataForForm1() {
		String[][] data = null;
		Utils utils = new Utils();
		data = utils.readDataFromCSV("PracticeForm_TC01.csv");
		return data;
	}
	
	@DataProvider(name= "PracticeForm_TC01_1")
	public StudentRegistration [] readDataForFormUsingObject() {
		String[][] data = null;
		Utils utils = new Utils();
		data = utils.readDataFromCSV("PracticeForm_TC01.csv");
		StudentRegistration studentRegistration = new StudentRegistration();
		studentRegistration.firstName = data[0][0];
		studentRegistration.lastName = data[0][1];
		studentRegistration.email = data[0][2];
		studentRegistration.gender = data[0][3];
		studentRegistration.mobileNumber= data[0][4];
		studentRegistration.dateOfBirth=data[0][5];
		studentRegistration.subject=data[0][6];
		studentRegistration.hobbies=data[0][7];
		studentRegistration.picture=data[0][8];
		studentRegistration.currentAddress= data[0][9];
		studentRegistration.state=data[0][10];
		studentRegistration.city=data[0][11];
		StudentRegistration[] studentRegistrations = new StudentRegistration[1];
		studentRegistrations[0] = studentRegistration;
		return studentRegistrations;
	}
	
}