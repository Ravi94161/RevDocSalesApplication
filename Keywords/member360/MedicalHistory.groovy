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
import member360.ElectronicHealthRecord

import member360.Demographics
public class MedicalHistory {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics dem=new Demographics();
	ElectronicHealthRecord elec=new ElectronicHealthRecord();

	@Keyword
	def fillInMedicalHistoryScreen(CancerType) {
		elec.verifyAndTapOnYesBtn();
		tapOnAcidRefluxBtn();
		tapOnCurrentCheckBox();
		tapOnAddACancerTypeOption();
		setTextInCancerTypeTxtBx(CancerType);
		tapOnPastRdBtn();
		dem.tapOnNextBtn();
	}

	@Keyword
	def tapOnNextBtn() {
		dem.tapOnNextBtn();
	}

	@Keyword
	def tapOnBackBtn() {
		dem.tapOnBackBtn();
	}

	@Keyword
	def tapOnAcidRefluxBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/acidRefluxBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCurrentCheckBox(index= 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/currentCheckbox_android',['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCurrentCheckBox(index= 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/currentCheckbox_android',['index': index]), defaultTime);
	}

	@Keyword
	def tapOnPastCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/pastCheckBox_android'), defaultTime);
	}

	@Keyword
	def verifySubHeading(heading, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/subHeadings_andriod',['heading': heading]), defaultTime, onFailure)
	}

	@Keyword
	def verifySubHeadingNotExist(heading, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/subHeadings_andriod',['heading': heading]), defaultTime, onFailure)
	}

	@Keyword
	def verifyHealthConditionList(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/healthConditionlist_andriod',['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAddACancerTypeOption() {
		Mobile.scrollToText("Add a Cancer Type", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/addACancerType_android'), defaultTime);
	}
	@Keyword
	def verifyAddACancerTypeOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText("Add a Cancer Type", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/addACancerType_android'), defaultTime, onFailure);
	}

	@Keyword
	def setTextInCancerTypeTxtBx(text, index = 1) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/setTextInCancerType_android', ['index': index]), text, defaultTime);
	}

	@Keyword
	def verifyCancerTypeTxtBx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/setTextInCancerType_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyTextInCancerTypeTxtBx(text, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/setTextInCancerType_android', ['index': index]), text, onFailure);
	}

	@Keyword
	def verifySecondCancerTypeNotExist(index = 2, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/setTextInCancerType_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAddAdditionalCancer() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/addAdditionalCancerBtn_andriod'), defaultTime)
	}

	@Keyword
	def getTextInCancerTypeTxtBx(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/setTextInCancerType_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyCancerCurrentCbx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Cancer/currentCbx_android',  ['index': index]), defaultTime, onFailure);
	}


	@Keyword
	def tapOnCancerCurrentCbx(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Cancer/currentCbx_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def verifyCancerPastCbx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Cancer/pastCbx_android',  ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCancerPastCbx(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Cancer/pastCbx_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def verifyDeleteMedicalConditaionOfTypeCancer(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Cancer/deleteMedicalConditions_android',  ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnDeleteMedicalConditaionOfTypeCancer(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Cancer/deleteMedicalConditions_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnAddABloodDisorder() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/addABloodDisorder_andriod'), defaultTime)
	}

	@Keyword
	def verifyAddABloodDisorderBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/addABloodDisorder_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def setTextInBloodDisordersTxtBx(text, index = 1) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/bloodDisordersTextField_android', ['index': index]), text, defaultTime);
	}

	@Keyword
	def verifyBloodDisordersTxtBx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/bloodDisordersTextField_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyTextInBloodDisordersTxtBx(text, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/bloodDisordersTextField_android', ['index': index]), text, onFailure);
	}

	@Keyword
	def verifySecondBloodDisordersNotExist(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/bloodDisordersTextField_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def getTextInBloodDisordersTypeTxtBx(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/bloodDisordersTextField_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyBloodDisordersCurrentCbx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/currentCbx_android',['index': index]), defaultTime, onFailure, )
	}

	@Keyword
	def tapOnBloodDisordersCurrentCbx(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/currentCbx_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def verifyBloodDisordersPastCbx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/pastCbx_android',  ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnBloodDisordersPastCbx(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/pastCbx_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnDeleteMedicalConditaionOfTypeBloodDisorders(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/deleteMedicalConditions_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def verifyDeleteMedicalConditaionBtnOfTypeBloodDisorders(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/deleteMedicalConditions_android',  ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAddAdditionalBloodDisOrder() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/BloodDisorders/addAdditionalBloodDisorder_andriod'), defaultTime)
	}

	@Keyword
	def tapOnAddOtherMedicalContion() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/addAOtherMedicalCondition_andriod'), defaultTime)
	}

	@Keyword
	def verifyAddOtherMedicalOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/addAOtherMedicalCondition_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def setTextInOtherMedicalConditionsTxtBx(text, index = 1) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/otherMedicalConditionsTextBox_android', ['index': index]), text, defaultTime);
	}

	@Keyword
	def verifyOtherMedicalConditionsTxtBx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/otherMedicalConditionsTextBox_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyTextInOtherMedicalConditionsTxtBx(text, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/otherMedicalConditionsTextBox_android', ['index': index]), text, onFailure);
	}

	@Keyword
	def verifySecondOtherMedicalConditionsNotExist(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/otherMedicalConditionsTextBox_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def getTextInOtherMedicalConditionsTypeTxtBx(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/otherMedicalConditionsTextBox_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyOtherMedicalConditionsCurrentCbx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/currentCbx_android',  ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnOtherMedicalConditionsCurrentCbx(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/currentCbx_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def verifyOtherMedicalConditionsPastCbx(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/pastCbx_android',  ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnOtherMedicalConditionsPastCbx(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/pastCbx_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def taponAddAdditionalMedicalCondition() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/addAdditionalMedicalCondition_andriod'), defaultTime)
	}

	@Keyword
	def verifyDeleteMedicalConditaionOfTypeOtherMedicalConditions(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/deleteMedicalConditions_android',  ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnDeleteMedicalConditaionOfTypeOtherMedicalConditions(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/OtherMedicalConditions/deleteMedicalConditions_android',  ['index': index]), defaultTime);
	}

	@Keyword
	def verifyPastRadioBtn(index=1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/pastRadioBtn_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnPastRdBtn(index=1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Health Condition/pastRadioBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnMedicalHistory() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
		Mobile.scrollToText("Personal Medical History", FailureHandling.OPTIONAL)
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/medicalHistoryTab_android'), defaultTime)
	}
	@Keyword
	def tapOnMedicalHistoryAfterExpand() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/medicalHistoryBtnAftrExpnd_andriod'), defaultTime)
	}

	@Keyword
	def tapOnEditIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/editIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnEditOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/editOption_android'), defaultTime)
	}
	
	@Keyword
	def tapOnPlusEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/plusEditBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnNotesIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/notes_android'), defaultTime)
	}

	@Keyword
	def tapOnYes() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/yesBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnNo() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/noBtn_android'), defaultTime)
	}

	@Keyword
	def verfyNoHealthConditionsTextExists(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/noHeathConditionsText_android'), defaultTime, onFailure)
	}

	@Keyword
	def verfyCurrentStatusTextExists(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/CurrentPanel/currentSavedMedicalHistory', ['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def verfyPastStatusTextExists(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/CurrentPanel/pastSavedMedicalHistory', ['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def verfyCurrentStatusTextNotExists(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/CurrentPanel/currentSavedMedicalHistory', ['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def verfyPastStatusTextNotExists(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/CurrentPanel/pastSavedMedicalHistory', ['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/saveBtn_android'), defaultTime)
	}

	@Keyword
	def verifyDeleteBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/deleteBtnConfirm_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/deleteBtnConfirm_android'), defaultTime)
	}

	@Keyword
	def VerifyEHRNotesTitle(text = 'EHR Notes', onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/EHRNotesTitle_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/EHRNotesTitle_android'), text, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def VerifyCloseBtnInEHRNotes(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/closeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapCloseBtnInEHRNotes(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/closeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/cancelBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/cancelBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyPopUpTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/deletePopUpTitle_android'), text, onFailure)
	}
	@Keyword
	def getAddedNotesText(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/getAddedNoteText_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAddedNotesText(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/getAddedNoteText_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyProviderNameTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/Notes/providerNameTitle_android'), text, onFailure);
	}
}
