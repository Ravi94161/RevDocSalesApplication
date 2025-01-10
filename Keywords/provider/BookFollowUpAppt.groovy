package provider

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
import member.AllAvailabilities
import mobile.Generic
import mobile.MobileActions

public class BookFollowUpAppt {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions ma = new MobileActions();
	AllAvailabilities availabilities = new AllAvailabilities();
	Generic gen = new Generic()
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE;

	// -------------- Start Book Follow up Appt Btn-------------
	@Keyword
	def verifyBookFollowUpBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/bookFollowUpBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnBookFollowUpBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/bookFollowUpBtn_android'), defaultTime)
	}

	// -------------- End Book Follow up Appt Btn-------------

	// -------------- Start Book Follow up Appt popup-------------

	@Keyword
	def verifyCloseBtnExists(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/closeBtn_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseBtn(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/closeBtn_android', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCalederOrangeIconExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/calendarOrangeIcon'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyNoBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/noBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyYesBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/yesBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyFollowUpApptPopup() {
		ma.verifyElementPresentByText("Follow Up Appointment", FailureHandling.STOP_ON_FAILURE, defaultTime)
		verifyCloseBtnExists()
		verifyCalederOrangeIconExists()
		ma.verifyElementPresentByText("Would you like to schedule a follow up appointment with this patient?", FailureHandling.CONTINUE_ON_FAILURE, defaultTime)
		ma.verifyElementPresentByText("This appointment will be available at no cost to the patient.", FailureHandling.STOP_ON_FAILURE, defaultTime)
		verifyNoBtnExists()
		verifyYesBtnExists()
	}

	@Keyword
	def tapOnNoBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/noBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnYesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/FollowUpApptPopup/yesBtn_android'), defaultTime)
	}
	// -------------- End Book Follow up Appt popup-------------

	@Keyword
	def deliveryMethods() {
		def houseCall = "House Call"
		def teleMedicine = "Telemedicine Call"
		def vanCall = "Luxe Mobile Clinic"
		def facilityCash = "Cash"
		def facilityInsurance = "Insurance"

		return [houseCall: houseCall, telemedicine: teleMedicine, vanCall: vanCall, facilityCash: facilityCash, facilityInsurance: facilityInsurance]
	}

	@Keyword
	def selectSlot(deliveryType, index) {
		Mobile.scrollToText(deliveryType, FailureHandling.OPTIONAL);
		gen.swipeUpLittle()
		def slotTime, slotPrice;
		if (deliveryType.toLowerCase() == "cash" || deliveryType.toLowerCase() == "insurance") {
			gen.swipeUpLittle()
			slotTime = getFaciltiySlotTime(deliveryType, index, defaultTime = defaultTime)
			slotPrice = getFaciltiySlotPrice(deliveryType, index, defaultTime = defaultTime)
			tapFaciltiySlotTime(deliveryType, index, defaultTime = defaultTime)
		} else if(deliveryType.toLowerCase() == "house call" || deliveryType.toLowerCase() == "telemedicine call" || deliveryType.toLowerCase() == "luxe mobile clinic") {
			slotTime = availabilities.getSlotTimeByIndex(deliveryType, index)
			slotPrice = availabilities.getRevOneSlotUsdByDMIndex(deliveryType, index)
			availabilities.tapOnSlotTimeByDMIndex(deliveryType, index)
		} else {
			println("Plese use the deliveryMethods methods variables")
		}

		return [slotTime: slotTime, slotPrice: slotPrice]
	}

	@Keyword
	def getFaciltiySlotTime(facilityType, index, defaultTime = defaultTime) {
		// here facilityType = 'Insurance' | 'Cash
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/FacilityVisitAppt/facilityVisitSlotTime', ['facilityType': facilityType.toLowerCase(), 'index': index]), defaultTime)
	}

	@Keyword
	def tapFaciltiySlotTime(facilityType, index, defaultTime = defaultTime) {
		// here facilityType = 'Insurance' | 'Cash
		return Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/FacilityVisitAppt/facilityVisitSlotTime', ['facilityType': facilityType.toLowerCase(), 'index': index]), defaultTime)
	}

	@Keyword
	def getFaciltiySlotPrice(facilityType, index, defaultTime = defaultTime) {
		// here facilityType = 'Insurance' | 'Cash
		return Mobile.getText(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/FacilityVisitAppt/facilityVisitPrice', ['facilityType': facilityType.toLowerCase(), 'index': index]), defaultTime)
	}

	@Keyword
	def bookFollowUpAppt(deliveryMethodName, slotIndex = 1) {
		tapOnBookFollowUpBtn()
		tapOnYesBtn()
		Mobile.delay(5)
		def selectedSlotDate = availabilities.getSelectedSlotDate();
		def slotDetails = selectSlot(deliveryMethodName, slotIndex)
		def confirmApptDetails = getConfirmApptDetails()

		tapOnYesBookBtn()
		tapOnOkayBtn()

		return [selectedSlotDate: selectedSlotDate, slotDetails: slotDetails, confirmApptDetails: confirmApptDetails]
	}

	// -------------- Start Confirm Appt popup-------------

	@Keyword
	def getTotalpriceOnConfirmAppt() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/totalPrice_android'), defaultTime, FailureHandling.OPTIONAL)) {
			return  Mobile.getText(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/totalPrice_android'), defaultTime, onFailure);
		}
		else {
			return null;
		}
	}

	@Keyword
	def getConfirmApptDetails( ) {
		def procedureName = availabilities.getConfirmApptProcedureNameText();
		def providerName = availabilities.getConfirmApptproviderNameAndTitleText();
		def dateTime = availabilities.getConfirmApptstartDateAndTimeText();
		def deliveryMethodName = availabilities.getConfirmDeliveryMethodNameText();
		def apptAddress =  availabilities.getConfirmAppoinmentAddress();
		def total = getTotalpriceOnConfirmAppt();

		return [procedureName: procedureName, providerName: providerName, dateTime: dateTime, deliveryMethodName: deliveryMethodName, total: total, apptAddress: apptAddress]
	}

	@Keyword
	def tapOnYesBookBtn() {
		availabilities.tapYesBookBtn();
	}
	// -------------- End Confirm Appt popup-------------

	// -------------- Start Follow Up Scheduled popup-------------
	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/FollowUpScheduledPopup/okayBtn'), defaultTime)
	}

	@Keyword
	def verifyOkayBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/FollowUpScheduledPopup/okayBtn'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyFollowUpScheduledPopup() {
		ma.verifyElementPresentByText("Follow Up Scheduled", FailureHandling.STOP_ON_FAILURE, defaultTime)
		//		verifyCloseBtnExists()
		verifyOkayBtnExists();
		ma.verifyElementPresentByText("Thank you, the follow up appointment has been booked.", FailureHandling.STOP_ON_FAILURE, defaultTime)
	}
	@Keyword
	def slectSlotByName(deliveryMethodName) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/MemberDetails/BookFollowUp/AllAvailabilities/selectSlot_android', ['deliveryMethodName': deliveryMethodName]), defaultTime)
	}

	// -------------- End Follow Up Scheduled popup-------------
}
