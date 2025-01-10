package provider360

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
import providerRegistration.CreditCard

import internal.GlobalVariable

public class OrderSupplies {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	CreditCard card = new CreditCard()

	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	@Keyword
	def clickOnOrderSuppliesOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSuppliesOption_android'), defaultTime);
	}

	@Keyword
	def clickOnOrderSuppliesAutoSearchField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/autoSearchSuppliesField_android'), defaultTime);
	}

	@Keyword
	def getTextOfFirstOrderSupply() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/firstOrderSuppliesName_andriod'), defaultTime);
	}

	@Keyword
	def getCostOfFirstOrderSupply() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/firstOrderSupplieCost_android'), defaultTime);
	}

	@Keyword
	def getPriceOfSearchedOrderSupply(text) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/searchedOrderSuppliePrice_android',['text':text]), defaultTime);
	}

	@Keyword
	def enterTextInAutoSearchSuppliesField(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/autoSearchSuppliesField_android'), txt, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyAutoSearchedSupply(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/autoSearchedOption_android',["value":txt]), defaultTime);
	}

	@Keyword
	def verifyAutoSearchedSupplyNotExist(txt, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/autoSearchedOption_android',["value":txt]), defaultTime, OnFailure);
	}

	@Keyword
	def clickOnOrderSuppliesInfoIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSuppliesInfoIcon_android'), defaultTime);
	}

	@Keyword
	def verifyOrderSuppliesInfoPopup(supplyName) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/bottomSheetTitle_android'), supplyName)
	}

	@Keyword
	def verifyCloseBtnOnInfoPopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/closeInfoPopup_android'), defaultTime);
	}

	@Keyword
	def clickOnCloseBtnOnInfoPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/closeInfoPopup_android'), defaultTime);
	}

	@Keyword
	def verifyInfoPopupTitleAbsence() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/bottomSheetTitle_android'), defaultTime);
	}

	@Keyword
	def verifyOrderSuppliesTab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSuppliesTab_android'), defaultTime);
	}

	@Keyword
	def tapOnOrderSuppliesTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSuppliesTab_android'), defaultTime);
	}

	@Keyword
	def verifyOrderSuppliesTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSuppliesTitle_android'), defaultTime);
	}

	@Keyword
	def verifySearchSupplies() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/searchSupplies_android'), defaultTime);
	}

	@Keyword
	def verifyBuyNowBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/buyNowBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddToCartBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/addToCartBtn_android'), defaultTime);
	}

	@Keyword
	def verifyCartIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/cartIcon_android'), defaultTime);
	}

	@Keyword
	def verifyPastOrdersTab() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/pastOrdersTab_android'), defaultTime);
	}

	@Keyword
	def tapOnPastOrdersTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/pastOrdersTab_android'), defaultTime);
	}

	@Keyword
	def verifyPastOrdersTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/pastOrdersTitle_android'), defaultTime);
	}

	@Keyword
	def verifySearchPastOrders() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/searchPastOrders_android'), defaultTime);
	}

	@Keyword
	def tapOnPlusBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/plusBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnMinusBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/minusBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAddToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/addToCartBtn_android'), defaultTime);
	}

	@Keyword
	def verifyOrderQuantity(number) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderQuantity_android',['number': number]), defaultTime, onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderQuantity_android',['number': number]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/buyNowBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAddItemPlus() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/addItemPlus_'+os),defaultTime );
	}

	@Keyword
	def tapOnProceedToCheckOutBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/ProceedToCheckOutBtn_'+os),defaultTime, onFailure);
	}

	@Keyword
	def verifyPlaceOrderPageTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyOrders/placeOrderPageTitle_android'), defaultTime);
	}

	@Keyword
	def verifyOrderSummaryTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyOrders/orderSummaryTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyOrderQuantityNotExist(number) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderQuantity_android',['number': number]), defaultTime);
	}

	@Keyword
	def verifyOrderQuantity2(number) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderQuantity2_android',['number': number]), defaultTime);
	}

	@Keyword
	def tapOnCartIcon1() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/cartIcon1_android'), defaultTime);
	}

	@Keyword
	def verifyItemName(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/itemName_android',['name': name]), defaultTime, onFailure);
	}

	@Keyword
	def verifyItemNameNotExist(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/itemName_android',['name': name]), defaultTime, onFailure);
	}

	@Keyword
	def verifyItemCost(cost) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/itemCost_android',['cost': cost]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCartIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/cartIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/backBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/removeBtn_android'), defaultTime);
	}

	@Keyword
	def verifyNoItmsInCartMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/noItemsCartMsg_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyBtnsOnMyCartPage() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/moveToCartBtn_android'), defaultTime, onFailure)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/removeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMoveToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/moveToCartBtn_android'), defaultTime)
	}

	@Keyword
	def verifySavedForLaterTxt(count = 1) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/saveForLaterTxt_android', ['count': count]), defaultTime)
	}

	@Keyword
	def verifyAbsenceOfSavedForLaterTxt() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/saveForLaterTxt_android'), defaultTime)
	}

	@Keyword
	def verifyDeliveryAddress() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/deliveryAddress_android'), defaultTime);
	}

	@Keyword
	def tapOnDeliveryAddressOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/deliveryAddress_android'), defaultTime);
	}

	@Keyword
	def verifyDeliveryAddressesTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/myDeliveryAddressesTitle_android'), defaultTime)
	}

	@Keyword
	def selectValidShippingAddress(address) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/validShhippingAddress_android', ['address':address]), defaultTime)
	}

	@Keyword
	def getAddressInMyDlvryAddrsPage(address) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/getAddressInMyDlvryAddrsPage_andriod', ['address':address]), defaultTime)
	}

	@Keyword
	def verifyValidShippingAddress(address) {
		Mobile.scrollToText(address)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/validDeliveryAddressInThankYouPage_android', ['address':address]), defaultTime)
	}

	@Keyword
	def verifyDeliveryAddressOnThankYouScreen() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/deliveryAddressOnThankYouScreen_android'), defaultTime);
	}

	@Keyword
	def verifyQuantityInOrderSummaryScreen(count) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSupplyQuantityInOrderSummaryScreen_android', ['value': count]), defaultTime)
	}

	@Keyword
	def verifyPaymentSummaryTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/paymentSummary_android'), defaultTime)
	}

	@Keyword
	def verifySelectedOrderSupply(element) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/selectedSupply_android', ['value': element]), defaultTime)
	}

	@Keyword
	def verifySaveForLaterBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/saveForLaterBtn_android'), defaultTime)
	}

	@Keyword
	def verifySaveForLaterBottomBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/saveForLaterBottomBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveForLaterBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/saveForLaterBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/saveBtn_android'), defaultTime)
	}

	@Keyword
	def verifyTotalText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/selectedSupply_android', ['value': "Total"]), defaultTime)
	}

	@Keyword
	def verifyTotalValue(cost) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/totalValue_android', ['value': cost]), defaultTime)
	}

	@Keyword
	def tapOnPlaceOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyOrders/placeOrderBtn_android'), defaultTime)
	}

	@Keyword
	def placeOrderBtnPageTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyOrders/placeOrderPageTitle_android'), defaultTime)
	}

	@Keyword
	def verifyLearnMoreBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyOrders/learnMoreBtn_android'), defaultTime)
	}

	@Keyword
	def verifyPaymentTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/selectPaymentTitle_android'), defaultTime)
	}

	@Keyword
	def tapOnPayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/payBtn_android'), defaultTime)
		Mobile.delay(5)
	}

	@Keyword
	def verifyThankyouTitle() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/thankYouPageTitle_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPaymentMethodTitle() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/paymentMethod_android'), defaultTime)
	}

	@Keyword
	def verifyPaymentMethodName(card) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/paymentMethodName_android', ['card': card]), defaultTime)
	}

	@Keyword
	def tapOnViewOrdersBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/viewOrdersBtn_android'), defaultTime)
	}

	@Keyword
	def orderSupplyInfo(orderSupplieName, costOfFirstSupply) {
		verifyItemName(orderSupplieName);
		//verifyOrderQuantity("1");
		verifyItemCost(costOfFirstSupply);
	}

	@Keyword
	def tapOnviewDetailsBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/viewDetailsBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/viewDetailsBtn_android'), defaultTime)
	}

	@Keyword
	def verifyOrderDetails(orderSupplieName, costOfFirstSupply) {
		orderSupplyInfo(orderSupplieName, costOfFirstSupply)
		verifyLearnMoreBtn();
		verifyTotalValue(costOfFirstSupply);
		verifyPaymentMethodTitle();
		verifyDeliveryAddressOnThankYouScreen()
	}

	@Keyword
	def tapOnTrackOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/trackOrderBtn_android'), defaultTime)
	}

	@Keyword
	def verifyOrderNumberTitle() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderNumTitle_android'), defaultTime)
	}

	@Keyword
	def verifyThankYouScreen() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/thankYouPageLabel1_android'), defaultTime, onFailure)
	}

	@Keyword
	def getOrderNum() {
		String txt = Mobile.getText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/oderNumber_android'), defaultTime)
		String[] parts = txt.split("#")
		String num = parts[1].trim()
		return num
	}

	@Keyword
	def verifyOrderNumber(orderNum) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderNumThankYouScreen_android', ['value': orderNum]), defaultTime)
	}

	@Keyword
	def verifyDate(date) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/dateFieldInPastOrdersTab_android', ['date': date]), defaultTime)
	}

	@Keyword
	def verifyDateTitle(date) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/dateTitle_android', ['date': date]), defaultTime)
	}
	@Keyword
	def tapOnHelpWithOrderBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/helpWithOrderBtn_android'), defaultTime)
	}
	@Keyword
	def verifyHelpWithOrderPopupTitle() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/helpWithOrderTitle_android'), defaultTime);
	}
	@Keyword
	def verifyHelpWithOrderPopupDescription() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/helpWithOrderPopupDescription_android'), defaultTime);
	}
	@Keyword
	def verifyHelpWithOrderPopupServiceNum(num) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/helpWithOrderPopupServiceNum_android', ['num': num]), defaultTime);
	}

	@Keyword
	def addPaymentDetails(acctNum, expDate, cvv, zip) {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/Credit Card Details/addCardBtn_android'), defaultTime);
		}catch(Exception e) {
		}
		card.typeInCardNumberInputBx(acctNum);
		Mobile.hideKeyboard();
		card.typeInExipreDateInputBx(expDate)
		Mobile.hideKeyboard();
		card.typeInCvvInputBx(cvv);
		Mobile.hideKeyboard();
		card.typeInZipCodeInputBx(zip);
		Mobile.hideKeyboard();
		tapOnPayBtn();
	}

	@Keyword
	def addPaymentDetailswithCheckTheSaveFutrRvDcPymntChckBx(acctNum, expDate, cvv, zip) {
		card.typeInCardNumberInputBx(acctNum);
		Mobile.hideKeyboard();
		card.typeInExipreDateInputBx(expDate)
		Mobile.hideKeyboard();
		card.typeInCvvInputBx(cvv);
		Mobile.hideKeyboard();
		card.typeInZipCodeInputBx(zip);
		Mobile.hideKeyboard();
		card.tapOnSaveForFutureCheckBox();
		tapOnPayBtn();
	}

	@Keyword
	def verifyTrackYourOrderTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/trackYourOrderTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyOrderSubmittedlabel(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/orderSubmittedlabel_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyTheHelpWithOrderBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/helpWithOrderBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def enterTextInSearchPastOrderField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/searchPastOrders_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def verifyTheSearchedResults(value, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/searchedResult_andriod', ['value': value, 'index' : index]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def getDeliveryAddressInCheckOutPg() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/getDeliveryAddressInCheckOutPg_andriod'), defaultTime)
	}

	@Keyword
	def verifyTextMatch(addrs, addrs2) {
		String expectedPattern = ".*"+addrs+".*";
		Mobile.verifyMatch(addrs2, expectedPattern, true);
	}

	@Keyword
	def verifySavedForLaterItemInMyCart(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/savedForLaterItem_andriod', ['index' : index]), defaultTime, onFailure)
	}

	@Keyword
	def verifycartItemInMyCart(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/cartItem_andriod', ['index' : index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCheckOutTitle(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/checkOutTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyPlacedOrderInPastOrderSection(quantiy, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/verifyPlaceOrderInPastOrdrsect_andriod', ['value': quantiy]), defaultTime, onFailure);
	}
	@Keyword
	def verifyEnabledBynowBtn(enabledStatus, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/enabledByNowBtn_android', ["trueOrFalse":enabledStatus]), defaultTime, onFailure);
	}
	@Keyword
	def verifyEnabledAddToCartBtn(enabledStatus, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/enabledAddToCartBtn_android', ["trueOrFalse":enabledStatus]), defaultTime, onFailure);
	}
}
