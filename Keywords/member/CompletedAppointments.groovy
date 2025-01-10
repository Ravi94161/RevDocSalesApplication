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
import mobile.MobileActions

public class CompletedAppointments {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE;

	MobileActions ma = new MobileActions();

	@Keyword
	def tapOnCancelledApptProvider(providerName) {
		Mobile.scrollToText(providerName, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/completed/cancelledApptProvider_android',["providerName":providerName]), defaultTime);
	}

	@Keyword
	def verifyApptCanceledOnProviderCard(provider, time, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		println("//android.widget.TextView[contains(@text,'${date}')]/../android.widget.TextView[contains(@text, '${provider}')]/../android.widget.TextView[contains(@text, '${time}')]/..//android.widget.TextView[@text ='Appointment Cancelled']")
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/completed/apptCancelled_android', ['date': date, 'provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def verifyApptCanceledOnProviderCardNotExist(provider, time, date, onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		println("//android.widget.TextView[contains(@text,'${date}')]/../android.widget.TextView[contains(@text, '${provider}')]/../android.widget.TextView[contains(@text, '${time}')]/..//android.widget.TextView[@text ='Appointment Cancelled']")
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/completed/apptCancelled_android', ['date': date, 'provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def tapApptCanceledOnProviderCard(provider, time, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/apptCancelled_android', ['date': date, 'provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnOnProviderCard(provider, time, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/appttimeOnCard_android', ['date': date, 'provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def verifyAppointmentCancelledBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(3)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/completed/appointmentCancelledBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyMsgProviderDisabled(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/completed/disabledMsgProviderOption_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMsgProviderNotDisabled(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/myCarePage_android/completed/disabledMsgProviderOption_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyaddProcedureBtnDisabled(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/myCarePage_android/completed/disabledAddProcedureBtn_android'), defaultTime, onFailure)
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/completed/disabledAddProcedureBtn_android'),defaultTime, onFailure)
	}
	@Keyword
	def verifyaddAddSymtomsBtnDisabled(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/completed/disabledAddSymtomsBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/backBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBottomSheetTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/completed/bottomSheetTitle_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/completed/bottomSheetTitle_android'), text, onFailure)
	}

	@Keyword
	def verifyElementText(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/completed/elementText_android', ['text': text]), defaultTime, OnFailure)
	}

	@Keyword
	def tapOkayBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/okayBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyOkayBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/okayBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapApptCancelledBtnInProviderProfile(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/apptCancelledBtnInProviderProfile_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnYesterdayAppoinment(date) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/completed/yesterdayAppoinment_andriod', ['date': date]), defaultTime)
	}
	@Keyword
	def verifyYesterdayAppoinmentNotExist(date) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/myCarePage_android/completed/yesterdayAppoinment_andriod', ['date': date]), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyNeedHelpWiththisappoinmentBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/myCarePage_android/completed/needHelpWithThisAppoinment_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyNeedHelpWiththisappoinmentBtnNotExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/myCarePage_android/completed/needHelpWithThisAppoinment_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnReBookBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/rebookBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnFacilityReBookBtn(index=1) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/completed/facilityRebookBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnOnRebookBtnByProvider(date, providerName, time, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime, iterations = 15) {
		TestObject obj = findTestObject('Object Repository/Member/myCarePage_android/completed/providerRebookBtn_android', ['date': date, 'providerName': providerName, 'time': time])
		ma.scrollUntilElementIsVisible(obj, iterations)
		Mobile.tap(obj, defaultTime, onFailure);
	}

	@Keyword
	def tapOnReBookBtn(String providerProfileName) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/rebook', ['providerProfileName': providerProfileName]), defaultTime);
		Mobile.delay(5)
	}

	@Keyword
	def tapOnReBookBtnByIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/rebookBtn_android', ['index': index]), defaultTime);
		Mobile.delay(5)
	}

	@Keyword
	def tapOnProviderInfoIcon(provider, time, date) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completed/providerInfoIcon_andriod',['date': date, 'provider': provider, 'time': time]), defaultTime)
	}
	@Keyword
	def verifyProviderDetails(provider, time, date, text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/completed/providerDetails_andriod',['date': date, 'provider': provider, 'time': time, 'text': text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyTelemedicineAppoinmentByDateAndProviderName(providerName, date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject testObject = findTestObject('Object Repository/Member/Appointments/completed/verifyTeleMedicineApptBYDateAndProviderName_andriod', ["providerName": providerName, "date": date])
		ma.scrollUntilElementIsVisible(testObject, 75)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/completed/verifyTeleMedicineApptBYDateAndProviderName_andriod', ["providerName": providerName, "date": date]), defaultTime, onFailure)
	}
}

