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
import member360.Demographics

public class Medications {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	Demographics dem=new Demographics();

	@Keyword
	def fillInMedicationsScreen() {
		def medication = "Drug";
		def randomOneToNinetyNine = (new Random().nextInt(99) + 1).toString();
		def mg = "${randomOneToNinetyNine} mg";
		def randomOneDigit = (new Random().nextInt(9) + 1).toString();
		def years = "${randomOneDigit} years"
		verifyMedicationCheckboxAndUncheck()
		setTxtInMedicationNameField(medication);
		setTxtInDoseField(mg);
		setTxtInHowAftenTxtField(years);
		verifyAndTapOnTakingBtn();
		if(dem.verifyNextBtn(FailureHandling.OPTIONAL)) {
			dem.tapOnNextBtn();
		}
	}
	
	@Keyword
	def verifyMedicationCheckboxAndUncheck() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationCheckBoxFilled_android'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationCheckBoxFilled_android'), defaultTime);
		}
	}
	
	@Keyword
	def tapOnMedicationTab() {
		tapOnExpandAllBtn();
		Mobile.scrollToText("Medications", FailureHandling.OPTIONAL);
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationsTab_android'), defaultTime);
	}
	
	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/editBtn_andriod'), defaultTime, onFailure)
	}
	
	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSummaryBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/summaryAndStatusIcon_andriod'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnPlusEditOpt() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/plusEditOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnNotTakingMedicationFilledRadioBtn(index = 1) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingMedicationFilledRadioBtn_android',['index':index]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingMedicationFilledRadioBtn_android',['index':index]), defaultTime);
		}
		else {
			println("Not taking is already unchecked")
		}
	}

	@Keyword
	def verifyNotTakingMedicationFilledRadioBtn(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingMedicationFilledRadioBtn_android',['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnNotTakingMedicationEmptyRadioBtn(index = 1) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingMedicationEmptyRdBtn_android',['index':index]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingMedicationEmptyRdBtn_android',['index':index]), defaultTime);
		}
		else {
			println("Not taking is already Checked")
		}
	}

	@Keyword
	def tapOnMoreInfoBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/moreInfoBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/saveBtn_android'), defaultTime);
		Mobile.delay(5)
	}
	@Keyword
	def verifyRequiredTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/requiredTxt_android'), defaultTime);
	}
	@Keyword
	def verifyMedicationNameField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationNameField_android'), defaultTime);
	}
	@Keyword
	def verifyDoseField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/doseTxtField_android'), defaultTime);
	}
	@Keyword
	def verifyHowAftenTxtField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/howAftenTxtField_android'), defaultTime);
	}
	@Keyword
	def verifyAddAdditionalMedicationOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/addAdditionalMedicationOption_android'), defaultTime);
	}
	@Keyword
	def verifyNotExistAddAdditionalMedicationOption() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/addAdditionalMedicationOption_android'), defaultTime);
	}
	@Keyword
	def setTxtInMedicationNameField(medication) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationNameField_android'),medication, defaultTime)
	}
	@Keyword
	def setTxtInMedicationField(index = 2, medication) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationNameFieldByIndexValue_android',['index':index]),medication, defaultTime)
	}

	@Keyword
	def verifyMedicationField(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationNameFieldByIndexValue_android',['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyDoseFieldByIndex(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/doseTextFieldByIndex_android', ['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyHowAftenTxtFieldByIndex(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/howAftenTxtFieldByIndex_android', ['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def getMedicationFieldText(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationNameFieldByIndexValue_android',['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def getDoseFieldTextByIndex(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/doseTextFieldByIndex_android', ['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def getHowAftenTxtFieldByIndex(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/howAftenTxtFieldByIndex_android', ['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def setTxtInDoseField(mg) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/doseTxtField_android'),mg, defaultTime)
	}
	@Keyword
	def setTxtInDoseFieldByIndex(index = 2, mg) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/doseTextFieldByIndex_android', ['index':index]),mg, defaultTime)
	}
	@Keyword
	def setTxtInHowAftenTxtField(yrs) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/howAftenTxtField_android'),yrs, defaultTime)
	}
	@Keyword
	def setTxtInHowAftenTxtFieldByIndex(index = 2, yrs) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/howAftenTxtFieldByIndex_android', ['index':index]),yrs, defaultTime)
	}
	@Keyword
	def verifyAndTapOnNotTakingBtn(index = 1, defaultTime = defaultTime, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingBtn_android',['index':index]), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingBtn_android',['index':index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyAndTapOnTakingBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/takingBtn_andoid'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/takingBtn_andoid'), defaultTime);
	}
	@Keyword
	def tapOnEditOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/editOption_android'), defaultTime);
	}
	@Keyword
	def verifyEnteredTxtExist(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/verifyEnteredTxt_android',["txt":txt]), defaultTime);
	}

	@Keyword
	def tapOnAddOptionInMedication(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Medications", FailureHandling.OPTIONAL);
		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addOptnInMedication_android'), defaultTime, FailureHandling.OPTIONAL)) {
			dem.gen.swipeUpLittle();
		}
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addOptnInMedication_android'), defaultTime);
	}

	@Keyword
	def tapOnEmptyCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/emptyCheckBox_android'), defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalMedication(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Add An Additional Medication", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalMedication_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnDeleteMedication(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/deleteMedications_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyTheDeletePopUp(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/confirmDeletePopUp_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnConfirmDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/confirmDeleteBtn_andriod'), defaultTime);
		Mobile.delay(5);
	}

	@Keyword
	def verifyDeleteMedicationNotPresent(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/deleteMedications_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPageTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/bottomSheetTitle_android'), title, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyMedicationName(med) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationName_android', ['medName': med]), defaultTime)
	}

	@Keyword
	def verifySigValue(sig) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/sigValue_android', ['sigValue': sig]), defaultTime)
	}

	@Keyword
	def verifyQuantityOfMedication(quantity) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/quantityAndUnitValue_android', ['dose': quantity]), defaultTime)
	}

	@Keyword
	def verifyICDCode(code) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/icdCodeValue_android', ['code': code]), defaultTime)
	}
	@Keyword
	def setTxtInAdditionalMedicationNameField(medication, index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/AdditionalMedicationField_android',["index":index]),medication, defaultTime)
	}
	@Keyword
	def setTxtInAddtionalDoseField(mg, index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/AdditionalDoseField_android',["index":index]),mg, defaultTime)
	}
	@Keyword
	def setTxtInAdditionalHowAftenTxtField(yrs, index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/AdditionalHowAftenTxtField_android',["index":index]),yrs, defaultTime)
	}
	@Keyword
	def tapOnTakingBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/takingBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnDeleteAdditionalMedication(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/deleteMedicationBtn_android',["index":index]), defaultTime);
	}

	@Keyword
	def tapOnRevPrivtPopUpXBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/revPrvtPopUpXBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnViewMoreBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/viewMoreBtn_andriod'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/viewMoreBtn_andriod'), defaultTime)
	}


	@Keyword
	def tapOnFilterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/filterBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifySelectedOPtionSelectedOrNot(value, onFailure= FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/selectedOption_andriod',['value': value]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnOption(value) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/selectTheOption_andriod', ['value': value]), defaultTime)
	}

	@Keyword
	def verifyDeSelectedOptionNotSelected(value) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/selectTheOption_andriod', ['value': value]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnClearBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/clearbtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyClearBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/clearbtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnApplyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/applyBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyFilterCount(value) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/filterCount_andriod'), value)
	}

	@Keyword
	def verifyFilterCountNotPresent(onFailure= FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/filterCount_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def enterTheTextInSearchField(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchField_andriod'), text, defaultTime)
	}

	@Keyword
	def verifySearchFieldPresentOrNot() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchField_andriod'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	tapOnXBtnInSearchField(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/XBtnInSearchField_andriod'), defaultTime)
	}

	@Keyword
	def getCardText(index) {
		index = index + 2
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/resultCard_andriod',['index': index]), defaultTime)
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/resultCard_andriod',['index': index]), defaultTime)
	}

	@Keyword
	def verifyEnteredValueInSearchField(text, onFailure= FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchFieldValue_andriod',['text':text]), defaultTime, onFailure)
	}

	@Keyword
	def verifyEnteredValueInSearchFieldNotPresent(text, onFailure= FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchFieldValue_andriod',['text':text]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMedicationSummaryBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/summaryBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnBookAnAppoinmentForRefillBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/bookAnAppoinmentForRefillBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyBookAnAppointmentForRefillBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/bookAnAppoinmentForRefillBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnNotesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notesBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyNotesBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notesBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyEditBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/editBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def VerifyCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/closeBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyNotesPageTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notesPageTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyNameAndDateInNotesPage(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/nameAndDateInNotesPage_andriod', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnClose() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/closeBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyPatientAddedMedicationDetails(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/detailsOfPatientAddMedication_andriod', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def getProviderName() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/detailsOfPatientAddMedication_andriod', ['index': 4]), defaultTime)
	}

	@Keyword
	def verifyAddedByPatienttext(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/detailsOfPatientAddMedication_andriod', ['index': 4]), text)
	}

	@Keyword
	def verifyTakingOrNotTakingBtn(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/takingOrNotTakingBtn_andriod',['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnNotTakingBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/takingOrNotTakingBtn_andriod',['index':index]), defaultTime)
	}

	@Keyword
	def verifyCloseBtnInMedicationStatusPage(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/closeBtnInMedicationStatusPage_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMedicationStatusCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/closeBtnInMedicationStatusPage_andriod'), defaultTime)
	}

	@Keyword
	def verifyMedicationStatusTitle(title,onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationStatusTitle_andriod',['title':title]),defaultTime, onFailure)
	}

	@Keyword
	def verifyMedicationStatusMsgText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationTextMsg_andriod'), text, onFailure)
	}

	@Keyword
	def verifyNoBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/noBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyYesBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/yesBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMedicationIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationIcon_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyTitle(title) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationStatusTitle_andriod', ['title': title]), defaultTime, onFailure)
	}

	@Keyword
	def verifyTakingBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/takingBtn_andoid'), defaultTime)
	}

	@Keyword
	def verifySummaryBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/summaryAndStatusIcon_andriod'), defaultTime)
	}

	@Keyword
	def tapOnErrorBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/errorStatusBtn_android'), defaultTime);
	}

	@Keyword
	def verifyErrorMsg(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/errorMsg_android', ['txt': txt]), defaultTime)
	}

	@Keyword
	def verifyUploadBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/uploadBtn_android'), defaultTime)
	}

	@Keyword
	def verifyUpdatedDate(date) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/updateDate_android',['date': date]), defaultTime)
	}
	@Keyword
	def tapOnAddBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/addBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/addBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyMedicationNameFieldNotPresent() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationNameField_android'), defaultTime);
	}

	@Keyword
	def verifyDoseFieldNotPresent() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/doseTxtField_android'), defaultTime);
	}

	@Keyword
	def verifyHowAftenTxtFieldNotPresent() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/howAftenTxtField_android'), defaultTime);
	}

	@Keyword
	def verifyTakingBtnNotPresent() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/takingBtn_andoid'), defaultTime)
	}

	@Keyword
	def tapOnAddAdditionalMedicationOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/addAdditionalMedicationOption_android'), defaultTime);
	}

	@Keyword
	def verifyDeleteMedicationPresent(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/deleteMedications_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnTakingBtnUsingText(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/takingBtnTxt_android',["index":index]), defaultTime);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/backBtnOnCard_android'), defaultTime);
	}

	@Keyword
	def tapOnMedicationCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationCheckBox_android'), defaultTime)
	}

	@Keyword
	def verifyListOfNotes(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/listOfNotes_android',["index":index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAnyNotes(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/listOfNotes_android',["index":index]), defaultTime);
	}

	@Keyword
	def getProviderNameFromNotes(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/providerNamefromNotes_android',["index":index]), defaultTime);
	}

	@Keyword
	def getProviderDateAndTime(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/providerDateAndTime_android',["index":index]), defaultTime);
	}

	@Keyword
	def getProviderNpi(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/providerNpI_android',["index":index]), defaultTime);
	}

	@Keyword
	def getProviderNote(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/providerNote_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyListOfMedications(index, onFailure = FailureHandling.OPTIONAL) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/listOfMedications_android',["index":index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnRequestRefillBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/requestRefillBtn_android',["isEnabled":true]), defaultTime)
	}

	@Keyword
	def verifyRequestRefillBtnEnabled(isEnabled = true) {
		Mobile.scrollToText("Request Refill", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/requestRefillBtn_android',["isEnabled":isEnabled]), defaultTime)
	}

	@Keyword
	def searchPharmacyNameTxtField() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchPharmacyName_android'), defaultTime)
	}

	@Keyword
	def setTxtInsearchPharmacyNameTxtField(txt) {
		Mobile.delay(5)
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchPharmacyName_android'), txt, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnFirstResult() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/searchFirstResult_android'), defaultTime)
	}

	@Keyword
	def tapOnSavePharmacyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/savePharmacy_android'), defaultTime)
	}

	@Keyword
	def tapOnSendRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/sendRequestBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnAdditionalNotTakingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/AddAnAdditionalMedication/notTakingBtn_android'), defaultTime);
	}
	@Keyword
	def verifyPatientAddedRequestRefillBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/patientAddedRequestRefillBtn_android'), defaultTime);
	}
	@Keyword
	def verifyListOfMedicationsExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/listOfMedications_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyPatientDetailsFieldExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/patinetDetails_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyPrescriberDetailsFieldExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/precsriberDetails_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyPharmacyDetailsFieldExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/pharmacyDetails_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyPrescriptionDetailsFieldExist(text, index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/eprescribeDetails_android',(["text" :text, "index" :index])), defaultTime);
  }
	@Keyword
	def getProviderNameFromMedications(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/providerNameFromMedications_android', ["index": index]), defaultTime)
	}
}
