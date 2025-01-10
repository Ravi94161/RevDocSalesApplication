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

public class NotesPage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE

	@Keyword
	def tapOnAbdominalPainOption() {
		Mobile.scrollToText("Abdominal Pain", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/abdominalPainOption_android'), defaultTime);
	}
	@Keyword
	def tapOnAllergiesOption() {
		Mobile.scrollToText("Allergies", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/allergiesOpt_android'), defaultTime);
	}
	@Keyword
	def setTxtInAddAdditionalInfoTxtBx(note) {
		Mobile.setText(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/addAdditionalNoteTxtBox_android'), note, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnBackPainOption() {
		Mobile.scrollToText("Back pain", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/backPainOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnReUploadSymptomsPhotoOpt() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/reuploadSymptomsPic_android'), defaultTime);
	}
	@Keyword
	def verifyReUploadSymptomsPhotoOpt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/reuploadSymptomsPic_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSymptomsDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/symptomsDrpDn_android'), defaultTime);
	}
	@Keyword
	def verifySymptomsDropDown(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/symptomsDrpDn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnUploadSymptomsPhotoOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/uploadSymptomPicBtn_android'), defaultTime);
		Mobile.delay(5);
	}
	@Keyword
	def verifyUploadSymptomsPhotoOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/uploadSymptomPicBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTxtOfAddAdditionalInfoTxtBox(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/verifyTxtOfAddAdditionalTxtBx_android',["txt":txt]), defaultTime, onFailure);
	}
	@Keyword
	def verifyImagePreview(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/preViewOfImage_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyScreenTitleText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/screenTitle_android'), text, onFailure)
	}
	@Keyword
	def tapOnChooseFromLibrary() {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/chooseFromLibrary_android'), defaultTime);
	}
	@Keyword
	def verifyScreenTitleTextnotVisible(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/Banking/verifyScreenTitle_android', ["title":text]), defaultTime, onFailure)
	}
}
