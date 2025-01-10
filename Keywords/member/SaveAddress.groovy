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
import member.SelectAddresses
import mobile.Generic
import member.Checkout

public class SaveAddress {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	SelectAddresses selectAddresses = new SelectAddresses();
	Checkout checkout = new Checkout();
	Generic gen = new Generic();

	@Keyword
	def tapOn() {
		Mobile.tap(findTestObject(''), defaultTime);
	}
	@Keyword
	def verifyeditableAddress2TxtField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/address2Field_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyeditableArrivalInstructionTextField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/editableArrivalInstructionTxtField_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyeditableANameOfAddressTextField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/editableNameOfAddressTxtField_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyErrorMsgForNameOfAddressTextField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/errorMsgForNameOfAddres_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMakeDefaultAddressCheckBox(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/makedefaultAddressCheckBox_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyNoCancelBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/noCancelBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyYesSaveBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/yesSaveBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnYesSaveBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/yesSaveBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnNoCancelBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/noCancelBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifynonEditableAddress1txtField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def text = Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableAddress1Field_android'), defaultTime, onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableAddress1Field_android'), text, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableAddress1Field_android'), defaultTime, onFailure);
		return text;
	}
	@Keyword
	def verifynonEditableSelectStatetxtField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableSelectStateField_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifynonEditableZiptxtField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def text = Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableZipField_android'), defaultTime, onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableZipField_android'), text, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/nonEditableZipField_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifynonEditableCitytxtField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def text = Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/uneditableCityField_android'), defaultTime, onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/uneditableCityField_android'), text, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/uneditableCityField_android'), defaultTime, onFailure);
	}
	@Keyword
	def getSelectedStateTxtAndverify(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def text = Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/getSelectedStateText_android'), defaultTime, onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/getSelectedStateText_android'), text, onFailure);
	}
	@Keyword
	def verifySavedAddressWithStar(address, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/savedAddressWithStar_android',["address":address]), defaultTime, onFailure);
	}
	@Keyword
	def setTextInAddress2TxtField(text) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/address2Field_android'), text, defaultTime);
	}
	@Keyword
	def setTextInArrivalInstructionTextField(text, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/editableArrivalInstructionTxtField_android'), text, defaultTime);
	}
	@Keyword
	def setTextInNameOfAddressTextField(text, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/editableNameOfAddressTxtField_android'), text, defaultTime);
	}
	@Keyword
	def verifyScreenTitle(text, index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Inbox/getScreenTitle_android',["index":index]), text, onFailure);
	}

	@Keyword
	def saveLocation(address, nameOfAddress = 'Work', message = 'Address Saved') {
		selectAddresses.tapOnLocationDpn();
		selectAddresses.setTxtInSearchLocationsField(address);
		selectAddresses.tapFirstSearchResultStar();
		setTextInNameOfAddressTextField(nameOfAddress);
		tapOnYesSaveBtn();

		gen.verifyElementTxtWithoutScroll(message);
		checkout.tapOnOkayBtn();
		selectAddresses.tapFirstSearchResult();
	}
}
