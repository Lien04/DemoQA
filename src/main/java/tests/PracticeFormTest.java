package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.PracticeFormPage;
import pages.ThanksForSubmittingPages;

public class PracticeFormTest extends TestCase {
	@Test
	public void submitDataSuccessfully() {
		String firstName = "Lien" ;
		String lastName = "Trinh";
		String email = "trinhlien10101@gmail.com";
		String gender = "Female";
		String mobileNumber = "0865101004";
		String dateOfBirthYear = "2004";
		String dateOfBirthDayAndMonth = "10 Oct";
		String dateOfBirth = dateOfBirthDayAndMonth + " " + dateOfBirthYear;
		String subject = "Maths, English, Chemistry";
		String hobbies = "Sports, Reading, Music";
		String projectPath = System.getProperty("user.dir");
		String fileName = "BÒ1.jpg";
		String picture = projectPath + "\\testcase\\TestData\\" + fileName;
		String currentAddress = "Pham Van Dong";
		String state = "NCR";
		String city = "Noida";

		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");

		ThanksForSubmittingPages thanksForSubmittingPage = practiceFormPage.inputData(firstName, lastName, email, gender,
				mobileNumber, dateOfBirth, subject, hobbies, picture, currentAddress, state, city);
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
		String givenDateOfBirth = dateOfBirthDayAndMonth + "," + dateOfBirthYear;
		assertEquals(actualDateOfBirth, givenDateOfBirth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subjects");
		assertEquals(actualSubject, subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies, hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture, fileName);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress, currentAddress);
		String actualStateAndCity = thanksForSubmittingPage.getActualText("State and City");
		String givenStateAndCity = state + " " + city;
		assertEquals(actualStateAndCity, givenStateAndCity);

	}
}