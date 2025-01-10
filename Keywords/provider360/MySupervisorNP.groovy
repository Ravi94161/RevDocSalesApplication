package provider360

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
import mobile.Generic

public class MySupervisorNP {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic()

	@Keyword
	def tapOnMySupervisorOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/MySupervisorOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnCancelRequestOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/CancelRequestOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnCancelRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/CancelRequestBtn_'+os), defaultTime);
		Mobile.delay(5);
	}
	@Keyword
	def tapOnRemoveSupervisorOption(name, failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/RemoveSupervisorOption_'+os, ['name': name]), defaultTime, failure);
	}

	@Keyword
	def tapOnRemoveSupervisorBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/removeSupervisorBtn_android'), defaultTime)
	}

	@Keyword
	def verifyMySupervisorTitleElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/mySupervisorTitle_'+os), defaultTime);
	}

	@Keyword
	def verifyProviderProfileNPElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/providerProfileNP_'+os), defaultTime);
	}

	@Keyword
	def verifyMySupervisionOptionElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/MySupervisorOption_'+os), defaultTime);
	}

	@Keyword
	def verifySupervisionOptionElementNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisionOption_'+os), defaultTime);
	}
	@Keyword
	def isTitleOneExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/titleOne_'+os), defaultTime);
	}
	@Keyword
	def isMessageOneExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/messageOne_'+os), defaultTime);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/backBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyAndTapOnPractisingTab(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/practisingTab_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/practisingTab_android'), defaultTime);
	}

	@Keyword
	def verifyAndTapOnNonPractisingTab(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/nonPractisingTab_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/nonPractisingTab_android'), defaultTime);
	}

	@Keyword
	def verifySupervisor(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorInPractisingTab_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyRemoveSupervisorOption(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/RemoveSupervisorOption_'+os, ['name': name]), defaultTime);
	}

	@Keyword
	def verifyNonPractisingLicensedstate() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/nonPracticingLicensedState_android'), defaultTime);
	}

	@Keyword
	def verifyAndTapOnConfigureBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/configureBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/configureBtn_android'), defaultTime);
	}

	@Keyword
	def verifySupervisorName(name) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorName_android', ['name': name]), defaultTime)
	}

	@Keyword
	def verifySupervisorNameExistAndCancelRequest(name) {
		Mobile.scrollToText(name)
		verifySupervisorName(name)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/cancelrequestBySupervisorName_android', ['name': name]), defaultTime)
	}

	@Keyword
	def verifySupervisorNameNotVisible(name) {
		Mobile.delay(8)
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorName_android',['name': name]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapONSupervisorInfoIcon(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisorProfileInfoBtn_android', ['name': name]), defaultTime)
	}

	@Keyword
	def tapOnMedicalLicense() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/medicalLicense_android'), defaultTime)
	}

	@Keyword
	def getLicensedStateDetails(value) {
		def state = Mobile.getText(findTestObject('Provider/Provider360/SupervisionNP/medicalLicenseDetails_android', ['value': value]), defaultTime)
		return state
	}

	@Keyword
	def tapOnEducationalDetailsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/educationDetailsBtn_android'), defaultTime)
	}

	@Keyword
	def getEducationalDetails(value) {
		def text = Mobile.getText(findTestObject('Provider/Provider360/SupervisionNP/medicalLicenseDetails_android', ['value': value]), defaultTime)
		return text
	}

	@Keyword
	def tapOnWorkHistory() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/workHistoryDetails_android'), defaultTime)
	}

	@Keyword
	def verifyWorkCompanyName(name){
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/workCompanyName_android', ['name': name]), defaultTime)
	}

	@Keyword
	def tapOnCloseIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/closeIcon_android'), defaultTime)
	}
	
	@Keyword
	def verifySuperviseeRequestExists(name) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorName_android', ['name': name]), defaultTime, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}
	
	@Keyword
	def verifyAndRemoveSupervisionRequest(name) {
		if(verifySuperviseeRequestExists(name)== true) {
			tapOnRemoveSupervisorOption(name, FailureHandling.OPTIONAL)
			isTitleOneExist()
			isMessageOneExist()
			tapOnRemoveSupervisorBtn()
		}
	}
}
