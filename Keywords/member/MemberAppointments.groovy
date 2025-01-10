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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

import internal.GlobalVariable
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import mobile.Generic
import mobile.MobileActions


public class MemberAppointments {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	ThankYou thank = new ThankYou();
	Checkout checkOut = new Checkout();
	Generic gen = new Generic();
	MobileActions ma = new MobileActions();

	@Keyword
	def tapOnSearchResult(text, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_android', ['text':text, 'index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchResult(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_'+os, ['text':text]), defaultTime, onFailure);
	}

	@Keyword
	def getMemberAgeText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/getMemberAgeText_android'), defaultTime);
	}

	@Keyword
	def verifyLicenseAvailabilityNotExpired(date) {
		Date inputDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(date)
		// Get the current date and time
		Date currentDate = new Date()
		// Compare the dates
		if (inputDate.after(currentDate)) {
			println("License Not Expired")
		} else {
			println("License Expired")
		}
	}

	@Keyword
	def tapOnSelectAppointmentDate(text,appt) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/selectAppointmentDate_'+os, ['text':text, 'appt':appt]), defaultTime);
	}

	@Keyword
	def getAppointmentDate(text,appt) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/getAppointmentDate_android', ['text':text, 'appt':appt]), defaultTime);
	}

	@Keyword
	def tapOnSelectTimeSlot(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/getCostOfTimeSlotText_'+os, ['index': index]), defaultTime);
	}

	@Keyword
	def getTimeSlotText() {
		try {
			return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/getTimeSlotText_'+os), defaultTime);
		}
		catch (Exception e){
			Date currentDate = new Date()
			Calendar calendar = Calendar.getInstance()
			calendar.time = currentDate
			calendar.add(Calendar.DAY_OF_MONTH, 1)
			Date nextDate = calendar.time
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd")
			String formattedNextDate = dateFormat.format(nextDate)

			println("Tomorrow's Date: " + formattedNextDate)


			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/selectNextDay_'+os, ['date': formattedNextDate]), defaultTime);
			return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/getTimeSlotText_'+os), defaultTime);
		}
	}

	@Keyword
	def getCostOfTimeSlotText(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/getCostOfTimeSlotText_android', ['index': index]), defaultTime);
	}

	@Keyword
	def getConfirmApptUSD() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/confirmApptUSD_'+os), defaultTime);
	}

	@Keyword
	def getItemPriceLabelDisplayExpAmt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/itemPriceLabelDisplayExpAmt_'+os), defaultTime);
	}

	@Keyword
	def verifySubTotalPriceTextExist(price, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/subTotalPriceText_'+os, ["price": price, "index": index]), defaultTime);
	}

	@Keyword
	def verifyItemPriceLabelElementText(index,price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/MemberAppointments/itemPriceLabel_'+os, ["index": index]), price);
	}

	@Keyword
	def verifyPayBtnPriceTextExist(price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/payBtnPriceText_'+os, ["price": price]), defaultTime);
	}

	@Keyword
	def tapOnYesBookBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/yesBookBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnCheckoutNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/checkoutNowBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnProceedToCheckoutBtn() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/proceedToCheckoutBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCheckoutTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/checkoutText_'+os), defaultTime);
	}

	@Keyword
	def verifyOrderSummaryTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/orderSummaryText_'+os), defaultTime);
	}

	@Keyword
	def verifySaveForLaterBtnElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/saveForLaterBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyPlaceOrderBtnElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/placeOrderBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/removeBtn_android'), defaultTime);
	}

	@Keyword
	def verifyRemoveConfirmationText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/removeConfirmationText_'+os, ['text':text]), defaultTime);
	}

	@Keyword
	def tapOnNoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/noBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnYesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/yesBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveForLaterBtnProceedToCheckout() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/saveForLaterBtnProceedToCheckout_'+os), defaultTime);
	}

	@Keyword
	def tapOnMoveToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/moveToCartBtn_'+os), defaultTime);
	}

	@Keyword
	def verifySaveForLaterConfirmationText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/saveForLaterConfirmationText_'+os,['text':text]), defaultTime);
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/closeBtn_android'), defaultTime);
	}
	@Keyword
	def verifyCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCloseBtnSaveForLater() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/closeBtnSaveForLater_'+os), defaultTime);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/backBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnPlaceOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/placeOrderBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyPurchaseConfirmationText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/purchaseConfirmationText_'+os, ['text':text]), defaultTime);
	}

	@Keyword
	def verifyOrderSummaryConfirmationText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/orderSummaryConfirmationText_'+os), defaultTime);
	}

	@Keyword
	def tapOnContinueToHealthRecordsBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/continueToHealthRecordsBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAppointmentsIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/appointmentsIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnAddCardBtn() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/addCardBtn_'+os), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/addCardBtn_'+os), defaultTime);
		}
	}

	@Keyword
	def tapOnUpcomingBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/upcomingBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnPayBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/singlePayBtn_'+os), defaultTime);
	}

	@Keyword
	def getPriceOnPayBtn() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/payBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyCountryAndUpdateZipCode(zip) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/verifyCountryInPaymentSheet_android', ['country': "United Kingdom"]), 20, FailureHandling.OPTIONAL)) {
			zip = "ABCDEF"
		}
		return zip
	}

	@Keyword
	def fillPaymentDetails(cardNum, expDate, cvv, zip) {
		tapOnAddCardBtn();
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cardNumberInputBx_android'), cardNum, defaultTime);
		Mobile.hideKeyboard();
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/exipreDateInputBx_android'), expDate, defaultTime);
		Mobile.hideKeyboard();
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cvvInputBx_android'), cvv, defaultTime);
		Mobile.hideKeyboard();
		zip = verifyCountryAndUpdateZipCode(zip)
		try {
			Mobile.setText(findTestObject('Object Repository/Provider/Registration/Credit Card Details/zipCodeInputBx_android'), zip, defaultTime);
		}
		catch(Exception e) {
			Mobile.setText(findTestObject('Member/Member360/MemberAppointments/postCodeInput_android'), zip, defaultTime, FailureHandling.OPTIONAL);
		}
		Mobile.hideKeyboard();
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/payBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAtHomeLabsPayBtn() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/payBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnPlaceOrderAndCompletePayment(cardNum = "4111111111111111", expDate = "02/26", cvv = "111", zip = "30002") {
		gen.swipeUp();
		def totalCartPrice = checkOut.getTotalPriceUnderPaymentSummary("Order Total");
		println("totalCartPrice": totalCartPrice)
		def totalCartPriceWithoutDollar = Double.parseDouble(totalCartPrice.replaceAll("[^\\d.]", ""));
		tapOnPlaceOrderBtn();
		if(totalCartPriceWithoutDollar >  0 || ma.verifyElementPresentByText("Card", onFailure = FailureHandling.OPTIONAL) || Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cardNumberInputBx_android'), 10, FailureHandling.OPTIONAL)) {
			fillPaymentDetails(cardNum, expDate, cvv, zip);
			Mobile.hideKeyboard();
		}
	}

	@Keyword
	def tapOnPlaceOrderAndCompletePaymentAndThankYouScreen(cardNum, expDate, cvv, zip) {
		tapOnPlaceOrderAndCompletePayment(cardNum, expDate, cvv, zip)
		thank.verifyThankYouForYourPurchaseText();
		thank.tapOnContinueToHealthRecordsBtn();
		thank.tapRemindMeLaterOrNoChangesButton();
	}

	@Keyword
	def tapOnCartIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/cartIcon_'+os), defaultTime);
	}

	@Keyword
	def tapOnRemoveBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnHomeIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_'+os), defaultTime);
	}

	@Keyword
	def verifyHomeIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_'+os), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def getItemCountElementCount() {
		def elements = Mobile.findElements(findTestObject('Object Repository/Member/Cart/itemCount_'+os), defaultTime);
		int count = elements.size();
		println("Number of elements matching the XPath: ${count}")

	}

	@Keyword
	def removeItemsFromCart() {
		tapOnCartIcon();
		for (int c = 1;c <= 3; c++) {
			try {
				tapOnRemoveBtn(1);
				tapOnYesBtn();
			}
			catch(Exception e){
				println("Items not there");
			}
		}

		tapOnHomeIcon();
	}

	@Keyword
	def tapOnProfileIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime);
	}

	@Keyword
	def verifyProfileIconElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def getProfileNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/getProfileNameText_'+os), defaultTime);
	}

	@Keyword
	def tapOnTeliMedicineAppointments() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/teliMedicineCallFirstAppt_'+os), defaultTime);
	}
	@Keyword
	def tapOnContinueShoppingBtn() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/continueShoppingBtn_android'), defaultTime);
	}

	@Keyword
	def getConfirmApptProcedureNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/confirmApptProcedureName_'+os), defaultTime);
	}

	@Keyword
	def getConfirmApptproviderNameAndTitleText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/confirmApptproviderNameAndTitle_'+os), defaultTime);
	}

	@Keyword
	def getConfirmApptstartDateAndTimeText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/confirmApptstartDateAndTime_'+os), defaultTime);
	}

	@Keyword
	def getConfirmDeliveryMethodNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/confirmDeliveryMethodName_'+os), defaultTime);
	}

	@Keyword
	def verifyProviderNameElementExist(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/providerName_'+os, ['name': name]), defaultTime);
	}

	@Keyword
	def tapOnProviderProfile(provider, time, iterations = 95) {
		TestObject obj = findTestObject('Object Repository/Member/Appointments/providerProfile_android', ['provider': provider, 'time': time])
		ma.scrollUntilElementIsVisible(obj, iterations)
		Mobile.tap(obj, defaultTime);
	}
	@Keyword
	def verifyProcedureNameElementExist(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/procedureName_'+os, ['procedure': name]), defaultTime);
	}

	@Keyword
	def verifyDeliveryMethodNameElementExist(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/deliveryMethodName_'+os, ['dmName': name]), defaultTime);
	}

	@Keyword
	def verifyApptDateAndTimeExist(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/apptDateAndTime_android', ['dateTime': name]), defaultTime);
	}

	@Keyword
	def verifyProviderVerificationBadgeElementExist(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/providerVerificationBadge_'+os, ['name': name]), defaultTime);
	}

	@Keyword
	def verifyProviderProfilePicElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/providerProfilePic_'+os), defaultTime);
	}

	@Keyword
	def verifyDeliveryMethodIconElementExist(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/deliveryMethodIcon_'+os, ['dmName': name]), defaultTime);
	}

	@Keyword
	def tapOnDoneBtn() {
		Mobile.delay(5)
		if(Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), 10, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		}
		else if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), 10, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		}
		//		try {
		//			Mobile.tap(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		//		}
		//		catch(Exception e) {
		//			Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		//		}

	}

	@Keyword
	def tapOnDoneBtnOptional() {
		Mobile.delay(5)
		if(Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), 10, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), defaultTime, FailureHandling.OPTIONAL)
		}
		else if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), 10, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), defaultTime, FailureHandling.OPTIONAL)
		}
		//		Mobile.delay(5)
		//		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnOkayBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/okayBtn_'+os), defaultTime);
			tapOnSelectTimeSlot(2);
			tapOnYesBookBtn();
		}
		catch(Exception e){
			println("Btn not there");
		}
	}

	@Keyword
	def tapOnCalendarIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/calendarIcon_android'), defaultTime);
	}

	@Keyword
	def verifyMemberProfileNameText(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberProfileName_'+os, ['name': name]), defaultTime);
	}

	@Keyword
	def verifyElementText(element) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/verifyElement_'+os, ['element': element]), defaultTime);
	}

	@Keyword
	def verifyMemberTimeSlotTextElementExist(slotTime, time) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/memberTimeSlotText_'+os, ['slotTime': slotTime, 'time': time]), defaultTime);
	}
	@Keyword
	def getTeleMedicineTimeSlotText(index) {
		Mobile.scrollToText("Telemedicine Call Appointments", FailureHandling.OPTIONAL);
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/getTeleTimeSlotText_android',["index":index]), defaultTime);
	}
	@Keyword
	def getTeleCostOfTimeSlotText(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/MemberAppointments/getTeleCostOfTimeSlotText_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnSelectTeleMedicineTimeSlot(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/selectTeleTimeSlot_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnBookedAppointment(time) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/bookedTeleAppot_'+os, ['time': time]), defaultTime);
	}
	@Keyword
	def verifyProviderProfileOption() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/providerProfileOption_android'), defaultTime);
	}
	@Keyword
	def verifyProcedureInfoOption() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/procedureInfoOption_android'), defaultTime);
	}
	@Keyword
	def tapProcedureInfoOption() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/procedureInfoOption_android'), defaultTime);
	}
	@Keyword
	def verifyUpdateMyEHROption() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/updateMyEHROption_android'), defaultTime);
	}
	@Keyword
	def tapOnUpdateMyEHROption() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/updateMyEHROption_android'), defaultTime);
	}
	@Keyword
	def verifyMessageProiderOption() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/messageProviderOption_android'), defaultTime);
	}
	@Keyword
	def tapOnMessageProiderOption() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/messageProviderOption_android'), defaultTime);
	}
	@Keyword
	def verifyAddSymtomsTxt() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/addSymtomstxt_android'), defaultTime);
	}
	@Keyword
	def verifyJoinTeleMedicineCallTxt() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/joinTelemedicineCallTxt_android'), defaultTime);
	}
	@Keyword
	def verifyAddProcedureTxt() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/addProcedureTxt_android'), defaultTime);
	}
	@Keyword
	def verifyCodeVerificationTxt() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/codeVerificationTxt_android'), defaultTime);
	}
	@Keyword
	def verifyNeedHelpWithThisAppointmentbtn() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/needHelpButton_android'), defaultTime);
	}
	@Keyword
	def tapOnNeedHelpWithThisAppointmentbtn() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/needHelpButton_android'), defaultTime);
	}
	@Keyword
	def verifyjoinBtn() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/joinBtn_android'), defaultTime);
	}
	@Keyword
	def verifyEditGreyIcon() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/editGreyIcon_android'), defaultTime);
	}
	@Keyword
	def verifyBookedFacilityAppointmentNotExist(index,time) {
		Mobile.delay(15);
		Mobile.verifyElementNotExist(findTestObject('Member/Member360/MemberAppointments/bookedFacilityAppt_android',["index":index,"time":time]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnRemindMeLaterBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/remindMeLaterBtn_'+os), defaultTime);
		}catch (Exception e) {
			println("button not found")
		}
	}

	@Keyword
	def tapOnAlertIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/alertIcon_'+os), defaultTime);
	}

	@Keyword
	def tapOnProviderChatOption(name) {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/providerChatOption_'+os, ['firstName': name]), defaultTime);
	}

	@Keyword
	def verifyAppointmentCancelledElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/appointmentCancelled_'+os), defaultTime);
	}

	@Keyword
	def verifyCancelApptMsg(msg) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Alerts/cancelApptMsg_'+os, ['msg': msg]), defaultTime);
	}

	@Keyword
	def tapOnAppointmentCancelled() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/appointmentCancelled_'+os), defaultTime);
	}

	@Keyword
	def verifyApptCancelledMsg(msg) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/apptCancelledMsg_'+os, ['msg': msg]), defaultTime);
	}

	@Keyword
	def tapOnCompletedOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/completedOption_'+os), defaultTime);
		Mobile.delay(15);
	}

	@Keyword
	def tapOnRebookByDeliveryMethod(delivery) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/completed/rebookBtnByDeliveryMethod_'+os,['delivery':delivery]), defaultTime);
		Mobile.delay(10);
	}

	@Keyword
	def tapOnBackBtnInAppt() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/backBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnReceiptsIcon() {
		Mobile.scrollToText("Receipts", FailureHandling.OPTIONAL)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Receipts/receiptsIcon_'+os), defaultTime, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/receiptsIcon_'+os), defaultTime);
	}

	@Keyword
	def tapOnChevronRightBtn(onFailure =FailureHandling.OPTIONAL) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/chevronRightBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyItemPriceStrike(dateTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/itemPriceStrike_'+os, ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def tapOnAppointmentCancelledBtn(dateTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/appointmentCancelledBtn_android', ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def tapOnBackBtnReceipts() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/backBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnEditApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/editApptBtn_'+os), defaultTime);
	}


	@Keyword
	def tapOnCancelApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/cancelApptBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyCancelApptBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/cancelApptBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnKeepApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/keepApptBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyKeepApptBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/keepApptBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCancelApptBtnPopup() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/cancelApptBtnPopup_'+os), defaultTime);
	}
	@Keyword
	def verifyCancelApptBtnOnPopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/cancelApptBtnPopup_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyApptTitleElementExist(text,index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/verifyApptTitle_'+os, ['text': text, 'index': index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnDoneApptBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/doneBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyDoneApptBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/doneBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyAppointmentCancelledTagElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/appointmentCancelledTag_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyAppointmentCancelledTagReceiptsElementExist(dateTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/appointmentCancelledTag_android', ['dateTime': dateTime]), defaultTime, onFailure);
	}

	@Keyword
	def verifyTimeSlotTextElementExist(time) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/verifyTimeSlotText_'+os, ['time': time]), defaultTime, onFailure);
	}

	def getSpecificTimeSlotText(cash,deliveryMethod) {
		try {
			return Mobile.getText(findTestObject('Member/Member360/MemberAppointments/getSpecificTimeSlot_android',["value":cash,"deliveryMethod":deliveryMethod]), defaultTime);
		}
		catch (Exception e){
			Date currentDate = new Date()
			Calendar calendar = Calendar.getInstance()
			calendar.time = currentDate
			calendar.add(Calendar.DAY_OF_MONTH, 1)
			Date nextDate = calendar.time
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd")
			String formattedNextDate = dateFormat.format(nextDate)

			println("Tomorrow's Date: " + formattedNextDate)

			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/selectNextDay_'+os, ['date': formattedNextDate]), defaultTime);
			return Mobile.getText(findTestObject('Member/Member360/MemberAppointments/getSpecificTimeSlot_android',["value":cash, "deliveryMethod":deliveryMethod]), defaultTime);

		}
	}
	@Keyword
	def getSpecificCostOfTimeSlotText(deliveryMethod) {
		return Mobile.getText(findTestObject('Member/Member360/MemberAppointments/getSpecificCostOfTimeSlotTxt_android',["deliveryMethod":deliveryMethod]), defaultTime);
	}
	@Keyword
	def tapOnSelectSpecificTimeSlot(deliveryMethod,index) {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/selectSpecificTimeSlot_android',["deliveryMethod":deliveryMethod,"index": index]), defaultTime);
	}
	@Keyword
	def tapOnFacilityCashFirstSlot() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/cashApptSlot_android'), defaultTime);
	}
	@Keyword
	def verifyDirectionsBtn() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/directionsBtn_android'), defaultTime);
	}
	@Keyword
	def verifyLocationTxt() {
		Mobile.verifyElementExist(findTestObject('Member/Member360/MemberAppointments/locationTxt_android'), defaultTime);
	}
	@Keyword
	def typeInMsgProviderTxtBx(txt) {
//		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/memberProviderTxtBx_android'), 30);
//		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		Mobile.setText(findTestObject('Member/Member360/MemberAppointments/memberProviderTxtBx_android'), txt, defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Chat/sendBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnProviderProfileName(providerName) {
		Mobile.delay(5)
		gen.swipeUpLittle()
		def providerProfileName = Mobile.getText(findTestObject('Object Repository/Member/Appointments/providerProfileByName_android', ["ProviderName":providerName]), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/providerProfileByName_android', ["ProviderName":providerName]), defaultTime);
		return providerProfileName;
	}
	@Keyword
	def verifyAppointmentHelpDescription() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/apptHelpDescription_android'), defaultTime);
	}
	@Keyword
	def verifyAppointmentHelpTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/apptHelpTitle_android'), defaultTime);
	}
	@Keyword
	def verifyMemberPRM() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/memberPRM_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapMessagePRMBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/messagePRMBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/messagePRMBtn_android'), defaultTime);
	}
	@Keyword
	def verifyPRMChatTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/PRMchatTitle_android'), defaultTime);
	}
	@Keyword
	def tapOnAddProcedureAddBtn() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/addProcedureAddBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnPrimaryCareOption() {
		Mobile.tap(findTestObject('Member/Member360/MemberAppointments/primaryCareOption_android'), defaultTime);
	}


	@Keyword
	def tapOnNoChangeBtn() {
		try {
			Mobile.tap(findTestObject('Member/Member360/MemberAppointments/noChangeBtn_android'), defaultTime);
		}catch (Exception e) {
			println("button not found")
		}
	}

	@Keyword
	def tapOnBookApptByProcedureBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/bookApptByProcedureBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnProcedureCategoryOptionBtn(category) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/procedureCategoryOption_android', ["category":category]), defaultTime);
	}

	@Keyword
	def verifyProcedureTextExist(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/verifyProcedureText_android', ["text":text]), defaultTime);
	}

	@Keyword
	def verifyProcedureTextNotExist(text) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/verifyProcedureText_android', ["text":text]), defaultTime);
	}

	@Keyword
	def tapOnSearchBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/searchBackBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnprocedureCategoryCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/procedureCategoryCloseBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnContinueToHealthRecordBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Confirm Appointment Screen/continueToHealthRecordBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnBookWithMeBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member Provider Profile/bookWithMeBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBookWithMeBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/bookWithMeBtn_android'), defaultTime);
	}

	@Keyword
	def verifyViewProgramBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/viewProgram_android'), defaultTime);
	}

}
