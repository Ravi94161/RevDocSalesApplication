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

public class MyAddresses {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	AtHomeLabs address=new AtHomeLabs();
	@Keyword
	def tapOnAddAddressAndFillTheDetails(fullAddress) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/My Addresses/addAddressPlusIcon_android'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/My Addresses/addAddressPlusIcon_android'), defaultTime);
			address.fillDetailsInAddressScreen(fullAddress)
			address.tapOnSaveBtn(FailureHandling.OPTIONAL);
		}
		else {
			println("Already Saved address is there");
			Mobile.delay(10);
			address.tapOnSaveBtn(FailureHandling.OPTIONAL);
		}
	}
	@Keyword
	def tapOnOneAddressRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/My Addresses/getAddressName_android'), defaultTime);
	}
	@Keyword
	def getAddressNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/My Addresses/getAddressName_android'), defaultTime);
	}
	@Keyword
	def tapOnHealthRecordBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/My Address/HealthRecordBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnMyAdressOption() {
		Mobile.delay(6)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/myAddresses_android'),defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/myAddresses_android'), defaultTime);
	}
	@Keyword
	def tapOnAdditionalAdressOption() {
		Mobile.tap(findTestObject('Object Repository/Member/My Address/AddAdditionalAddress_android'), defaultTime);
	}

	@Keyword
	def verifyElementTxt(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/My Address/VerfyElementNewAdress_android'), text, onFailure);
	}

	@Keyword
	def verifyElementAddressTxt(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/NameofAdressOption_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSelectStateDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Member/My Address/SateDropDownBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSelectFLState() {
		Mobile.tap(findTestObject('Object Repository/Member/My Address/SelectFLState_android'), defaultTime);
	}

	@Keyword
	def SetTextInArrivalInstructionsBox(name) {
		Mobile.setText(findTestObject('Object Repository/Member/My Address/ArrivalInstructionsTxtBox_android'), name, defaultTime);
	}
	@Keyword
	def verifyArrivalInstructionsPlaceholder(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/ArrivalInstructionsTxtBox_android',['text':text]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddress(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyEditIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/EditIcon_android'), defaultTime);
	}

	@Keyword
	def verifyExistingAdress() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/VerifyExistingAdress_android'), defaultTime);
	}

	@Keyword
	def verifyScreenTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/VerifyScreenTitle_android'), defaultTime);
	}

	@Keyword
	def verifyDefaultCheckBox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/DefaultAddressCheckBox_android'), defaultTime);
	}
	@Keyword
	def getAddressName(index=1) {
		return Mobile.getText(findTestObject('Object Repository/Member/My Address/getAddressname_android',["index":index]), defaultTime);
	}

	@Keyword
	def tapOnEditIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/My Address/EditIcon_android'), defaultTime);
	}

	@Keyword
	def verifyEmptyCheckBx(onFailure = FailureHandling.OPTIONAL) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/emptyCheckBox_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyListOfAddresses(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/listOfAddresses_android', ['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyAddressNameElementExist(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/My Address/getAddressname_android',["index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyExpandIconExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/chevronRightIcon_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyAddAdditionalAddressBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/addAdditionalAddresses_android'), defaultTime);
	}

	@Keyword
	def verifyDownExpandIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/chevronDown_android'), defaultTime);
	}
}
