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

import internal.GlobalVariable

public class ProviderEHR {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;

	@Keyword
	def verifyPageTitle() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/bottomSheetTitle_android'), "Patient EHR", FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnMedicalNotes() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/medicalNotes_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/medicalNotes_android'), defaultTime)
	}

	@Keyword
	def verifyDraftMedicalNote() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/draftMedicalNote_android'), defaultTime)
	}

	@Keyword
	def tapOnDraftNote() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/draftMedicalNote_android'), defaultTime)
	}

	@Keyword
	def verifyFamilyHistoryExists() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/familyHistoryOption_android'), defaultTime)
	}

	@Keyword
	def tapOnShareEHRBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/shareEHRBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/PatientHealthRecord/closeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnFamilyHistoryOption() {
		//Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
		Mobile.scrollToText("Family History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/familyHistoryOption_'+os), defaultTime);
	}

	@Keyword
	def tapOnSocialHistoryOption() {
		//tapOnExpandAllBtn();
		Mobile.scrollToText("Social History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/socialHistoryOption_'+os), defaultTime);
	}

	@Keyword
	def tapOnAllergiesTab() {
		Mobile.scrollToText("Allergies", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/allergiesTab_android'), defaultTime);
	}

	@Keyword
	def tapOnDocumentsTab() {
		Mobile.scrollToText("Documents", FailureHandling.OPTIONAL)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Documents/documentOption_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Documents/documentOption_android'), defaultTime);
	}
	
	@Keyword
	def tapOnMedicalHistory() {
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		Mobile.scrollToText("Personal Medical History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/medicalHistoryTab_android'), defaultTime)
	}
	
	@Keyword
	def tapOnSurgicalHistoryOpt() {
		Mobile.scrollToText("Surgical History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgicalHistoryOpt_andriod'), defaultTime)
	}
	
}

