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

public class DeliveryMethods {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def tapOnInsuranceYesRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/insuranceYesRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnInsuranceNoRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/insuranceNoRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSelfPayYesRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/selfPayYesRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSelfPayNoRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/selfPayNoRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveDeliveryMethodsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/saveDeliveryMethodsBtn_android'), defaultTime);
	}
	@Keyword
	def verifySavDeliveryMethodsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/FacilityDeliveryMethod/saveDeliveryMethodsBtn_android'), defaultTime, onFailure)
	}
	/// miles input field
	@Keyword
	def enterMilesValue(value) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/milesInputBx_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/milesInputBx_android'), value, defaultTime)
		Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyMilesValue(value) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/DeliveryMethods/milesInputBx_android'), value)
	}
}
