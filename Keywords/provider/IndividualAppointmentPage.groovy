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
import mobile.MobileActions
import provider.ProviderEHR
import provider.MedicalNotes
import mobile.Generic

public class IndividualAppointmentPage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	MobileActions ma = new MobileActions()
	ProviderEHR ehr = new ProviderEHR()
	MedicalNotes mn = new MedicalNotes()
	Generic gen = new Generic()

	@Keyword
	def tapOnPatientHealthRecord(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/patientHealthRecord_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPatientName(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/patientNameOnAppoinment_android', ['name': name]), name, onFailure)
	}

	@Keyword
	def verifyProcedureName(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/procedureOnAppt_android'), name, onFailure)
	}

	@Keyword
	def verifyPrice(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/priceOnAppt_android'), price, onFailure)
	}

	@Keyword
	def verifyTimeSlot(time, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/timeSlotOnAppt_android'), time, onFailure)
	}

	@Keyword
	def verifyMessagePatientOption(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/messagePatientOption_android'), defaultTime)
		verifyPageTitle(title)
		verifymsgInputField()
	}

	@Keyword
	def verifyPageTitle(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/bottomSheetTitle_android'), title, onFailure)
	}

	@Keyword
	def verifymsgInputField() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/patientMsgInputField_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/bottomSheetCloseBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCancelApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/cancelAppointmentBtn_android'), defaultTime)
	}

	@Keyword
	def verifyCancelPopUpTitleAndCloseBtn(title) {
		//Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/cancelApptPopUpTitle_android'), title)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/cancelApptCloseBtn_android'), defaultTime)
	}

	@Keyword
	def verifyApptCancellationMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/apptCancellationMsg_android'), defaultTime)
	}

	@Keyword
	def completeSignNoteWithoutFillingDetails(firstName) {
		ma.tapOnElementByText(firstName);
		ma.verifyElementPresentByText(firstName);
		tapOnPatientHealthRecord();
		ehr.verifyPageTitle();
		ehr.tapOnMedicalNotes();
		mn.tapOnPlusMedicalNotesBtn();
		mn.verifyPageTitle("Add Medical Note");
		mn.addHPIValue("Random text");
		mn.tapOnSignAndCloseBtn(onFailure = FailureHandling.STOP_ON_FAILURE);
		Mobile.delay(5)
		mn.verifyAddendumAndEPrescribeOptions("Addendum", "e-prescribe");
		tapOnCloseBtn();
		Mobile.delay(2)
		tapOnCloseBtn();
		Mobile.delay(2)
		tapOnCloseBtn();
		Mobile.delay(2)
	}

	//------------CONSENT FORM------------
	@Keyword
	def tapOnAddConsentBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/ConsentForm/consentFormBtn_android'), defaultTime)
	}

	@Keyword
	def enterTxtInConsentFormField(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/ConsentForm/consentFormTxtBox_android'), txt, defaultTime)
		Mobile.hideKeyboard()
	}

	@Keyword
	def tapOnSaveAndSendToPatient() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/ConsentForm/saveAndSendToPatient_android'), defaultTime)
	}

	@Keyword
	def tapOnDocuments() {
		gen.swipeUp()
		gen.swipeUp()
		ma.tapOnElementByText("Documents")
	}
}
