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

public class MedicalNotes {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnSignNoteBtn(member) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/signNoteBtn_'+os,['member':member]), defaultTime)
	}

	@Keyword
	def tapOnMedicalNotesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/plusMedicalNoteBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnPlusMedicalNotesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/plusMedicalNotesBtn_android'), defaultTime)
	}

	@Keyword
	def verifySupervisorEncounterDrpDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/SignNote/supervisorEncounter_android'), defaultTime)
	}

	@Keyword
	def tapOnSupervisorEncounterDrpDown() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/supervisorEncounter_android'), defaultTime)
	}

	@Keyword
	def tapOnFirstSupervisor() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/firstSupervisor_android'), defaultTime)
	}

	@Keyword
	def typeInInputBox(input,text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/inputBox_'+os,['input':input]), text, defaultTime)
	}

	@Keyword
	def tapOnAddVitalsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addVitalsBtn_android'), defaultTime)
	}
	@Keyword
	def verifyAddVitalsBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addVitalsBtn_android'), defaultTime)
	}

	@Keyword
	def typeInSystolicInput(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/systolicInput_'+os), name, defaultTime)
	}

	@Keyword
	def typeInDiastolicInput(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/diastolicInput_'+os), name, defaultTime)
	}

	@Keyword
	def typeInHeartRateInput(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/heartRateInput_'+os), name, defaultTime)
	}

	@Keyword
	def typeInRespiratoryRateInput(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/respiratoryRateInput_'+os), name, defaultTime)
	}

	@Keyword
	def typeInTemperatureInput(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/temperatureInput_'+os), name, defaultTime)
	}

	@Keyword
	def typeInHeightInput(text,index) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/heightInput_'+os,['index':index]), text, defaultTime)
	}

	@Keyword
	def typeInWeightInput(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/weightInput_'+os), text, defaultTime)
	}

	@Keyword
	def tapOnAddVitalsBtnIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addVitalsBtnIndex_'+os,['index':index]), defaultTime)
	}

	@Keyword
	def tapOnPhysicalExamInput(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/physicalExamInput_'+os), text, defaultTime)
		Mobile.hideKeyboard()
	}

	@Keyword
	def verifyPhysicalExamInput(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/physicalExamInput_'+os), text)
	}

	@Keyword
	def PhysicalExamInput(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/physicalExamInput_'+os), text, defaultTime)
		Mobile.hideKeyboard()
	}

	@Keyword
	def tapOnCaptureBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/AddPicture/captureBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/AddPicture/plusBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnChooseFromLibraryBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/AddPicture/chooseFromLibraryBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnSelectPic() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/AddPicture/selectPic_'+os), defaultTime)
	}

	@Keyword
	def tapOnSaveImagesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/AddPicture/saveImagesBtn_'+os), defaultTime)
	}

	@Keyword
	def typeInProcedureDocumentationInput(text) {
//		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/procedureDocumentationInput_'+os),text, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/procedureDocumentationInput_'+os),text, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyProcedureDocumentationInput(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/procedureDocumentationInput_'+os), text)
	}

	@Keyword
	def typeInAssessmentAndPlanInput(text) {
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/assessmentAndPlanInput_'+os),text, defaultTime)
		Mobile.hideKeyboard()
	}

	@Keyword
	def verifyAssessmentAndPlanInput(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/assessmentAndPlanInput_'+os),text)
	}

	//	@Keyword
	//	def typeInProcedureDocumentationInput(text) {
	//		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/procedureDocumentationInput_'+os),text, defaultTime)
	//	}


	@Keyword
	def verifyMemberName(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/memberName_android', ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSignAndForward(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/SignNote/signAndForward_android'), defaultTime)
	}

	@Keyword
	def tapOnSignAndCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/signAndCloseBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnSignCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/signCloseBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProviderNoteTitle(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/bottomSheetTitle_android'), title)
	}

	@Keyword
	def verifyAddendumBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addendumBtn_android'), defaultTime)
	}

	@Keyword
	def verifyPageTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/bottomSheetTitle_android'), title)
	}

	@Keyword
	def addHPIValue(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/hpiFieldInAddMedicalNotePage_android'), text, defaultTime)
		Mobile.hideKeyboard()
	}

	@Keyword
	def verifyHPIValue(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/hpiFieldInAddMedicalNotePage_android'), text)
		Mobile.hideKeyboard()
	}

	@Keyword
	def addROSValue(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/rosTextField_andriod'), text, defaultTime)
		Mobile.hideKeyboard()
	}

	@Keyword
	def verifyROSValue(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/rosTextField_andriod'), text)
		Mobile.hideKeyboard()
	}

	@Keyword
	def tapOnSaveAndDraftBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/saveAndDraftBtn_android'), defaultTime)
	}

	@Keyword
	def clearHPIValue() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/hpiFieldInAddMedicalNotePage_android'), defaultTime)
	}

	@Keyword
	def verifyAddendumAndEPrescribeOptions(addendum, epresc) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/addendumBtn_android', ['value': addendum]), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescribe_android', ['value': epresc]), defaultTime)
	}

	@Keyword
	def tapOnEPrescribe(epresc) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescribe_android', ['value': epresc]), defaultTime)
	}

	@Keyword
	def verifyNotSignedOption(date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/notSignedLabel_andriod', ["date": date]), defaultTime, onFailure)
	}

	@Keyword
	def tapNotSignedOption(date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/notSignedLabel_andriod', ["date": date]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAddedMedicalNote() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addedMedicalNote_android'), defaultTime);
	}
	@Keyword
	def tapOnaddendumPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addendumBtn_android'), defaultTime);
	}
	@Keyword
	def addAddendNote(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addendNoteTxtField_android'), text, defaultTime)
		Mobile.hideKeyboard()
	}
	@Keyword
	def tapSignAddedumBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/signAddedumBtn_android'), defaultTime);
	}
	//verifying Medical Notes Page
	@Keyword
	def verifySaveAndDraftBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/saveAndDraftBtn_android'), defaultTime)
	}
	@Keyword
	def verifySignAndCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/signAndCloseBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnPatientllergiesCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/patientAllergiesCheckBx_android'), defaultTime);
	}
	@Keyword
	def tapOnCompundMedicationCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/compoundMedicationcheckBx_android'), defaultTime);
	}
	@Keyword
	def fillMedicationNameTextField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/medicationTxtField_android'), text, defaultTime);
	}
	@Keyword
	def fillSigTextField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/sigTxtField_android'), text, defaultTime);
	}
	@Keyword
	def fillRefillsTextField(text) {
		Mobile.clearText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/refillTxtField_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/refillTxtField_android'), text, defaultTime);
	}
	@Keyword
	def tapOnSignedMedicalNotes(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/signedMedicalNote_android', ['index':index]), defaultTime)
	}
	@Keyword
	def verifyProviderNameElementExist(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/providerDetails_android', ['index':index]), defaultTime)
	}
	@Keyword
	def verifyProviderAddressElementExist(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/providerDetails_android', ['index':index]), defaultTime)
	}
	@Keyword
	def tapOnMedicalNoteByName(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/verifyProviderName_android', ['text': text]), defaultTime)
	}
	@Keyword
	def verifyListOfMedications(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/medicationNameElement_android', ['index':index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/closeBtn_android'), defaultTime)
	}
}
