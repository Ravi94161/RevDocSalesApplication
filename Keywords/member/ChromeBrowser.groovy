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

import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
public class ChromeBrowser {
	
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE
	
	@Keyword
	def tapOnSearchBar() {
		Mobile.tap(findTestObject('Object Repository/Member/Chrome/searchBar_android'), defaultTime);
	}
	
	@Keyword
	def typeInSearchBoxInput(deepLink) {
		Mobile.setText(findTestObject('Object Repository/Member/Chrome/searchBoxInput_android'), deepLink, defaultTime);
	}
	
	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Chrome/continueBtn_android'), defaultTime);
	}
	
	@Keyword
	def tapOnEnterBtn() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	@Keyword
	def openChromeApplication() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.activateApp('com.android.chrome')
	}
	
	
	@Keyword
	def enterDeeplinkinChromeandNavigateToMemberApp(link, clickOnContinue = true) {
		openChromeApplication()
		tapOnSearchBar()
		typeInSearchBoxInput(link)
		tapOnEnterBtn()
		clickOnContinue ? tapOnContinueBtn() : null;
		Mobile.delay(10)
	}
}
