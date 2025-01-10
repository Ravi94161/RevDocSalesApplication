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
import providerRegistration.Demographics
import mobile.Generic
import internal.GlobalVariable

public class ContactInformation {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics demo = new Demographics();

	@Keyword
	def typeInNameOfAddressInputBx(address) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/nameOfAddressInputBx_android'),address, defaultTime)
	}

	@Keyword
	def typeInAddress1InputBx(a1) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/address1InputBx_android'), a1, defaultTime)
	}

	@Keyword
	def typeInAddress2InputBx(a2) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/address2InputBx_android'), a2, defaultTime)
	}

	@Keyword
	def typeInCityInputBx(city) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/cityInputBx_android'), city, defaultTime)
	}

	@Keyword
	def tapOnSelectStateDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/selectStateDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectFL() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/selectFL_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectStateInDropDown(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/stateInStateDrpDwnList_android',['state': state]), defaultTime)
	}

	@Keyword
	def tapOnSelectState(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/selectState_android',['state':state]), defaultTime)
	}

	@Keyword
	def typeInZipInputBx(zip) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/zipInputBx_android'), zip, defaultTime)
	}

	@Keyword
	def tapOnFloridaFormCheckBx() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/floridaFormCheckBx_android'), defaultTime)
	}

	@Keyword
	def tapOnNextBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/nextBtn_android'), defaultTime)
	}

	@Keyword
	def verifyNameOfAddressInputBxElementText(address) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/nameOfAddressInputBx_android'),address)
	}

	@Keyword
	def verifyAddress1InputBxElementText(a1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/address1InputBx_android'),a1)
	}

	@Keyword
	def verifyAddress2InputBxElementText(a2) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/address2InputBx_android'),a2)
	}

	@Keyword
	def verifyCityInputBxElementText(city) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/cityInputBx_android'),city)
	}

	@Keyword
	def verifyStateSelectedText(state) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/verifyStateFlSelected_android', ['state': state]),defaultTime)
	}

	@Keyword
	def verifyZipInputBxElementText(zip) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Contact Information/zipInputBx_android'),zip)
	}

	@Keyword
	def verifyAddressValidatedText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/addressValidatedText_android', ['text': text]), defaultTime)
	}

	@Keyword
	def verifyErrorMsgAddressValidation(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/errorMsgAddressValidation_android', ['text': text]), defaultTime)
	}

	@Keyword
	def verifyfloridaOptionText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/floridaOptionText_android', ['text': text]), defaultTime)
	}

	@Keyword
	def verifyErrorMsgForCheckBox(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/errorMsgAddressValidation_android', ['text': text]), defaultTime)
	}

	@Keyword
	def verifyHomeAddressTitle() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Contact Information/homeAddressTitle_android'), defaultTime)
	}

	@Keyword
	def tapOnSearchField(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/searchField_android', ["index": index]), defaultTime)
	}


	@Keyword
	def tapOnInputSearchField(address) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Contact Information/inputSearchField_android'), address, defaultTime)
		Mobile.hideKeyboard();
	}

	@Keyword
	def tapOnFirstSearchResult() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/firstSearchResult_android'), defaultTime)
	}

	@Keyword
	def verifySavedAddress(address) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Contact Information/addressName_android', ['address': address]), defaultTime)
	}

	@Keyword
	def fillDetailsInContactInformationPage(addressName, address1, city, zipcode) {
		typeInNameOfAddressInputBx(addressName);
		typeInAddress1InputBx(address1);
		//tapOnAddress2InputBx("address");
		tapOnCityInputBx(city);
		Mobile.hideKeyboard();
		tapOnSelectStateDropdown();
		tapOnSelectFL();
		tapOnZipInputBx(zipcode);
		Mobile.hideKeyboard();
		Mobile.scrollToText('I have reviewed the Florida HCCE licensing requirements pursuant to FL ST 499.01 and have determined that the HCCE Permit is not applicable to me and my practice. Therefore, I will not be applying for an HCCE Permit, and will continue to purchase prescription drugs under the authority of my individual Florida State License. ', FailureHandling.STOP_ON_FAILURE);
		//demo.swipeUp();
		typeInCityInputBx(city);
		tapOnSelectStateDropdown();
		tapOnSelectFL();
		typeInZipInputBx(zipcode);
		demo.swipeUp();
		Mobile.delay(20);
		tapOnFloridaFormCheckBx();
		tapOnNextBtn();
		demo.tapOnBackBtn();
	}

	@Keyword
	def verifyContactInformationPage(address, addressName) {
		verifySavedAddress(address)
		verifyNameOfAddressInputBxElementText(addressName);
		Mobile.hideKeyboard();
		tapOnNextBtn();
	}

	@Keyword
	def verifyUIValidationOfContactScreen(address, addressName) {
		verifyHomeAddressTitle()
		tapOnSearchField()
		tapOnInputSearchField(address)
		tapOnFirstSearchResult()
		typeInNameOfAddressInputBx(addressName);
		tapOnNextBtn();
		demo.tapOnBackBtn();
	}

	@Keyword
	def fillAddress(addressName, address1, city, state, zipcode) {
		typeInNameOfAddressInputBx(addressName);
		typeInAddress1InputBx(address1);
		typeInCityInputBx(city);
		tapOnSelectStateDropdown();
		tapOnSelectStateInDropDown(state)
		typeInZipInputBx(zipcode);
	}

	@Keyword
	def tapOnCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/checkBox_andriod'), defaultTime)
	}

	@Keyword
	def fillAddress(address, addressName, addressLine2) {
		verifyHomeAddressTitle()
		tapOnSearchField()
		tapOnInputSearchField(address)
		tapOnFirstSearchResult()
		typeInNameOfAddressInputBx(addressName);
		if(addressLine2 != null) {
			typeInAddress2InputBx(addressLine2)
		}
	}
	@Keyword
	def tapOnFirstAddressSearchResult(address, addressName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Contact Information/addressSearchResultWithAddressName_android',['address': address, 'addressName': addressName]), defaultTime);
	}
	@Keyword
	def getCheckBxTxt() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Registration/Contact Information/getCheckBxText_android'),defaultTime);
	}
	@Keyword
	def verifyAcceptanceIsRequiredValidationTxtExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Contact Information/acceptanceIsRequired_android'), defaultTime)
	}
	@Keyword
	def getCheckBxInstructionTxt() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Registration/Contact Information/checkBxInstructionTxt_android'),defaultTime);
	}
}
