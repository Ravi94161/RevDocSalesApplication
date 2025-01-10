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

public class SyncApptsToExpternalCalendar {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifysyncToExternalCalendarEnabled(isEnabled = false, defaultTime = 10, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		isEnabled = isEnabled ? 'true' : 'false'
		TestObject syncBtn = findTestObject('Object Repository/Member/Settings/SyncApptsToExternalCalendar/syncToExternalCalendarSwitch_android')
		return Mobile.verifyElementAttributeValue(syncBtn, 'checked', isEnabled, defaultTime, onFailure)
	}

	@Keyword
	def enableSyncToExternalCalendar(enable = false) {
		enable = enable ? true : false
		TestObject syncBtn = findTestObject('Object Repository/Member/Settings/SyncApptsToExternalCalendar/syncToExternalCalendarSwitch_android')
		def isEnabled = verifysyncToExternalCalendarEnabled(true, 5, FailureHandling.OPTIONAL)
		if(enable != isEnabled) {
			Mobile.tap(syncBtn, defaultTime)
		}
	}
}
