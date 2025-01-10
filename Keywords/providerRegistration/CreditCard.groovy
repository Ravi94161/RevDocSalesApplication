package providerRegistration

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

public class CreditCard {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyCashAppPayBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cashAppPayBtn_android'), defaultTime)
	}
	
	@Keyword
	def tapAndVerifyCashAppPayBtnWorking(txt="stripe.com") {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cashAppPayBtn_android'), defaultTime)
		tapOnPayBtn()
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': txt]), defaultTime)
		Mobile.delay(3)
		Mobile.pressBack()
//		Mobile.pressBack()
	}
	
	@Keyword
	def typeInCardNumberInputBx(number) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cardNumberInputBx_android'), number, defaultTime);
	}

	@Keyword
	def typeInExipreDateInputBx(number) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/exipreDateInputBx_android'), number, defaultTime);
	}

	@Keyword
	def typeInCvvInputBx(number) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cvvInputBx_android'), number, defaultTime);
	}

	@Keyword
	def tapOnSaveForFutureCheckBox() {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/saveForFutureCheckBox_android'), defaultTime);
		}
		catch(Exception e) {
			println("Save for future checkbox is not there")
		}
	}

	@Keyword
	def typeInZipCodeInputBx(number) {
		try {
			Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/zipCodeInputBx_android'), number, defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		}
		catch(Exception e) {
			Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/postCodeInputBx_android'), number, defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		}
	}

	@Keyword
	def tapOnPayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/payBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnPayBtnIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/payBtnIndex_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifyTitleElementExist(title) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Education/verifyTitle_android', ['title': title]),defaultTime)
	}

	@Keyword
	def verifyCountryAndUpdateZipCode(zip) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/verifyCountryInPaymentSheet_android', ['country': "United Kingdom"]), 20, FailureHandling.OPTIONAL)) {
			zip = "ABCDEF"
		}
		return zip
	}
	
	@Keyword
	def tapOnCardBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/addCardBtn_android'), defaultTime)
	}

	@Keyword
	def fillPaymentDetails(cardNum, expDate, cvv, zip) {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/addCardBtn_android'), defaultTime);
		}catch(Exception e) {
		}
		typeInCardNumberInputBx(cardNum);
		Mobile.hideKeyboard();
		typeInExipreDateInputBx(expDate);
		Mobile.hideKeyboard();
		typeInCvvInputBx(cvv);
		Mobile.hideKeyboard();
		zip = verifyCountryAndUpdateZipCode(zip)
		//tapOnSaveForFutureCheckBox();
		typeInZipCodeInputBx(zip);
		Mobile.hideKeyboard();
		tapOnPayBtn();
	}

	@Keyword
	def verifyUIAndFillPaymentDetails(cardNum, expDate, cvv, zip) {
		verifyCashAppPayBtnExist()
		tapAndVerifyCashAppPayBtnWorking()
		verifyTitleElementExist("Pay with [icon]")
		verifyTitleElementExist("Or pay using")
		tapOnCardBtn()
		verifyTitleElementExist("Card information")
		verifyTitleElementExist("Card number")
		typeInCardNumberInputBx(cardNum);
		Mobile.hideKeyboard();
		verifyTitleElementExist("MM / YY")
		typeInExipreDateInputBx(expDate);
		Mobile.hideKeyboard();
		verifyTitleElementExist("CVC")
		typeInCvvInputBx(cvv);
		Mobile.hideKeyboard();
		zip = verifyCountryAndUpdateZipCode(zip)
		verifyTitleElementExist("ZIP Code")
		typeInZipCodeInputBx(zip);
		Mobile.hideKeyboard();
		tapOnPayBtn();
	}

	@Keyword
	def verifySavedPaymentMethod(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Credit Card Details/savedPaymentMethod_andriod'), defaultTime, onFailure)
	}

	//SetUp Button in Member app - RevPlus Membership purchase process
	@Keyword
	def tapOnSetUpBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/setUpBtn_android'), defaultTime);
	}

	@Keyword
	def setUpPaymentDetails(cardNum, expDate, cvv, zip) {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/addCardBtn_android'), defaultTime);
		}catch(Exception e) {
		}
		typeInCardNumberInputBx(cardNum);
		Mobile.hideKeyboard();
		typeInExipreDateInputBx(expDate);
		Mobile.hideKeyboard();
		typeInCvvInputBx(cvv);
		Mobile.hideKeyboard();
		zip = verifyCountryAndUpdateZipCode(zip)
		typeInZipCodeInputBx(zip);
		Mobile.hideKeyboard();
		tapOnSetUpBtn();
	}
}
