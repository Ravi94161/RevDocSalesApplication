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

public class Empower {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	
	@Keyword
	def verifyIAgreeBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Empower/iAgreeBtn_android'), defaultTime, onFailure);
	}
	
	@Keyword
	def tapIAgreeBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Empower/iAgreeBtn_android'), defaultTime)
	}
	
	@Keyword
	def tapContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Empower/continueBtn_android'), defaultTime)
	}
}
