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

public class SetUpProviderProfile {
	String os=GlobalVariable.osName;
	int defaultTime =GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	@Keyword
	def verifySetUpProviderProfileTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/setUpProviderProfileTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSetUpProviderProfile() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/SetupProviderProfile_'+os), defaultTime);
	}
	@Keyword
	def tapOnAddPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/AddPlusBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnMondayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/MondayBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnWeekday(day) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/clickWeekday_'+os,['day':day]), defaultTime);
	}
	@Keyword
	def tapOnStartTimeBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/StartTimeBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnEndTimeBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/EndTimeBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnConformBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/ConformBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnStartSelectHours() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/startSelectHours_'+os), defaultTime);
	}
	@Keyword
	def tapOnStartSelectMin() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/startSelectMinBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnEndSelectHour() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/EndSelectHour_'+os), defaultTime);
	}
	@Keyword
	def tapOnEndSelectMin() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/EndSelectMin_'+os), defaultTime);
	}
	@Keyword
	def tapOnTimeRangeSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/TimeRangeSaveBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnSetUpYourAvailability() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/SetUpYourAvailabilityOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnSaveAndContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/SaveAndContinueBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnEditMondayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/EditMondayBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnEditWeekday(day) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/editWeekday_'+os,['day':day]), defaultTime);
	}
	@Keyword
	def getProviderName() {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/getProviderNameTxt_android'), defaultTime);
	}
	@Keyword
	def getProviderCity() {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/getProviderCity_android'), defaultTime);
	}
}
