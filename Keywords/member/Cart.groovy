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

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import mobile.Generic

public class Cart {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE
	Generic gen = new Generic();

	@Keyword
	def tapOnCartIcon() {
		TestObject cartIcon = findTestObject('Object Repository/Member/Cart/cartIcon_android')
		def eHeight = Mobile.getElementHeight(cartIcon, defaultTime)
		def eWidth = Mobile.getElementWidth(cartIcon, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(cartIcon, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(cartIcon, defaultTime)

		def x = (eLeftPos + (eWidth/2)).toInteger()
		def y = (eTopPos + (eHeight/2) + 20).toInteger()

		println("x": x)
		println("y": y)
		Mobile.tapAtPosition(x, y)

		//		Mobile.tap(findTestObject('Object Repository/Member/Cart/cartIcon_android'), defaultTime);
	}
	@Keyword
	def verifyCartIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/cartIcon_android'), defaultTime);
	}
	@Keyword
	def tapOnRemoveBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyConfirmTitlePopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/confirmPopupTitle_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyPopupDescription() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/popupDescription_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyYesBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/yesBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyNoBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/noBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnNoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/noBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnYesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/yesBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/continueBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnConfirmRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/confirmRemoveBtn_android'), defaultTime);
	}

	@Keyword
	def verifyContinueBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/continueBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/cancelBtn_android'), defaultTime);
	}
	@Keyword
	def verifyCancelBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/cancelBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def getTextOfHeathCareTitle() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/getHealthCareTitle_android'), defaultTime);
	}
	@Keyword
	def verifyHealthCareTitle(txt) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Cart/verifyHealthCareTitile_android',["txt":txt]), defaultTime,onFailure);
	}
	@Keyword
	def tapOnRevMoneyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/revMoneyOption_android'), defaultTime);
	}
	@Keyword
	def verifyRevMoneyTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/revMoneyTitle_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyAndTapOnApplyBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/applyBtn_android'), defaultTime,onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/applyBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def getRevDocPlusMembershipName(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/revdocPlusMembershipItemName_android'), defaultTime, onFailure);
	}
	@Keyword
	def getRevDocPlusMembershipAmount(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/revDocPlusMembershipItemPrice_android'), defaultTime, onFailure);
	}
	@Keyword
	def getSubTotalPriceInCart() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/subTotalPriceInCart_android'), defaultTime);
	}
	@Keyword
	def tapOnProceedToCheckoutBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/proceedToCheckoutBtn_android'), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/proceedToCheckoutBtn_android'), defaultTime,FailureHandling.OPTIONAL);
	}
	@Keyword
	def VerifyRevDocPlusMembershipNameNotExist() {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Cart/revdocPlusMembershipItemName_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnDeliveryAddressOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/deliveryAddressOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.delay(15);
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Checkout/saveBtn_'+os), defaultTime);
	}
	@Keyword
	def verifySaveBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/saveBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyText(msg) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/verifyText_'+os,['msg': msg]), defaultTime);
	}
	@Keyword
	def tapOnCartAndverifyCartIsEmpty(text) {
		tapOnCartIcon();
		verifyText(text)
	}
	@Keyword
	def getTextProceedToCheckOutBtn() {
		def originalText = Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/getTextProceedToCheckOutBtn_'+os), defaultTime);
		def regex = /\d+/
		def matcher = (originalText =~ regex)
		def countNumber = matcher.find() ? matcher.group().toInteger() : null
		println("Count number: $countNumber")
		return countNumber
	}
	@Keyword
	def verifyCountInPTCBtn(count) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/verifyCountInPTCBtn_'+os,['count': count]), defaultTime);
	}
	@Keyword
	def verifyAbsenceOfPTCBtn(count) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Cart/Checkout/verifyCountInPTCBtn_'+os,['count': count]), defaultTime);
	}
	@Keyword
	def getItemNameInCart(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/itemTitleInCart_android', ['index': index]), defaultTime,onFailure)
	}
	@Keyword
	def getItemTitleInCart(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/itemNameInCart_android', ['index': index]), defaultTime,onFailure)
	}
	@Keyword
	def getappProviderNameAndTitleInCart(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/apptCartItemProviderNameAndTitle_android', ['index': index]), defaultTime)
	}
	@Keyword
	def getItemPriceInCart(index = 1) {
		def testObject = findTestObject('Object Repository/Member/Cart/itemPriceInCart_android', ['index': index])
		try {
			return Mobile.getText(testObject, defaultTime)
		} catch (Exception e) {
			gen.swipeUpLittle();
			return Mobile.getText(testObject, defaultTime)
		}
	}
	@Keyword
	def getProviderNameInCart(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/getProviderName', ['index': index]), defaultTime)
	}
	@Keyword
	def getapptDateAndTimeInCart(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/dateAndTime_android', ['index': index]), defaultTime)
	}
	@Keyword
	def getApptDateAndTimeInCart(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/getDateAndTime_android', ['index': index]), defaultTime)
	}
	@Keyword
	def tapOnHomeIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/backBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSearchBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/searchBackBtn_android'), defaultTime);
	}

	@Keyword
	def navigateBackToHomeFromCheckout() {
		tapOnBackBtn()
		tapOnBackBtn()
		tapOnSearchBackBtn()
	}

	@Keyword
	def removAllItemFromCart() {
		tapOnCartIcon();
		Mobile.delay(10)
		def isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.delay(10)
			tapOnConfirmRemoveBtn();
			Mobile.delay(4)
		}
		tapOnSaveForLaterOption();
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.delay(10)
			tapOnConfirmRemoveBtn();
			Mobile.delay(4)
		}
		tapOnBackBtn();
		tapOnHomeIcon();
	}
	@Keyword
	def removAllItemFromCartAndSaveForLater() {
		tapOnCartIcon();
		Mobile.delay(10)
		def isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.delay(10)
			tapOnConfirmRemoveBtn();
			Mobile.delay(4)
		}
		tapOnSaveForLaterOption();
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.delay(10)
			tapOnConfirmRemoveBtn();
			Mobile.delay(4)
		}
		tapOnBackBtn();
		tapOnHomeIcon();
	}

	@Keyword
	def removAllItemFromCartForPromos() {
		gen.swipeDownLoop(2)
		def isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.delay(5)
			tapOnConfirmRemoveBtn();
			Mobile.delay(4)
		}
		tapOnSaveForLaterOption();
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/removeBtn_android', ['index': 1]), 10, FailureHandling.OPTIONAL)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtn_android', ['index': 1]), 10)
			Mobile.delay(5)
			tapOnConfirmRemoveBtn();
			Mobile.delay(4)
		}
		tapOnBackBtn();
		tapOnHomeIcon();
	}

	@Keyword
	def verifyNonStikeAmtofAppt(price, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/itemPriceNonStrikeAmt_android', ['index': index]), price);
	}
	@Keyword
	def tapOnSaveForLaterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/saveForLaterBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveForLaterOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/saveForLaterOption_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnRemoveBtnForSaveLaterAppt(time) {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/removeBtnForSaveLaterAppt_android',["time":time]), defaultTime);
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/closeBtn_android'), defaultTime);
	}
	@Keyword
	def verifyCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Member Services/At Home Labs/closeBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def getLabNameAndQty() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/labNameAndQty_android'), defaultTime)
	}
	@Keyword
	def verifyRevPlusMembershipTitleText(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/revPlusMembershipTitle_'+os), text, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def verifyRevPlusMembershipUnderSavedForLaterInCart() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/revplusMembershipInSavedForLater_android'), defaultTime)
	}
	@Keyword
	def verifyRevPlusMembershipUnderSavedForLaterInCartCondition() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/revplusMembershipInSavedForLater_android'), defaultTime,FailureHandling.OPTIONAL)
	}
	@Keyword
	def tapOnRebookBtnOfSaveForLaterOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/rebookBtnForSaveFrLtr_andriod'), defaultTime)
	}

	@Keyword
	def verifyRebookBtnOfSaveForLaterOptionUnderSavedForLater() {
		return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/rebookBtnForSaveFrLtr_andriod'), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapOnChangeApptBtnInCart() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/changeApptBtnFromCartItem_andriod'), defaultTime)
	}

	@Keyword
	def tapOnRevCreditHistory() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/RevMoney/revCreditHistoryBtn_android'), defaultTime)
	}
	@Keyword
	def verifyRevCreditHistoryMoney(date, price){
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/RevMoney/revCreditHistoryMoney_andriod',['date': date]), price)
	}
	@Keyword
	verifySaveForLaterAptPresent(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/saveForLaterApt_android'),defaultTime)
	}
	@Keyword
	def isSaveForLaterExpanded() {
		if(Mobile.verifyElementExist(findTestObject("Object Repository/Member/Cart/saveForLaterRightArrow_android"), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Cart/saveForLaterRightArrow_android'), defaultTime)
			Mobile.delay(3)
			Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/saveForLaterDownArrow_android'), defaultTime)
		}
	}
	@Keyword
	def verifyApptExpiredLabel(area, label) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/apptExpiredLabel_android', ['area': area, 'label': label]), defaultTime)
	}
	@Keyword
	def verifyRemoveBtnAndRebookBtnInSaveForLaterBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/rebookBtnForSaveFrLtr_andriod'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/saveForLaterRemoveBtn_android'), defaultTime)
	}
	@Keyword
	def verifyMoveToCartBtnAbsenceInSavedForLater() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Cart/saveForLaterMoveTOCartBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureNameInCart(text) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/procedureNameInCart_android', ['text': text]), defaultTime)
	}
	@Keyword
	def verifyOrdersDisplayHereMsg(text) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/cartMsg_android', ['text': text]), defaultTime)
	}
	@Keyword
	def verifyNoLongerPageTitle(txt) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Cart/bottomSheetTitle_android'), txt)
	}
	@Keyword
	def verifyItemNameInCart(itemName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/verifyItemName',['itemName': itemName]), defaultTime);
	}
	@Keyword
	def verifyProviderNameInCart(providerName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/verifyProviderName',['providerName': providerName]), defaultTime);
	}

	@Keyword
	def verifyDateAndTimeInCart(dateTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/verifyDataAndTime',['dateTime': dateTime]), defaultTime);
	}

	@Keyword
	def getCountOfAppointmentsInCart() {
		int count = MobileDriverFactory.getDriver().findElementsByXPath("//android.view.ViewGroup[@resource-id= 'basecartitem:-bronchoscopy']").size()
		return count
	}


	@Keyword
	def getCountOfExpiredLabelInCart(area, label) {
		String xpath = "(//android.view.ViewGroup[contains(@content-desc,'${area}')]//following-sibling::android.view.ViewGroup//child::android.widget.TextView[contains(@text,'${label}')])"
		int count = MobileDriverFactory.getDriver().findElementsByXPath(xpath).size()
		return count
	}

	@Keyword
	def removeApptFromSavedFromLater() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/saveForLaterRemoveBtn_android'), defaultTime)
		tapOnYesBtn();
		Mobile.delay(2)
	}
	@Keyword
	def verifyRemoveAndCheckOutBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Cart/Checkout/removeAndCheckout_android'), defaultTime)
	}

	@Keyword
	def verifyAndtapOnRebookBtnOfSaveForLaterOption() {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/rebookBtnForSaveFrLtr_andriod'), defaultTime, FailureHandling.OPTIONAL)) {
			tapOnRebookBtnOfSaveForLaterOption();
		}
		else {
			tapOnSaveForLaterOption();
			tapOnRebookBtnOfSaveForLaterOption();
		}
	}
	@Keyword
	def tapOnChangeAppointmentOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/changeAppointmentOptn_android'), defaultTime)
	}
}
