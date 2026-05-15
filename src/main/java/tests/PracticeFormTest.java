package tests;

import org.testng.annotations.Test;

import common.Utils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.PracticeFormPage;
import pages.ThanksForSubmittingPages;

public class PracticeFormTest {
	@Test (dataProvider = "Practice_TC01")
	public void submitDataSuccessfully_DataProvider(String firstName,String lastName,String email,String gender,String mobileNumber,String dateOfBirthYear,String dateOfBirthDayAndMonth,String dateOfBirth,String subject,String hobbies,String projectPath,String fileName,String picture,String currentAddress,String state,String city) {
		String picturePath = System.getProperty("user.dir") +"\\test case\\test data\\" +picture;
//		String firstName = "Lien";
//		String lastName ="Trinh";
//		String email ="trinhlien10101@gmail.com";
//		String gender = "Female";
//		String mobileNumber ="0865101004";
//		String dateOfBirth = "10 Oct 2004";
//		String subject = "English, Maths, Chemistry";
//		String hobbies = "Sports, Reading, Music";
//		String projectPath = System.getProperty("user.dir");
//		String pictureName = "BÒ1.jpg";
//		String picture = projectPath +"\\testcase\\TestData\\"+"picture.name";
//		String currentAddress = "Pham Van Dong";
//		String state ="NCR";
//		String city ="Noida";
		
		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.webDriver);
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
		
		ThanksForSubmittingPages thanksForSubmittingPage = (ThanksForSubmittingPages) practiceFormPage.inputData(firstName, lastName, email, gender, mobileNumber,dateOfBirth, subject,  hobbies, picturePath, currentAddress, state, city );
		String actualStudentName = thanksForSubmittingPage.getActualText("Student Name");
		String expectedStudentName = firstName + " "+ lastName;
		assertEquals(actualStudentName, expectedStudentName);
		String actualEmail = thanksForSubmittingPage.getActualText("Student Email");
		assertEquals(actualEmail, email);
		String actualGender = thanksForSubmittingPage.getActualText("Student Gender");
		assertEquals(actualGender, gender);
		String actualMobileNumber = thanksForSubmittingPage.getActualText("Student Mobile Number");
		assertEquals(actualMobileNumber, mobileNumber);
		String actualDateOfBirth = thanksForSubmittingPage.getActualText("Date of birth");
//		int firstSpace = dateOfBirth.indexOf("");
//		int secondSpace = dateOfBirth.indexOf(" ", firstSpace + 1);
		String[] dateOfBirths = dateOfBirth.split("");
		String expectedDateOfBirth = dateOfBirths[0] +" " +dateOfBirth[1] +"," +dateOfBirth[2]
		
		assertEquals(actualDateOfBirth, date Of birth);
		String actualSubject = thanksForSubmittingPage.getActualText("Subject");
		assertEquals(actualSubject,subject);
		String actualHobbies = thanksForSubmittingPage.getActualText("Hobbies");
		assertEquals(actualHobbies,hobbies);
		String actualPicture = thanksForSubmittingPage.getActualText("Picture");
		assertEquals(actualPicture,fileName);
		String actualAddress = thanksForSubmittingPage.getActualText("Address");
		assertEquals(actualAddress,address);
		
	}
	@DataProvider(name = "PracticeForm_TC01")
	public String[][] readDataForForm() {
		String [][] data = null;
		Utils utils = new Utils();
		data = utils.readDataFromCSV("PracticeForm_TC01.csv");
		return data;
	}
}
