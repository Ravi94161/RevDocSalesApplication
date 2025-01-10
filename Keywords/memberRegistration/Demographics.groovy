package memberRegistration

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

public class Demographics {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	@Keyword
	def verifyElectronicHealthRecordTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/electronicHealthRecordTitle_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyStep1of8Option() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/step1of8Option_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyNameTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/nameTitle_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifySexTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/sexTitle_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyiIdentifyAsTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/iIdentifyAsTitle_'+os), defaultTime, onFailure);
	}

	@Keyword
	def typeInFirstNameTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/firstNameTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def typeInmiddleNameTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/middleNameTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def typeInlastNameTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/lastNameTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnGenderMaleBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/genderMaleBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnGenderFemaleBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/genderFemaleBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnGenderOtherBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/genderOtherBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnIdentifyAsMale() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/identifyAsMale_android'), defaultTime);
	}

	@Keyword
	def tapOnIdentifyAsFemale() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/identifyAsFemale_'+os), defaultTime);
	}

	@Keyword
	def tapOnEnterOtherTxtBx() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/enterOtherTxtBx_'+os), defaultTime);
	}

	@Keyword
	def tapOnDobTxtBx() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/dobTxtBx_'+os), defaultTime);
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width * 2 / 3  // Change to 2/3rd from the left
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.80  // Change to 80% from the top (or adjust as needed)

		// Swipe down the year field
		Mobile.swipe(startX, startY, endX, endY) //swiping 3 years down for every swipe
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/confirmBtn_'+os), defaultTime)
	}

	@Keyword
	def typeInNameOfOtherTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/nameOfOtherTxtBx_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnNextBtn_() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/nextBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyPlaceholderFirstName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/placeholderFirstName_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderMiddleName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/placeholderMiddleName_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderLastName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/placeholderLastName_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderDob() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/placeholderDob_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderNameOfAddress() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/Address/placeholderNameOfAddress_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderAddress1() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/Address/placeholderAddress1_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderAddress2() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/Address/placeholderAddress2_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderCity() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/Address/placeholderCity_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderState() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/Address/placeholderState_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceholderZip() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Registration/Demographics/Address/placeholderZip_'+os), defaultTime, onFailure);
	}

	@Keyword
	def typeInNameOfAddressInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/Address/nameOfAddressInput_'+os), name, defaultTime);
	}

	@Keyword
	def typeInAddress1Input(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/Address/address1Input_'+os), name, defaultTime);
	}

	@Keyword
	def typeInAddress2Input(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/Address/address2Input_'+os), name, defaultTime);
	}

	@Keyword
	def typeInCityInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/Address/cityInput_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnSelectStateDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/Address/selectStateDrpdwn_'+os), defaultTime);
	}

	@Keyword
	def tapOnSelectStateFL(state = "FL") {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/Address/selectStateFL_'+os,['state':state]), defaultTime);
	}

	@Keyword
	def typeInZipInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Registration/Demographics/Address/zipInput_'+os), name, defaultTime);
	}
}
