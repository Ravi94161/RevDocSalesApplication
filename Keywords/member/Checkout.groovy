package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.DecimalFormat
import java.math.RoundingMode

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import mobile.Generic
import mobile.MobileActions
import member.ThankYou
import member360.MemberServices;
import member360.Receipts
import api.Admin

public class Checkout{
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE
	MyAddresses myAddress = new MyAddresses();
	Generic gen = new Generic();
	ThankYou thankYou = new ThankYou();
	MobileActions mbActions = new MobileActions();
	Cart cart = new Cart()
	MemberServices mem = new MemberServices();
	HomePage home = new HomePage()
	Admin admin = new Admin()
	Receipts res = new Receipts();
	SelectAddresses select = new SelectAddresses()
	//	MemberAppointments member = new MemberAppointments()

	@Keyword
	def verifyRevdocPlusMembershipText(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/revdocPlusMembershipText_android'), defaultTime, onFailure);
	}

	@Keyword
	def getRevdocPlusMembershipAmt(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/revDocPlusMembershipAmt_android', ["index": index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyRevdocPlusMembershipAmt(price, onFailure = FailureHandling.STOP_ON_FAILURE, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/revDocPlusMembershipAmt_android', ["index": index]), price, onFailure)
	}

	@Keyword
	def verifyRevdocPlusBilledMonthlyTxt(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/revDocPlusBilledMontlyText_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnRemoveBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyRemoveBtn(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyConfirmTitlePopup(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/confirmPopupTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyNotExistConfirmTitlePopup(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/confirmPopupTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPopupDescription(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/popupDescription_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyYesBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/yesBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyNoBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/noBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnNoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/noBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnYesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/yesBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddApptNoteBtn(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/addApptNoteBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnAddApptNoteBtn(index) {
		Mobile.scrollToText("+ Reason for this Appointment", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/addApptNoteBtn_android',["index":index]), defaultTime);
		Mobile.delay(5);
	}

	@Keyword
	def tapOnReasonForThisAppt() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/addReasonForApptBtn_android'), defaultTime)
	}

	@Keyword
	def verifyDateAndTimeElement(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/dateAndTime_android'), defaultTime, onFailure);
	}

	@Keyword
	def getApptItemName(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/apptTitle_android', ['index': index]), defaultTime);
	}

	@Keyword
	def getApptPrice(index = 1) {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/apptPrice_android', ['index': index]), defaultTime);
	}

	@Keyword
	def VerifyProcedureExistUnderPaymentSummary(procedureName) {
		Mobile.scrollToText('Payment Summary',onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/procedureNameUnderPaymentSummary_android',['procedureName': procedureName]), defaultTime,onFailure)
	}

	@Keyword
	def getApptPriceUnderPaymentSummary(index = 1) {
		Mobile.scrollToText('Order Total', FailureHandling.OPTIONAL);
		def actualPrice =  Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/itemPriceUnderPaymentSummary_android', ['index': index]), defaultTime,onFailure);
		actualPrice = actualPrice.trim()
		return actualPrice;
	}

	@Keyword
	def getRevPlusApptPriceUnderPaymentSummary(index = 1) {
		Mobile.scrollToText('Order Total', FailureHandling.OPTIONAL);
		try {
			return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getRevPlusItemExpPriceUnderPaymentSum_android', ['index': index]), 10,onFailure);
		}catch(Exception e) {
			return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getRevPlusItemPriceUnderPaymentSum_android', ['index': index]), 10,onFailure);
		}
	}
	@Keyword
	def getTotalPriceUnderPaymentSummary(text = "Order Total") {
		Mobile.scrollToText(text, FailureHandling.OPTIONAL);
		def price = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/totalPriceUnderPaymentSummary_android',['text': text]), defaultTime,onFailure);
		price = price.trim();
		return price;
	}

	@Keyword
	def getTotalPriceUnderPaymentSummaryReceipts(text = "Order Total") {
		def actualPrice = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/totalPriceUnderPaymentSummary_android',['text': text]), defaultTime,onFailure);
		actualPrice = actualPrice.trim();
		return actualPrice;
	}

	@Keyword
	def getRevplusCardDescription() {
		Mobile.scrollToText('Sign Up Now');
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/revdocPlusCardDescription_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnRevplusCard(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText('Sign Up Now');
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/revPlusCard_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/revPlusCard_android'), defaultTime);
	}

	@Keyword
	def verifyPlaceOrderBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/placeOrderBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapPlaceOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/placeOrderBtn_android'), defaultTime);
		if(verifyAddAddressBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = 15)) {
			tapOnAddAddressBtn();
			myAddress.tapOnAddAddressAndFillTheDetails(GlobalVariable.searchAddress2);
			Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/placeOrderBtn_android'), defaultTime, onFailure = FailureHandling.OPTIONAL);
		}
	}

	@Keyword
	def tapOnAddCardBtn() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/addCardBtn_android'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/addCardBtn_android'), defaultTime);
		}
	}

	@Keyword
	def enterCardDetailsAndPay(cardNum, expDate, cvv, zip) {
		Mobile.delay(5)
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
	def verifyCountryAndUpdateZipCode(zip) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/verifyCountryInPaymentSheet_android', ['country': "United Kingdom"]), 20, FailureHandling.OPTIONAL)) {
			zip = "ABCDEF"
		}
		return zip
	}

	@Keyword
	def fillPaymentDetails(cardNum, expDate, cvv, zip) {
		tapOnAddCardBtn();
		Mobile.delay(5)
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
	def tapPlaceOrderAndBuyMembershipAndAtHomeLabs(cardNum = "4111111111111111", expDate = "02/26", cvv = "111", zip = "30002") {
		gen.swipeUp();
		def totalCartPrice = getTotalPriceUnderPaymentSummary("Order Total");
		println("totalCartPrice": totalCartPrice)
		def totalCartPriceWithoutDollar = Double.parseDouble(totalCartPrice.replaceAll("[^\\d.]", ""));
		tapPlaceOrderBtn();
		if(totalCartPriceWithoutDollar >  0 || mbActions.verifyElementPresentByText("Card", onFailure = FailureHandling.OPTIONAL) || Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cardNumberInputBx_android'), 10, FailureHandling.OPTIONAL)) {
			fillPaymentDetails(cardNum, expDate, cvv, zip);
			Mobile.hideKeyboard();
		}
		return totalCartPrice;
	}

	@Keyword
	def tapPlaceOrderAndCompletePayment(cardNum = "4111111111111111", expDate = "02/26", cvv = "111", zip = "30002") {
		gen.swipeUp();
		def totalCartPrice = getTotalPriceUnderPaymentSummary("Order Total");
		println("totalCartPrice": totalCartPrice)
		def totalCartPriceWithoutDollar = Double.parseDouble(totalCartPrice.replaceAll("[^\\d.]", ""));
		tapPlaceOrderBtn();
		if(totalCartPriceWithoutDollar >  0 || mbActions.verifyElementPresentByText("Card", onFailure = FailureHandling.OPTIONAL) || Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cardNumberInputBx_android'), 10, FailureHandling.OPTIONAL)) { //Add your payment information
			fillPaymentDetails(cardNum, expDate, cvv, zip);
			Mobile.hideKeyboard();
		}
		thankYou.verifyThankYouForYourPurchaseText(FailureHandling.OPTIONAL);
		return totalCartPrice;
	}

	@Keyword
	def tapOnPlaceOrderAndCompletePaymentAndThankYouScreen(cardNum = "4111111111111111", expDate = "02/26", cvv = "111", zip = "30002") {
		def totalCartPrice = tapPlaceOrderAndCompletePayment(cardNum, expDate, cvv, zip)
		thankYou.tapOnContinueToHealthRecordsBtn();
		thankYou.tapRemindMeLaterOrNoChangesButton(15);
		return totalCartPrice;
	}

	@Keyword
	def tapOnPlaceOrderAndCompletePaymentAndThankYou(cardNum = "4111111111111111", expDate = "02/26", cvv = "111", zip = "30002") {
		def totalCartPrice = tapPlaceOrderAndCompletePayment(cardNum, expDate, cvv, zip)
		thankYou.tapOnDoneBtn();
	}

	@Keyword
	def tapOnRemoveAndCheckoutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/removeAndCheckoutBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnContinueBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/continueBtnInAdditionalPage_android'), defaultTime, onFailure);
	}


	@Keyword
	def verifyPayBtnPriceTextExist(price) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/RevPrivate/payBtn_android'), defaultTime,onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/payBtnPriceText_android', ["price": price]), defaultTime,onFailure);
	}

	@Keyword
	def tapOnPayBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/RevPrivate/payBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/RevPrivate/payBtn_android'), defaultTime);
	}

	@Keyword
	def verifyNonStikeAmtofAppt(price, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/itemPriceNonStrikeAmt_android', ['index': index]), price,onFailure);
	}

	@Keyword
	def revPrivateVerifyNonStikeAmtofAppt(price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/revPrivateVerifyNonStrikePrice_android'), price,onFailure);
	}

	@Keyword
	def verifyNonStikeApptPriceUnderPaymentSummary(price, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/nonStrikeItemPriceUnderPaymentSummary_android', ['index': index]), price,onFailure);
	}

	@Keyword
	def verifyRevplusSavingsPrice(price) {
		Mobile.scrollToText('Rev+ Savings');
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/revplusSavingsPrice_android'), price,onFailure);
	}

	@Keyword
	def getSavingsLabelTxtAndSavedAmount(txt) {
		String amount = txt.replaceAll("[^\\d.]", "")
		return amount
	}

	@Keyword
	def verifyRevPrivateCardPrice(price) {
		Mobile.scrollToText('RevPrivate membership',onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/verifyPriceOnRevPrivateCard_android', ['price': price]), defaultTime,onFailure);
	}

	@Keyword
	def verifyElementText(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/elementText_android', ['text': text]), defaultTime, OnFailure)
	}
	@Keyword
	def verifyElementTextNotExist(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/elementText_android', ['text': text]), defaultTime, OnFailure)
	}
	@Keyword
	def verifyOkayBtnExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/okayBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/okayBtn_android'), defaultTime);
	}
	@Keyword
	def tapBackBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/Checkout/backBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/backBtn_android'), defaultTime);
	}
	@Keyword
	def verifyBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {

		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/backBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def getSelectedDeliveryAddress() {
		Mobile.scrollToText('Delivery Address');
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/selectedDeliveryAddress_android'), defaultTime);
	}

	@Keyword
	def tapOnDeliveryAddressOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/deliveryAddressOption_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/saveBtn_'+os), defaultTime);
	}

	@Keyword
	def getRevPlusPriceInCheckout(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getRevPlusPriceInCheckout_android',['index':index]), defaultTime);
	}

	@Keyword
	def getRevPlusPriceInPaymentSummary() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getRevPlusPriceInPaymentSummary_android'), defaultTime);
	}

	@Keyword
	def getRevPlusMembershipFee(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/AllAvailabilities/FacilityVisitAppointments/getRevPlusMembershipFee_android',['index':index]), defaultTime);
	}

	@Keyword
	def getTotalPriceFacility(index=1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getTotalPriceFacility_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifyRev1Price(price, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/OrderSummary/rev1Price_android', [index: index]), price);
	}

	@Keyword
	def verifyRevPlusPrice(price, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/OrderSummary/revplusPrice_android', [index: index]), price);
	}

	@Keyword
	def getRev1PriceFromProcedureCardForRev1User(index = 1) {
		def dollarValue = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/Procedure/rev1PriceForProcedureForRev1User_android', [index: index]), defaultTime)
		def price = dollarValue.replaceAll(/[^\d.]/, '') as Double
		return [dollarValue: dollarValue, price: price]
	}

	@Keyword
	def getUpgradeToRevPlusAndPayPriceFromProcedureCardForRev1User(index = 1) {
		def dollarValue = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/Procedure/upgradeToRevPlusAndPayPrice_android', [index: index]), defaultTime)
		def price = dollarValue.replaceAll(/[^\d.]/, '') as Double
		return [dollarValue: dollarValue, price: price]
	}

	@Keyword
	def getTotalPriceFromProcedureCard(index = 1) {
		def dollarValue = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/Procedure/totalProcedurePrice_android', [index: index]), defaultTime)
		def price = dollarValue.replaceAll(/[^\d.]/, '') as Double
		return [dollarValue: dollarValue, price: price]
	}

	@Keyword
	def verifyTotalPriceFromProcedureCard(price, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/Procedure/totalProcedurePrice_android', [index: index]), price);
	}

	@Keyword
	def getPromoCodeAppliedPriceForProcedure(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/Procedure/promoCodeAppliedPriceForProcedure_android',["index":index]), defaultTime)
	}

	@Keyword
	def verifyPromoCodeAppliedPriceForProcedureExists(index = 1, onFailure = FailureHandling.OPTIONAL, defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/Procedure/promoCodeAppliedPriceForProcedure_android',["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def getPromoCodeAppliedValueForProcedureCard(index = 1) {
		def actualPrice, formattedPrice;
		if(verifyPromoCodeAppliedPriceForProcedureExists(index, FailureHandling.OPTIONAL, 10)) {
			actualPrice = getPromoCodeAppliedPriceForProcedure(index)
			def priceAfterSplit = actualPrice.replace("\$", "").split("-")[1].toFloat()
			formattedPrice  = String.format("%.2f", priceAfterSplit).toFloat()
			println("formattedPrice": formattedPrice)
		}
		return [actualPrice: actualPrice, price: formattedPrice]
	}

	@Keyword
	def getPromoCodeAppliedPriceForMemberships() {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/Memberships/promoCodeAppliedPriceForMembership_android'), defaultTime)
	}

	@Keyword
	def getPromoCodePriceUnderPaymentSummary(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/PaymentSummary/promoCodeAppliedPriceUnderPaymentSummaryByIndex_android', ['index': index]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyPromoCodeUnderPaymentSummaryExist(onFailure = FailureHandling.OPTIONAL, defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/PaymentSummary/promoCodeAppliedPriceListUnderPaymentSummary_android'), defaultTime, onFailure)
	}

	@Keyword
	def getListOfPromoCodePricesUnderPaymentSummary() {
		def values = [];
		def numericValues = [];
		def size = 0, totalSum;
		//gen.swipeUp()
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);

		if(verifyPromoCodeUnderPaymentSummaryExist(FailureHandling.OPTIONAL, 10)) {

			AppiumDriver<?> driver = MobileDriverFactory.getDriver();
			List<WebElement> elements = driver.findElementsByXPath("//android.widget.TextView[contains(@text,'Promo Code Applied')]/following-sibling::android.widget.TextView[@content-desc='itemPriceLabelDisplayAmt']")
			size = elements.size()
			println("size": elements.size())
			for( def i = 1; i <= elements.size(); i++) {
				println ("i value": i)
				values << getPromoCodePriceUnderPaymentSummary(i)
				println("values": values )
			}
		}

		if(size > 0) {
			// Iterate through each element in the list
			values.each { value ->
				// Remove the "$" sign and split by "-"
				def price = value.replace("\$", "").split("-")[1]
				// Convert the value to a Double and append to the list
				numericValues << price.toDouble()
			}

			// Calculate the sum of all values
			totalSum = numericValues.sum()
		} else {
			totalSum = 0
		}
		def totalPriceWithDollar = "\$${totalSum}"

		// Print the results
		println "Numeric Values: ${numericValues}"
		println "Total Sum: ${totalSum}"
		return [values: values, totalSum: totalSum, totalPriceWithDollar:totalPriceWithDollar]
	}

	@Keyword
	def getListOfPromoCodePricesUnderPaymentSummaryByCount(count = 2) {
		def values = [];
		def numericValues = [];
		def size = 0, totalSum;
		//gen.swipeUp()
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);

		if(verifyPromoCodeUnderPaymentSummaryExist(FailureHandling.OPTIONAL, 10)) {
			for( def i = 1; i <= count; i++) {
				println ("i value": i)
				values << getPromoCodePriceUnderPaymentSummary(i)
				println("values": values )
			}
		}

		if(count > 0) {
			// Iterate through each element in the list
			values.each { value ->
				// Remove the "$" sign and split by "-"
				def price = value.replace("\$", "").split("-")[1]
				// Convert the value to a Double and append to the list
				numericValues << price.toDouble()
			}

			// Calculate the sum of all values
			totalSum = numericValues.sum()
		} else {
			totalSum = 0
		}
		def totalPriceWithDollar = "\$${totalSum}"

		// Print the results
		println "Numeric Values: ${numericValues}"
		println "Total Sum: ${totalSum}"
		return [values: values, totalSum: totalSum, totalPriceWithDollar:totalPriceWithDollar]
	}

	@Keyword
	def verifyOrderTotalwithAndWithoutPromoPrice(totalPriceInPaymentSummary, ItemPrice) {
		def promo = getListOfPromoCodePricesUnderPaymentSummary()
		def promoPrice = promo.totalSum
		double priceValue = ItemPrice.replaceAll("\\\$", "").toDouble()
		// Subtract the specified amount
		double newPriceValue = priceValue - promoPrice
		// Format the result with $ symbol
		def newItemPrice;
		if (newPriceValue % 1 == 0) {
			newItemPrice = String.format("\$%.0f", newPriceValue)  // No decimals if it's a whole number
		} else {
			newItemPrice = String.format("\$%.2f", newPriceValue)  // Show decimals if fractional part exists
		}
		Mobile.verifyEqual(totalPriceInPaymentSummary, newItemPrice, FailureHandling.CONTINUE_ON_FAILURE);
		return newItemPrice;
	}

	@Keyword
	def getAmtUnderPaymentSummaryByName(name, index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/PaymentSummary/actualAmtByNameUnderPaymentSummary_android', ['name': name, index: index]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def getDiscountAmtUnderPaymentSummaryByName(name, index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/PaymentSummary/discountAmtByNameUnderPaymentSummary_android', ['name': name, index: index]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	// Rev Money

	@Keyword
	def verifyRevCashEarnings(price) {
		Mobile.scrollToText('RevCash earned');
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/revCashEarned_android'), price);
	}

	@Keyword
	def tapRevMoney() {
		Mobile.scrollToText('RevMoney', FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/revMoneyTitle_android'), defaultTime)
	}

	@Keyword
	def getRevCashbalanceAmt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/RevMoney/revcashBalanceAmt_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapRevCashApplyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/RevMoney/revCashApplyBtn_android'), defaultTime)
	}

	@Keyword
	def tapRevMoneyRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/revMoneyRemoveBtn_android'), defaultTime)
	}

	@Keyword
	def verifyRevMoneyRemoveBtnExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/revMoneyRemoveBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevMoneyRemoveBtnNotExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/revMoneyRemoveBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyRevCashAppliedPriceUnderPaymentSummary(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/revcashAppliedUnderPaymentSummary_android'), price, onFailure)
	}
	@Keyword
	def verifyRevCashAppliedPriceUnderPaymentSummaryNotExist(price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/revCreditAppliedTxt_android',["price":price]), defaultTime, onFailure)
	}
	@Keyword
	def getRevCashAppliedPriceUnderPaymentSummary(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/revcashAppliedUnderPaymentSummary_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapRemoveBtnInBottomSheet() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/RevMoney/removeBtnInRemoveMoneyBottomSheet_android'), defaultTime)
	}
	@Keyword
	def continueBtnInBottomSheet() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/continueInRemovebottomSheet_android'), defaultTime)
	}
	@Keyword
	def verifyRemoveBtnInBottomSheet(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/removeBtnInRemoveMoneyBottomSheet_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyCancelBtnInBottomSheet(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/cancelBtnInRevMoneyBtnSheet_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSaveForLaterBtn(index = 1) {
		Mobile.scrollToText("Save for Later");
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/saveForLater_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyAddAddressBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/addAddressBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAddAddressBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/addAddressBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyAndTapOnRevCreditHistoryBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/revCreditHistoryBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/RevMoney/revCreditHistoryBtn_android'), defaultTime)
	}
	@Keyword
	def verifyRevCreditAmount(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/revCreditAmount_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRevCreditAmountCreditedDate(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/revCreditAmountCreditedDate_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyScreenTitle(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/ScreenTitle_android',["title":title]), defaultTime, onFailure);
	}
	@Keyword
	def verifyScreenTitleNotExist(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/RevMoney/ScreenTitle_android',["title":title]), defaultTime, onFailure);
	}
	@Keyword
	def getRevCreditBalance() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/RevCredit/getRevCreditBal_android'), defaultTime);
	}
	@Keyword
	def tapOnRevCreditApplyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/RevCredit/revCreditApplyBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAppointmentAddress(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Appointment address", onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/verifyElementExist_android',["txt":text]), defaultTime, onFailure)
	}
	@Keyword
	def getRevPlusApptPrice(index = 5) {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getRevPlusApptAmount_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnSavedForLaterOption() {
		Mobile.scrollToText("Saved For Later", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/savedForLaterOption_android'), defaultTime);
	}
	@Keyword
	def verifyAppointmentUnderSavedForLater(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/ApptUnderSavedForLater_android',["text":procedure]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnRevPlusRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/revplusRemoveBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnReBookBtn(index = 1) {
		Mobile.scrollToText("Cart", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/rebookBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnRefundAndCancellationPolicyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/RefundAndCancellationPolicy_android'), defaultTime)
	}

	@Keyword
	def tapOnRefundAndCancellationPolicyText(text = "Refund and Cancellation Policy") {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/refundAndCancellationPolicyText_android',['text':text]), defaultTime)
	}

	@Keyword
	def verifyContinueShoppingBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/At Home Labs/continueShoppingBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnContinueShoppingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/At Home Labs/continueShoppingBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnCartOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/CartOptionInCheckoutPage_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def getItemName(index) {
		Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/apptTitle_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyItemNameExist(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/verifyItemName_android', ['text': text]), defaultTime);
	}
	@Keyword
	def verifyItemNameNotExist(text) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/verifyItemName_android', ['text': text]), defaultTime);
	}
	@Keyword
	def verifyItemImageExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/VerifyItemImage_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyItemImageNotExist(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/VerifyItemImage_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyPaymentSummary(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/PaymentSummaryInCheckOut_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRevCashApplyBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/RevMoney/revCashApplyBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRevCreditApplyBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/RevCredit/revCreditApplyBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnChooseFromLibraryOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/chooseFromLibrary_android'), defaultTime);
	}
	@Keyword
	def getSavingsLableText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getSavingsLableText_android'), defaultTime);
	}
	@Keyword
	def getSummarySavingsLableText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getSummarySaving_android'), defaultTime);
	}
	@Keyword
	def verifyOkRemoveBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/Checkout/okRemoveBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnOkRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/okRemoveBtn_android'), defaultTime)
	}

	@Keyword
	def verifyExpiredLabelOnNoLongerPage() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/Checkout/expiredLabelOnNoLongerPage_android'), defaultTime)
	}

	@Keyword
	def getApptSlotTimeInCheckoutPage(area) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/apptSlotTimeInCheckout_android', ['area': area]), defaultTime)
	}

	@Keyword
	def verifyApptSlotTimeInCheckoutPage(area, time) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/apptSlotTimeInCheckout_android', ['area': area]), time)
	}

	@Keyword
	def verifyRemoveAndCHeckoutBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/Checkout/removeAndCheckout_android'), defaultTime)
	}

	@Keyword
	def verifySaveForLaterAndCheckoutBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/Checkout/saveForLaterAndCheckoutBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveForLaterAndCheckoutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/saveForLaterAndCheckoutBtn_android'), defaultTime, FailureHandling.OPTIONAL)
	}


	//----------------------------- Start  Review Order -------------------------------------

	@Keyword
	def tapOnContinueToPaymentBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/ReviewOrder/continueToPayment_android'), defaultTime)
	}
	//----------------------------- End Review Order ----------------------------------

	//--------------------------------Address Verification-----------------------------

	@Keyword
	def tapOnEditAddressOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Checkout Screen/editAddressOption_android',['index':index]), defaultTime)
	}

	@Keyword
	def verifyEditAddressOptionNotExist(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Checkout Screen/editAddressOption_android',['index':index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddressAndInstruction(dm=1, index, text) {
		Mobile.delay(3)
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Appointments/Checkout Screen/verifyAddress_android',['dm': dm, 'index':index]), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Checkout Screen/verifyAddress_android',['dm': dm, 'index':index]), text, onFailure)
	}

	@Keyword
	def verifyAddressInstruction(modifiedAddress, instruction) {
		verifyAddressAndInstruction(1,modifiedAddress);
		verifyAddressAndInstruction(2,instruction);
	}

	@Keyword
	def verifyRxAddressAndInstruction(index, text) {
		Mobile.delay(3)
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Checkout Screen/rxShippingAddressText_android',['index':index]), text, onFailure)
	}

	@Keyword
	def verifyAddressAndInstructionWthDeliveryMthd(deliveryMethod, index, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Appointments/Checkout Screen/deliveryMethodWithVerifyAddress_andriod',['index':index, "deliveryMethod": deliveryMethod]), text, onFailure)
	}

	@Keyword
	def verifyRxAddressInstruction(modifiedRxAddress, rxInstruction) {
		Mobile.delay(5)
		verifyRxAddressAndInstruction(1,modifiedRxAddress);
		verifyRxAddressAndInstruction(2,rxInstruction);
	}

	@Keyword
	def tapOnSearchAddress() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Checkout Screen/searchAddress_android'), defaultTime)
	}

	@Keyword
	def verifyAddressAndInstructionNotExist(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Checkout Screen/verifyAddress_android',['index':index]), 15)
	}


	//--------------------------------Address Verification-----------------------------

	//-----------------------------------------At home labs Address Section------------------------------------------------------
	@Keyword
	def getAddressText(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/At Home labs Address Section/getAddressText_android',['index':index]), defaultTime);
	}
	@Keyword
	def tapOnEditGreenBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/At Home labs Address Section/editGreenBtn_android',['index':index]), defaultTime)
	}
	@Keyword
	def verifyEditGreenBtn(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/At Home labs Address Section/editGreenBtn_android',['index':index]), defaultTime, onFailure)
	}
	@Keyword
	def getOrderTotalAmount() {
		def actualPrice =  Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/OrderSummary/summaryTotal_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		actualPrice = actualPrice.trim();
		return actualPrice;
	}
	@Keyword
	def verifyAddressElementExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/At Home labs Address Section/getAddressText_android',['index':index]), defaultTime);
	}
	@Keyword
	def getAppliedPromoCodeAmount(promocode, index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/appliedPromoCodeAmount_andriod', ["promocode": promocode, "index": index]), defaultTime)
	}
	@Keyword
	def tapPlaceOrderAndCompletePaymentWithoutThankYouScreen(cardNum = "4111111111111111", expDate = "02/26", cvv = "111", zip = "30002") {
		gen.swipeUp();
		def totalCartPrice = getTotalPriceUnderPaymentSummary("Order Total");
		println("totalCartPrice": totalCartPrice)
		def totalCartPriceWithoutDollar = Double.parseDouble(totalCartPrice.replaceAll("[^\\d.]", ""));
		tapPlaceOrderBtn();
		if(totalCartPriceWithoutDollar >=  0 || mbActions.verifyElementPresentByText("Card", onFailure = FailureHandling.OPTIONAL) || Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Credit Card Details/cardNumberInputBx_android'), 10, FailureHandling.OPTIONAL)) {
			fillPaymentDetails(cardNum, expDate, cvv, zip);
			Mobile.hideKeyboard();
		}
	}

	@Keyword
	def tapOnDoneBtn() {
		try {
			Mobile.tap(findTestObject('Member/Member360/MemberAppointments/doneBtn_android'), defaultTime);
		} catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Member/Appointments/Thank You Screen/continueBtn_android'), defaultTime);
		}
	}

	@Keyword
	def tapOnSelectProviderBtnByIndex(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/selectProviderBtn_android',['index':index]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def typeInRevPlusProviderSearchField(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Member/RevPlus Popup/revPlusProviderSearchField_android'), text, defaultTime, onFailure)
	}
	@Keyword
	def verifyAddressFieldExist() {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/SelectAddresses/searchLocationsField_android'), 8, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnGetStartedBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/getStartedBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnContinueToSelectLocationBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/continueToSelectLocationBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnContinueToSelectProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/continueToSelectProviderBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def selectAddressAndRevPlusProvider(address = GlobalVariable.searchAddress, provider = null) {
		tapOnGetStartedBtn();
		tapOnContinueToSelectLocationBtn();
		select.searchAndSelectAddress(address);
		tapOnContinueToSelectProviderBtn();
		if (provider && provider.trim()) {
			typeInRevPlusProviderSearchField(provider)
			tapOnSelectProviderBtnByIndex()
			home.tapOnXcloseBtn(FailureHandling.OPTIONAL)
		} else {
			tapOnSelectProviderBtnByIndex();
			home.tapOnXcloseBtn(FailureHandling.OPTIONAL)
		}
	}

	@Keyword
	def upgradeToRevPlus(address = GlobalVariable.searchAddress, provider = null) {
		home.tapOnRevOneBtn();
		home.tapOnMonthlyBtn();
		tapPlaceOrderAndCompletePayment()
		tapOnDoneBtn();
		selectAddressAndRevPlusProvider(address, provider)
	}

	// Promo Detais Verifications

	@Keyword
	def verifyPromoText(text, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoText_android',['index':index]), text)
	}

	@Keyword
	def verifyPromoAmount(itemPrice, text, index = 1, type = "promo") {
		def price;
		if (text.contains('%')) {
			def data = calculatePromoAmountPercentage(itemPrice, text)
			price = data.discountPrice
		}
		else {

			price = formatPromoAmount(text)

		}
		if(index==1) {
			gen.swipeDown();
		}
		def priceInCart = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoAmount_android',['index':index]), defaultTime)
		if(type == "prog") {
			def amt = mem.trimTxtToGetOnlyPrice(priceInCart)
			Mobile.verifyEqual(amt, price, FailureHandling.CONTINUE_ON_FAILURE);
		}
		else {
			def price2 = price;
			Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoAmount_android',['index':index]), price2, FailureHandling.CONTINUE_ON_FAILURE)
		}
		return price
	}

	@Keyword
	def verifyPromoAmountAndReturn(itemPrice, text, index = 1, type = "promo") {
		def price;
		def discountAmount;
		if (text.contains('%')) {
			def data = calculatePromoAmountPercentage(itemPrice, text)
			price = data.discountPrice
			discountAmount = data.discountAmount
		}
		else {
			price = formatPromoAmount(text)
			discountAmount = text.replaceAll(/\$/, '').toInteger()

		}
		def priceInCart = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoAmount_android',['index':index]), defaultTime)
		if(type == "prog") {
			def amt = mem.trimTxtToGetOnlyPrice(priceInCart)
			Mobile.verifyEqual(amt, price, FailureHandling.CONTINUE_ON_FAILURE);
		}
		else {
			Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoAmount_android',['index':index]), price)
		}
		return ['price':price,'discountAmount':discountAmount]
	}

	@Keyword
	def calculatePromoAmountAndReturn(itemPrice, text, index = 1, type = "promo") {
		def price;
		def discountAmount;
		if (text.contains('%')) {
			def data = calculatePromoAmountPercentage(itemPrice, text)
			price = data.discountPrice
			discountAmount = data.discountAmount
		}
		else {
			price = formatPromoAmount(text)
		}
		return ['price':price,'discountAmount':discountAmount]
	}

	@Keyword
	def verifyPromoTitleAndCode(code, title, index = 1) {
		Mobile.scrollToText("${code} Applied - ${title}", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoTitleWithCode_android',['code':code,'title':title, 'index':index]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyPromoTitleAndCodeNotApplied(code, title, index = 1) {
		Mobile.scrollToText("${code} Applied - ${title}", FailureHandling.OPTIONAL)
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoTitleWithCode_android',['code':code,'title':title, 'index':index]), 10, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyPromoCodeInPaymentSummary(code, index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoCodeTextInPaymentSummary_android',['code':code,'index':index]), defaultTime)
	}

	@Keyword
	def verifyPromoAmountInPaymentSummary(code, text, index = 1) {
		def price = formatPromoAmount(text)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoAmountInPaymentSummary_android',['code':code,'price':price, 'index':index]), defaultTime)
	}

	@Keyword
	def verifyPromoCodeAndAmountInPaymentSummary(code, price, index = 1) {
		verifyPromoCodeInPaymentSummary(code, index);
		verifyPromoAmountInPaymentSummary(code, price, index)
	}

	@Keyword
	def verifyRevPlusPromoAmountInPaymentSummary(code, price, index  = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/PromoDetails/promoAmountInPaymentSummary_android',['code': code,'price': price, 'index': index]), defaultTime)
	}

	@Keyword
	def formatPromoAmount(input) {
		// Remove the characters and convert to double value
		def amount = cleanAndConvert(input)

		// Format the amount to negative dollar with two decimal places
		def formattedAmount = convertPriceToNegativedDollarString(amount)

		return formattedAmount
	}

	@Keyword
	def calculateDiscountAndFinalPrice(itemPrice, discount) {
		println(itemPrice:itemPrice)
		println(discount:discount)
		double finalDiscount = cleanAndConvert(discount)
		double total = cleanAndConvert(itemPrice)
		def finalPrice
		if (discount.contains('%')) {

			def number = cleanAndConvert(discount)
			println(number:number)

			println(total:total)
			finalDiscount = total * (number / 100)
			println "----- finalDiscount = " + finalDiscount
			finalPrice = String.format("%.2f", (float) (total - finalDiscount))
			println "----- finalPrice = " + finalPrice
		}
		else{
			finalPrice =  String.format("%.2f",(double)(total - finalDiscount))
			println "----- finalPrice = " + finalPrice
		}
		return ['discountAmount': finalDiscount, 'finalPrice': finalPrice, 'discountAmountRoundOff': Math.ceil(finalDiscount)]
	}

	@Keyword
	def calculatePromoAmountPercentage(itemPrice, text) {
		println(itemPrice:itemPrice)
		println(text:text)
		def number = cleanAndConvert(text)
		println(number:number)
		def total = cleanAndConvert(itemPrice)
		println(total:total)
		def discountAmount = total * (number / 100)
		println(discountAmount:discountAmount)
		// Calculate the final price after applying the discount
		def formatTotal = total - discountAmount
		def finalPrice = convertPriceToPositiveDollarString(formatTotal)
		//		def finalPrice = "\$${formatTotalNew}"
		println(finalPrice:finalPrice)
		def price =  convertPriceToNegativedDollarString(formatTotal)
		println(price:price)
		def discountPrice =  convertPriceToNegativedDollarString(discountAmount)
		//def discountPrice = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP).toString()

		def discountPricePositiveValue =  convertPriceToPositiveDollarString(discountAmount)
		println(discountPrice:discountPrice)
		return ['price':price,'finalPrice':finalPrice,'discountPrice':discountPrice,'discountPricePositiveValue':discountPricePositiveValue,'discountAmount':discountAmount,'formatTotal':formatTotal]
	}

	@Keyword
	def calculateDifference(value1, value2) {
		def amount1 = cleanAndConvert(value1)
		def amount2 = cleanAndConvert(value2)
		println(amount1:amount1)
		println(amount2:amount2)
		// Calculate the difference
		def difference = amount1 - amount2
		println(difference:difference)
		// Format the result back to a string with the dollar sign
		def roundedValue = Math.ceil(difference)
		def result =  String.format("\$%d", roundedValue as int)

		//def result = convertPriceToPositiveDollarString(difference)

		return result
	}

	@Keyword
	def cleanAndConvert(input) {
		String inputStr = input.toString()
		if (inputStr.replaceAll("[\\d.]", "").length() > 0) {
			def matcher = (inputStr =~ /-?\$?(\d+(\.\d+)?)/)

			// Check if the matcher found a valid price
			if (matcher.find()) {
				inputStr = matcher.group(1) // Extract the captured group (the number)
			} else {
				throw new IllegalArgumentException("No valid number found in the input string")
			}
		}

		// Convert the cleaned string to a double
		double value = Double.parseDouble(inputStr)
		// Format the value to two decimal places
		value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP)
		return value
	}

	@Keyword
	def convertPriceToNegativedDollarString(input) {
		def roundedValue = Math.ceil(input)
		def value =  String.format("-\$%d", roundedValue as int)
		return value
	}

	@Keyword
	def convertPriceToPositiveDollarString(input) {
		def roundedValue = Math.ceil(input)
		def value =  String.format("\$%d", roundedValue as int)
		return value
	}

	@Keyword
	def getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne(count) {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement> elements = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="paymentSummary"]//android.widget.TextView[@resource-id="itempricelabeldisplayamt"]')
		println(elements:elements)
		def totalPrice = 0.0

		// Loop through each element, extract the text, parse it, and add to the total price
		for (int i = 0;i<count;i++) {
			String text = elements[i].getText()
			println(text:text)
			// Remove the $ sign and convert to double
			double price = Double.parseDouble(text.replace('$', ''))
			totalPrice += price
		}

		// Return the total price
		totalPrice = convertPriceToPositiveDollarString(totalPrice)

		println(totalPrice:totalPrice)
		return totalPrice
	}

	@Keyword
	def getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOnePrices(count) {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement> elements = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="paymentSummary"]//android.widget.TextView[@resource-id="itempricelabeldisplayamt"]')
		println(elements:elements)
		def totalPrice = 0.0
		count  = count*2
		// Loop through each element, extract the text, parse it, and add to the total price
		for (int i = 0;i<count;i++) {
			String text = elements[i].getText()
			println(text:text)
			// Remove the $ sign and convert to double
			double price = Double.parseDouble(text.replace('$', ''))
			if(i%2 == 0) {
				totalPrice += price
			}

		}

		// Return the total price
		totalPrice = convertPriceToPositiveDollarString(totalPrice)

		println(totalPrice:totalPrice)
		return totalPrice
	}

	@Keyword
	def getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus() {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		List<WebElement> elements = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="paymentSummary"]//android.widget.TextView[@resource-id="itempricelabeldisplayexpamt"]')
		println(elements:elements)
		def size = elements.size()
		def totalPrice = 0.0

		// Loop through each element, extract the text, parse it, and add to the total price
		elements.each { element ->
			String text = element.getText()
			println(text: text)
			// Remove the $ sign and convert to double
			String processedText = text.replace('$', '')
			//			double price = Double.parseDouble(text.replace('$', ''))
			if (processedText.contains('/mo')) {
				processedText = processedText.replace('/mo', '').trim()
			}
			double price = Double.parseDouble(processedText)
			totalPrice += price
		}

		// Return the total price
		totalPrice = convertPriceToPositiveDollarString(totalPrice)

		println(totalPrice:totalPrice)
		return totalPrice
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevOne(offAmount, promoCode, promoTitle, index = 1, type = "promo") {
		def labItemPriceInCart = cart.getItemPriceInCart();

		verifyPromoText("Promo Code Applied");
		def offPrice = verifyPromoAmount(labItemPriceInCart, offAmount, index, type)

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice, index, type)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}
	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevOneForLab(labId, offAmount, promoCode, promoTitle) {
		def labDetails = admin.getLabDetailsById(labId)

		def labItemPriceInCart = labDetails.finalBasicMembershipPrice
		println("itemPriceInCart": labItemPriceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(labItemPriceInCart, offPrice)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		println("totalPriceInPaymentSummaryExpected": totalPriceInPaymentSummaryExpected)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		println("totalPriceInPaymentSummary": totalPriceInPaymentSummary)
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		println("totalPriceInPaymentSummaryExpectedRounded": totalPriceInPaymentSummaryExpectedRounded)
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);
		println("totalPriceInPaymentSummaryRounded": totalPriceInPaymentSummaryRounded)

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	//we can use it for revPlus and revPrivate
	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevPlusOrRevPrivate(offAmount, promoCode, promoTitle, type = "promo") {
		gen.swipeDownLoop(2)
		def labItemPriceInCart = cart.getItemPriceInCart();
		println("itemPriceInCart": labItemPriceInCart)

		verifyPromoText("Promo Code Applied");
		def offPrice = verifyPromoAmount(labItemPriceInCart, offAmount, type)

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevPlusOrRevPrivateForLab(labId, offAmount, promoCode, promoTitle) {
		def labDetails = admin.getLabDetailsById(labId)

		def labItemPriceInCart = labDetails.finalPlusMembershipPrice //cart.getItemPriceInCart();
		println("itemPriceInCart": labItemPriceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount


		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(labItemPriceInCart, offPrice)
		println("totalPriceInPaymentSummaryExpected": totalPriceInPaymentSummaryExpected)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		println("totalPriceInPaymentSummary": totalPriceInPaymentSummary)
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForLab(labId, offAmount, promoCode, promoTitle, user = "revone") {
		user = user.toLowerCase()
		def labItemPriceInCart;
		def labDetails = admin.getLabDetailsById(labId)
		if(user == "revone"){
			labItemPriceInCart = labDetails.finalBasicMembershipPrice    //cart.getItemPriceInCart();
		}
		else if(user == "revplus"){
			labItemPriceInCart = labDetails.finalPlusMembershipPrice
		}
		else if(user == "revprivate"){
			labItemPriceInCart = labDetails.finalPrivateMembershipPrice
		}
		println("itemPriceInCart": labItemPriceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(labItemPriceInCart, offPrice)
		println("totalPriceInPaymentSummaryExpected": totalPriceInPaymentSummaryExpected)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		println("totalPriceInPaymentSummary": totalPriceInPaymentSummary)
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		println("totalPriceInPaymentSummaryExpectedRounded":totalPriceInPaymentSummaryExpectedRounded)
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);
		println("totalPriceInPaymentSummaryRounded":totalPriceInPaymentSummaryRounded)
		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInCheckoutPaymentSummaryForRevOne(count) {
		gen.swipeUpLoop(2)
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOnePrices(count) //getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, 'totalPriceInPaymentSummary':totalPriceInPaymentSummary]
	}

	@Keyword
	def verifySinglePromoPriceDetailsInCheckoutPaymentSummaryForRevOne(itemPrice, offAmount, count = 1) {
		gen.swipeUpLoop(2)
		def totalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOnePrices(count) //getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		def actualPrice = cleanAndConvert(totalItemsPriceInPaymentSummary)
		def expectedPrice = cleanAndConvert(itemPrice)
		mbActions.verifyEqual(actualPrice, actualPrice);

		def data = calculatePromoAmountAndReturn(itemPrice, offAmount)
		def offPrice = data.discountAmount

		actualPrice = cleanAndConvert(totalPromoPricesUnderPaymentSummary)
		expectedPrice = cleanAndConvert(offPrice)
		mbActions.verifyEqual(actualPrice, actualPrice);

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPrice,offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
		return ['totalItemsPriceInPaymentSummary':totalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, 'totalPriceInPaymentSummary':totalPriceInPaymentSummary]
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInCheckoutThankYouPaymentSummaryForRevPlusRevPrivate() {
		gen.swipeUpLoop(2)
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded, FailureHandling.CONTINUE_ON_FAILURE);
		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, totalPriceInPaymentSummary: totalPriceInPaymentSummary]
	}

	@Keyword
	def verifySinglePromoPriceDetailsInCheckoutThankYouPaymentSummaryForRevPlusRevPrivate(itemPrice, offAmount) {
		gen.swipeUpLoop(2)
		def totalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		def actualPrice = cleanAndConvert(totalItemsPriceInPaymentSummary)
		def expectedPrice = cleanAndConvert(itemPrice)
		mbActions.verifyEqual(actualPrice, actualPrice);

		def data = calculatePromoAmountAndReturn(itemPrice, offAmount)
		def offPrice = data.discountAmount

		actualPrice = cleanAndConvert(totalPromoPricesUnderPaymentSummary)
		expectedPrice = cleanAndConvert(offPrice)
		mbActions.verifyEqual(actualPrice, actualPrice);

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPrice,offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
		return ['totalItemsPriceInPaymentSummary':totalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, totalPriceInPaymentSummary: totalPriceInPaymentSummary]
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInCheckoutThankYouPaymentSummaryForRevPlusRevPrivateCopy(count) {
		gen.swipeUpLoop(2)
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne(count)
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpected, totalPriceInPaymentSummary);
		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, totalPriceInPaymentSummary: totalPriceInPaymentSummary]
	}

	// Verification for ThankYou and Receipts Screens

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevOne(offAmount, promoCode, promoTitle, index = 1, type = "promo") {
		def labItemPriceInCart = cart.getItemPriceInCart();

		verifyPromoText("Promo Code Applied");
		def offPrice = verifyPromoAmount(labItemPriceInCart, offAmount, index, type)

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice,index, type)

		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}
	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevOneForLab(labId, offAmount, promoCode, promoTitle) {
		def labDetails = admin.getLabDetailsById(labId)

		def labItemPriceInCart = labDetails.finalBasicMembershipPrice


		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice)

		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(labItemPriceInCart, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevPlusOrRevPrivate(offAmount, promoCode, promoTitle) {
		def labItemPriceInCart = cart.getItemPriceInCart();

		verifyPromoText("Promo Code Applied");
		def offPrice = verifyPromoAmount(labItemPriceInCart, offAmount)

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice)

		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevPlusOrRevPrivateForLab(labId, offAmount, promoCode, promoTitle) {
		def labDetails = admin.getLabDetailsById(labId)

		def labItemPriceInCart = labDetails.finalPlusMembershipPrice

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice)

		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(labItemPriceInCart, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}
	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForLab(labId, offAmount, promoCode, promoTitle, user = "revone") {
		user = user.toLowerCase()
		def labItemPriceInCart;
		def labDetails = admin.getLabDetailsById(labId)
		if(user == "revone"){
			labItemPriceInCart = labDetails.finalBasicMembershipPrice    //cart.getItemPriceInCart();
		}
		else if(user == "revplus"){
			labItemPriceInCart = labDetails.finalPlusMembershipPrice
		}
		else if(user == "revprivate"){
			labItemPriceInCart = labDetails.finalPrivateMembershipPrice
		}
		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount
		println('offPrice': offPrice )

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)
		println('totalPrice':totalPrice)
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		mem.verifyTotalPriceElementText(totalPrice)

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(labItemPriceInCart, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutCartItemsByIndex(offAmount, index = 1, type = "promo") {
		def labItemPriceInCart = cart.getItemPriceInCart(index);
		verifyPromoText("Promo Code Applied", index);
		def labItemPriceInCartNumeric = cleanAndConvert(labItemPriceInCart) + ""
		println '----- labItemPriceInCartNumeric = ' + labItemPriceInCartNumeric
		if(offAmount.contains("%")) {
			def itemPrice = labItemPriceInCartNumeric.replace('$','').toDouble();
			def OffPercentage = offAmount.replace('%','').toDouble() * 0.01;
			def promoValue =Math.ceil(itemPrice*OffPercentage).toInteger();
			def discountPrice ="-\$${promoValue}";
			mbActions.verifyElementPresentByText(discountPrice)
			return ['discountPrice':discountPrice]
		}else {
			println("${labItemPriceInCart} and ${offAmount}")
			def discountPrice = verifyPromoAmount(labItemPriceInCart, offAmount, index, type)
			def totalPrice = calculateDifference(labItemPriceInCart, discountPrice)
			mem.verifyTotalPriceElementText(totalPrice, index, type)

			return ['labItemPriceInCart':labItemPriceInCart,'totalPrice':totalPrice, 'discountPrice':discountPrice]
		}
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutCartItemsPricesByIndex(itemPrice, offAmount, index = 1, type = "promo") {
		verifyPromoText("Promo Code Applied", index);

		def data = verifyPromoAmountAndReturn(itemPrice, offAmount, index, type)
		def discountPrice = data.price
		def discountAmount = data.discountAmount

		def totalPrice = calculateDifference(itemPrice, discountAmount)

		mem.verifyTotalPriceElementText(totalPrice, index, type)

		return ['itemPrice':itemPrice,'totalPrice':totalPrice, 'discountPrice':discountPrice]
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutCartItemsByIndexWithoutRoundOff(priceInCart, offAmount, index = 1, type = "promo") {

		verifyPromoText("Promo Code Applied", index);

		def discountPrice = verifyPromoAmount(priceInCart, offAmount, index, type)
		def totalPrice = calculateDifference(priceInCart, discountPrice)

		mem.verifyTotalPriceElementText(totalPrice, index, type)

		return ['priceInCart':priceInCart,'totalPrice':totalPrice, 'discountPrice':discountPrice]
	}

	@Keyword
	def swipeByDeliveryMethodToVerifyMultipleApptPricesInCart(dm, offAmount, index = 1) {
		Mobile.scrollToText(dm, FailureHandling.OPTIONAL)
		//		gen.swipeDownLittle()
		def promoPriceDetailsInCart = verifyPromoPriceDetailsInCheckoutCartItemsByIndex(offAmount, index)
		return promoPriceDetailsInCart
	}

	@Keyword
	def swipeByDeliveryMethodToVerifyMultipleApptPricesInCheckout(dm, offAmount, itemPrice) {
		Mobile.scrollToText(dm, FailureHandling.OPTIONAL)
		gen.swipeDownLittle()
		def promoPriceDetailsInCart = verifyPromoPriceDetailsInCheckoutCartItemsPricesByIndex(itemPrice, offAmount)
		return promoPriceDetailsInCart
	}

	@Keyword
	def verifyPromoNotAppliedInCheckoutCartItemsByIndex(index = 1) {
		def labItemPriceInCart = cart.getItemPriceInCart(index);
		mem.verifyTotalPriceElementText(labItemPriceInCart, index)
		return ['labItemPriceInCart':labItemPriceInCart]
	}

	@Keyword
	def verifyPromoNotAppliedInCheckoutPaymentSummaryByCount(count = 1) {
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne(count)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		Mobile.verifyEqual(toalItemsPriceInPaymentSummary, totalPriceInPaymentSummary, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPromoNotAppliedInCheckoutPaymentSummaryForRevPlusRevPrivate() {
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		Mobile.verifyEqual(toalItemsPriceInPaymentSummary, totalPriceInPaymentSummary, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def getOriginalPriceInPaymentSummary(index = 1) {
		Mobile.scrollToText('Order Total');
		Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/itemPriceNonStrikeAmt_android', ['index': index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevPlus(offAmount, promoCode, promoTitle) {
		def labItemPriceInCart = cart.getItemPriceInCart();
		verifyPromoText("Promo Code Applied");
		verifyPromoAmount(labItemPriceInCart, offAmount);
		def totalPrice = calculateDifference(labItemPriceInCart,offAmount);
		mem.verifyTotalPriceElementText(totalPrice);
		verifyPromoTitleAndCode(promoCode,promoTitle);
		gen.swipeUpLoop(2);
		def itemPriceInPaymentSummary = getOriginalPriceInPaymentSummary();
		verifyPromoCodeInPaymentSummary(promoCode);
		verifyPromoAmountInPaymentSummary(promoCode, offAmount);
		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary,offAmount);
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInThankYouPaymentSummaryForRevOne(count) {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOnePrices(count) //getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevPlus(offAmount, promoCode, promoTitle) {
		def labItemPriceInCart = cart.getItemPriceInCart();

		verifyPromoText("Promo Code Applied");
		def offPrice = verifyPromoAmount(labItemPriceInCart, offAmount);

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice);

		mem.verifyTotalPriceElementText(totalPrice);

		def itemPriceInPaymentSummary = getOriginalPriceInPaymentSummary();

		verifyPromoCodeInPaymentSummary(promoCode);
		verifyPromoAmountInPaymentSummary(promoCode, offPrice);

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice);
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInReceiptsPaymentSummaryForRevPlusRevPrivate() {
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, totalPriceInPaymentSummary: totalPriceInPaymentSummary]
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInReceiptsPaymentSummaryForRevPlusAndRevPrivate(count = 2) {
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummaryByCount(count)

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary, totalPriceInPaymentSummary: totalPriceInPaymentSummary]
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInReceiptsPaymentSummaryForRevOne(count) {
		Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne(count)
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()

		totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
		println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

		def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	//-------------------------------------select a Stripe test clock drop down--------------------------
	@Keyword
	def tapOnSelectAStripeTestClockDropDn() {
		Mobile.scrollToText("Select a stripe test clock", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/StripeTestClock/selectAStripeTestClockDropDn_android'), defaultTime);
	}

	//-------------------------------------close select a Stripe test clock drop down-----------------------

	// Thank you and Recipts Screen promo verifications
	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsPaymentSummaryForRevOne(itemsPrice, promosPrice, totalPrice, count) {
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevOne(count)
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		println(totalPriceInPaymentSummary:totalPriceInPaymentSummary)

		Mobile.verifyEqual(toalItemsPriceInPaymentSummary,itemsPrice, FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.verifyEqual(totalPromoPricesUnderPaymentSummary.totalPriceWithDollar, promosPrice, FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.verifyEqual(totalPriceInPaymentSummary, totalPrice, FailureHandling.CONTINUE_ON_FAILURE);

		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary]
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsPaymentSummaryForRevPlusRevPrivate(itemsPrice, promosPrice, totalPrice) {
		def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
		def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary()
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		println(totalPriceInPaymentSummary:totalPriceInPaymentSummary)

		Mobile.verifyEqual(toalItemsPriceInPaymentSummary,itemsPrice, FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.verifyEqual(totalPromoPricesUnderPaymentSummary.totalPriceWithDollar, promosPrice, FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.verifyEqual(totalPriceInPaymentSummary, totalPrice, FailureHandling.CONTINUE_ON_FAILURE);

		return ['toalItemsPriceInPaymentSummary':toalItemsPriceInPaymentSummary, 'totalPromoPricesUnderPaymentSummary':totalPromoPricesUnderPaymentSummary]
	}

	// ---------- Promo Codes ------
	@Keyword
	def typeInApplyPromoCodeField(text) {
		Mobile.scrollToText('Promo Codes', FailureHandling.OPTIONAL)
		Mobile.sendKeys(findTestObject('Object Repository/Member/Cart/Checkout/PromoCodes/applyPromoCodeField_android'), text)
	}

	@Keyword
	def tapOnApplyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/PromoCodes/applyBtn_android'), defaultTime)
	}

	@Keyword
	def applyPromoCodeAndVerify(text, message = "Promo Code Applied!", onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		typeInApplyPromoCodeField(text)
		tapOnApplyBtn()
		gen.swipeUpLittle();
		Mobile.scrollToText(message);
		mbActions.verifyElementPresentByText(message, onFailure)
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
	def verifyProgramTotalPrice(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/totalPrice_andriod'), value, onFailure)
	}

	@Keyword
	def verifyMembershipPromoAppliedLabelExists(isExists = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExists) {
			return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedLabel_android'), defaultTime, onFailure)
		} else {
			return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedLabel_android'), defaultTime, onFailure)
		}
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
	def getMembershipPromoAppliedValue(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedVal_android'), defaultTime, onFailure)
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
	def verifyMembershipPromoDetailsInCheckoutOld(revplusPrice = '$20/month', offAmount, promoCode, promoTitle) {

		verifyMembershipRegularValue(revplusPrice)

		verifyMembershipPromoAppliedLabel("Promo Code Applied");

		def price = getRevdocPlusMembershipAmt()
		def promoPrice = getPromoCodeAppliedPriceForMemberships()
		println("revPlusPrice": price)
		println("promoPrice": promoPrice)

		def offPrice = verifyRevplusMembershipPromoAmount(price, promoPrice)

		def promotionalRevplusValue = calculateDifference(price, offPrice);
		println("promotionalRevplusValue": promotionalRevplusValue)

		verifyPromoMembershipLabel("Promotional REV+");
		verifyPromoMembershipValue("${promotionalRevplusValue}/month");

		verifyPromoTitleAndCode(promoCode, promoTitle);

		gen.swipeUpLoop(2);
		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary();

		verifyPromoCodeInPaymentSummary(promoCode);
		verifyRevPlusPromoAmountInPaymentSummary(promoCode, offPrice);

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice);
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpected, totalPriceInPaymentSummary);

		return [revPlusPrice: price, promoPrice: promoPrice, discount: offPrice, totalPriceInPaymentSummary: totalPriceInPaymentSummary, promotionalRevplusValue: "${promotionalRevplusValue}/month"]
	}

	@Keyword
	def verifyMembershipPromoDetailsInCheckout(revplusPrice = '$20/month', offAmount, promoCode, promoTitle) {

		verifyMembershipRegularValue(revplusPrice) // verify rev+ actual cost

		verifyMembershipPromoAppliedLabel("Promo Code Applied");

		def price = getRevdocPlusMembershipAmt()
		def promoPrice = getPromoCodeAppliedPriceForMemberships()
		println("revPlusPrice": price)
		println("promoPrice": promoPrice)

		def expectedOffPrice = calculateDiscountAndFinalPrice(revplusPrice, offAmount)
		int expectedOffInt = Double.parseDouble(expectedOffPrice.discountAmountRoundOff + "").toInteger()
		println '----- calculated discount amount = ' + expectedOffInt
		if(! promoPrice.contains(expectedOffInt + "")) {
			KeywordUtil.markFailed("expected discount = " + expectedOffInt + " is not presentin the actual discount = " + promoPrice)
		}

		def offPrice = verifyRevplusMembershipPromoAmount(price, promoPrice) // verify discount cost
		println '----- offPrice = ' + offPrice
		def promotionalRevplusValue = calculateDifference(price, offPrice);
		println("promotionalRevplusValue": promotionalRevplusValue)

		verifyPromoMembershipLabel("Promotional REV+");
		verifyPromoMembershipValue("${promotionalRevplusValue}/month"); // verify final cost

		verifyPromoTitleAndCode(promoCode, promoTitle);

		gen.swipeUpLoop(2);
		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary();
		println '----- itemPriceInPaymentSummary = ' + itemPriceInPaymentSummary
		if(! revplusPrice.contains(itemPriceInPaymentSummary)) {
			KeywordUtil.markFailed("actual item price = " + itemPriceInPaymentSummary + " is not presentin the expected item price = " + revplusPrice)
		}
		verifyPromoCodeInPaymentSummary(promoCode);
		verifyRevPlusPromoAmountInPaymentSummary(promoCode, offPrice);

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice);
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpected, totalPriceInPaymentSummary, FailureHandling.CONTINUE_ON_FAILURE);
		def finalPrice = '$'+expectedOffPrice.finalPrice
		if(finalPrice.endsWith(".00")) {
			finalPrice = finalPrice.replaceAll(".00", "")
		}
		if(! totalPriceInPaymentSummary.contains(finalPrice)) {
			KeywordUtil.markFailed("actual order total = " + totalPriceInPaymentSummary + " is not contains the expected amount = " + finalPrice)
		}
		return [revPlusPrice: price, promoPrice: promoPrice, discount: offPrice, totalPriceInPaymentSummary: totalPriceInPaymentSummary, promotionalRevplusValue: "${promotionalRevplusValue}/month"]
	}

	@Keyword
	def verifyRevplusMembershipPromoAmount(itemPrice, off, index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		def discountAmount;
		if (off.contains('%')) {
			def data = calculatePromoAmountPercentage(itemPrice, off)
			discountAmount = data.discountPrice
		}
		else {
			discountAmount = formatPromoAmount(off)
		}
		def text = extractTextAfterPrice(off)
		def actualPrice = "${discountAmount} ${text}"
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Receipts/memberShips/promoAppliedVal_android'), actualPrice, onFailure)
		return discountAmount
	}

	@Keyword
	def verifyRevplusMembershipPromoDetailsInThankYouAndReceipts(itemPrice, promoPrice, promotionalRevplusValue, promoCode, discountInPaymentSummary, totalPrice) {
		//verifying promo details in Thank you screen and receipts
		verifyMembershipRegularValue(itemPrice)
		//gen.swipeUpLoop(1)
		verifyMembershipPromoAppliedLabel("Promo Code Applied");
		verifyMembershipPromoAppliedValue(promoPrice);
		verifyPromoMembershipLabel("Promotional REV+");
		if(!promotionalRevplusValue.contains('month')) {
			promotionalRevplusValue = "${promotionalRevplusValue}/month"
		}
		verifyPromoMembershipValue(promotionalRevplusValue);

		//gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary();
		verifyPromoCodeInPaymentSummary(promoCode);
		verifyRevPlusPromoAmountInPaymentSummary(promoCode, discountInPaymentSummary);
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		Mobile.verifyEqual(totalPriceInPaymentSummary, totalPrice);
	}

	@Keyword
	def verifyRevplusMembershipDetailsInCheckoutThankYouAndReceipts(itemPrice, yearly = false, isThankYouOrReceipts = false) {
		def offPrice;
		Mobile.delay(5)
		mbActions.verifyElementPresentByText("Rev+ Membership");
		verifyMembershipRegularValue(itemPrice)

		if(verifyMembershipPromoAppliedLabelExists(true, FailureHandling.OPTIONAL, 5) && yearly == false) {
			verifyMembershipRegularLabel('Regular REV+')
			verifyPromoMembershipLabel("Promotional REV+");

			def promoValue = getMembershipPromoAppliedValue();
			offPrice = verifyRevplusMembershipPromoAmount(itemPrice, promoValue)

			def promotionalRevplusValue = calculateDifference(itemPrice, offPrice);
			println("promotionalRevplusValue": promotionalRevplusValue)

			verifyPromoMembershipValue("${promotionalRevplusValue}/month");

			if(isThankYouOrReceipts == false) {
				mbActions.verifyElementPresentByText("Billed Monthly (one year commitment required)");
				gen.swipeUpLoop(2)
			}

			def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary();

			def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice);
			def totalPriceInPaymentSummary = getOrderTotalAmount();

			Mobile.verifyEqual(totalPriceInPaymentSummaryExpected, totalPriceInPaymentSummary,  FailureHandling.CONTINUE_ON_FAILURE);
		} else {
			verifyMembershipRegularLabel('REV+')
			verifyPromoMembershipLabel("Total");
			verifyPromoMembershipValue(itemPrice);

			if(isThankYouOrReceipts == false) {
				yearly == false ? mbActions.verifyElementPresentByText("Billed Monthly (one year commitment required)"): mbActions.verifyElementPresentByText("Billed Yearly (one year commitment required)");
				gen.swipeUpLoop(2)
			}

			mbActions.verifyElementPresentByText('Payment Summary');

			def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary();
			def totalPriceInPaymentSummary = getOrderTotalAmount();

			def amount = yearly == false ? itemPrice.replaceAll(/\/month$/, '') : itemPrice.replaceAll(/\/year$/, '')

			def amountWithoutDecimals = amount;
			if (amount.endsWith(".00")) {
				amountWithoutDecimals = amount.replace(".00", "")
			}

			Mobile.verifyEqual(itemPriceInPaymentSummary, amountWithoutDecimals, FailureHandling.CONTINUE_ON_FAILURE)
			Mobile.verifyEqual(totalPriceInPaymentSummary, amount, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	@Keyword
	def verifyRevplusMembershipDetailsInThankYouAndReceipts(itemName = "Rev+ Membership", itemPrice, totalPrice, paymentSummaryPrice) {
		mbActions.verifyElementPresentByText(itemName);
		verifyMembershipRegularValue(itemPrice)
		verifyMembershipRegularLabel('REV+')
		verifyPromoMembershipLabel("Total");
		verifyPromoMembershipValue(totalPrice);
		mbActions.verifyElementPresentByText('Payment Summary');

		def itemPriceInPaymentSummary = getApptPriceUnderPaymentSummary();
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		Mobile.verifyEqual(itemPriceInPaymentSummary, paymentSummaryPrice, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyEqual(totalPriceInPaymentSummary, paymentSummaryPrice, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyOrderSummaryMembershipPromoDetailsInCheckout(revplusPrice = '$20.00/month', offAmount, promoCode, promoTitle) {
		def price = getRevdocPlusMembershipAmt()
		def promoPrice = getPromoCodeAppliedPriceForMemberships()
		println("revPlusPrice": price)
		println("promoPrice": promoPrice)

		verifyMembershipRegularValue(revplusPrice)
		verifyMembershipPromoAppliedLabel("Promo Code Applied");

		def offPrice = verifyRevplusMembershipPromoAmount(price, offAmount)

		def promotionalRevplusValue = calculateDifference(price, offPrice);
		println("promotionalRevplusValue": promotionalRevplusValue)

		verifyPromoMembershipLabel("Promotional REV+");
		verifyPromoMembershipValue("${promotionalRevplusValue}/month");

		return [revPlusPrice: price, promoPrice: promoPrice, discount: offPrice, promotionalRevplusValue: "${promotionalRevplusValue}/month"]
	}

	// ---------- End Memberships -------------

	//At Home Labs Price verification in checkout and reciepts
	@Keyword
	def verifyMultipleAtHomelabsPriceVerificationOnCheckoutAndReciept(offAmount, count, promoCode, discount1, discount2) {
		for(int i = 0 ; i < count ; i++) {
			verifyPromoPriceDetailsInCheckoutCartItemsByIndex(offAmount, count);
		}
		verifyMultiplePromoPriceDetailsInReceiptsPaymentSummaryForRevOne(count);
		verifyPromoCodeAndAmountInPaymentSummary(promoCode, discount1, 1);
		verifyPromoCodeAndAmountInPaymentSummary(promoCode, discount2, 2);
	}

	@Keyword
	def verifyProgramDetailsInCartOrderAndPaymentSummary(user = 'revone', programName, rev1Price, revplusOrRevPrivatePrice, index = 1, hasMOLabelInPrice = true) {
		println(rev1Price:rev1Price)
		println(revplusOrRevPrivatePrice:revplusOrRevPrivatePrice)

		def actualRev1Price =  rev1Price.contains('$0') ? '0' : String.format("%,.2f", cleanAndConvert(rev1Price))
		def actualrevplusOrRevPrivatePrice = revplusOrRevPrivatePrice.contains('$0') ? '0' : String.format("%,.2f", cleanAndConvert(revplusOrRevPrivatePrice))
		Mobile.comment("actualRev1Price: ${actualRev1Price}")
		Mobile.comment("actualrevplusOrRevPrivatePrice: ${actualrevplusOrRevPrivatePrice}")

		user = user.toLowerCase()
		def itemName = getApptItemName(index)
		def itemPrice = cart.getItemPriceInCart(index);
		def upgradeToRevPlusPrice;
		def itemPrice1 = cleanAndConvert(itemPrice)
		def formattedNumber = String.format("%,.2f", itemPrice1)
		def itemDollarPrice =  '$' + formattedNumber
		Mobile.comment("itemDollarPrice: ${itemDollarPrice}")
		def itemDollarPriceRounded = gen.formatAndRoundPriceValue(itemDollarPrice);
		def revplusOrRevPrivatePriceRounded = gen.formatAndRoundPriceValue(revplusOrRevPrivatePrice);
		revplusOrRevPrivatePriceRounded = gen.formatAmountWithCommas(revplusOrRevPrivatePriceRounded);

		def rev1PriceRounded = gen.formatAndRoundPriceValue(rev1Price);
		rev1PriceRounded = gen.formatAmountWithCommas(rev1PriceRounded);

		Mobile.verifyEqual(itemName, programName);
		if (user == "revone") {
			upgradeToRevPlusPrice = getUpgradeToRevPlusAndPayPriceFromProcedureCardForRev1User(index)
			if (!hasMOLabelInPrice) {
				mbActions.verifyEqual(upgradeToRevPlusPrice.dollarValue, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			} else {
				mbActions.verifyEqual(upgradeToRevPlusPrice.dollarValue, "${revplusOrRevPrivatePriceRounded}/mo", FailureHandling.CONTINUE_ON_FAILURE);
			}
		}

		if (!hasMOLabelInPrice) {
			user != 'revone' ? mbActions.verifyEqual(itemPrice, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE) : mbActions.verifyEqual(itemPrice, rev1PriceRounded, FailureHandling.CONTINUE_ON_FAILURE)
		} else  {
			user != 'revone' ? mbActions.verifyEqual(itemPrice, "${revplusOrRevPrivatePriceRounded}/mo", FailureHandling.CONTINUE_ON_FAILURE) : mbActions.verifyEqual(itemPrice, "${rev1PriceRounded}/mo", FailureHandling.CONTINUE_ON_FAILURE)
		}

		mem.verifyTotalPriceElementText(itemPrice, index)

		// Verify prices in payment Summary
		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = user != 'revone' ? getRevPlusApptPriceUnderPaymentSummary(index) : getApptPriceUnderPaymentSummary(index);
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		if (user == 'revone') {
			mbActions.verifyEqual(itemPriceInPaymentSummary, rev1PriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualRev1Price, FailureHandling.CONTINUE_ON_FAILURE);
		} else {
			mbActions.verifyEqual(itemPriceInPaymentSummary, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualrevplusOrRevPrivatePrice, FailureHandling.CONTINUE_ON_FAILURE);
		}

		return [itemDiscountPrice: itemPrice, itemDollarPrice: itemDollarPrice, upgradeToRevPlusPrice: upgradeToRevPlusPrice]
	}

	@Keyword
	def verifyProgramDetailsInCartOrderSummary(user = 'revone', programName, rev1Price, revplusOrRevPrivatePrice, index = 1) {
		user = user.toLowerCase()
		def itemName = getApptItemName(index)
		def itemPrice = cart.getItemPriceInCart(index);
		def upgradeToRevPlusPrice;
		def revplusOrRevPrivatePriceRounded = gen.formatAndRoundPriceValue(revplusOrRevPrivatePrice);
		def rev1PriceRounded = gen.formatAndRoundPriceValue(rev1Price);

		def itemDollarPrice =  '$' + cleanAndConvert(itemPrice)
		Mobile.comment("itemDollarPrice: ${itemDollarPrice}")

		Mobile.verifyEqual(itemName, programName);
		if (user == "revone") {
			upgradeToRevPlusPrice = getUpgradeToRevPlusAndPayPriceFromProcedureCardForRev1User(index)
			Mobile.verifyEqual(upgradeToRevPlusPrice.dollarValue, revplusOrRevPrivatePriceRounded);
		}

		user != 'revone' ? Mobile.verifyEqual(itemPrice, revplusOrRevPrivatePriceRounded) : Mobile.verifyEqual(itemPrice, rev1PriceRounded)
		mem.verifyTotalPriceElementText(itemPrice, index)

		return [itemDiscountPrice: itemPrice, itemDollarPrice: itemDollarPrice, upgradeToRevPlusPrice: upgradeToRevPlusPrice]
	}

	@Keyword
	def verifyProgramDetailsInThankYouAndReceiptsForOrderAndPaymentSummary(user = 'revone', programName, rev1Price, revplusOrRevPrivatePrice, index = 1,  hasMOLabelInPrice = true) {
		def actualRev1Price =  rev1Price.contains('$0') ? '0' : String.format("%,.2f", cleanAndConvert(rev1Price))
		def actualrevplusOrRevPrivatePrice = revplusOrRevPrivatePrice.contains('$0') ? '0' : String.format("%,.2f", cleanAndConvert(revplusOrRevPrivatePrice))
		Mobile.comment("actualRev1Price: ${actualRev1Price}")
		Mobile.comment("actualrevplusOrRevPrivatePrice: ${actualrevplusOrRevPrivatePrice}")

		user = user.toLowerCase()
		mbActions.verifyElementPresentByText(programName, FailureHandling.CONTINUE_ON_FAILURE)
		def itemPrice = cart.getItemPriceInCart(index);

		def itemPrice1 = cleanAndConvert(itemPrice)
		def formattedNumber = String.format("%,.2f", itemPrice1)
		def itemDollarPrice =  '$' + formattedNumber
		Mobile.comment("itemDollarPrice: ${itemDollarPrice}")
		def itemDollarPriceRounded = gen.formatAndRoundPriceValue(itemDollarPrice);
		def revplusOrRevPrivatePriceRounded = gen.formatAndRoundPriceValue(revplusOrRevPrivatePrice);
		revplusOrRevPrivatePriceRounded = gen.formatAmountWithCommas(revplusOrRevPrivatePriceRounded);

		def rev1PriceRounded = gen.formatAndRoundPriceValue(rev1Price);
		rev1PriceRounded = gen.formatAmountWithCommas(rev1PriceRounded);

		if (!hasMOLabelInPrice) {
			user != 'revone' ? mbActions.verifyEqual(itemPrice, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE) : mbActions.verifyEqual(itemPrice, rev1PriceRounded, FailureHandling.CONTINUE_ON_FAILURE)
		} else  {
			user != 'revone' ? mbActions.verifyEqual(itemPrice, "${revplusOrRevPrivatePriceRounded}/mo", FailureHandling.CONTINUE_ON_FAILURE) : mbActions.verifyEqual(itemPrice, "${rev1PriceRounded}/mo", FailureHandling.CONTINUE_ON_FAILURE)
		}
		mem.verifyTotalPriceElementText(itemPrice, index)

		// Verify prices in payment Summary
		def itemPriceInPaymentSummary = user != 'revone' ? getRevPlusApptPriceUnderPaymentSummary(index) : getApptPriceUnderPaymentSummary(index);
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		if (user == 'revone') {
			mbActions.verifyEqual(itemPriceInPaymentSummary, rev1PriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualRev1Price, FailureHandling.CONTINUE_ON_FAILURE);
		} else {
			if(res.verifyReciptsScreenTitle("Receipts", true, FailureHandling.OPTIONAL, 10)) {
				revplusOrRevPrivatePriceRounded = "${revplusOrRevPrivatePriceRounded}/mo"
				mbActions.verifyEqual(itemPriceInPaymentSummary, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			} else {
				mbActions.verifyEqual(itemPriceInPaymentSummary, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			}
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualrevplusOrRevPrivatePrice, FailureHandling.CONTINUE_ON_FAILURE);
		}

		return [itemDiscountPrice: itemPrice, itemDollarPrice: itemDollarPrice]
	}

	@Keyword
	def verifyProgramDetailsInThankYouAndReceiptsForOrderSummary(user = 'revone', programName, rev1Price, revplusOrRevPrivatePrice, index = 1) {
		user = user.toLowerCase()
		mbActions.verifyElementPresentByText(programName, FailureHandling.CONTINUE_ON_FAILURE)
		def itemPrice = cart.getItemPriceInCart(index);

		def itemDollarPrice =  '$' + cleanAndConvert(itemPrice)
		Mobile.comment("itemDollarPrice: ${itemDollarPrice}")
		def revplusOrRevPrivatePriceRounded = gen.formatAndRoundPriceValue(revplusOrRevPrivatePrice);
		def rev1PriceRounded = gen.formatAndRoundPriceValue(rev1Price);

		user != 'revone' ? Mobile.verifyEqual(itemPrice, revplusOrRevPrivatePriceRounded) : Mobile.verifyEqual(itemPrice, rev1PriceRounded)
		mem.verifyTotalPriceElementText(itemPrice, index)
		return [itemDiscountPrice: itemPrice, itemDollarPrice: itemDollarPrice]
	}

	@Keyword
	def getProgramPromoPricesFromCheckoutSummaryAndVerify(user, offAmount, itemsCount, promoCodeType, promoCode, promoName) {
		def pricesFromCheckoutSummary;
		def data = verifyPromoPriceDetailsInCheckoutCartItemsByIndex(offAmount, itemsCount, promoCodeType)
		verifyPromoTitleAndCode(promoCode, promoName, 1)
		if(user == "Revone") {
			pricesFromCheckoutSummary = verifyMultiplePromoPriceDetailsInCheckoutPaymentSummaryForRevOne(itemsCount)

		}
		else {
			pricesFromCheckoutSummary = verifyMultiplePromoPriceDetailsInCheckoutThankYouPaymentSummaryForRevPlusRevPrivate()
		}
		def itemsPrice = pricesFromCheckoutSummary.toalItemsPriceInPaymentSummary
		def discountPrice = pricesFromCheckoutSummary.totalPromoPricesUnderPaymentSummary
		def totalPrice = pricesFromCheckoutSummary.totalPriceInPaymentSummary
		gen.swipeUp();
		verifyPromoCodeAndAmountInPaymentSummary(promoCode, data.discountPrice, 1);

		return [itemsPrice : itemsPrice, discountPrice: discountPrice, totalPrice: totalPrice]
	}

	@Keyword
	def getProgramPromoPricesFromCheckoutSummaryAndVerifyPrices(user, itemPrice, offAmount, itemsCount, promoCodeType, promoCode, promoName) {
		def pricesFromCheckoutSummary;
		def data = verifyPromoPriceDetailsInCheckoutCartItemsPricesByIndex(itemPrice, offAmount, itemsCount, promoCodeType)
		verifyPromoTitleAndCode(promoCode, promoName, 1)
		if(user == "Revone") {
			pricesFromCheckoutSummary = verifySinglePromoPriceDetailsInCheckoutPaymentSummaryForRevOne(itemPrice, offAmount, itemsCount)

		}
		else {
			pricesFromCheckoutSummary = verifySinglePromoPriceDetailsInCheckoutThankYouPaymentSummaryForRevPlusRevPrivate(itemPrice, offAmount)
		}
		def itemsPrice = pricesFromCheckoutSummary.totalItemsPriceInPaymentSummary
		def discountPrice = pricesFromCheckoutSummary.totalPromoPricesUnderPaymentSummary
		def totalPrice = pricesFromCheckoutSummary.totalPriceInPaymentSummary
		gen.swipeUp();
		verifyPromoCodeAndAmountInPaymentSummary(promoCode, data.discountPrice, 1);

		return [itemsPrice : itemsPrice, discountPrice: discountPrice, totalPrice: totalPrice]
	}

	@Keyword
	def verifyProgramPromoPricesInThankyouAndReceipts(user, itemsPrice, discountPrice, totalPrice, count) {
		user == "Revone" ? verifyPromoPriceDetailsInThankYouReceiptsPaymentSummaryForRevOne(itemsPrice, discountPrice, totalPrice, count) : verifyPromoPriceDetailsInThankYouReceiptsPaymentSummaryForRevPlusRevPrivate(itemsPrice, discountPrice, totalPrice)
	}

	@Keyword
	def getCartItemDateAndTime() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/getCartItemDateAndTime_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def getRevcashApplied() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/RevCash/revcashApplied_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}


	//Affiliation prices verification in checkout

	@Keyword
	def verifyAffiliationDetailsInCartOrderAndPaymentSummary(user = 'revone', programName, rev1Price, revplusOrRevPrivatePrice, index = 1) {
		println(rev1Price:rev1Price)
		println(revplusOrRevPrivatePrice:revplusOrRevPrivatePrice)

		def actualRev1Price  =  String.format("%,.2f", cleanAndConvert(rev1Price))
		def actualrevplusOrRevPrivatePrice = String.format("%,.2f", cleanAndConvert(revplusOrRevPrivatePrice))
		Mobile.comment("actualRev1Price: ${actualRev1Price}")
		Mobile.comment("actualrevplusOrRevPrivatePrice: ${actualrevplusOrRevPrivatePrice}")

		user = user.toLowerCase()
		def itemName = getApptItemName(index)
		def itemPrice = cart.getItemPriceInCart(index);
		def upgradeToRevPlusPrice;
		def itemPrice1 = cleanAndConvert(itemPrice)
		def formattedNumber = String.format("%,.2f", itemPrice1)
		def itemDollarPrice =  '$' + formattedNumber
		Mobile.comment("itemDollarPrice: ${itemDollarPrice}")
		def itemDollarPriceRounded = gen.formatAndRoundPriceValue(itemDollarPrice);
		def revplusOrRevPrivatePriceRounded = gen.formatAndRoundPriceValue(revplusOrRevPrivatePrice);
		def rev1PriceRounded = gen.formatAndRoundPriceValue(rev1Price);

		Mobile.verifyEqual(itemName, programName);
		if (user == "revone") {
			upgradeToRevPlusPrice = getUpgradeToRevPlusAndPayPriceFromProcedureCardForRev1User(index)
			mbActions.verifyEqual(upgradeToRevPlusPrice.dollarValue, "${revplusOrRevPrivatePriceRounded}", FailureHandling.CONTINUE_ON_FAILURE);
		}

		user != 'revone' ? mbActions.verifyEqual(itemPrice, "${revplusOrRevPrivatePriceRounded}") : mbActions.verifyEqual(itemPrice, "${rev1PriceRounded}", FailureHandling.CONTINUE_ON_FAILURE)
		mem.verifyTotalPriceElementText(itemPrice, index)

		// Verify prices in payment Summary
		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = user != 'revone' ? getRevPlusApptPriceUnderPaymentSummary(index) : getApptPriceUnderPaymentSummary(index);
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		if (user == 'revone') {
			mbActions.verifyEqual(itemPriceInPaymentSummary, rev1PriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualRev1Price, FailureHandling.CONTINUE_ON_FAILURE);
		} else {
			mbActions.verifyEqual(itemPriceInPaymentSummary, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualrevplusOrRevPrivatePrice, FailureHandling.CONTINUE_ON_FAILURE);
		}

		return [itemDiscountPrice: itemPrice, itemDollarPrice: itemDollarPrice, upgradeToRevPlusPrice: upgradeToRevPlusPrice]
	}

	@Keyword
	def verifyAffiliationDetailsInThankYouAndReceiptsForOrderAndPaymentSummary(user = 'revone', programName, rev1Price, revplusOrRevPrivatePrice, index = 1) {
		def actualRev1Price  =  String.format("%,.2f", cleanAndConvert(rev1Price))
		def actualrevplusOrRevPrivatePrice = String.format("%,.2f", cleanAndConvert(revplusOrRevPrivatePrice))
		Mobile.comment("actualRev1Price: ${actualRev1Price}")
		Mobile.comment("actualrevplusOrRevPrivatePrice: ${actualrevplusOrRevPrivatePrice}")

		user = user.toLowerCase()
		mbActions.verifyElementPresentByText(programName, FailureHandling.CONTINUE_ON_FAILURE)
		def itemPrice = cart.getItemPriceInCart(index);

		def itemPrice1 = cleanAndConvert(itemPrice)
		def formattedNumber = String.format("%,.2f", itemPrice1)
		def itemDollarPrice =  '$' + formattedNumber
		Mobile.comment("itemDollarPrice: ${itemDollarPrice}")
		def itemDollarPriceRounded = gen.formatAndRoundPriceValue(itemDollarPrice);
		def revplusOrRevPrivatePriceRounded = gen.formatAndRoundPriceValue(revplusOrRevPrivatePrice);
		def rev1PriceRounded = gen.formatAndRoundPriceValue(rev1Price);

		user != 'revone' ? mbActions.verifyEqual(itemPrice, "${revplusOrRevPrivatePriceRounded}", FailureHandling.CONTINUE_ON_FAILURE) : mbActions.verifyEqual(itemPrice, "${rev1PriceRounded}", FailureHandling.CONTINUE_ON_FAILURE)
		mem.verifyTotalPriceElementText(itemPrice, index)

		// Verify prices in payment Summary
		def itemPriceInPaymentSummary = user != 'revone' ? getRevPlusApptPriceUnderPaymentSummary(index) : getApptPriceUnderPaymentSummary(index);
		def totalPriceInPaymentSummary = getOrderTotalAmount();

		if (user == 'revone') {
			mbActions.verifyEqual(itemPriceInPaymentSummary, rev1PriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualRev1Price, FailureHandling.CONTINUE_ON_FAILURE);
		} else {
			mbActions.verifyEqual(itemPriceInPaymentSummary, revplusOrRevPrivatePriceRounded, FailureHandling.CONTINUE_ON_FAILURE);
			mbActions.verifyEqual(totalPriceInPaymentSummary,  '$' + actualrevplusOrRevPrivatePrice, FailureHandling.CONTINUE_ON_FAILURE);
		}

		return [itemDiscountPrice: itemPrice, itemDollarPrice: itemDollarPrice]
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutPaymentSummaryForSingleItem(boolean isRevOne, itemPrice, offAmount, promoCode, promoTitle) {

		def expectedItemPriceRoundOff = gen.formatAndRoundPriceValue(itemPrice + "");
		println 'expectedItemPriceRoundOff = ' + expectedItemPriceRoundOff

		//Verify promo details in promo code accordion
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)

		def actualItemPriceInPaymentSummary = isRevOne ? getApptPriceUnderPaymentSummary() : getRevPlusApptPriceUnderPaymentSummary()
		println 'actualItemPriceInPaymentSummary = ' + actualItemPriceInPaymentSummary

		verifyPromoCodeInPaymentSummary(promoCode)

		def offPrice = calculateDiscountAndFinalPrice(itemPrice, offAmount)

		verifyPromoAmountInPaymentSummary(promoCode, offPrice.discountAmountRoundOff)

		def expectedTotalPriceInPaymentSummary = offPrice.finalPrice
		if (expectedTotalPriceInPaymentSummary instanceof String) {
			expectedTotalPriceInPaymentSummary = expectedTotalPriceInPaymentSummary.endsWith(".00") ? expectedTotalPriceInPaymentSummary.toDouble().toInteger() : expectedTotalPriceInPaymentSummary.toDouble()
		} else if (expectedTotalPriceInPaymentSummary instanceof Double) {
			expectedTotalPriceInPaymentSummary = expectedTotalPriceInPaymentSummary % 1 == 0 ? expectedTotalPriceInPaymentSummary.toInteger() : expectedTotalPriceInPaymentSummary
		}
		def actualTotalPriceInPaymentSummary = getOrderTotalAmount().trim()

		println 'actualTotalPriceInPaymentSummary = ' + actualTotalPriceInPaymentSummary

		Mobile.verifyEqual(actualItemPriceInPaymentSummary, expectedItemPriceRoundOff, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyEqual(actualTotalPriceInPaymentSummary, '$' + expectedTotalPriceInPaymentSummary, FailureHandling.STOP_ON_FAILURE)

		def discountPrice =  convertPriceToNegativedDollarString(offPrice.discountAmountRoundOff)

		return [itemPriceInPaymentSummary: expectedItemPriceRoundOff, discountPriceRoundOff: discountPrice, orderTotal: actualTotalPriceInPaymentSummary]
	}

	@Keyword
	def verifyThankYouReceiptsPromoPriceDetails(isRevOne, expectedItemPriceInPaymentSummary, discountAmount, expectedOrderTotal, promoCode) {

		if(mbActions.verifyElementNotPresentByText("Order Total", FailureHandling.OPTIONAL)) {
			gen.swipeUp()
		}

		verifyPromoCodeInPaymentSummary(promoCode)

		verifyPromoAmountInPaymentSummary(promoCode, discountAmount);

		def actualItemPriceInPaymentSummary = isRevOne ? getApptPriceUnderPaymentSummary() : getRevPlusApptPriceUnderPaymentSummary()

		def actualTotalPriceInPaymentSummary = getOrderTotalAmount().trim()

		Mobile.verifyEqual(actualTotalPriceInPaymentSummary, expectedOrderTotal)

		Mobile.verifyEqual(actualItemPriceInPaymentSummary, expectedItemPriceInPaymentSummary, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnPaymentPopupCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/paymentPopupCloseBtn_android'), defaultTime);
	}

	@Keyword
	def verifyPaymentPopupCloseBtn(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/paymentPopupCloseBtn_android'), defaultTime, onFailure)
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/Checkout/paymentPopupCloseBtn_android'), defaultTime, onFailure)
		}
	}

	@Keyword
	def extractTextAfterPrice(input) {

		String inputStr = input.toString()

		def matcher = (inputStr =~ /-?\$?\d+(\.\d+)?\s*(.*)/)

		// Check if the matcher found a valid price and text after it
		if (matcher.find()) {
			return matcher.group(2).trim() // Return the text after the price
		} else {
			return ""
		}
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevPlusOrRevPrivateForProcedure(procedureId, offAmount, promoCode, promoTitle) {
		//		def procedureId  = admin.getProcedureIdByName(procedureName)
		def procedureDetails = admin.getProcedureById(procedureId)

		def labItemPriceInCart = procedureDetails.finalPrice //cart.getItemPriceInCart();
		println("itemPriceInCart": labItemPriceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevPlusOrRevPrivatePrice(priceInCart, offAmount, promoCode, promoTitle) {
		println("priceInCart": priceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(priceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(priceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, offPrice)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInCheckoutForRevPlusOrRevPrivatePriceProgram(priceInCart, offAmount, promoCode, promoTitle) {
		println("priceInCart": priceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(priceInCart, offAmount, 1, 'prog')
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(priceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice, 1 , 'prog')
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)
		def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, offPrice)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);
		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevPlusOrRevPrivateForProcedure(procedureId, offAmount, promoCode, promoTitle) {
		//		def procedureId  = admin.getProcedureIdByName(procedureName)
		def procedureDetails = admin.getProcedureById(procedureId)

		def labItemPriceInCart = procedureDetails.finalPrice

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(labItemPriceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(labItemPriceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice)

		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(itemPriceInPaymentSummary, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevPlusOrRevPrivatePrice(priceInCart, offAmount, promoCode, promoTitle) {
		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(priceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(priceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice)

		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForRevPlusOrRevPrivatePriceProgram(priceInCart, offAmount, promoCode, promoTitle) {
		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(priceInCart, offAmount, 1, 'prog')
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(priceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice, 1, 'prog')

		def itemPriceInPaymentSummary = getRevPlusApptPriceUnderPaymentSummary()

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded);
	}

	@Keyword
	def calculateTwoPricesDifference(rev1Price, revplusOrRevPrivatePrice) {
		println(rev1Price:rev1Price)
		println(revplusOrRevPrivatePrice:revplusOrRevPrivatePrice)

		double basic = rev1Price instanceof String ? Double.parseDouble(rev1Price) : rev1Price as double
		double plus = revplusOrRevPrivatePrice instanceof String ? Double.parseDouble(revplusOrRevPrivatePrice) : revplusOrRevPrivatePrice as double

		double priceDifference = Math.abs(basic - plus)
		double roundedDifference = Math.round(priceDifference * 100) / 100.0
		println(roundedDifference:roundedDifference)

		return roundedDifference
	}

	@Keyword
	def verifyMultiplePromoPriceDetailsInCheckoutThankYouAndReceiptsScreens(priceInCart, offAmount = "", count = 2) {

		if (offAmount.contains("%")) {
			Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);

			def toalItemsPriceInPaymentSummary = getMultipleItemsTotalPriceInCheckoutPaymentSummaryRevPlus()
			def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummaryByCount(count)

			totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
			println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

			def totalPriceInPaymentSummaryExpected = calculateDifference(toalItemsPriceInPaymentSummary,totalPromoPricesUnderPaymentSummary)

			def totalPriceInPaymentSummary = getOrderTotalAmount();
			double tolerance = 1.0

			// Remove currency symbols and convert to double for comparison
			double actual = Double.parseDouble(totalPriceInPaymentSummaryExpected.replace('$', ''))
			double expected = Double.parseDouble(totalPriceInPaymentSummary.replace('$', ''))

			// Verify within the tolerance range
			if (Math.abs(actual - expected) <= tolerance) {
				KeywordUtil.markPassed("The total prices are within the \$1 tolerance range.")
			} else {
				KeywordUtil.markFailedAndStop("Actual price '\$${totalPrice}' and expected price '\$${totalPriceInPaymentSummary}' differ by more than \$1.")
			}

		}else {
			Mobile.scrollToText("Order Total", FailureHandling.OPTIONAL);
			def totalPromoPricesUnderPaymentSummary = getListOfPromoCodePricesUnderPaymentSummary();

			totalPromoPricesUnderPaymentSummary = "\$${totalPromoPricesUnderPaymentSummary.totalSum}"
			println(totalPromoPricesUnderPaymentSummary:totalPromoPricesUnderPaymentSummary)

			def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, totalPromoPricesUnderPaymentSummary)
			totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
			def totalPriceInPaymentSummary = getOrderTotalAmount();
			def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
			def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

			Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded, FailureHandling.CONTINUE_ON_FAILURE);
		}
	}

	@Keyword
	def verifySendGiftCardPrice(price) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/Checkout/sendGiftCardTotalPrice_andriod'), price, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def	verifyPromoPriceDetailsInCheckoutForAllUsers(userType = 'revone', priceInCart, offAmount, promoCode, promoTitle, index = 1) {
		println("priceInCart": priceInCart)

		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(priceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(priceInCart, offPrice)
		totalPrice = "${totalPrice}"
		println("totalPrice": totalPrice)

		mem.verifyTotalPriceElementText(totalPrice)
		verifyPromoTitleAndCode(promoCode, promoTitle)

		gen.swipeUpLoop(2)
		def itemPriceInPaymentSummary = userType != 'revone' ? getRevPlusApptPriceUnderPaymentSummary(index) : getApptPriceUnderPaymentSummary(index);

		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, offPrice)
		totalPriceInPaymentSummaryExpected = "${totalPriceInPaymentSummaryExpected}"
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyPromoPriceDetailsInThankYouReceiptsForAllUsers(userType = 'revOne', priceInCart, offAmount, promoCode, promoTitle, index = 1) {
		verifyPromoText("Promo Code Applied");
		def data = verifyPromoAmountAndReturn(priceInCart, offAmount)
		def offPrice = data.discountAmount

		def totalPrice = calculateDifference(priceInCart, offPrice)

		mem.verifyTotalPriceElementText(totalPrice)

		def itemPriceInPaymentSummary = userType != 'revone' ? getRevPlusApptPriceUnderPaymentSummary(index) : getApptPriceUnderPaymentSummary(index);
		verifyPromoCodeInPaymentSummary(promoCode)
		verifyPromoAmountInPaymentSummary(promoCode, offPrice)

		def totalPriceInPaymentSummaryExpected = calculateDifference(priceInCart, offPrice)
		def totalPriceInPaymentSummary = getOrderTotalAmount();
		def totalPriceInPaymentSummaryExpectedRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummaryExpected);
		def totalPriceInPaymentSummaryRounded = gen.formatAndRoundPriceValue(totalPriceInPaymentSummary);

		Mobile.verifyEqual(totalPriceInPaymentSummaryExpectedRounded, totalPriceInPaymentSummaryRounded, FailureHandling.CONTINUE_ON_FAILURE);
	}

}
