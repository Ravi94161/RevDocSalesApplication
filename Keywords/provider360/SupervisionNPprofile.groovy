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

public class SupervisionNPprofile {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def verifySelectStateOneRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectStateOneRadioBtn_android'), defaultTime);
	}
	@Keyword
	def verifySelectStateTwoRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectStateTwoRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSelectStateOneRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectStateOneRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSelectStateTwoRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectStateTwoRadioBtn_android'), defaultTime);
	}
	@Keyword
	def verifyPendingRequest() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/pendingRequest_'+os), defaultTime);
	}
	@Keyword
	def verifycancelRequest() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/CancelRequestOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnfirstProviderInSelectedState() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/firstProviderInSelectedState_android'), defaultTime);
	}
	@Keyword
	def tapOnFirstProviderSelectedStateRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectFirstProviderRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnFloridaProviderRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/floridaProviderRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def verifySendRequestTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/sendRequestTitle_'+os), defaultTime);
	}
	@Keyword
	def verifySendRequestMessage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/sendRequestMessage_'+os), defaultTime);
	}
	@Keyword
	def verifyAlabamaProviderRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/alabamaProviderRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyFloridaProviderRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/floridaProviderRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyPendingRequestElement() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/pendingRequestElement_'+os), defaultTime);
	}
}
