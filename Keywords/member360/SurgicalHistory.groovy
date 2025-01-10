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

public class SurgicalHistory {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics dem=new Demographics();

	@Keyword
	def fillInSurgicalHistoryScreen(SurgeryType) {
		tapOnYearOfSurgeryDrpDn();
		tapOnSpecificYear();
		setTxtInSurgeryNameTxtBx(SurgeryType);
		if(dem.verifyNextBtn(FailureHandling.OPTIONAL)) {
			dem.tapOnNextBtn();
		}
	}
	
	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSurgicalHistoryOpt() {
		tapOnExpandAllBtn()
		Mobile.scrollToText("Surgical History", FailureHandling.OPTIONAL)
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgicalHistoryOpt_andriod'), defaultTime)
	}
	@Keyword
	def tapOnSurgicalHistoryOptAfterExpand() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/surgicalHistoryBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/editBtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnAdditionalSurgeryBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addAdditionalSurgery_andriod'), defaultTime)
	}
	@Keyword
	def tapOnNoKnownSurgicalHistory() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/noKnownSurgeriesRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnCheckedNoKnownSurgicalHistory() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/checkedNoKnownSurgeriesBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnYearOfSurgeryDrpDn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/yearOfSurgeryDpDn_android', ['index' : index]), defaultTime);
	}
	@Keyword
	def tapOnSpecificYear(year = 2023) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/selectYear_android',['year':year]), defaultTime);
	}
	@Keyword
	def setTxtInSurgeryNameTxtBx(index = 1, text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgeryNameTxtBx_android',['index' : index]), text, defaultTime)
	}
	@Keyword
	def tapOnDeleteBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/deleteBtn_andriod',['index': index]), defaultTime)
	}
	@Keyword
	def verifyDeleteBtn(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/deleteBtn_andriod',['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyDeleteBtnNotPresent(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/deleteBtn_andriod',['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/cancelBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyCancelBtnExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/cancelBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnConfirmDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/deleteConfirmBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyDeletePopUpTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/deletePopUpTitle_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifydeletePopUpDescription(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/deletePopUpDescription_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnSaveBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/saveBtn_andriod'), defaultTime)
		}
		catch(Exception e) {
		}
	}
	@Keyword
	def verifyAddedValuesAftrSave(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def testObject = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addedValues_andriod',['value': value])
		Mobile.waitForElementPresent(testObject, defaultTime, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(testObject, defaultTime, onFailure)
	}
	@Keyword
	def verifyAdditionalRecordNotpresent(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/additionalSurgeryRecord_andriod',['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnSurgicalHistoryAddBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Surgical History", FailureHandling.OPTIONAL);
		dem.gen.swipeUpLittle();
		Mobile.scrollToText("Surgical History", FailureHandling.OPTIONAL);
		dem.gen.swipeUpLittle();
		Mobile.scrollToText("Surgical History", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addBtnForSurgicalHistory_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addBtnForSurgicalHistory_android'), defaultTime);
	}

	@Keyword
	def verifyYearOfSurgeryDropDownExistAndNotExist(exist=true, index, defaultTime = 10, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		if (exist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/yearOfSurgeryDpDn_android', ['index': index]), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/yearOfSurgeryDpDn_android', ['index': index]), defaultTime, onFailure);
		}
	}

	@Keyword
	def tapOnCheckedNoKnownSurgicalHistoryForEnabling() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/checkedNoKnownSurgeriesForEnabling_andriod'), defaultTime);
	}

	@Keyword
	def verifyAddAdditionalSurgeryExistAndNotExist(exist=true,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		if(exist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addAdditionalSurgery_andriod'), defaultTime, onFailure);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addAdditionalSurgery_andriod'), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifySurgeryNameInputFieldExistAndNotExist(exist=true,index, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		if(exist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgeryNameTxtBx_android',['index' : index]), defaultTime,onFailure);
		}
		else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgeryNameTxtBx_android',['index' : index]), defaultTime,onFailure);
		}
	}

	@Keyword
	def verifyYearOfSurgeryTextValue(year,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/yearOfSurgeryInputField_andriod'), year, onFailure);
	}

	@Keyword
	def verifySurgeryNameTextValue(surgeryName,index,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgeryNameTxtBx_android',['index' : index]), surgeryName, onFailure);
	}
	//verifying Edit Button Not Exist
	@Keyword
	def verifyEditBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/editBtn_andriod'), defaultTime)
	}
	//verifying Additional Surgery Not Exist
	@Keyword
	def verifyAdditionalSurgeryBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/addAdditionalSurgery_andriod'), defaultTime)
	}

	@Keyword
	def tapOnAddASurgeryBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/addASurgery_android'), defaultTime, onFailure)
	}
}

