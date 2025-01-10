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

public class MemberSpecialists {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnSpecialistsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member Services/Specialists/specialistsOption_'+os), defaultTime);
	}

	@Keyword
	def getSpecialityName() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member Services/Specialists/specialityName_'+os), defaultTime)
	}

	@Keyword
	def tapOnDesiredSpeciality(speciality) {
		Mobile.tap(findTestObject('Object Repository/Member/Member Services/Specialists/cardiologistOption_'+os, ['speciality': speciality]), defaultTime);
	}

	@Keyword
	def tapOnSelectAddress(address) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member Services/Specialists/selectAddress_'+os,['address': address]), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member Services/Specialists/selectAddress_'+os,['address': address]), defaultTime);
	}

	@Keyword
	def typeInSelectAddressInput(address) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member Services/Specialists/selectAnAddressInput_'+os), defaultTime, FailureHandling.OPTIONAL);
		Mobile.setText(findTestObject('Object Repository/Member/Member Services/Specialists/selectAnAddressInput_'+os), address, defaultTime);
	}

	@Keyword
	def tapOnSelectApptDate(date) {
		Mobile.tap(findTestObject('Object Repository/Member/Member Services/Specialists/selectApptDate_android',['date': date]), defaultTime);
	}

	@Keyword
	def tapOnSelectTimeSlot(index) {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/Member/Member Services/Specialists/selectTimeSlot_'+os,['index': index]), defaultTime);
	}

	@Keyword
	def getProcedureName() {
		return Mobile.getText(findTestObject('Object Repository/Member/Appointments/getProcedureName_'+os), defaultTime);
	}

	@Keyword
	def verifyNameInCart(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/verifyNameInCart_'+os), text);
	}

	@Keyword
	def tapOnCheckoutNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/checkoutNowBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnYesBookBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/yesBookBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnOkayBtn(index) {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/okayBtn_'+os), defaultTime);
			tapOnSelectTimeSlot(index);
			tapOnYesBookBtn();
		}
		catch(Exception e){
			println("Btn not there");
		}
	}

	@Keyword
	def tapBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member Services/Specialists/backBtn_android'), defaultTime);
	}

	@Keyword
	def verifySpecialistsScreenTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Services/Specialists/specialistsScreenTitle_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifySpeciality(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Services/Specialists/verifySpeciality_'+os,['name': name]), defaultTime);
	}

	@Keyword
	def verifySpecialityNotExist(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member Services/Specialists/verifySpeciality_'+os,['name': name]), defaultTime);
	}
}
