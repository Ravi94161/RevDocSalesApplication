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

public class EPrescriptionForm {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	MobileActions ma = new MobileActions()

	@Keyword
	def tapOnReviewPatientsAllergiesCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/allergiesCheckbox_android'), defaultTime)
	}

	@Keyword
	def verifyCompoundMedicationCheckbox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/compoundMedication_android'), defaultTime)
	}

	@Keyword
	def tapOnMedicationField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/medicationField_android'), defaultTime)
	}

	@Keyword
	def enterMedicationNameInSearchBar(med) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/medicationsSearchBar_android'), med, defaultTime)
	}

	@Keyword
	def tapOnFirstAutoSuggestedMedication() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/firstAutoSuggestedMedication_android'), defaultTime)
	}
	
	@Keyword
	def getNameOfFirstAutoSuggestedMed() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/getFirstAutoSuggestedMedName_android'), defaultTime)
	}
	
	@Keyword
	def verifyCancelRXBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/cancelRxBtn_android'), defaultTime)
	}
	
	@Keyword
	def tapOnCancelRXBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/cancelRxBtn_android'), defaultTime)
	}
	
	@Keyword
	def enterCancellationNotes(notes) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/cancellationNotesField_android'), notes, defaultTime)
		Mobile.hideKeyboard();
	}
	
	@Keyword
	def tapOnSubmitCancellationBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/submitCancellationBtn_android'), defaultTime)
	}
	
	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/cancellationPopupOkBtn_android'), defaultTime)
	}
	
	@Keyword
	def verifyPrescriptionFormDetails(ProviderFullName, patientName, medName, sigValue, qty, pharmacyInstruction) {
		ma.verifyElementPresentByText("Prescriber");
		ma.verifyElementPresentByText(ProviderFullName);
		ma.verifyElementPresentByText("Patient");
		ma.verifyElementPresentByText(patientName);
		ma.verifyElementPresentByText("Name, Strength, & Dosage Form");
		ma.verifyElementPresentByText(medName);
		ma.verifyElementPresentByText("Sig");
		ma.verifyElementPresentByText(sigValue);
		ma.verifyElementPresentByText("Qty & Unit ");
		ma.verifyElementPresentByText(qty);
		ma.verifyElementPresentByText("ICD-10")
		ma.verifyElementPresentByText("Instructions to Pharmacy")
		ma.verifyElementPresentByText(pharmacyInstruction)
		ma.verifyElementPresentByText("Signed")
		ma.verifyElementPresentByText(ProviderFullName)
	}
	
	@Keyword
	def getMedicationTxt() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/medicationField_android'), defaultTime)
	}

	@Keyword
	def enterSigName(sig) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/sigField_android'), sig, defaultTime)
	}

	@Keyword
	def enterQuantity(qty) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/quantityDrpDwn_android'), qty, defaultTime)
	}

	@Keyword
	def enterDaySupply(dose) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/daySupplyField_android'), dose, defaultTime)
	}


	@Keyword
	def tapOnQuantityUnitOfMeasure() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/quantityUnitOfMeasure_android'), defaultTime)
	}

	@Keyword
	def tapOnTypeOfQuantityUnitOfMeasure(type) {
		//Capsule
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/typeOfQuantity_android', ['type': type]), defaultTime)
	}

	@Keyword
	def tapOnDiagnosisCode() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/diagnosisCode_android'), defaultTime)
	}

	@Keyword
	def tapOnAddDiagnosisBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/addDiagnosisBtn_android'), defaultTime)
	}

	@Keyword
	def enterSymptomName(symptom) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/symptomNameSearchField_android'), symptom, defaultTime)
	}

	@Keyword
	def tapOnFirstAutoSuggestedSymptomCode() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/autoSuggestedSymptomCode_android'), defaultTime)
	}

	@Keyword
	def getSymptomCode() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/firstSymptomCode_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveDiagnosisBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/saveDiagnosisBtn_android'), defaultTime)
	}
	
	@Keyword
	def tapOnSaveAsDraftBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/saveAndDraftBtn_android', ['index': index]), defaultTime)
	}

	@Keyword
	def getDiagnosisDescriptionTxt() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/diagnosisDescriptionField_android'), defaultTime)
	}
	@Keyword
	def tapOnDiagnosisDescrption() {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/diagnosisDescriptionField_android'), defaultTime)
	}
	//verifying e-prescription page
	@Keyword
	def verifyReviewPatientsAllergiesCheckbox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/allergiesCheckbox_android'), defaultTime)
	}
	@Keyword
	def verifyMedicationFieldExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/medicationField_android'), defaultTime)
	}
	@Keyword
	def verifySigNamePlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/sigField_android'), defaultTime)
	}
	@Keyword
	def verifyQuantityPlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/quantityDrpDwn_android'), defaultTime)
	}
	@Keyword
	def verifyDaySupplyPlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/daySupplyField_android'), defaultTime)
	}
	@Keyword
	def verifyQuantityOfUnitMeasureDrpDownExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/quantityUnitOfMeasure_android'), defaultTime)
	}
	@Keyword
	def verifyDiagnosisCodePlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/diagnosisCode_android'), defaultTime)
	}
	@Keyword
	def verifyDiagnosisDescrptionPlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/diagnosisDescriptionField_android'), defaultTime)
	}
	@Keyword
	def typeInDiagnosisDescriptionField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/ePresciption/diagnosisDescriptionField_android'), text, defaultTime)
	}
	@Keyword
	def verifyInstructionToPharmacyPlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/instructionPharmacyField_android'), defaultTime)
	}
	@Keyword
	def typeInInstructionToPharmacyField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/instructionPharmacyField_android'), text, defaultTime)
	}
	@Keyword
	def verifyInstructionToPatientPlaceHolderExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/intructionToPatientField_android'), defaultTime)
	}
	@Keyword
	def typeInInstructionToPatientField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/intructionToPatientField_android'), text, defaultTime)
	}
	@Keyword
	def verifyDoNotFillCalendarExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/doNotFillCalendar_android'), defaultTime)
	}
	@Keyword
	def tapOnDoNotFillCalendar() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/doNotFillCalendar_android'), defaultTime)
	}
	@Keyword
	def verifyDispenseCheckBoxExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/dispenseCheckBox_android'), defaultTime)
	}
	@Keyword
	def tapOnSignatureAndCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/signatureAndClose_android'), defaultTime)
	}
	//get E-prescribe Details
	@Keyword
	def getSigNameText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/sigField_android'), defaultTime)
	}
	@Keyword
	def getQtyText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/quantityDrpDwn_android'), defaultTime)
	}
	@Keyword
	def getDaySupplyText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/daySupplyField_android'), defaultTime)
	}
	@Keyword
	def getQtyUnitOfMeasureText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/quantityUnitOfMeasure_android'), defaultTime)
	}
	@Keyword
	def getDiagnosisCodeText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/diagnosisCode_android'), defaultTime)
	}
	@Keyword
	def getRefillsText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/refillsPlaceHolder_android'), defaultTime)
	}
	@Keyword
	def verifyElementPresentByText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/AppointmentPage/EHRPopup/ePrescriptionForm/verifyElementText_android', ['text': text]), defaultTime, onFailure);
	}
}
