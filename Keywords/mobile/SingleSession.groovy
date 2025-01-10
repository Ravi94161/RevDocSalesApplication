package mobile

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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver

public class SingleSession {
	
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()
	def memberPackage = "com.revdoc.member"
	def providerPackage = "com.revdoc.revdoc_provider"
	
	@Keyword
	def installProviderAppWithDriver() {
		driver.installApp(GlobalVariable.providerAppAndroid)
	}
	
	@Keyword
	def installMemberAppWithDriver() {
		driver.installApp(GlobalVariable.memberAppAndroid)
	}
	
	@Keyword
	def activateBackgroundApp(pack) {
		driver.activateApp(pack)
	}
	
	@Keyword
	def terminateApp(pack) {
		driver.terminateApp(pack)
	}
}
