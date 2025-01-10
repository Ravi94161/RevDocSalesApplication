package provider

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class ForgotPassword {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;

	@Keyword
	def verifyForgotPasswordTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/ForgotPassword/forgotPasswordTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyElementText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/ForgotPassword/verifyElementText_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyEmailAddressField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/ForgotPassword/emailAddressField_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifysendOTPBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/ForgotPassword/sendOTPBtn_Android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCancelBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/ForgotPassword/cancelBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnForgotPasswordLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/ForgotPassword/forgotPasswordLink_android'), defaultTime);
	}
	@Keyword
	def typeInEmailTxtBx(email) {
		Mobile.setText(findTestObject('Object Repository/Provider/ForgotPassword/emailTxtBx_'+os), email+Keys.chord(Keys.RETURN), defaultTime);
	}

	@Keyword
	def tapOnSendOtpBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/ForgotPassword/sendOTPBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyLastStepShown() {
		Mobile.verifyElementExist(findTestObject("Object Repository/Provider/ForgotPassword/lastStep_"+os), defaultTime);
	}
	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/ForgotPassword/cancelBtn_android'), defaultTime)
	}

	@Keyword
	def verifyResendCodeLink() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/ForgotPassword/resendCodeLink_android'), defaultTime);
	}

	@Keyword
	def tapOnResendCodeLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/ForgotPassword/resendCodeLink_android'), defaultTime);
	}
}
