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
import java.text.SimpleDateFormat
import java.util.Date

import internal.GlobalVariable

public class Upcoming {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnAppointmentsIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/appointmentsIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnUpcomingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/upcomingBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnProviderProfile(provider, time) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/providerProfile_android', ['provider': provider, 'time': time]), defaultTime);
	}

	@Keyword
	def verifyDeliveryNameExistsOnProviderCard(provider, time, deliveryMethod, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/deliveryMethodInUpcoming_android', ['provider': provider, 'time': time, 'deliveryMethod': deliveryMethod]), defaultTime, onFailure);
	}
	@Keyword
	def verifyDeliveryNameNotExistsOnProviderCard(provider, time, deliveryMethod, onFailure =FailureHandling.OPTIONAL, defaultTime = 10) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Upcoming/deliveryMethodInUpcoming_android', ['provider': provider, 'time': time, 'deliveryMethod': deliveryMethod]), defaultTime, onFailure);
	}

	@Keyword
	def verifyProcedureNameExistsOnProviderCard(provider, time, procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/procedureNameInProviderCard_android', ['provider': provider, 'time': time, 'procedureName': procedureName]), defaultTime, onFailure);
	}

	@Keyword
	def verifyVerifiedIconExistsOnProviderCard(provider, time ,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/verifiedIconBesideProviderName_andorid', ['provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def verifyProfileImageExistsOnProviderCard(provider, time, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/avatarIconInProviderCard_android', ['provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def verifyRatingStarExistsOnProviderCard(provider, time, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/ratingStarInProviderCard_android', ['provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def verifyProviderCardWithDateAndTime(date, provider, time, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/providerCardFromDateProviderAndTime_android', ['date': date, 'provider': provider, 'time': time]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnProviderProfileBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/providerProfileBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnProcedureInfoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/procedureInfoBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnUpdateMyEHRBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/updateMyEHRBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnMessageProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/messageProviderBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBottomSheetTitle(text) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Appointments/Upcoming/bottomSheetTitle_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Upcoming/bottomSheetTitle_android'), text,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyBottomSheetTitleExist(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Upcoming/bottomSheetTitle_android'), text,FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyElementTextExist(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/elementText_android', ['text': text]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyElementTextNotExist(text) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Upcoming/elementText_android', ['text': text]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapNeedHelpWithThisApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/needHelpWithThisAppt_android'), defaultTime);
	}
	@Keyword
	def verifyNeedHelpWithThisApptBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/needHelpWithThisAppt_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapMessagePRMBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/messagePRM_android'), defaultTime);
	}

	@Keyword
	def verifyPhotoOfSymptoms(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/photoOfSymptoms_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyYourAppointmentNotesTxt(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Appointments/Upcoming/yourAppointmentsNotesTxt_android'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/yourAppointmentsNotesTxt_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAddBtnOfReasonForThisAppt() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/symptomsAddBtn_android'), defaultTime);
	}
	@Keyword
	def getformatDate(inputDate) {
		Date date = new SimpleDateFormat("d MMMM yyyy").parse(inputDate)
		SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, MMMM d") // Date suffix will be appended later
		return outputFormat.format(date) + getDaySuffix(date) // Appending date suffix
	}
	@Keyword
	def getDaySuffix(Date date) {
		def day = date.getDate()
		def suffix = ""
		switch (day % 100) {
			case 11:
			case 12:
			case 13:
				suffix = "th"
				break
			default:
				switch (day % 10) {
					case 1: suffix = "st"; break
					case 2: suffix = "nd"; break
					case 3: suffix = "rd"; break
					default: suffix = "th"; break
				}
		}
		return suffix
	}
	@Keyword
	def verifyInfoIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/infoIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyProviderElementExistOnProviderCard(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/providerName_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/infoIcon_android'), defaultTime)
	}
	@Keyword
	def verifyAddProcedureSectionWithAddBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Add a Procedure", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/addProcedurewithAddBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAddProcedurewithAddBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/addProcedurewithAddBtn_android'), defaultTime)
	}

	@Keyword
	def verifyTelemedicineCallWithJoinBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/telecallwithJoinBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyHowtoPrepareForTelicallOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/telecallwithJoinBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyScreenTitle(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Receipts/receiptsScreenTitle_android',["text":text]), defaultTime, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/receiptsScreenTitle_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyHowtoPrepareForHouseCallOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/howToPrepareForHouseCallOpt_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyAddSymptomsWithAddBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/addSymptomswithAddBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyHowtoPrepareForLuxeMobileClinicOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/howtoPrepareForMobileClinicOption_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyLocationSectionwithDirectionBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/locationSectionWithDirectionBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyHowtoPrepareForFacilityVisitOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/howToPrepareForFacilityVisit_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnProviderInfoIcon(providerName) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/providerInfo_android',["providerName":providerName]), defaultTime);
	}
	@Keyword
	def tapOnAppointmentCardTitle(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/apptCardTitle_android', ["index":index]), defaultTime);
	}

	@Keyword
	def getApptCardDateTime() {
		return Mobile.getText(findTestObject('Object Repository/Member/Appointments/Upcoming/getApptCardDateTime_android'), defaultTime)
	}
}
