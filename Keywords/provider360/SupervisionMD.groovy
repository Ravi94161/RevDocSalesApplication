package provider360

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
import org.openqa.selenium.Rectangle

import internal.GlobalVariable

public class SupervisionMD {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;


	@Keyword
	def verifyElementTxt(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/verifyElementTxt_android',["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyStateCheckBox(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/checkBoxState_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnProfileIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/profileIcon_android'), 30)
	}

	@Keyword
	def tapOnProviderProfileOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/providerProfileOption_android'), 30)
	}

	@Keyword
	def tapOnSupervisionOption() {
		Mobile.scrollToText('Supervision');
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/supervisionOption_android'), 30)
	}

	@Keyword
	def tapOnSignUpButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/signUpButtonMD_android'), 30)
	}

	@Keyword
	def tapOnNotNowButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/notNowButtonMD_android'), 30)
	}

	@Keyword
	def tapOnCloseButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/closeButtonInModalPopUp_android'), 30)
	}
	@Keyword
	def verifyCloseButton(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/closeButtonInModalPopUp_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnBackButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/backButton_android'), 30)
	}

	@Keyword
	def tapOnCheckboxState() {
		Mobile.tap(findTestObject('Provider/Provider360/SupervisionMD/checkBoxState_android'), 30)
	}

	@Keyword
	def verifyExpiresDateLabel(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/expiresDateLabel_andriod'), 30, onFailure)
	}

	@Keyword
	def tapOnContiueButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/continueButtonInModalPopUp_android'), 30)
	}

	@Keyword
	def tapOnSubmitButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/submitButtonInModalPopUp_android'), 30)
	}
	@Keyword
	def verifySubmitButton(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/submitButtonInModalPopUp_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyUserNavigationToProfileSetUpScreen() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/supervisionOption_android'), 30)
	}

	@Keyword
	def verifySupervisionTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/titleSupervision_android'), 30)
	}

	@Keyword
	def verifyIfYouLikeToBeSupervisorTextIsPresentOrNot() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/textIn1stLineOfSupervisionMD_android'), 30)
	}

	@Keyword
	def verifySupervisorMake20percentTextIsPresentOrNot() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/textIn2ndLineOfSupervisionMD_android'), 30)
	}

	@Keyword
	def verifySignUpButtonisPresentOrNot() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/signUpButtonMD_android'), 30)
	}

	@Keyword
	def verifyNotNowButtonIsPresentOrNot() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/notNowButtonMD_android'), 30)
	}

	@Keyword
	def verifyBackButtonIsPresentOrNot() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionMD/backButton_android'), 30)
	}

	@Keyword
	def verifyOpenTasksTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/openTasksTitle_android'), 30)
	}
}