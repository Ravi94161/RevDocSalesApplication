package member360

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

public class Pharmacy {
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyElementText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime, onFailure)
	}
	@Keyword
	def verifypreferredPharmacyBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/preferredPharmacyOption_android'), defaultTime);
	}
	@Keyword
	def verifyCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/closeBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/closeBtn_android'), defaultTime);
	}
	@Keyword
	def setTextInSearchBox(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/SearchBox_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnFirstPharmacyOnList() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/SelectFirstPharmacyFromList_android'), defaultTime);
	}
	@Keyword
	def tapOnOkBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/OkButton_android'), defaultTime);
	}
	@Keyword
	def tapOnAdditionalPharmacyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/addAdditionalPharmacyBtn_android'), defaultTime);
		Mobile.delay(8)
	}
	@Keyword
	def verifyCheckedPrimaryPharmacyCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/CheckedPrimaryPharmacyCheckBox_android'), defaultTime);
	}
	@Keyword
	def tapOnSecondPharmacyOnList(index = 2) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/SelectSecondpharmacyFromList_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnAdvaceSearchBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/advanceSearchBtn_android'), defaultTime)
	}
	@Keyword
	def verifySeekBar(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/SeekBar_android'), defaultTime)
	}
	@Keyword
	def verifyToggle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/Toggle_android'), defaultTime)
	}
	@Keyword
	def tapOnToggle() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/Toggle_android'), defaultTime)
	}
	@Keyword
	def verifyChekedReatilcCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/CheckedRetailCheckBox_android'), defaultTime)
	}
	@Keyword
	def verifyCheckedMailCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/CheckedMailCheckBox_android'), defaultTime)
	}

	@Keyword
	def verifyPlaceHolder(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/searchPlaceHolder_android',["txt":txt]), defaultTime,onFailure);
	}
	@Keyword
	def tapOnClearBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/clearbtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnSearchBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/searchBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnDeletePharmacyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/DeletePharmacyBtn_android'), defaultTime)
	}
	@Keyword
	def setTextInAdvanceSearchPharmacyNameBox(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/SearchBoxInAdvanceSearch_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnFirstResultOfAdvanceSearch() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/FirstResultOfAdvanceSearch_android'), defaultTime);
	}
	@Keyword
	def tapOnpreferredPharmacyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/PreferredPharmacyOptn_android'), defaultTime);
	}
	//get Pharmacy Details
	@Keyword
	def getPharmacyDetails(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/getPharmacyDetails_android', ["index": index]), defaultTime);
	}

	@Keyword
	def verifySavePharmacyBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/savePharmacyBtn_android')
		if(isExist) {
			Mobile.verifyElementExist(testObject, defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(testObject, defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnSavePharmacyBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/savePharmacyBtn_android')
		Mobile.tap(testObject, defaultTime, onFailure)
	}
}
