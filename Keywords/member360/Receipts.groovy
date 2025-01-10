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
import mobile.Generic

public class Receipts {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE
	Generic gen = new Generic();

	@Keyword
	def tapOnReceiptsIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Receipts", FailureHandling.OPTIONAL)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Receipts/receiptsIcon_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/receiptsIcon_android'), defaultTime);
	}

	@Keyword
	def navigateToReceiptsScreenFromHomeScreen(month, year) {
		// Navigate to Receipts
		Mobile.tap(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime);
		Mobile.delay(5);
		tapOnReceiptsIcon()
		verifyReciptsScreenTitle("Receipts");
		tapOnMonthByText(month)

		verifyReciptsScreenTitle("$month $year Receipts");
		verifyBackBtnReceipts();
	}

	@Keyword
	def navigateBackToHomeFromReceipts(clickBackBtnCount = 2) {
		for(int i = 0; i < clickBackBtnCount; i++) {
			tapOnBackBtnReceipts();
		}
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime);
	}

	@Keyword
	def verifyReceiptsIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Receipts", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/receiptsIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnChevronRightBtn(index = 1, onFailure = FailureHandling.OPTIONAL) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MyPrograms/ProgramMoreInfo/chevronRightBtn_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyItemPrice(dateTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/itemPriceStrike_'+os, ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def verifyReciptsScreenTitle(text, isExist = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(3)
		if(isExist == true) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/receiptsScreenTitle_android', ['text': text]), defaultTime, onFailure);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/Receipts/receiptsScreenTitle_android', ['text': text]), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifyItemText(dateTime, text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/procedureNameOnReceipt_android', ['dateTime': dateTime, 'text': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyItemPriceText(dateTime, price, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/apptPrice_android', ['dateTime': dateTime]), price, onFailure);
	}

	@Keyword
	def verifyItemPriceStrike(dateTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/itemPriceStrike_'+os, ['dateTime': dateTime]), defaultTime, onFailure);
	}

	@Keyword
	def tapApptViewDetailsBtn(dateTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Receipts/apptViewDetailsBtn_android', ['dateTime': dateTime]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/apptViewDetailsBtn_android', ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def tapOnAppointmentCancelledBtn(dateTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/appointmentCancelledBtn_'+os, ['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def verifyAppointmentCancelledBtn(dateTime, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/appointmentCancelledBtn_'+os, ['dateTime': dateTime]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAppoinmentCancelledBtn(dateTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/appointmentCancelledBtn_'+os, ['dateTime': dateTime]), defaultTime)
	}

	@Keyword
	def tapOnBackBtnReceipts() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/backBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyBackBtnReceipts() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/backBtn_'+os), defaultTime);
	}

	// View Details - Order Summary

	@Keyword
	def getApptItemName(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/apptTitle_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyItemName(procedure, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/getItemName_android', ['procedure': procedure]), defaultTime, onFailure);
	}

	@Keyword
	def getApptPrice(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/apptPrice_android', ['index': index]), defaultTime);
	}

	@Keyword
	def VerifyProcedureExistUnderPaymentSummary(procedureName, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('Payment Summary', FailureHandling.OPTIONAL)
		Mobile.scrollToText(procedureName, FailureHandling.OPTIONAL)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/procedureNameUnderPaymentSummary_android',['procedureName': procedureName]), defaultTime)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/procedureNameUnderPaymentSummary_android',['procedureName': procedureName]), defaultTime, onFailure)
	}

	@Keyword
	def getApptPriceUnderPaymentSummary(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/itemPriceUnderPaymentSummary_android', ['index': index]), defaultTime);
	}

	@Keyword
	def revPrivateGetApptPriceUnderPaymentSummary(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/RevPrivate/revOneApptPriceUnderPaymentSummary_android', ['index': index]), defaultTime);
	}

	@Keyword
	def getRevPlusPriceUnderPaymentSummary(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/getRevPlusPriceUnderPaymentSummary_android', ['index': index]), defaultTime);
	}
	@Keyword
	def getItemPrice(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/getItemPrice_android', ['index': index]), defaultTime);
	}

	@Keyword
	def getRevPlusPrice() {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/getRevPlusPrice_android'), defaultTime);
	}

	@Keyword
	def verifyPriceByLabelUnderPaymentSummary(label, price, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('Payment Summary')
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/priceByLabelUnderPaymentSummary_android',['label': label, 'price': price]), defaultTime, onFailure)
	}

	@Keyword
	def getTotalPriceUnderPaymentSummary() {
		Mobile.scrollToText('Order Total', FailureHandling.OPTIONAL);
		def actualPrice = Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/totalPriceUnderPaymentSummary_android'), defaultTime);
		actualPrice = actualPrice.trim();
		return actualPrice;
	}

	@Keyword
	def verifyNonStikeAmtofAppt(price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/itemPriceNonStrikeAmt_android', ['index': index]), price, onFailure);
	}

	@Keyword
	def verifyNonStikeApptPriceUnderPaymentSummary(price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/nonStrikeItemPriceUnderPaymentSummary_android', ['index': index]), price, onFailure);
	}

	@Keyword
	def verifyRevplusSavingsPrice(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('Rev+ Savings');
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/revplusSavingsPrice_android'), price, onFailure);
	}

	@Keyword
	def verifyRevdocPrivateSavingsPrice(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.scrollToText('Revdoc Private Savings');
		def revPrice = Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/revPrivateSavings_android'), defaultTime,onFailure);
		Mobile.verifyEqual(revPrice, price)
	}

	@Keyword
	def verifyBottomSheetTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/bottomSheetTitle_android'), text, onFailure);
	}

	@Keyword
	def verifyElementText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/okayBtn_android'), defaultTime);
	}

	@Keyword
	def verifyLabItemExists(itemName, index= 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/labItemName_android', ["itemName": itemName, "index": index]), defaultTime, onFailure);
	}

	@Keyword
	def tapLabItemViewDetailsBtn(labItemName, index= 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/labItemViewDetailsBtn_android', ["labItemName": labItemName, "index": index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyLabItemPrice(labItemName, price, index= 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/labItemPrice_android', ["labItemName": labItemName, "index": index]), price, onFailure);
	}

	// ---------- Memberships -------------
	@Keyword
	def verifyMembershipRegularLabel(label, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/regularLabel_android'), label, onFailure)
	}

	@Keyword
	def verifyMembershipRegularValue(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/regularVal_android'), value, onFailure)
	}

	@Keyword
	def verifyMembershipPromoAppliedLabelExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedLabel_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMembershipPromoAppliedLabel(label, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedLabel_android'), label, onFailure)
	}

	@Keyword
	def verifyMembershipPromoAppliedValue(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedVal_android'), value, onFailure)
	}

	@Keyword
	def verifyPromoMembershipLabel(label, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoMembershipLabel_android'), label, onFailure)
	}

	@Keyword
	def verifyPromoMembershipValue(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoMembershipVal_android'), value, onFailure)
	}

	@Keyword
	def verifyRevPlusPrice(labItemName, price, index= 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/revPlusPrice_android', ["labItemName": labItemName, "index": index]), price, onFailure);
	}

	// ---------- End Memberships -------------

	// ---------- Start Procedures ------------

	@Keyword
	def verifyDiscountPriceOfProcedure(procedureName, price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/Procedures/discountPriceByProcedureName_android', ['procedureName': procedureName, 'index': index]), price, onFailure)
	}

	@Keyword
	def verifytotalPriceOfProcedure(procedureName, price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/Procedures/totalPriceByProcedureName_android', ['procedureName': procedureName, 'index': index]), price, onFailure)
	}

	@Keyword
	def verifyPromoCodeAppliedPriceOfProcedure(procedureName, price, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/Procedures/promoCodeAppliedPriceByProcedureName_android', ['procedureName': procedureName, 'index': index]), price, onFailure)
	}
	// ---------- End Procedures --------------

	@Keyword
	def tapOnElementText(text) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': text]), defaultTime);
	}

	@Keyword
	def getTotalPriceFacilityAppt(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/OrderSummary/getTotalPriceFacilityAppt_android', ['index': index]), defaultTime);
	}

	@Keyword
	def getApptPriceUnderPaymentSummaryReceipts() {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/Payment Summary/getItemPriceUnderPaymentSummary_android'), defaultTime);
	}
	@Keyword
	def tapOnAnyMonth(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/MonthsListInReciepts_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnMonthByText(month) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/month_android', ['month': month]), defaultTime);
	}
	@Keyword
	def verifyRebookBtn(time, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/rebookBtn_andriod',['time': time]), defaultTime, onFailure)
	}
	@Keyword
	def verifyViewBtn(dateTime, onFailure = FailureHandling.OPTIONAL) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/Receipts/apptViewDetailsBtn_android', ['dateTime': dateTime]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnReBookBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/reBookBtn_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyProviderName(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyProviderType(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyProcedureName(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyAddress(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': text]), defaultTime, onFailure);
		Mobile.takeScreenshot(FailureHandling.OPTIONAL)
	}
	@Keyword
	def verifyDate(date, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/elementText_android', ['text': date]), defaultTime, onFailure);
	}
	@Keyword
	def verifyShareReceiptsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/shareReceiptsBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyAtHomeLabsViewDetailsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/atHomeLabViewDetailsBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAtHomeLabsViewDetailsBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/atHomeLabViewDetailsBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyLabItemProfile(labName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/labItemProfile_android',["labName":labName]), defaultTime, onFailure);
	}

	@Keyword
	def tapApptViewDetailsBtnByIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Receipts/viewDetailsByIndex_android',['index':index]), defaultTime);
	}
	@Keyword
	def getProcedureNameFromBaseCart() {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/getProcedureName_android'), defaultTime);
	}

	@Keyword
	def navigatingToReceiptsAndOpenCurrentMonthReceipt() {
		tapOnReceiptsIcon();
		verifyReciptsScreenTitle("Receipts");
		tapOnChevronRightBtn();
		def monthAndYear = gen.getCurrentMonthAndYear()
		verifyReciptsScreenTitle("$monthAndYear.currentMonth $monthAndYear.currentYear Receipts");
	}
	
	@Keyword
	def getYearRevenue() {
		return Mobile.getText(findTestObject('Object Repository/Member/Settings/yearRevenueInReceipts_android'), defaultTime)
	}
}
