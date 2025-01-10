package member

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

import internal.GlobalVariable

public class registrationPage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyElectronicHealthRecordTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/electronicHealthRecordTitle_'+os), defaultTime);
	}

	@Keyword
	def verifystep1of8Option() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/step1of8Option_'+os), defaultTime);
	}

	@Keyword
	def typeInFirstNameTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/firstNameTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def typeInmiddleNameTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/middleNameTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def typeInlastNameTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/lastNameTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnGenderMaleBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/genderMaleBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnGenderFemaleBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/genderFemaleBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnGenderOtherBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/genderOtherBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnDobTxtBx() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/dobTxtBx_'+os), defaultTime);
	}

	@Keyword
	def typeInNameOfOtherTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/nameOfOtherTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnNextBtn_() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/nextBtn_'+os), defaultTime);
	}
}
