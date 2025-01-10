package member

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

public class SendAGiftCard {
	
	@Keyword
	def enterTheReceiptname(name) {
		Mobile.sendKeys(findTestObject('Object Repository/Member/Settings/SendAGiftCard/recipientsTextInput_andriod'), name);
	}
	
	@Keyword
	def enterTheOptionalMessage(message) {
		Mobile.sendKeys(findTestObject('Object Repository/Member/Settings/SendAGiftCard/optionalMessage_andriod'), message, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def EnterTheWhosGiftFrom(value) {
		Mobile.sendKeys(findTestObject('Object Repository/Member/Settings/SendAGiftCard/whosGiftFrom_andriod'), value, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def EnterTheRecipientNumber(number) {
		Mobile.sendKeys(findTestObject('Object Repository/Member/Settings/SendAGiftCard/recipientsPhoneNumber_andriod'), number, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def tapOnCheckOutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/SendAGiftCard/checkOutBtn_andriod'), 0, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def verifyElementTextpresent(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/SendAGiftCard/textElement_andriod',["text":text]), 0, FailureHandling.STOP_ON_FAILURE)
	}
}
