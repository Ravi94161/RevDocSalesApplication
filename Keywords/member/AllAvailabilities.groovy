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
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

import internal.GlobalVariable
import mobile.Generic
import mobile.MobileActions
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

public class AllAvailabilities {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE;
	Generic gen = new Generic()
	SelectAddresses addr = new SelectAddresses()
	MobileActions mobile = new MobileActions();
	Checkout check = new Checkout()
	ThankYou thankYou = new ThankYou();

	@Keyword
	def getMonthTileOnCalender() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/monthYearOnCalender_android'), defaultTime);
	}
	@Keyword
	def getTotalApptsTxt(defaultTime = 60) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/totalApptsText'), defaultTime,onFailure);
	}
	@Keyword
	def getSlotTimeForHouseCallByIndex(index) {
		Mobile.scrollToText('House Call Appointments');
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/houseCallSlotTimeByIndex_android', ['index': index]), defaultTime,onFailure)
	}

	@Keyword
	def verifyslotTimeByIndex(delivery = "House Call", index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(delivery, FailureHandling.OPTIONAL);
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/VanCallAppointments/slotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime, onFailure)
	}

	@Keyword
	def getslotTimeByIndex(delivery,index) {
		Mobile.scrollToText(delivery, FailureHandling.OPTIONAL);
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/VanCallAppointments/slotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSlotByDMIndex(delivery,index) {
		Mobile.scrollToText(delivery, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/VanCallAppointments/slotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime, onFailure)
	}

	@Keyword
	def getslotTimeByIndexTele(index = 1) {
		Mobile.scrollToText("Telemedicine Call", FailureHandling.OPTIONAL);
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/telemedicineCallSlot_android', ['index': index]), defaultTime,onFailure)
	}

	@Keyword
	def getSlotUsdForHouseCallByIndex(index) {
		Mobile.scrollToText('House Call Appointments');
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/houseCallSlotUsdByIndex_android', ['index': index]), defaultTime,onFailure)
	}
	@Keyword
	def getFacilitySlotCashPrice(delivery,index) {
		//index = index*2
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getFacilitySlotCashPrice_android', ['delivery':delivery,'index': index]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def tapOnFacilitySlotCashPrice(delivery,index) {
		//		index = index*2
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getFacilitySlotCashPrice_android', ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def getFacilityInsuranceSlotTime(index) {
		//		index = index*2
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getFacilityInsuranceSlotTime_android', ['index': index]), defaultTime)
	}
	@Keyword
	def tapOnFacilityInsuranceSlotTime(index) {
		//		index = index*2
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getFacilityInsuranceSlotTime_android', ['index': index]), defaultTime)
	}
	@Keyword
	def getRevOneSlotUsdByDMIndex(delivery,index) {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getRevOneDMPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def verifyRevPlusPriceAbsence(delivery,index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getRevOneDMPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def tapOnRevOneSlotUsdByDMIndex(delivery,index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getRevOneDMPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}

	@Keyword
	def tapOnRevPlusSlotUsdByDMIndex(delivery,index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getRevOneDMPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}

	@Keyword
	def getRevPlusDMPriceByIndex(delivery,index, defaultTime = defaultTime) {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getRevPlusDMPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def verifyMemberPayTxtForHouseCallByIndex(index) {
		Mobile.scrollToText('House Call Appointments');
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/houseCallMemberPayTextByIndex_android', ['index', index]), defaultTime);
	}
	@Keyword
	def getRevDocPlusPriceForHouseCallByIndex(index) {
		Mobile.scrollToText('House Call Appointments');
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/houseCallRevdocPlusPriceByIndex_android', ['index': index]), defaultTime)
	}
	@Keyword
	def getRevDocPlusPriceByIndex(delivery,index, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/VanCallAppointments/revPlusSlotPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime, onFailure);
	}
	@Keyword
	def tapHouseCallSlotByIndex(index) {
		Mobile.scrollToText('House Call Appointments',FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/houseCallSlotTimeByIndex_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapTelemedicineCallSlotByIndex(delivery, index) {
		def testObject = findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/VanCallAppointments/slotTimeByIndex_android', ['delivery':delivery,'index': index])
		mobile.scrollUntilElementIsVisible(testObject, 2, 5)
		Mobile.tap(testObject, defaultTime);
	}
	// Confirm Appointments
	@Keyword
	def getConfirmApptProcedureNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptProcedureName_android'), defaultTime,onFailure);
	}
	@Keyword
	def getConfirmApptproviderNameAndTitleText() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptproviderNameAndTitle_android'), defaultTime,onFailure);
	}
	@Keyword
	def getConfirmApptstartDateAndTimeText() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptstartDateAndTime_android'), defaultTime,onFailure);
	}
	@Keyword
	def getConfirmDeliveryMethodNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmDeliveryMethodName_android'), defaultTime,onFailure);
	}
	@Keyword
	def getConfirmAppoinmentAddress(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confimApptAddress_android',['index':index]), defaultTime, onFailure);
	}

	def getconfirmApptDetailsByLabel(text) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptUSD_android',['text':text]), defaultTime,onFailure);
	}

	@Keyword
	def getpricesOnConfirmAppt(userType = "revone") {
		def membersPrice, nonMembersPayPrice;
		userType = userType.toLowerCase()
		if(userType == "revone") {
			membersPrice = getconfirmApptDetailsByLabel("Members Pay ")
			nonMembersPayPrice = getconfirmApptDetailsByLabel('Non-Members Pay ')
		} else {
			membersPrice = getconfirmApptDetailsByLabel("You Pay ")
			nonMembersPayPrice = getconfirmApptDetailsByLabel("Non-Members Price ")
		}

		return [membersPrice: membersPrice, nonMembersPrice: nonMembersPayPrice]
	}

	@Keyword
	def getpriceOnConfirmAppt(userType = "revone") {
		Mobile.delay(8)
		def text;
		userType = userType.toLowerCase()
		if(userType == "revone") {
			text = "Non-Members Pay "
		}
		else if(userType == "revplus" || userType == 'revprivate') {
			text = "You Pay "
		}
		return  Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptUSD_android',['text':text]), defaultTime,onFailure);
	}

	@Keyword
	def getPriceOfRevprivate(text) {
		return  Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptUSD_android',['text':text]), defaultTime,onFailure);
	}
	@Keyword
	def getpriceOnConfirmApptByApptType(userType = "revone", apptType = '') {
		def text;
		apptType = apptType.toLowerCase()
		if(apptType == 'insurance') {
			apptType = "(Using Insurance)"
		}
		userType = userType.toLowerCase()
		if(userType == "revone") {
			text = "Non-Members Pay ${apptType}"
		}
		else if(userType == "revplus" || userType == 'revprivate') {
			text = "You Pay ${apptType}"
		}
		return  Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptUSD_android',['text':text]), defaultTime,onFailure);
	}

	@Keyword
	def getRevonePriceUnderUpgradeAndSave() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/revOnePriceUnderUpgradeAndSave_android'), defaultTime);
	}
	@Keyword
	def getRevplusPriceUnderUpgradeAndSave() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/revPlusPriceUnderUpgradeAndSave_android'), defaultTime);
	}
	@Keyword
	def verifyRevplusPriceSavingsUnderUpgradeAndSave(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/revPlusPriceSavingsUnderUpgradeAndSave_android'), price, onFailure);
	}
	@Keyword
	def tapRevplusPriceUnderUpgradeAndSave() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/revPlusPriceUnderUpgradeAndSave_android'), defaultTime);
	}
	@Keyword
	def tapRevoneCbxUnderUpgradeAndSave() {
		gen.swipeUp();
		try {
			Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/continueAsRevoneMember_cbx_android'), defaultTime);
		}catch(Exception e) {
			println("CheckBox not found")
		}

	}
	@Keyword
	def tapRevplusCbxUnderUpgradeAndSave() {
		gen.swipeUp();
		return Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/revPlusCbx_android'), defaultTime);
	}
	@Keyword
	def verifyRevOneRevPlusText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/verifyRevOneRevPlusText_android',['text':text]), defaultTime);
	}
	@Keyword
	def verifyUpgradeAndSaveText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/verifyUpgradeAndSaveText_android',['text':text]), defaultTime);
	}
	@Keyword
	def tapYesBookBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/yesBookBtnInConfirmAppointment_android'), defaultTime);
	}

	@Keyword
	def verifyYesBookBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/yesBookBtnInConfirmAppointment_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnContinueToHealthRecordBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/continueToHealthRecordBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnNoCancelBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/noCancelBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCheckoutNowBtn(onFailure = FailureHandling.OPTIONAL) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/checkoutNowBtn_android'), defaultTime,onFailure );
	}
	@Keyword
	def verifyCheckoutNowBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/MemberAppointments/checkoutNowBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def getSlotPrice(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Search/getSlotPrice_'+os,['index': index]), defaultTime);
	}
	@Keyword
	def verifyDirectionsBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/DirectionsBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyFacilityInsuranceSlots() {
		Mobile.scrollToText("Insurance");
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/facilityInsuranceSlots_android'), defaultTime);
	}
	@Keyword
	def verifyFacilityCashSlots() {
		Mobile.scrollToText("Cash");
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/facilityCashSlots_android'), defaultTime);
	}
	@Keyword
	def verifyFacilityInsuranceSlotsNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/facilityInsuranceSlots_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyFacilityCashSlotsNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/facilityCashSlots_android'), defaultTime);
	}
	@Keyword
	def getSlotTimeByIndex(delivery,index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getSlotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def tapOnSlotTimeByIndex(delivery,index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getSlotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}

	@Keyword
	def verifySlotByDeliveryMethodIndex(delivery,index, onFailure = FailureHandling.OPTIONAL) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getSlotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifySlotByDeliveryMethodIndexNotExist(delivery,index, onFailure = FailureHandling.OPTIONAL) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getSlotTimeByIndex_android', ['delivery':delivery,'index': index]), defaultTime, onFailure)
	}

	@Keyword
	def getSlotPriceByIndex(delivery,index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getSlotPriceByIndex_android', ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def tapOnSlotTimeByDMIndex(delivery,index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getSlotTimeByIndex_'+os, ['delivery':delivery,'index': index]), defaultTime)
	}
	@Keyword
	def getFacilityCashSlotTimeByIndex(index) {
		Mobile.scrollToText('Facility Visit Appointments');
		Mobile.scrollToText('Cash');
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/faciltyCashSlotTimeByIndex_android', ['index': index]), defaultTime)
	}
	@Keyword
	def getFacilityCashSlotPriceByIndex(index = 1) {
		index = index*2
		Mobile.scrollToText('Facility Visit Appointments');
		Mobile.scrollToText('Cash');
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/facilityCashRevdocPlusPrice_android', ['index': index]), defaultTime)
	}
	@Keyword
	def tapFacilityCashSlotTimeByIndex(index = 1) {
		Mobile.scrollToText('Cash');
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/faciltyCashSlotTimeByIndex_android', ['index': index]), defaultTime)

	}
	@Keyword
	def tapOnProcedureDropdown() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/procedureDropdown_'+os), defaultTime)
	}
	@Keyword
	def tapOnSelectProcedure(procedure) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/selectProcedure_'+os, ['procedure': procedure]), defaultTime)
	}
	@Keyword
	def getAnySlotTimeByIndex(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/getAnySlotTimeByIndex_'+os, ['index': index]), defaultTime)
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/backBtn_'+os), defaultTime)
	}
	@Keyword
	def roundOffToNextQuarter(time) {
		Calendar calendar = Calendar.getInstance()
		calendar.time = time
		calendar.add(Calendar.MINUTE, -30)
		calendar.add(Calendar.HOUR_OF_DAY, -10)

		int minutes = calendar.get(Calendar.MINUTE)
		int hour = calendar.get(Calendar.HOUR_OF_DAY)

		if (minutes >= 0 && minutes < 15) {
			calendar.set(Calendar.MINUTE, 15)
		} else if (minutes >= 15 && minutes < 30) {
			calendar.set(Calendar.MINUTE, 30)
		} else if (minutes >= 30 && minutes < 45) {
			calendar.set(Calendar.MINUTE, 45)
		} else if (minutes >= 45) {
			if (hour < 23) {
				calendar.add(Calendar.HOUR_OF_DAY, 1)
				calendar.set(Calendar.MINUTE, 0)
			} else {
				calendar.set(Calendar.HOUR_OF_DAY, 0)
				calendar.set(Calendar.MINUTE, 0)
			}
		}

		return calendar.time
	}
	@Keyword
	def verifyFirstAvailableSlot(time, deliveryMethod) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstAvailableSlot_android', ['time': time, 'deliveryMethod': deliveryMethod]), defaultTime)
	}
	@Keyword
	def tapOnSpecificDate(date, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/selectSpecificDate_'+os,['date':date,"index":index]), defaultTime)
	}
	@Keyword
	def verifyDateIsPresentOrNot(date, index=1) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/selectSpecificDate_'+os,['date':date, "index": index]), defaultTime, FailureHandling.OPTIONAL)
	}
	@Keyword
	def verifyOkayBtnExists(timeout) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/okayBtn_android'), timeout,FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnOkayBtn(timeout) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/MemberAppointments/okayBtn_android'), timeout, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/okayBtn_android'), timeout);
		Mobile.delay(timeout)
	}
	@Keyword
	def selectDayOfMonthByWeekDay(dayOfWeek, dayOfMonth) {
		Mobile.delay(2)
		Mobile.tap(findTestObject("Object Repository/Member/HomePage/Search/AllAvailabilities/selectDayByWeekDay_android", ['dayOfWeek': dayOfWeek.toLowerCase(), 'dayOfMonth': dayOfMonth]), defaultTime)
	}
	@Keyword
	def tapNextMonthIcon() {
		Mobile.tap(findTestObject("Object Repository/Member/HomePage/Search/AllAvailabilities/nextMonthBtn_android"), defaultTime)
	}
	@Keyword
	def tapOnrevOneFacilitySlotByTypeAndIndex(type, index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/revOneFacilitySlotByInex_android', ["type":type, "index":index]), defaultTime);
	}
	@Keyword
	def verifyDisabledOrEnabledYesBookBtn(trueOrfalse, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime){
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/disabledorEnabledYesBookBtn_android',["TorF":trueOrfalse]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def tapOnRevPlusRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/revPlusRadioBtn_android'), defaultTime);
	}
	@Keyword
	def getSelectedSlotDate() {
		def monthYear = getMonthTileOnCalender();
		Thread.sleep(5000)
		gen.swipeUpShortLoop(2)
		def totalApptsTxt = getTotalApptsTxt();
		// Regular expression to capture the month and day
		def pattern = /\w+, (\w+) (\d+)/
		// Extract the year from monthYear
		def year = (monthYear =~ /\w+ (\d+)/)[0][1]
		// Extract the month and day from totalApptsTxt
		def matcher = totalApptsTxt =~ pattern
		def month = matcher[0][1]
		def day = matcher[0][2]
		return [year: year, month: month, day: day]
	}

	@Keyword
	def geSelectedSlotDate() {
		return getSelectedSlotDate()
		Mobile.takeScreenshot(FailureHandling.OPTIONAL)
	}

	@Keyword
	def gerRevoneSlotDetailsByIndex(deliveryMethod, index) {
		def time = getslotTimeByIndex(deliveryMethod, index);
		def revonePrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index);
		def revPlusPrice = getRevDocPlusPriceByIndex(deliveryMethod, index);

		println("revonePrice": revonePrice);
		println("revPlusPrice": revPlusPrice);
		return [time: time, revonePrice: revonePrice, revPlusPrice: revPlusPrice]
	}

	@Keyword
	def getRevPLusSlotDetailsByIndex(deliveryMethod, index) {
		def time = getslotTimeByIndex(deliveryMethod, index);
		def revPlusPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index)
		println("revPlusPrice": revPlusPrice);
		return [time: time, revPlusPrice: revPlusPrice]
	}

	@Keyword
	def getAppointmentDetailsFromConfirmAppointment(totalPriceRequired = true, userType = "revone") {
		def procedureName = getConfirmApptProcedureNameText();
		def providerName = getConfirmApptproviderNameAndTitleText();
		def dateTime = getConfirmApptstartDateAndTimeText();
		def deliveryMethodName = getConfirmDeliveryMethodNameText();
		def apptAddress =  getConfirmAppoinmentAddress();
		gen.swipeUpLittle()
		def total = totalPriceRequired ? getpriceOnConfirmAppt(userType) : null;
		def memberPrices = totalPriceRequired ? getpricesOnConfirmAppt(userType) : null
		def memberPrice = totalPriceRequired ? memberPrices.membersPrice: null
		def nonMemberPrice =totalPriceRequired ?  memberPrices.nonMembersPrice : null

		return [procedureName: procedureName, providerName: providerName, dateTime: dateTime, deliveryMethodName: deliveryMethodName,
			total: total, apptAddress: apptAddress, memberPrice: memberPrice, nonMemberPrice: nonMemberPrice]
	}

	@Keyword
	def selectRevOneSlotAndGetAppointmentDetailsUptoCheckout(deliveryMethod) {
		def userType = "revone"
		gen.swipeUp();
		def index = 1
		def time = getslotTimeByIndex(deliveryMethod, index);
		def revonePrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index);
		def revPlusPrice = getRevDocPlusPriceByIndex(deliveryMethod, index);
		tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index)

		// Get details from Confirm Appointment
		def procedureName = getConfirmApptProcedureNameText();
		def providerName = getConfirmApptproviderNameAndTitleText();
		def dateTime = getConfirmApptstartDateAndTimeText();
		def deliveryMethodName = getConfirmDeliveryMethodNameText();
		def apptAddress =  getConfirmAppoinmentAddress();
		gen.swipeUpShortLoop(2);
		def total = getpriceOnConfirmAppt(userType);
		def memberPrices = getpricesOnConfirmAppt(userType)
		def memberPrice = memberPrices.membersPrice
		def nonMemberPrice = memberPrices.nonMembersPrice

		Mobile.delay(3);
		gen.swipeUp();
		tapRevoneCbxUnderUpgradeAndSave();
		Mobile.delay(5);
		tapYesBookBtn();
		int i = 0;
		while(verifyOkayBtnExists(15) && i <= 2) {
			tapOnOkayBtn(15);
			i = i + 1;
			index = index + 1;
			time = getslotTimeByIndex(deliveryMethod, index);
			revonePrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index);
			revPlusPrice = getRevDocPlusPriceByIndex(deliveryMethod, index);
			tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index);

			// Get details from Confirm Appointment
			procedureName = getConfirmApptProcedureNameText();
			providerName = getConfirmApptproviderNameAndTitleText();
			dateTime = getConfirmApptstartDateAndTimeText();
			deliveryMethodName = getConfirmDeliveryMethodNameText();
			apptAddress =  getConfirmAppoinmentAddress();
			gen.swipeUpShortLoop(2);
			total = getpriceOnConfirmAppt(userType);
			memberPrices = getpricesOnConfirmAppt(userType)
			memberPrice = memberPrices.membersPrice
			nonMemberPrice = memberPrices.nonMembersPrice

			Mobile.delay(3);
			gen.swipeUp();
			tapRevoneCbxUnderUpgradeAndSave();
			tapYesBookBtn();
		}
		tapOnCheckoutNowBtn();

		return [procedureName: procedureName, providerName: providerName, dateTime: dateTime, deliveryMethodName: deliveryMethodName,
			total: total, apptAddress: apptAddress, time:time, revonePrice:revonePrice, memberPrice: memberPrice, nonMemberPrice: nonMemberPrice]
	}

	@Keyword
	def selectRevPlusSlotAndGetAppointmentDetailsUptoCheckout(deliveryMethod, userType = "revplus") {
		userType = "revplus"
		gen.swipeUp();
		def index = 1
		def time = getslotTimeByIndex(deliveryMethod, index);
		def revPlusPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index);
		println(revPlusPrice:revPlusPrice)
		tapOnRevPlusSlotUsdByDMIndex(deliveryMethod, index)

		// Get details from Confirm Appointment
		def procedureName = getConfirmApptProcedureNameText();
		def providerName = getConfirmApptproviderNameAndTitleText();
		def dateTime = getConfirmApptstartDateAndTimeText();
		def deliveryMethodName = getConfirmDeliveryMethodNameText();
		def apptAddress =  getConfirmAppoinmentAddress();
		gen.swipeUpShortLoop(2);
		def total = getpriceOnConfirmAppt(userType);
		def memberPrices = getpricesOnConfirmAppt(userType)
		def memberPrice = memberPrices.membersPrice
		def nonMemberPrice = memberPrices.nonMembersPrice

		Mobile.delay(5)
		tapYesBookBtn();
		int i = 0;
		while(verifyOkayBtnExists(15) && i <= 2) {
			tapOnOkayBtn(15);
			i = i + 1;
			index = index + 1;
			time = getslotTimeByIndex(deliveryMethod, index);
			revPlusPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index);
			tapOnRevPlusSlotUsdByDMIndex(deliveryMethod, index);

			// Get details from Confirm Appointment
			procedureName = getConfirmApptProcedureNameText();
			providerName = getConfirmApptproviderNameAndTitleText();
			dateTime = getConfirmApptstartDateAndTimeText();
			deliveryMethodName = getConfirmDeliveryMethodNameText();
			apptAddress =  getConfirmAppoinmentAddress();
			gen.swipeUpShortLoop(2);
			total = getpriceOnConfirmAppt(userType);
			memberPrices = getpricesOnConfirmAppt(userType)
			memberPrice = memberPrices.membersPrice
			nonMemberPrice = memberPrices.nonMembersPrice

			tapYesBookBtn();
		}
		tapOnCheckoutNowBtn();

		return [procedureName: procedureName, providerName: providerName, dateTime: dateTime, deliveryMethodName: deliveryMethodName,
			total: total, apptAddress: apptAddress, time:time, revPlusPrice:revPlusPrice, memberPrice: memberPrice, nonMemberPrice: nonMemberPrice]
	}

	@Keyword
	def verifyTelemedicineSlotList(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/Telemedicine Call Appoinment/telemedicineSlotList_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRPlusMemberPay(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/Telemedicine Call Appoinment/rPlusmemberPay_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def getProvider(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/providerName_andriod', ["index": index]), defaultTime, onFailure)
	}
	@Keyword
	def getProcedure(procedure, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/procedurename_andriod', ['value': procedure]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnDeliveryMethodInfoIcon(deliveryMethod) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/deliveryMethodInfoIcon_android', ['deliveryMethod': deliveryMethod]), defaultTime)
	}
	@Keyword
	def tapOnContinueShoppingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/continueShoppingBtn_android'), defaultTime);
	}
	@Keyword
	def verifyContinueShoppingBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/continueShoppingBtn_android'), defaultTime);
	}
	@Keyword
	def verifyInfoPopUpTItle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/popupTitle_android'), title)
	}
	@Keyword
	def verifyAndTapOnCloseBtn() {
		Mobile.delay(8);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/closeBtn_android'), 45, FailureHandling.OPTIONAL)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/closeBtn_android'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodIconAndText(icon,  txt) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/deliveryMethodIcon_android', ['icon': icon]), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/deliveryMethodTxt_android', ['txt': txt]), defaultTime)
	}
	@Keyword
	def verifyDeliveryMethodPopup(title, icon, txt) {
		verifyInfoPopUpTItle(title)
		verifyDeliveryMethodIconAndText(icon, txt)
		verifyAndTapOnCloseBtn()
	}
	@Keyword
	def verifyNextAppointmentLable(deliveryMethod, index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/nextAppointmentLable_android',["deliveryMethod":deliveryMethod, "index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyNextAppointmentLabel(deliveryMethod, index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/nextAppointmentLable_android',["deliveryMethod":deliveryMethod, "index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyNextAppointmentText(deliveryMethod, boolean isPresent) {
		if(isPresent) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/verifyApptAvailableText_android',['deliveryMethod': deliveryMethod]), defaultTime);
		}
		else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/verifyApptAvailableText_android',['deliveryMethod': deliveryMethod]), defaultTime)
		}
	}
	@Keyword
	def verifyDeliveryMethodSlotsNotVisible(deliveryMethod, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/deliveryMethodSlotList_android', ['deliveryMethod': deliveryMethod]), defaultTime, onFailure)
	}
	@Keyword
	def verifyDeliveryMethodSlotsVisible(deliveryMethod, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(deliveryMethod, FailureHandling.OPTIONAL)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/deliveryMethodSlotList_android', ['deliveryMethod': deliveryMethod]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnSpecificDateOnCalendar(date) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/selectSpecificDate_android',["date":date]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.delay(15);
	}
	@Keyword
	def verifyAllDeliveryMethodsAreVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsVisible("House Call")
		verifyDeliveryMethodSlotsVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyTwoDeliveryMethodsSlotsAreVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsNotVisible("House Call")
		verifyDeliveryMethodSlotsVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsNotVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyFacilityDeliveryMethodSlotIsVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsNotVisible("House Call")
		verifyDeliveryMethodSlotsNotVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsNotVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyHouseCallDeliveryMethodSlotIsVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsVisible("House Call")
		verifyDeliveryMethodSlotsNotVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsNotVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsNotVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyVanCallDeliveryMethodSlotAreVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsNotVisible("House Call")
		verifyDeliveryMethodSlotsNotVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsNotVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyTelemedicineDeliveryMethodSlotsAreVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsNotVisible("House Call")
		verifyDeliveryMethodSlotsVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsNotVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsNotVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyAllDeliveryMethodsAreNotVisible(){
		gen.swipeUpLittle()
		gen.swipeUpLittle()
		verifyDeliveryMethodSlotsNotVisible("House Call")
		verifyDeliveryMethodSlotsNotVisible("Telemedicine Call")
		verifyDeliveryMethodSlotsNotVisible("Luxe Mobile Clinic")
		verifyDeliveryMethodSlotsNotVisible("Facility Visit")
		gen.swipeDownLittle()
	}

	@Keyword
	def verifyProcedureInCalendar(procedureName, isPresent) {
		Mobile.delay(20)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/procedureDropdown'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/searchProcedure'), procedureName, defaultTime)
		if(isPresent) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/selectProcedure_'+os, ['procedure': procedureName]), defaultTime)
		}
		else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/selectProcedure_'+os, ['procedure': procedureName]), defaultTime)
		}
	}

	@Keyword
	def verifyConfirmAppoinmentAddressText(index = 1, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confimApptAddress_android',['index':index]), text, onFailure);
	}

	@Keyword
	def verifyPromoBadgeIsExist(isExists = true) {
		if (isExists) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/promoAppliedTag_Andriod'), defaultTime, FailureHandling.STOP_ON_FAILURE)
		}
		else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/promoAppliedTag_Andriod'), defaultTime, FailureHandling.STOP_ON_FAILURE)
		}
	}

	@Keyword
	def bookAnAppointmentBasedOnUserTypeAndVerifyPromoApplied(user, index, address, providerName, procedureName, deliveryMethod, promoName, promoCode, promoStatus, countForUnSelectedProcItem) {
		user = user.toLowerCase()
		addr.searchAddressProviderProcedureViewAll(address, providerName, providerName, procedureName)
		gen.swipeUp()
		def deliveryMethodSlotDetails = user =="revone" ? gerRevoneSlotDetailsByIndex(deliveryMethod, index) : getRevPLusSlotDetailsByIndex(deliveryMethod, index)
		tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index)
		def confirmAppointmentDetails = getAppointmentDetailsFromConfirmAppointment(true, user)
		gen.swipeUp()
		if(promoStatus == "Yes") {
			mobile.verifyElementPresentByText("Promo Applied")
		}
		else {
			mobile.verifyElementNotPresentByText("Promo Applied")
		}
		user == "revone" ? tapRevoneCbxUnderUpgradeAndSave() : null
		tapYesBookBtn();
		int count = 0
		while(verifyOkayBtnExists(10) && count <= 5){
			tapOnOkayBtn(15);
			index = index + 1;
			count = count + 1;
			tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index);
			user == "revone" ? tapRevoneCbxUnderUpgradeAndSave() : null
			tapYesBookBtn();
		}
		tapOnCheckoutNowBtn()
		promoStatus == "No" ? check.verifyPromoNotAppliedInCheckoutCartItemsByIndex(countForUnSelectedProcItem) : null
		return deliveryMethodSlotDetails;
	}

	@Keyword
	def selectSlotOnAvailabilitiesPage(user = "revone", deliveryMethod, promoApplied = null, promoAmount = null, index = 1) {
		user = user.toLowerCase()
		Mobile.scrollToText(deliveryMethod, FailureHandling.OPTIONAL);
		gen.swipeUp();
		def deliveryMethodSlotDetails = user =="revone" ? gerRevoneSlotDetailsByIndex(deliveryMethod, index) : getRevPLusSlotDetailsByIndex(deliveryMethod, index)
		def slotTime = deliveryMethodSlotDetails.time
		def slotRevonePrice = deliveryMethodSlotDetails.revonePrice
		def slotRevPlusPrice = deliveryMethodSlotDetails.revPlusPrice

		tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index);

		def confirmAppointmentDetails = getAppointmentDetailsFromConfirmAppointment(true, user);

		gen.swipeUp();
		if(promoApplied == 'yes') {
			mobile.verifyElementPresentByText("Promo Applied");
			if(!promoAmount.contains('%')) {
				verifyPromoAppliedAmount(promoAmount, index = 1)
			}
		} else {
			mobile.verifyElementNotPresentByText("Promo Applied")
		}
		if(user =="revone") {
			tapRevoneCbxUnderUpgradeAndSave();
		}
		tapYesBookBtn();

		int count = 0
		while(verifyOkayBtnExists(10) && count <= 5){
			tapOnOkayBtn(15);
			index = index + 1;
			count = count + 1;
			tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index);
			tapRevoneCbxUnderUpgradeAndSave();
			tapYesBookBtn();
		}
		return [deliveryMethodSlotDetails: deliveryMethodSlotDetails, confirmAppointmentDetails: confirmAppointmentDetails]
	}

	@Keyword
	def tapOnViewAllBtnByIndex(index = 1) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android', ["index": index]), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android', ["index": index]), defaultTime);
	}

	@Keyword
	def verifyViewAllBtnByIndexExist(index = 1, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android', ["index": index]), defaultTime, onFailure)
	}

	@Keyword
	def selectRandomProviderAndBookApptForProgramProcedure(deliveryMethod) {
		gen.waitForRevdocLoaderToDisappear();
		Mobile.delay(5)

		verifyViewAllBtnByIndexExist(1, FailureHandling.OPTIONAL, 10) ? null : gen.swipeUpLittle()

		int i = 1;
		while(i <= 10) {
			Mobile.comment("iteration: ${i}")
			i = i + 1
			gen.waitForRevdocLoaderToDisappear();
			Mobile.delay(5)
			tapOnViewAllBtnByIndex(1);
			gen.waitForRevdocLoaderToDisappear();;
			boolean isdeliveryMethodVisisble = verifyDeliveryMethodSlotsVisible(deliveryMethod, FailureHandling.OPTIONAL)
			if(isdeliveryMethodVisisble) {
				break;
			} else {
				tapOnBackBtn();
				gen.swipeUp()
			}
		}
		def selectedSlotDate = getSelectedSlotDate();
		def year = selectedSlotDate.year
		def month = selectedSlotDate.month
		def day = selectedSlotDate.day

		def slotTime = getslotTimeByIndex(deliveryMethod, 1)
		tapTelemedicineCallSlotByIndex(deliveryMethod, 1)
		def confirmApptDetails = getAppointmentDetailsFromConfirmAppointment(false)
		tapYesBookBtn();
		int count = 0
		int index = 2
		while(verifyOkayBtnExists(10) && count <= 5){
			tapOnOkayBtn(15);
			index = index + 1;
			count = count + 1;
			slotTime = getslotTimeByIndex(deliveryMethod, index)
			tapTelemedicineCallSlotByIndex(deliveryMethod, index)
			confirmApptDetails = getAppointmentDetailsFromConfirmAppointment(false)
			tapYesBookBtn();
		}
		tapOnContinueToHealthRecordBtn();
		thankYou.tapRemindMeLaterOrNoChangesButton(15)

		def  dateTime = "${month} ${day}, ${year}, ${slotTime}";
		println("dateTime": dateTime);
		def inputString = dateTime
		def trimmedTime = inputString.split(',')[2].trim()
		println("trimmedTime": trimmedTime);
		def date = "${month} ${day}, ${year}"

		return [slotTime: slotTime, confirmApptDetails: confirmApptDetails, dateTime:dateTime, trimmedTime:trimmedTime, date: date]
	}

	@Keyword
	def selectProviderAndBookApptForProgProcedure(deliveryMethod, testObject, providerName) {
		gen.waitForRevdocLoaderToDisappear();
		Mobile.delay(5)
		mobile.scrollUntilElementIsVisible(testObject, 50)
		tapOnViewAllBtnByProviderName(providerName)
		boolean isdeliveryMethodVisisble = verifyDeliveryMethodSlotsVisible(deliveryMethod, FailureHandling.OPTIONAL)
		def index = 1
		def slotTime = getslotTimeByIndex(deliveryMethod, 1)
		verifyRevPlusPriceAbsence(deliveryMethod,1)
		tapTelemedicineCallSlotByIndex(deliveryMethod, 1)
		def confirmApptDetails = getAppointmentDetailsFromConfirmAppointment(false)
		tapYesBookBtn();
		int i = 0;
		while(verifyOkayBtnExists(15) && i <= 2) {
			tapOnOkayBtn(15);
			i = i + 1;
			index = index + 1;
			slotTime = getslotTimeByIndex(deliveryMethod, index);
			tapTelemedicineCallSlotByIndex(deliveryMethod, index)

			// Get details from Confirm Appointment
			confirmApptDetails = getAppointmentDetailsFromConfirmAppointment(false)
			Mobile.delay(3);
			gen.swipeUp();
			tapRevoneCbxUnderUpgradeAndSave();
			tapYesBookBtn();
		}
		tapOnContinueToHealthRecordBtn();
		thankYou.tapRemindMeLaterOrNoChangesButton(15)

		return [slotTime: slotTime, confirmApptDetails: confirmApptDetails]
	}

	@Keyword
	def selectProviderAndBookApptForAffiliateProcedure(user, deliveryMethod, testObject, providerName, index = 1) {
		user = user.toLowerCase()
		gen.waitForRevdocLoaderToDisappear();
		Mobile.delay(5)
		verifyViewAllBtnByIndexExist(1, FailureHandling.OPTIONAL, 10) ? null : gen.swipeUpLittle()
		mobile.scrollUntilElementIsVisible(testObject, 25)
		tapOnViewAllBtnByProviderName(providerName)

		gen.waitForRevdocLoaderToDisappear();
		gen.swipeUpLittle()
		def deliveryMethodSlotDetails = user =="revone" ? gerRevoneSlotDetailsByIndex(deliveryMethod, index) : getRevPLusSlotDetailsByIndex(deliveryMethod, index)
		tapTelemedicineCallSlotByIndex(deliveryMethod, 1)
		def confirmApptDetails = getAppointmentDetailsFromConfirmAppointment(true, user)
		tapYesBookBtn();
		int count = 0
		while(verifyOkayBtnExists(10) && count <= 5){
			tapOnOkayBtn(15);
			index = index + 1;
			count = count + 1;
			deliveryMethodSlotDetails = user =="revone" ? gerRevoneSlotDetailsByIndex(deliveryMethod, index) : getRevPLusSlotDetailsByIndex(deliveryMethod, index)
			tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index);
			confirmApptDetails = getAppointmentDetailsFromConfirmAppointment(true , user);
			user == "revone" ? tapRevoneCbxUnderUpgradeAndSave() : null
			tapYesBookBtn();
		}
		tapOnCheckoutNowBtn()

		return [slotDetails: deliveryMethodSlotDetails, confirmApptDetails: confirmApptDetails]
	}

	@Keyword
	def selectRandomProviderAndCheckoutForAffiliateProcedure(user, deliveryMethod, index = 1) {
		user = user.toLowerCase()
		gen.waitForRevdocLoaderToDisappear();
		Mobile.delay(5)
		verifyViewAllBtnByIndexExist(1, FailureHandling.OPTIONAL, 10) ? null : gen.swipeUpLittle()

		int i = 1;
		while(i <= 10) {
			Mobile.comment("iteration: ${i}")
			i = i + 1
			gen.waitForRevdocLoaderToDisappear();
			Mobile.delay(5)
			tapOnViewAllBtnByIndex(1);
			gen.waitForRevdocLoaderToDisappear();;
			boolean isdeliveryMethodVisible = verifyDeliveryMethodSlotsVisible(deliveryMethod, FailureHandling.OPTIONAL)
			if(isdeliveryMethodVisible) {
				break;
			} else {
				tapOnBackBtn();
				gen.swipeUp()
			}
		}

		gen.swipeUp()
		def deliveryMethodSlotDetails = user =="revone" ? gerRevoneSlotDetailsByIndex(deliveryMethod, index) : getRevPLusSlotDetailsByIndex(deliveryMethod, index)
		tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index)
		def confirmAppointmentDetails = getAppointmentDetailsFromConfirmAppointment(true, user);
		gen.swipeUp()

		user == "revone" ? tapRevoneCbxUnderUpgradeAndSave() : null
		tapYesBookBtn();
		int count = 0
		while(verifyOkayBtnExists(10) && count <= 5){
			tapOnOkayBtn(15);
			index = index + 1;
			count = count + 1;
			tapOnRevOneSlotUsdByDMIndex(deliveryMethod, index);
			user == "revone" ? tapRevoneCbxUnderUpgradeAndSave() : null
			tapYesBookBtn();
		}
		tapOnCheckoutNowBtn()
		return ['slotDetails': deliveryMethodSlotDetails, 'confirmApptDetails': confirmAppointmentDetails]
	}

	@Keyword
	def getProviderNameInAvailabilities() {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/getProviderName_android'), defaultTime);
	}

	@Keyword
	def tapOnProgramInProviderProfile(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/programByIndex_android',['index':index]), defaultTime);
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/buyNowBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnContinueBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/continueBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnViewAllBtnByProviderName(name) {
		Mobile.scrollToText(name, FailureHandling.OPTIONAL)
		def detailsTestObj = findTestObject('Object Repository/Member/HomePage/Search/SearchResults/viewAllBtnforProvider_android', ['name': name])
		mobile.scrollUntilElementIsVisible(detailsTestObj, 5)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/viewAllBtnforProvider_android', ['name': name]), defaultTime)
	}

	@Keyword
	def tapOnCheckAvailabilityBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Programs/checkAvailabilityBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnNextDayIfSlotsNotAvailable(daysToAdd = 1) {

		LocalDate today = LocalDate.now()
		YearMonth currentYearMonth = YearMonth.now()
		int daysInMonth = currentYearMonth.lengthOfMonth();
		println(daysInMonth:daysInMonth)

		// Get the day of the month
		int dayOfMonth = today.getDayOfMonth() +daysToAdd;
		println(dayOfMonth:dayOfMonth)
		if(dayOfMonth > daysInMonth) {
			//if month change tap on next Month
			tapNextMonthIcon();
			dayOfMonth = dayOfMonth - daysInMonth;
		}
		println(dayOfMonth:dayOfMonth)
		Mobile.delay(15)
		tapOnSpecificDate(dayOfMonth);
	}

	@Keyword
	def tapOnFutureDate(int daysToAdd = 1, index = 1) {
		// Get today's date
		LocalDate today = LocalDate.now()

		// Get the current YearMonth
		YearMonth currentYearMonth = YearMonth.now()

		// Number of days in the current month
		int daysInMonth = currentYearMonth.lengthOfMonth()
		println("Days in the month: ${daysInMonth}")

		// Calculate future date (days into the future)
		int futureDayOfMonth = today.getDayOfMonth() + daysToAdd  // Add specified days to current date
		println("Calculated future day: ${futureDayOfMonth}")

		// Check if future day goes into the next month
		if (futureDayOfMonth > daysInMonth) {
			// If the calculated date exceeds the number of days in the current month, move to next month
			tapNextMonthIcon()

			// Adjust the day to account for the new month
			futureDayOfMonth = futureDayOfMonth - daysInMonth
		}
		println("Final day to tap: ${futureDayOfMonth}")

		// Adding delay to allow calendar UI to load
		Mobile.delay(15)

		def xpathExpression = "//android.widget.TextView[@text='${futureDayOfMonth}']"

		// Find all elements matching the XPath
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement> elements = driver.findElementsByXPath(xpathExpression)

		// Get the count of elements
		def count = elements.size()
		println(count:count)

		// Tap on the specific date
		if(count >= 2) {
			println("count is 2")
			tapOnSpecificDate(futureDayOfMonth, index)
		}
		else {
			tapOnSpecificDate(futureDayOfMonth)
		}
		Mobile.delay(10)
		return [dayOfMonth:futureDayOfMonth]
	}

	@Keyword
	def selectSpecificDate(dayOfMonth) {
		while(verifyDateIsPresentOrNot(dayOfMonth)){
			tapNextMonthIcon();
		}
		tapOnSpecificDate(dayOfMonth);
	}

	@Keyword
	def tapOnFutureDay(int daysToAdd = 1) {
		// Get today's date
		LocalDate today = LocalDate.now()

		// Get the current YearMonth
		YearMonth currentYearMonth = YearMonth.now()

		// Number of days in the current month
		int daysInMonth = currentYearMonth.lengthOfMonth()
		println("Days in the month: ${daysInMonth}")

		// Calculate future date (days into the future)
		int futureDayOfMonth = today.getDayOfMonth() + daysToAdd  // Add specified days to current date
		println("Calculated future day: ${futureDayOfMonth}")

		def xpathExpression = "//android.widget.TextView[@text='${futureDayOfMonth}']"

		// Find all elements matching the XPath
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement> elements = driver.findElementsByXPath(xpathExpression)

		// Get the count of elements
		def count = elements.size()
		println(count:count)
		// Check if future day goes into the next month
		if (futureDayOfMonth > daysInMonth) {
			// If the calculated date exceeds the number of days in the current month, move to next month
			tapNextMonthIcon()
			Mobile.delay(10)
			// Adjust the day to account for the new month
			futureDayOfMonth = futureDayOfMonth - daysInMonth
			tapOnSpecificDate(futureDayOfMonth)
		}
		else if(futureDayOfMonth >= 25 && futureDayOfMonth <= 31 && count >= 2){
			tapOnSpecificDate(futureDayOfMonth, 2)
		}
		else {
			tapOnSpecificDate(futureDayOfMonth)
		}
		Mobile.delay(10)
		return [dayOfMonth:futureDayOfMonth]
	}

	@Keyword
	def verifyNoCancelBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/noCancelBtn_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/SaveAddress/noCancelBtn_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifyHouseCallPriceNotExist(index = 1) {
		Mobile.scrollToText('House Call Appointments', FailureHandling.OPTIONAL);
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/houseCallSlotUsdByIndex_android', ['index': index]), defaultTime,onFailure)
	}

	@Keyword
	def verifyPriceOnConfirmApptNotExist(userType = "revone") {
		Mobile.delay(8)
		def text;
		userType = userType.toLowerCase()
		if(userType == "revone") {
			text = "Non-Members Pay "
		}
		else if(userType == "revplus" || userType == 'revprivate') {
			text = "You Pay "
		}
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/confirmApptUSD_android',['text':text]), defaultTime,onFailure);
	}

	@Keyword
	def covertDateTimeStrToIndividualText(dateTimeStr) {
		def matcher = (dateTimeStr =~ /\s*(\w+)\s+(\d{1,2}),\s+(\d{4})/)
		def month; def day; def year;
		if (matcher.find()) {
			month = matcher.group(1)
			day = matcher.group(2)
			year = matcher.group(3)
		}
		return ['month':month, 'day':day, 'year':year]
	}

	@Keyword
	def verifyPromoDiscountPriceOnEachSlot(deliveryMethod, promoAmount, indexLimit) {
		def index1 = 1
		def index2 = 2
		Mobile.scrollToText(deliveryMethod, FailureHandling.OPTIONAL)
		gen.swipeUpLittle()
		if (promoAmount.contains("%")) {
			promoAmount = promoAmount.replace("%", "").toDouble() * 0.01

			for (int i = 1; i <= indexLimit; i++) {
				def discountPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index1).replace('$', '').toDouble()
				def actualPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index2).replace('$', '').toDouble()

				def percentageRemovedPrice = actualPrice * promoAmount
				def discountPrice2 = Math.ceil(actualPrice - percentageRemovedPrice)

				// Verify promo prices on each slot
				Mobile.verifyEqual(discountPrice, discountPrice2, FailureHandling.CONTINUE_ON_FAILURE)

				index1 += 2
				index2 += 2
			}
		} else {
			promoAmount = promoAmount.toInteger()

			for (int i = 1; i <= indexLimit; i++) {
				def discountPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index1).replace('$', '').toInteger()
				def actualPrice = getRevOneSlotUsdByDMIndex(deliveryMethod, index2).replace('$', '').toInteger()

				// Calculate the difference
				def difference = actualPrice - discountPrice

				// Log values for debugging
				println "Discount Price: $discountPrice, Actual Price: $actualPrice, Difference: $difference, Promo Amount: $promoAmount"

				// Verify the difference matches the promo amount
				Mobile.verifyEqual(difference, promoAmount, FailureHandling.CONTINUE_ON_FAILURE)

				index1 += 2
				index2 += 2
			}
		}
	}
	@Keyword
	def bookOtherSlotIfSelectedSlotReserved(user = "revone", deliveryMethod) {
		def index = 1
		int count = 0
		def confirmAppointmentDetails
		while(verifyOkayBtnExists(10) && count <= 5){
			tapOnOkayBtn(15);
			index = index + 1;
			count = count + 1;
			tapTelemedicineCallSlotByIndex(deliveryMethod, index);
			confirmAppointmentDetails = getAppointmentDetailsFromConfirmAppointment(true, user);
			gen.swipeUp()
			user == "revone" ? tapRevoneCbxUnderUpgradeAndSave() : null
			tapYesBookBtn();
		}
		return confirmAppointmentDetails;
	}

	@Keyword
	def verifyPromoAppliedAmount(promoAmount, index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/ConfirmAppt/promoAappliedAmount_android',['promoAmount':promoAmount,'index':index]), defaultTime, onFailure)
	}

	@Keyword
	def setTxtInSearchLocationsField(txt) {
		try {
			Mobile.setText(findTestObject('Object Repository/Member/SelectAddresses/searchLocationsField_android'), txt, defaultTime);
			Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		}
		catch(Exception e) {
			Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/addressField_android'), txt, defaultTime)
			Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		}
	}

	@Keyword
	def tapFirstSearchResult() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/firstSearchResults_android'), 15)
	}

	@Keyword
	def searchAndSelectAddress(address) {
		setTxtInSearchLocationsField(address);
		tapFirstSearchResult();
		Mobile.delay(5)
	}

	@Keyword
	def tapOnBookBtn(index = 1) {
		TestObject testObject = findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramCard/bookBtn_android', ["index": index])
		mobile.scrollUntilElementIsVisible(testObject, 10, 5)
		Mobile.tap(testObject, defaultTime);
	}

	@Keyword
	def tapOnMyProgramsInHomePage() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/myProgramsIconInHomePage_android'), defaultTime)
	}

	@Keyword
	def tapOnHomePageIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def bookAllAppointmentsInProg(progName, address, providerFirstName1, deliveryMethod, testObject, index) {
		Mobile.scrollToText(progName)
		gen.verifyElementTextPresent(progName)
		tapOnBookBtn(index)
		searchAndSelectAddress(address);
		def slotDetails = selectProviderAndBookApptForProgProcedure(deliveryMethod,  testObject, providerFirstName1)
		tapOnHomePageIcon()
		tapOnMyProgramsInHomePage()
		gen.verifyElementTextPresent(progName)
		return slotDetails
	}

}
