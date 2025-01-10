package providerBuildMyProfile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class HippaTraining {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnHipaaTrainingOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/HIPAA Training/hipaaTrainingOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnTakeTheQuizBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/takeTheQuizBtn_android'), defaultTime)
	}

	@Keyword
	def verifyHippaOverviewText() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/hippaOverviewTitle_android'), defaultTime)
	}

	@Keyword
	def tapOnCorrectOption(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/selectOption_android', ['index': index]), defaultTime)
	}

	@Keyword
	def tapOnSubmitAnswerAndNxtBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/submitAnswerBtn_android'), defaultTime)
		Mobile.delay(1)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/correctMsg_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/nextBtn_android'), defaultTime)
		Mobile.delay(2)
	}

	@Keyword
	def verifyHippaTrainingCompletedMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/hippaTrainingCompletedMsg_android'), defaultTime)
	}

	@Keyword
	def tapOnCompleteQuizBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/completeQuizBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/backBtn_android'), defaultTime)
	}

	@Keyword
	def completeHippaQuizOnBuildMyProfileScreen() {
		tapOnHipaaTrainingOption()
		tapOnTakeTheQuizBtn()
		verifyHippaOverviewText()
		tapOnCorrectOption('5')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('5')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('2')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('3')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('2')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('4')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('4')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('3')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('3')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('2')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('4')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCorrectOption('3')
		tapOnSubmitAnswerAndNxtBtn()
		tapOnCompleteQuizBtn()
		verifyHippaTrainingCompletedMsg()
		tapOnBackBtn()
	}
	@Keyword
	def verifyTakeTheQuizIsPresent() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/takeTheQuizBtn_android'), defaultTime)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Hippa Training/takeTheQuizBtn_android'), defaultTime)
	}
}
