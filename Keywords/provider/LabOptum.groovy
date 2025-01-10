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

public class LabOptum {

	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/requestBtn_android'), defaultTime)
	}

	@Keyword
	def verifyRequestBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/requestBtn_android'), defaultTime);
	}

	@Keyword
	def verifyUploadBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/uploadBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/uploadBtn_android'), defaultTime)
	}

	@Keyword
	def verifySelfPayBtnChecked() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/selfPayDefaultCheckedBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCardInsuranceBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/cardInsuranceBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSelfPayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/selfPayBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCardInsuranceBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/cardInsuranceBtn_android'), defaultTime)
	}

	@Keyword
	def verifyIamPayingRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/iamPayingRadioBtn_android'), defaultTime);
	}

	@Keyword
	def verifySomeoneElseIsPayingRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/someoneElseIsPayingRadioBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSomeoneElseIsPayingBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/someoneElseIsPayingRadioBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnIamPayingBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/iamPayingBtnunchecked_android'), defaultTime)
	}


	@Keyword
	def verifyRequiredTextFieldExist(fieldName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/verifyRequiredField_android', ['Text': fieldName]), defaultTime);
	}

	@Keyword
	def verifyRequiredTextFieldNotExist(fieldName) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/verifyRequiredField_android', ['Text': fieldName]), defaultTime);
	}

	@Keyword
	def verifyOrderLabBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/orderLabBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnOrderLabBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/orderLabBtn_android'), defaultTime)
	}

	@Keyword
	def verifyYesCheckBox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/yesCheckBx_android'), defaultTime);
	}

	@Keyword
	def tapOnDiagnosisCodeBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/diagnosisCodeTextField_android'), defaultTime)
	}

	@Keyword
	def verifySaveDiagnosisBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/LabOptum/saveDiagnosisBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnDiagnosisDescriptionText() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/diagnosisDescriptionTextField_android'), defaultTime)
	}
	
	@Keyword
	def tapOnSelectDrpDwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/selectLabDrpDwn_android'), defaultTime)
	}
	
	@Keyword
	def tapOnCloseBtnInSelectLab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/selectLabDrpDwn_android'), defaultTime)
	}
	
	@Keyword
	def tapOnYesCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/yesCheckBx_android'), defaultTime)
	}
	@Keyword
	def tapOnSearchTest() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/searchTest_android'), defaultTime)
	}
	@Keyword
	def tapOnDateAndTimeOfDraw() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/tapOnDateAndTimeDraw_android'), defaultTime)
	}
  @Keyword
	def enterTestName(test) {
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/LabOptum/enterSearchText_android'), test, defaultTime)
	}
	@Keyword
	def tapOnFirstSerachTest() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/tapOnFirstSearchTest_android'), defaultTime)
	}
	@Keyword
	def getDateAndTimeText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/LabOptum/getDateAndTimeText_android'), defaultTime)
	}
	@Keyword
	def getSearchTestText() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/LabOptum/getSearchTest_android'), defaultTime)
	}
	@Keyword
	def tapOnAddAdditionalTest() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/LabOptum/addAdditionalTest_android'), defaultTime)
	}
}
