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

public class MyProgramsOpt {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnMyProgramsOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/myProgramOpt_android'), defaultTime)
	}

	@Keyword
	def tapOnLiveProgramOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/liveProgramOpt_android'), defaultTime)
	}

	@Keyword
	def verifyLiveProgramsTabExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/liveProgramOpt_android'), defaultTime)
	}

	@Keyword
	def tapOnMyStaffBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/myStaffBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnMyStaffBtnByProgrameName(program) {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/myStaffBtnByProgrameName_andriod', ["program": program]), defaultTime)
	}
	@Keyword
	def tapOnInviteStaffBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/inviteStaffBtn_andriod'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def enterTheProviderName(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/searchProviderByName_andriod'), text, defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def checkTheProviderCheckBox(providerName) {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/providerCheckBox_andriod', ["providerName": providerName]), defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnSendProgrameInvite() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/SendProgrameInviteBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyStatusOfProvider(status, providerName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/verifyStatusOfProvider_andriod', ["status": status, "providerName": providerName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnYesRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/yesRemove_andriod'), defaultTime)
	}
	@Keyword
	def tapOnRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/removeBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyAndTapOnAddNewProgramBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/addNewProgramBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/addNewProgramBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyStartFromScratchBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/startFromScratchBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyDuplicateAnExistingProg() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/duplicateAnExistingProg_android'), defaultTime)
	}

	@Keyword
	def tapOnStartFromScratchBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/startFromScratchBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnDraftProgramsOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/draftProgramsOpt_android'), defaultTime)
	}

	@Keyword
	def verifyEditProgramBtnEnabled(programName,isEnabled = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def editProgramBtnObj = findTestObject('Object Repository/Provider/More/MyPrograms/draftProgramsOpt_android', ['programName':programName, 'isEnabled':isEnabled]);
		if(isEnabled) {
			Mobile.verifyElementExist(editProgramBtnObj, defaultTime, onFailure);
		} else {
			Mobile.verifyElementExist(editProgramBtnObj, defaultTime, onFailure);
		}
	}

	@Keyword
	def tapOnRemoveStaffBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/removeBtn_android'), defaultTime)
	}
	//--------------------Program Metrics------------------------
  
	@Keyword
	def tapOnProgramMetricsBtnByProgramName(progName) {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/programMetricsBtnByProgName_android', ['progName': progName]), defaultTime)
	}
	
	@Keyword
	def tapOnProgramMetricsMonthlyRevenue() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/programMonthlyRevenue_android'), defaultTime)
	}
	
	@Keyword
	def verifyActiveMembersCount(count) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/MyPrograms/activeMembersCount_android'), count)
	}
	
	@Keyword
	def verifyYearAndMonthDrpDwn(monthAndYear, price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/monthDrpDwn_android', ['monthAndYear': monthAndYear, 'price': price]), defaultTime)
	}

}
