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

public class OptPrograms {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnOptInToProgramsOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Opt-in to Programs/Opt-inToProgramsOpt_andriod'), defaultTime)
	}

	@Keyword
	def verifyProgramsOptTitle(OnFailure = FailureHandling.CONTINUE_ON_FAILURE){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/Opt-in to Programs/Programe-OptTitle_andriod'), defaultTime, OnFailure)
	}

	@Keyword
	def verifyRevDocProgramsTab(OnFailure = FailureHandling.CONTINUE_ON_FAILURE){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/Opt-in to Programs/RevDocProgramsTab_andriod'), defaultTime, OnFailure)
	}

	@Keyword
	def verifyShareBtn(OnFailure = FailureHandling.CONTINUE_ON_FAILURE){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/Opt-in to Programs/shareBtn_andriod'), defaultTime, OnFailure)
	}

	@Keyword
	def getProgramName(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/getProgramName_android', ['index':index]), defaultTime);
	}

	@Keyword
	def getProgramOwnerName(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Provider/More/Opt-in to Programs/getProgramOwnerName_android', ['index':index]), defaultTime);
	}
	@Keyword
	def tapOnoptOutBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Opt-in to Programs/optOutBtn_android'), defaultTime)
	}

	@Keyword
	def verifyOptOutBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def optOutBtnObj = findTestObject('Object Repository/Provider/More/Opt-in to Programs/optOutBtn_android');
		if(isExist) {
			Mobile.verifyElementExist(optOutBtnObj, defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(optOutBtnObj, defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnYesOptOutBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Opt-in to Programs/yesOptOutBtn_android'), defaultTime)
	}

	@Keyword
	def verifyYesOptOutBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def yesOptOutBtnObj = findTestObject('Object Repository/Provider/More/Opt-in to Programs/yesOptOutBtn_android');
		if(isExist) {
			Mobile.verifyElementExist(yesOptOutBtnObj, defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(yesOptOutBtnObj, defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnYesOptInBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Opt-in to Programs/yesOptInBtn_android'), defaultTime);
	}

	@Keyword
	def verifyYesOptInBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def yesOptInBtnObj = findTestObject('Object Repository/Provider/More/Opt-in to Programs/yesOptInBtn_android');
		if(isExist) {
			Mobile.verifyElementExist(yesOptInBtnObj, defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(yesOptInBtnObj, defaultTime, onFailure)
		}
	}

	@Keyword
	def tapOnOtherProviderProgramsTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Opt-in to Programs/otherProviderPrograms_android'), defaultTime);
	}

}
