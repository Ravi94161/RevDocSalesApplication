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

public class HipaaTraining {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnSetUpProviderProfileOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/setUpProviderProfileOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnHipaaTrainingOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaTrainingOption_'+os), defaultTime)
	}

	@Keyword
	def verifyHipaaPageTitleElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaPageTitle_'+os), defaultTime)
	}

	@Keyword
	def verifyHipaaTrainingCompletedTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaTrainingCompletedText_'+os), defaultTime)
	}

	@Keyword
	def verifyHipaaTrainingRetakeTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaTrainingRetakeText_'+os), defaultTime)
	}

	@Keyword
	def verifyHipaaTrainingRetakeDateElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaTrainingRetakeDate_'+os), defaultTime)
	}

	@Keyword
	def verifyHipaaTrainingScheduleTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaTrainingScheduleText_'+os), defaultTime)
	}

	@Keyword
	def verifySetUpProviderProfileTitleElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/setUpProviderProfileTitle_'+os), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/backBtn_'+os), defaultTime)
	}
	@Keyword
	def verifyBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/backBtn_'+os), defaultTime)
	}
	@Keyword
	def tapOnPlayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/videoPlayerBtn_'+os), defaultTime)
	}
}
