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

public class SendAGiftCard {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE

	@Keyword
	def tapOnSendAGiftCardIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Send a Gift Card", FailureHandling.OPTIONAL)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SendAGiftCard/sendAGiftCardIcon_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SendAGiftCard/sendAGiftCardIcon_android'), defaultTime);
	}
	
	@Keyword
	def verifyAddToCartBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/addToCartBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyBuyNowBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/buyNowBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyCustomAmountBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/customAmountBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyCustomAmountInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/customAmountInputField_'+os), defaultTime);
	}
	
	@Keyword
	def verifyEmailBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/emailBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyFiftyBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/fiftyBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifygiftFromInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/giftFromInputField_'+os), defaultTime);
	}
	
	@Keyword
	def verifyHundreadBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/hundreadBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyOptionalMsgInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/optionalMsgInputField_'+os), defaultTime);
	}
	
	@Keyword
	def verifyReceiptEmailAdressInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/receiptemailAdressInputField_'+os), defaultTime);
	}
	
	@Keyword
	def verifyReceiptPhoneNumberInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/receiptPhoneNumberInputField_'+os), defaultTime);
	}
	
	@Keyword
	def verifyReceiptNameInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/receiptsNameInputField_'+os), defaultTime);
	}
	
	@Keyword
	def verifyTextBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/textBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyTwentyFiveBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/twentyFiveBtn_'+os), defaultTime);
	}
	
	@Keyword
	def tapOnEmailBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SendAGiftCard/emailBtn_'+os), defaultTime);
	}
	
	@Keyword
	def tapOnCustomBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SendAGiftCard/customAmountBtn_'+os), defaultTime);
	}
	
	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SendAGiftCard/buyNowBtn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyImageWithPrice() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SendAGiftCard/imageWithPrice_'+os), defaultTime);
	}
	
	@Keyword
	def navigateToSendAGiftCardScreenFromHomeScreen() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime);
		Mobile.delay(5);
		tapOnSendAGiftCardIcon()
	}
	
	@Keyword
	def enterAmountInCustomAmountTxtBx(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SendAGiftCard/customAmountInputField_'+os), text, defaultTime);
	}
	
	@Keyword
	def enterTxtInReceiptNameTxtBx(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SendAGiftCard/receiptsNameInputField_'+os), text, defaultTime);
	}
	
	@Keyword
	def enterTxtInOptionalMessageTxtBx(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SendAGiftCard/optionalMsgInputField_'+os), text, defaultTime);
	}
	
	@Keyword
	def enterTxtInGiftFromTxtBx(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SendAGiftCard/giftFromInputField_'+os), text, defaultTime);
	}
	
	@Keyword
	def enterTxtInReceiptPhoneNumberTxtBx(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SendAGiftCard/receiptPhoneNumberInputField_'+os), text, defaultTime);
	}
}
