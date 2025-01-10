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

public class Status {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def tapOnStatusOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Status/StatusOpt_android'), defaultTime);
	}

	@Keyword
	def verifyElementText(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/elementText_android', ['text': text]), defaultTime, OnFailure)
	}
	@Keyword
	def verifyPRMNameElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/providerName_android'),defaultTime);
	}
	@Keyword
	def verifyPRMImageExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/OpenTasks/EHR/avatar_android'),defaultTime);
	}
	@Keyword
	def verifyPRMAddressElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Status/PRMAddress_android'),defaultTime);
	}
	@Keyword
	def verifyPassedStatusIcon(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Status/PassedStatus_Android',['index':index]), defaultTime);
	}
	@Keyword
	def verifyInProgressStatusIcon(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Status/InProgressStatus_android',['index':index]), defaultTime);
	}
	@Keyword
	def verifyBackgroundCheckStatusListProgress(listname, progress, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BackgroundCheckStatus/BackGroundCheckStatusListProgress_andriod', ["listname": listname, "progress": progress]), defaultTime, onFailure)
	}
	@Keyword
	def verifyBackgroundCheckStatusListProgressCheckMark(listname, checkmark, defaultTime = defaultTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/BackgroundCheckStatus/backGroundCheckStatusListCheckMark_andriod', ["listname": listname, "checkmark": checkmark]), defaultTime, onFailure)
	}
}
