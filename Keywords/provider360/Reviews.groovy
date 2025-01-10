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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.nativekey.AndroidKey

public class Reviews {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def tapOnReviewsBtn(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Reviews/reviewsBtn_android'), defaultTime);
	}
	
	@Keyword
	def verifyProviderRatingsOnReviewPage(provider, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Reviews/starRatingInReviewsPage_android', ['provider': provider, 'index': index]), defaultTime)
	}
}
