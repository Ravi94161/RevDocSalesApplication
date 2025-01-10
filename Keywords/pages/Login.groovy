package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utility.Verify

public class Login {

	Verify verify = new Verify();

	@Keyword
	def launchSalesApplication() {
		WebUI.openBrowser("");
		WebUI.maximizeWindow();
		WebUI.navigateToUrl(GlobalVariable.appURL);
	}

	@Keyword
	def enterEmail() {
		TestObject emailTextBox = findTestObject('Object Repository/Login/input_Email Address_email');
		verify.verifyElementPresent(emailTextBox, "Email textbox not found...");
		WebUI.setText(emailTextBox, "ravi.kumar+2050@qualitlabs.com");
	}

	@Keyword
	def enterPassword() {
		TestObject passwordTextBox = findTestObject('Object Repository/Login/input_Password_password');
		verify.verifyElementPresent(passwordTextBox, "password textbox not found...");
		WebUI.setText(passwordTextBox, "RevDoc@6");
	}

	@Keyword
	def clickOnLoginButton() {
		TestObject btnLogin = findTestObject('Object Repository/Login/button_Log In');
		verify.verifyElementPresent(btnLogin, "login button not found...");
		WebUI.click(btnLogin);
	}

	@Keyword
	def enterMobileNumber() {
		TestObject phoneNumberTextBox = findTestObject('Object Repository/Login/input_Mobile Number_mobilePhoneNumber');
		verify.verifyElementPresent(phoneNumberTextBox, "phonenumber textbox not found...");
		WebUI.setText(phoneNumberTextBox, '8977942050');
	}

	@Keyword
	def clickOnSendOTP() {
		TestObject sendOTPButton = findTestObject('Object Repository/Login/button_Send OTP');
		verify.verifyElementPresent(sendOTPButton, "send OTP button not found...");
		WebUI.click(sendOTPButton)
	}

	@Keyword
	def enterOTP() {
		TestObject enterOTP = findTestObject('Object Repository/Login/input_OTP_user_input_code');
		verify.verifyElementPresent(enterOTP, "enter OTP textbox not found...");
		WebUI.setText(enterOTP, '123456');
	}

	@Keyword
	def clickOnVerifyOTPButton() {
		TestObject verifyOTP = findTestObject('Object Repository/Login/button_Verify OTP');
		verify.verifyElementPresent(verifyOTP, "Verify OTP button not found...");
		WebUI.click(verifyOTP);
	}
}

