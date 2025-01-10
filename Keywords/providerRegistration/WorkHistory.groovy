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
import mobile.Generic
import providerRegistration.ContactInformation
import provider360.SetUpYourAvailability


public class WorkHistory {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	ContactInformation contactInfo = new ContactInformation();
	Demographics demo = new Demographics();
	SetUpYourAvailability avail = new SetUpYourAvailability();

	@Keyword
	def typeInEmployerNameInputBx(name, index = 1) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Work History/employerNameInputBx_android', ['index': index]), name, defaultTime)
	}

	@Keyword
	def verifyEmployerNameInputBxNotExist(index=1) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/Work History/employerNameInputBx_android', ['index': index]), defaultTime)
	}

	@Keyword
	def tapOnStartDateOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/startDateOption_android'), defaultTime)
	}

	@Keyword
	def tapOnEndDateOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/endDateOption_android'), defaultTime)
	}

	@Keyword
	def typeInNameOfAddressInputBx(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Work History/nameOfAddressInputBx_android'), name, defaultTime)
	}

	@Keyword
	def typeInAddress1InputBx(address) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Work History/address1InputBx_android'), address, defaultTime)
	}

	@Keyword
	def typeInAddress2InputBx(address) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Work History/address2InputBx_android'), address, defaultTime)
	}

	@Keyword
	def typeInCityInputBx(city) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Work History/cityInputBx_android'), city, defaultTime)
	}

	@Keyword
	def tapOnselectState() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/selectState_android'), defaultTime)
	}

	@Keyword
	def tapOnselectFl() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/selectFl_android'), defaultTime)
	}

	@Keyword
	def typeInzipInputBx(zip) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Work History/zipInputBx_android'), zip, defaultTime)
	}

	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/confirmBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnActiveCheckBox(index =1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/activeCheckBox_android', ["index": index]), defaultTime)
	}

	//verify the text in elements

	@Keyword
	def verifyEmployerNameInputBxElementText(name, index =1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/employerNameInputBx_android', ["index": index]),name)
	}

	@Keyword
	def verifyNameOfAddressInputBxElementText(name, index =1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/nameOfAddressInputBx_android',["index": index]),name)
	}

	@Keyword
	def verifyAddress1InputBxElementText(address) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/address1InputBx_android'),address)
	}

	@Keyword
	def verifyAddress2InputBxElementText(address) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/address2InputBx_android'),address)
	}

	@Keyword
	def verifyCityInputBxElementText(city) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/cityInputBx_android'),city)
	}

	@Keyword
	def verifyZipInputBxElementText(zip) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/zipInputBx_android'),zip)
	}

	@Keyword
	def verifyTitleElementExist(title) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Work History/verifyTitle_android', ['title': title]),defaultTime)
	}

	@Keyword
	def verifyRequiredMsgElementExist(msg,index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Work History/verifyRequiredMsg_android', ['msg': msg, 'index': index]),defaultTime)
	}

	@Keyword
	def verifyPlaceholderElementExist(placeholder) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Work History/verifyPlaceholder_android', ['placeholder': placeholder]),defaultTime)
	}

	@Keyword
	def tapOnSelectStateInDropDown(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/stateInStateDrpDwnList_android',['state': state]), defaultTime)
	}


	@Keyword
	def fillWorkHistoryDetails(companyName, addressName, address) {
		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		tapOnStartDateOption();
		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
		//		tapOnEndDateOption();
		//		gen.swipeUpRightOfScreen();
		//		tapOnConfirmBtn();
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		contactInfo.tapOnSearchField()
		contactInfo.tapOnInputSearchField(address)
		contactInfo.tapOnFirstSearchResult()

		Mobile.scrollToText('Active', FailureHandling.STOP_ON_FAILURE);
		tapOnActiveCheckBox();
		Mobile.delay(5);
		contactInfo.tapOnNextBtn();
		Mobile.delay(10);
	}
	@Keyword
	def fillWorkHistorySecondDetails(companyName, addressName, address) {
		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		tapOnStartDateOption();
		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
//		tapOnEndDateOption();
//		gen.swipeUpRightOfScreen();
//		tapOnConfirmBtn();
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		contactInfo.tapOnSearchField()
		contactInfo.tapOnInputSearchField(address)
		contactInfo.tapOnFirstSearchResult()

		Mobile.scrollToText('Active', FailureHandling.STOP_ON_FAILURE);
		tapOnActiveCheckBox(2);
		Mobile.delay(5);
		//		contactInfo.tapOnNextBtn();
		Mobile.delay(10);
	}
	@Keyword
	def fillWorkHistoryDetailsTwo(companyName, addressName, fullAddress, city, zip) {

		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		tapOnStartDateOption();
		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
		Mobile.scrollToText('Add Additional Work History', FailureHandling.STOP_ON_FAILURE);
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		typeInAddress1InputBx(fullAddress);
		Mobile.hideKeyboard();
		typeInCityInputBx(city);
		Mobile.hideKeyboard();
		demo.swipeUp();
		tapOnselectState();
		tapOnselectFl();
		typeInzipInputBx(zip);
		Mobile.hideKeyboard();
		Mobile.delay(15);
		Mobile.scrollToText('Active', FailureHandling.STOP_ON_FAILURE);
		tapOnActiveCheckBox();
		Mobile.delay(5);
	}

	@Keyword
	def verifyWorkHistoryDetails(companyName, addressName, address) {
		demo.tapOnBackBtn();
		verifyEmployerNameInputBxElementText(companyName);
		verifyNameOfAddressInputBxElementText(addressName);
		contactInfo.verifySavedAddress(address)
		contactInfo.tapOnNextBtn();
	}
	@Keyword
	def verifyWorkHistoryDetailsTwo(companyName, addressName, fullAddress, city, zip) {
		Mobile.scrollToText(companyName);
		verifyEmployerNameInputBxElementText(companyName);
		Mobile.scrollToText(addressName);
		verifyNameOfAddressInputBxElementText(addressName);
		Mobile.scrollToText(fullAddress);
		verifyAddress1InputBxElementText(fullAddress);
		Mobile.scrollToText(city);
		verifyCityInputBxElementText(city);
		Mobile.scrollToText(zip);
		verifyZipInputBxElementText(zip);
		Mobile.delay(10)
	}

	@Keyword
	def verifyUIAndFillWorkHistoryDetails(companyName, addressName, fullAddress, city, zip) {
		contactInfo.tapOnNextBtn();
		verifyTitleElementExist("Work History")
		verifyPlaceholderElementExist("Employer Name *")
		verifyRequiredMsgElementExist("Required","1")
		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		verifyTitleElementExist("Start Date *")
		verifyTitleElementExist("End Date")
		verifyRequiredMsgElementExist("Required","1")
		tapOnStartDateOption();
		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
		//tapOnEndDateOption();
		//gen.swipeUpRightOfScreen();
		//tapOnConfirmBtn();
		verifyPlaceholderElementExist("Name of Address (eg: Home, Work) *")
		verifyRequiredMsgElementExist("Required","1")
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("Address 1 *")
		verifyRequiredMsgElementExist("Required","1")
		typeInAddress1InputBx(fullAddress);
		verifyPlaceholderElementExist("Address 2 (eg: Apt #)")
		//typeInAddress2InputBx'("address2");
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("City *")
		verifyRequiredMsgElementExist("Required","1")
		typeInCityInputBx(city);
		Mobile.hideKeyboard();
		demo.swipeUp();
		verifyPlaceholderElementExist("Select State *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnselectState();
		tapOnselectFl();
		verifyPlaceholderElementExist("Zip *")
		verifyRequiredMsgElementExist("Required","1")
		typeInzipInputBx(zip);
		Mobile.hideKeyboard();
		Mobile.delay(15);
		Mobile.scrollToText('Active', FailureHandling.STOP_ON_FAILURE);
		verifyTitleElementExist("Address Validated")
		verifyTitleElementExist("Active")
		tapOnActiveCheckBox();
		Mobile.delay(5);
		contactInfo.tapOnNextBtn();
		Mobile.delay(5);
	}
	@Keyword
	def verifyAndFillWorkHistoryDetails(companyName, addressName) {
		contactInfo.tapOnNextBtn();
		verifyTitleElementExist("Work History")
		verifyPlaceholderElementExist("Employer Name *")
		verifyRequiredMsgElementExist("Required","1")
		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		verifyTitleElementExist("Start Date *")
		verifyTitleElementExist("End Date")
		verifyRequiredMsgElementExist("Required","1")
		tapOnStartDateOption();
		avail.selectYear(2022)
//		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
		tapOnEndDateOption();
		avail.selectYear(2024)
//		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn()
		verifyPlaceholderElementExist("Name of Address (eg: Home, Work) *")
		verifyRequiredMsgElementExist("Required","1")
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("Input your address *")
		verifyRequiredMsgElementExist("Required","1")
		//typeInAddress1InputBx(fullAddress);
		verifyPlaceholderElementExist("Address Line 2 (eg: Apt #)")
		//typeInAddress2InputBx("address2");
		Mobile.hideKeyboard();
		Mobile.delay(15);
		Mobile.scrollToText('Active', FailureHandling.STOP_ON_FAILURE);
		//verifyTitleElementExist("Address Validated")
		verifyTitleElementExist("Active")
		Mobile.delay(5);
		//contactInfo.tapOnNextBtn();
		Mobile.delay(5);
	}
	@Keyword
	def tapOnAddAdditionalWorkHistoryOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/addAditionalWorkHistoryOpt_android'), defaultTime);
	}
	@Keyword
	def verifyUIAndAdditionalWorkHistoryDetails(companyName, addressName, fullAddress, city, zip) {
		demo.tapOnBackBtn();
		demo.swipeUp();
		verifyTitleElementExist("Add Additional Work History")
		tapOnAddAdditionalWorkHistoryOption();
		contactInfo.tapOnNextBtn();
		demo.swipeUp();
		verifyTitleElementExist("Work History")
		verifyPlaceholderElementExist("Employer Name *")
		verifyRequiredMsgElementExist("Required","1")
		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		verifyTitleElementExist("Start Date *")
		verifyTitleElementExist("End Date")
		verifyRequiredMsgElementExist("Required","1")
		tapOnStartDateOption();
		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
		verifyPlaceholderElementExist("Name of Address (eg: Home, Work) *")
		verifyRequiredMsgElementExist("Required","1")
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("Address 1 *")
		verifyRequiredMsgElementExist("Required","1")
		typeInAddress1InputBx(fullAddress);
		verifyPlaceholderElementExist("Address Line 2 (eg: Apt #)")
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("City *")
		verifyRequiredMsgElementExist("Required","1")
		typeInCityInputBx(city);
		Mobile.hideKeyboard();
		demo.swipeUp();
		verifyPlaceholderElementExist("Select State *")
		verifyRequiredMsgElementExist("Required","1")
		tapOnselectState();
		tapOnselectFl();
		verifyPlaceholderElementExist("Zip *")
		verifyRequiredMsgElementExist("Required","1")
		typeInzipInputBx(zip);
		Mobile.hideKeyboard();
		Mobile.delay(15);
		Mobile.scrollToText('Active', FailureHandling.STOP_ON_FAILURE);
		verifyTitleElementExist("Address Validated")
		verifyTitleElementExist("Active")
		//tapOnActiveCheckBox();
		Mobile.delay(5);
		contactInfo.tapOnNextBtn();
		Mobile.delay(5);
	}
	@Keyword
	def verifyAndFillAdditionalWorkHistoryDetails(companyName, addressName) {
		demo.swipeUp();
		verifyTitleElementExist("Add Additional Work History")
		tapOnAddAdditionalWorkHistoryOption();
		contactInfo.tapOnNextBtn();
		demo.swipeUp();
		verifyPlaceholderElementExist("Employer Name *")
		verifyRequiredMsgElementExist("Required","1")
		typeInEmployerNameInputBx(companyName)
		Mobile.hideKeyboard();
		verifyTitleElementExist("Start Date *")
		verifyTitleElementExist("End Date")
		verifyRequiredMsgElementExist("Required","1")
		tapOnStartDateOption();
		avail.selectYear(2022)
//		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn();
		tapOnEndDateOption();
		avail.selectYear(2024)
//		gen.swipeDownRightOfScreen();
		tapOnConfirmBtn()
		verifyPlaceholderElementExist("Name of Address (eg: Home, Work) *")
		verifyRequiredMsgElementExist("Required","1")
		typeInNameOfAddressInputBx(addressName);
		Mobile.hideKeyboard();
		verifyPlaceholderElementExist("Input your address *")
		verifyRequiredMsgElementExist("Required","1")
		verifyPlaceholderElementExist("Address Line 2 (eg: Apt #)")
		Mobile.hideKeyboard();
		Mobile.delay(15);
		contactInfo.tapOnNextBtn();
		Mobile.delay(5);
	}

	@Keyword
	def tapOnDeleteWorkHistoryBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/trashBtn_andriod', ["index": index]), defaultTime)
	}

	@Keyword
	def verifyTitleText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Work History/popUpTitle_andriod'), text)
	}

	@Keyword
	def tapOnDeleteConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Work History/deleteConfirmBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyTextNotExist(text, index=1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/Work History/verifyEmployerName_andriod',["name": text, "index": index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyTextExist(text, index=1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Work History/verifyEmployerName_andriod',["name": text, "index": index]), defaultTime, onFailure)
	}
}
