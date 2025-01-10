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

public class PreviewProviderProfile {
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnPreviewProviderProfile(){
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Preview Provider Profile/previewProviderProfile_andriod'), defaultTime)
	}

	@Keyword
	def tapOnWorkHistory() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Preview Provider Profile/workHistory_andriod'), defaultTime)
	}

	@Keyword
	def verifyWorkHistoryVerifiedBadge(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Preview Provider Profile/workHistoryVerifiedbadge_andriod'), defaultTime, onFailure)
	}
	
	@Keyword
	def getFollowersCount() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Preview Provider Profile/getFollowersCount_android'), defaultTime)
	}
}
