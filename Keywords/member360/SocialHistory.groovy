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
import mobile.Generic

public class SocialHistory {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen=new Generic();
	Demographics dem=new Demographics();

	@Keyword
	def tapOnSocialHistoryOption() {
		tapOnExpandAllBtn();
		Mobile.scrollToText("Social History", FailureHandling.OPTIONAL)
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/socialHistoryOption_'+os), defaultTime);
	}
	
	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}
	
	@Keyword
	def tapOnSocialHistoryOptionAfterExpand() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/socialHistoryBtnAftrExpnd_andriod'), defaultTime);
	}

	@Keyword
	def verifyEditBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/editBtn_'+os)
		Mobile.waitForElementPresent(testObject, defaultTime, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(testObject, defaultTime, onFailure);
	}
	
	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/editBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyTitleText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/verifyTitleText_'+os,['title':text]), defaultTime);
	}

	@Keyword
	def verifyOptionText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/verifyOptionText_'+os,['title':text]), defaultTime);
	}
	@Keyword
	def tapOnEveryDaySmokerRadioBtn() {
		Mobile.scrollToText("Tobacco Smoking Status", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/everyDaySmokerRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSocialHistoryOptionsRadioBtn(title, option) {
		Mobile.scrollToText(title, FailureHandling.OPTIONAL)
		if(title == "Medical Marijuana Intake") {
			gen.swipeUp();
		}
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Tobacco Smoking Status/someDaySmokerRdBtn_android',['title':title, 'option':option]), defaultTime);
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Tobacco Smoking Status/someDaySmokerRdBtn_android',['title':title, 'option':option]), defaultTime);
	}
	
	@Keyword
	def verifyradioBtnSelected(radioOption, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/radioBtnSelected_android', ['radioOption': radioOption]), defaultTime, onFailure);
	}
	
	@Keyword
	def tapOnAlcoholInTakeNoneRadioBtn() {
		Mobile.scrollToText("Alcohol Intake", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/alcoholIntakeNoneRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnOneDrinkperDayRadioBtn() {
		Mobile.scrollToText("Alcohol Intake", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Alcohol Intake/oneDrinkPerDayRdBtn_android'), defaultTime);
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Alcohol Intake/oneDrinkPerDayRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnExerciseFqSeveralTimesRdBtn() {
		Mobile.scrollToText("Exercise Frequency", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Exercise Frequency/severalTimesInaDayRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnExerciseFqOnceADayRdBtn() {
		Mobile.scrollToText("Exercise Frequency", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Exercise Frequency/onceADayRdBtn_android'), defaultTime);
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Exercise Frequency/onceADayRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnMedicalIntakeOptOnceADayRdBtn() {
		Mobile.scrollToText("Medical Marijuana Intake", FailureHandling.OPTIONAL)
		gen.swipeUp();
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Medical Marijuana Intake/onceAdayRdBtn_android'), defaultTime);
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Medical Marijuana Intake/onceAdayRdBtn_android'), defaultTime);
	}
	@Keyword
	def verifyTitleAndOptionTxt(title, option, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/Tobacco Smoking Status/verifyTitleAndOptionTxt_android',['option':option, "title":title]), defaultTime, onFailure);
	}
	@Keyword
	def fillDetailsInSocialHistoryScreen(title1,option1,title2,option2,title3,option3,title4,option4) {
		tapOnSocialHistoryOptionsRadioBtn(title1,option1)
		tapOnSocialHistoryOptionsRadioBtn(title2,option2)
		tapOnSocialHistoryOptionsRadioBtn(title3,option3)
		tapOnSocialHistoryOptionsRadioBtn(title4,option4)
		dem.tapOnNextBtn();
	}

	@Keyword
	def verifyOptions(title, option, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/verifyOption_andriod',['title': title, "option": option]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnOption(title, option, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/verifyOption_andriod',['title': title, "option": option]), defaultTime, onFailure)
	}

	@Keyword
	def verifyRequiredValidation(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/verifyValidation_andriod', ['title': title]), defaultTime, onFailure)
	}
}
