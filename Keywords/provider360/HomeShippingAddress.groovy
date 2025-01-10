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

public class HomeShippingAddress {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnHomeShippingAddressOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/homeShippingAddressOption_'+os), defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalAddressBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/addAdditionalAddressBtn_'+os), defaultTime);
	}

	@Keyword
	def typeInNameOfAddressInputBx(address) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/nameOfAddressInputBx_android'),address, defaultTime)
	}

	@Keyword
	def verifyNameOfAddressInputBxText(address) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/nameOfAddressInputBx_android'),address, defaultTime)
	}

	@Keyword
	def typeInAddress1InputBx(a1) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/address1InputBx_android'), a1, defaultTime)
	}

	@Keyword
	def verifyAddress1InputBxText(a1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/address1InputBx_android'), a1, defaultTime)
	}

	@Keyword
	def typeInAddress2InputBx(a2) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/address2InputBx_android'), a2, defaultTime)
	}

	@Keyword
	def verifyAddress2InputBxText(a2) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/address2InputBx_android'), a2, defaultTime)
	}

	@Keyword
	def typeInCityInputBx(city) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/cityInputBx_android'), city, defaultTime)
	}

	@Keyword
	def verifyCityInputBxText(city) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/cityInputBx_android'), city, defaultTime)
	}

	@Keyword
	def tapOnSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/selectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectStateInDropDown(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/stateInStateDrpDwnList_android',['state': state]), defaultTime)
	}

	@Keyword
	def typeInZipInputBx(zip) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/zipInputBx_android'), zip, defaultTime)
	}

	@Keyword
	def verifyZipInputBxText(zip) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/zipInputBx_android'), zip, defaultTime)
	}

	@Keyword
	def tapOnFloridaFormCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/floridaFormCheckBx_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/saveBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/continueBtn_'+os), defaultTime);
	}

	@Keyword
	def swipeUp() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.30  // Change to 30% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(10)
	}

	@Keyword
	def addAdditionalAddress(btn,name,address1,city,zip) {
		tapOnHomeShippingAddressOption();
		Mobile.scrollToText(btn);
		tapOnAddAdditionalAddressBtn();
		typeInNameOfAddressInputBx(name);
		typeInAddress1InputBx(address1);
		typeInCityInputBx(city);
		tapOnSelectStateDropdown();
		tapOnSelectFL();
		typeInZipInputBx(zip);
		swipeUp();
		tapOnFloridaFormCheckBx();
		tapOnSaveBtn();
		tapOnContinueBtn();
	}

	@Keyword
	def addAdditionalAddressloop(btn,name,address1,city,zip) {
		//tapOnHomeShippingAddressOption();
		Mobile.scrollToText(btn);
		Mobile.scrollToText(btn);
		tapOnAddAdditionalAddressBtn();
		typeInNameOfAddressInputBx(name);
		typeInAddress1InputBx(address1);
		typeInCityInputBx(city);
		tapOnSelectStateDropdown();
		tapOnSelectFL();
		typeInZipInputBx(zip);
		swipeUp();
		tapOnFloridaFormCheckBx();
		tapOnSaveBtn();
		tapOnContinueBtn();

	}

	@Keyword
	def verifyNameOfAddress(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/verifyNameOfAddress_'+os, ['name': name]), defaultTime);
	}

	@Keyword
	def verifyAdditionalAddress(name) {
		//tapOnHomeShippingAddressOption();
		Mobile.scrollToText(name);
		verifyNameOfAddress(name);
		//		verifyAddress1InputBxText(address1)
		//		//verifyAddress2InputBxText(address2)
		//		verifyCityInputBxText(city)
		//		verifyZipInputBxText(zip)
	}

	@Keyword
	def tapOnAddressEditBtn(address) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/addressEditBtnInAddrsPg_andriod', ['value': address]), defaultTime)
	}

	@Keyword
	def checkTheDefaultDeliveryAddressCheckBox() {
		Mobile.checkElement(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/defaultDeliveryAddressCheckBox_andriod'), defaultTime)
	}

	@Keyword
	def verifyCheckBoxFilledExist() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/checkboxFilled_'+os), defaultTime, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/backBtn_andriod'), defaultTime)
	}

	@Keyword
	def getAddedaddressInAddressPg(address) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/getAddress_andriod', ['value': address]), defaultTime);
	}
	@Keyword
	def verifyEditBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/editBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyAdditionalAddressBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/addAdditionalAddressBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyCheckboxFilled(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/checkboxFilled_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyNameLabelPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/nameOfAddressInputBx_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyAddress1Present(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/addressOneLabel_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyAddress2Present(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/addressSecondLabel_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyArrivalInstructionsPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/arrivalInstructions_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnSearchLocationsField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/searchLocationField_android'), defaultTime, onFailure);
	}
	@Keyword
	def enterInputInSearchLocationField(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/searchInputTxt_android'), txt, defaultTime)
	}
	@Keyword
	def tapOnFirstResultAddress() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/Address/selectFirstAddress_android'), defaultTime);
	}
	@Keyword
	def addAdditionalMultipleAddresses(btn,address, addressName) {
		Mobile.delay(5);
		Mobile.scrollToText(btn);
		Mobile.scrollToText(btn);
		tapOnAddAdditionalAddressBtn();
		tapOnSearchLocationsField();
		enterInputInSearchLocationField(address);
		Mobile.hideKeyboard();
		tapOnFirstResultAddress();
		typeInNameOfAddressInputBx(addressName);
		tapOnSaveBtn();
	}
	@Keyword
	def verifyAlertPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/verifyAlertSymbol_'+os), defaultTime,onFailure);
	}
	@Keyword
	def verifyContinueBtnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/continueBtn_'+os), defaultTime,onFailure);
	}
	@Keyword
	def verifyCheckboxEmpty(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/checkboxEmpty_'+os), defaultTime,onFailure);
	}
	@Keyword
	def verifyUpdateScreenTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Home, Shipping Address/screenTitle_android'),title)
	}
}
