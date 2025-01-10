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

import internal.GlobalVariable

public class ProfileBiography {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def tapOnReUploadBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/reUploadBtnForVideo_android',['index':index]), defaultTime);
	}
	@Keyword
	def ChoosePhotofromLibraryBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/chooseFromLibraryBtn_android'), defaultTime);
	}
	@Keyword
	def SelectOnePhotoFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/SelectOnePhotoFromLibrary_android'), defaultTime);
	}
	@Keyword
	def tapOnVideoReUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/reUploadVideoBtn_andriod'), defaultTime);
	}
	@Keyword
	def ChooseVideofromLibraryBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/SelectOneVideoFromLibary_android'), defaultTime);
	}
	@Keyword
	def enterTextInInfoDetailsBox(msg) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/infoDetailsTxtboxProfileBiographypage_android'), msg, defaultTime);
	}

	@Keyword
	def tapOnLanguageDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/LanguageDrop_android'), defaultTime);
	}
	@Keyword
	def tapOnAkanLanguage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/AkanLanguage_android'), defaultTime);
	}

	@Keyword
	def saveLangBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveLangProfileBiography_android'), defaultTime);
	}
	@Keyword
	def tapOnFemaleBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/femaleBtn_android'), defaultTime);
	}
	@Keyword
	def verifyFemaleBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/femaleBtn_android'), defaultTime);
	}
	@Keyword
	def verifyMaleBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/SelectedMale_android'), defaultTime);
	}
	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/closeBtn_android'), 30);
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/closeBtn_android'), 30);
	}
	@Keyword
	def tapOnWhatShouldIncludeLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/whatShoulIncludeLink_android'), 30);
	}

	@Keyword
	def tapOnSaveProfileBiography() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/saveProfileBiographyBtn_android'), defaultTime);
	}
	@Keyword
	def verifyElementTxtinTextBox(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/infoDetailsTxtboxProfileBiographypage_android'), text, onFailure);
	}
	@Keyword
	def verifyElementTxt(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/VerifyElementText_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnProfileBiographyOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/profileBiographyOption_android'), defaultTime);
	}
	@Keyword
	def verifyPatientsPalceHolderWithTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/TellPatientsPlaceHolderwthTxt_android'), 30);
	}

	@Keyword
	def verifyVideoAddedOrNot(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Profile Biography/videoOnProfileBiographyPage_android'), defaultTime, onFailure)
	}
	
	@Keyword
	def tapOnPhotoReuploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/profileBiographyReuploadBtn_android'), 30);
	}
	@Keyword
	def tapOnCropBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Profile Biography/imageCropBtn_android'), defaultTime)
	}
}
