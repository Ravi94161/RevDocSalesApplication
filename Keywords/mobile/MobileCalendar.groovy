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

import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

public class MobileCalendar {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE

	MobileActions ma = new MobileActions()
	@Keyword
	def launchCalendar() {
		Mobile.pressHome()
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.activateApp('com.samsung.android.calendar')
		Mobile.delay(5)
	}

	@Keyword
	def tapOnDayInCalendar(date) {
		//date in format 2024-10-10
		Mobile.tap(findTestObject('Object Repository/Member/Mobile/Calendar/dayinCalendar_android', ['date': date]), defaultTime)
	}

	@Keyword
	def getCalendarEventTime() {
		Mobile.getText(findTestObject('Object Repository/Member/Mobile/Calendar/calendarEventTime_android'), defaultTime, onFailure)
	}

	@Keyword
	def getCalendarEventTitle() {
		Mobile.getText(findTestObject('Object Repository/Member/Mobile/Calendar/calendarEventTitle_android'), defaultTime, onFailure)
	}

	@Keyword
	def verfyCalendarEventTitle(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def text = getCalendarEventTitle()
		ma.verifyEqual(text.trim(), title.trim(), onFailure)
	}

	@Keyword
	def verfyCalendarEventNotAdd(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def text = getCalendarEventTitle()
		ma.verifyNotEqual(text.trim(), title.trim(), onFailure)
	}
	
	@Keyword
	def verifyCalendarEventNotAdd(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def text = getCalendarEventTitle()
		ma.verifyNotEqual(text.trim(), title.trim(), onFailure)
	}

	@Keyword
	def verfyCalendarEventTime(timeRanze, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		timeRanze = timeRanze.toUpperCase()
		def text = getCalendarEventTime()
		ma.verifyEqual(text.trim(), timeRanze.trim(), onFailure)
	}

	@Keyword
	def verfyCalendarEventTitlePresent(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def text = getCalendarEventTitle()
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Mobile/Calendar/verifyCalendarEventTitle_android',['eventTitle': title]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verfyCalendarEventTimePresent(timeRanze, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		timeRanze = timeRanze.toUpperCase()
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Mobile/Calendar/verifyCalendarEventTime_android',['timeRange': timeRanze]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
}
